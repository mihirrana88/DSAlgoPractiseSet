package Test;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncludeExcludeIps {

    private static boolean isLikelySubnet(String ipRange) {
        // Checks if ends with .0, .0.0, or .0.0.0 pattern
        return ipRange.matches(".*\\.(0)$") || ipRange.matches(".*\\.(0\\.0)$") || ipRange.matches(".*\\.(0\\.0\\.0)$");
    }

    public static boolean isNetworkBaseAddress(long ip, int prefixLength) {
        long mask = prefixToMask(prefixLength);
        return (ip & mask) == ip;
    }

    public static long prefixToMask(int prefixLength) {
        return prefixLength == 0 ? 0 : (~0L << (32 - prefixLength)) & 0xFFFFFFFFL;
    }

    public static long[] getNetworkRange(String ip, int prefixLength) {
        long ipLong = ipToLong(ip);
        long mask = prefixToMask(prefixLength);
        long networkBase = ipLong & mask;
        long broadcast = networkBase | (~mask & 0xFFFFFFFFL);
        return new long[]{networkBase, broadcast};
    }

    public static long ipToLong(String ip) {
        String[] octets = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (Long.parseLong(octets[i]) & 0xFF) << (24 - (8 * i));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        //Approach 1
        //String input = "10-12.20.0.0/14";
        //String input = "10.10-20.0.0/14";
        //String input = "172.16.0.0/24";
        //List<String> result = getFullyContainedSubnets(input);
        //result.forEach(System.out::println);

        //Approach 2 - handle hyphen properly
        //String input = "172.16.0.0/24";
        //String result = getFirstAndLastSubnetRange(input);
        //System.out.println(result);

        //Approach 3 - handles hyphen with simple range -- subnet mask is not applicable here and above case as well
        //String input = "10.10.10.5-50/30";
        //String result = getFirstAndLastRangeOrSubnet(input);
        //System.out.println(result);

        //Approach 4 - All above cases
        //String input = "10.10.10.11-15/30";
        //String result = getFirstAndLastRangeOrSubnet2(input);
        //System.out.println(result);

        //Approach 5 - Everything Working here.......
        //String input = "10-12.20.20.20/14";
        //String result = getFirstAndLastRangeOrSubnet3(input);
        //System.out.println(result);

        //Approach 6 - Everything Working here.......
        //String input = "10-12.20.20.20/14";
        //List<String> result = sanitizeHyphenatedIP(input);
        //result.forEach(System.out::println);
        List<String> included = Arrays.asList(
                "172.16.0.0/24",
                "172.16.2.0/24",
                "192.168.100.200-255/24",
                "10.10.10.5-50/30",
                "10.20-25.20.20/14"
        );

        List<String> excluded = Arrays.asList(
                "172.16.0.120/28",
                "10.10.10.11-15",
                "10-12.20.20.20/14"
        );
        included.stream().map(IncludeExcludeIps::sanitizeHyphenatedIP).flatMap(List::stream).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");
        excluded.stream().map(IncludeExcludeIps::sanitizeHyphenatedIP).flatMap(List::stream).forEach(System.out::println);

    }

    public static String getFirstAndLastRangeOrSubnet(String input) {
        String[] parts = input.split("/");
        String ipRange = parts[0];
        int subnetPrefix = Integer.parseInt(parts[1]);

        long[] ips = parseHyphenatedIP2(ipRange);
        long lowIp = ips[0];
        long highIp = ips[1];

        if (ipRange.contains("-") && isLikelySubnet(ipRange)) {
            // Treat as subnet blocks
            return getFirstAndLastSubnetRange(input);
        } else {
            // Treat as simple IP range ignoring subnet mask
            return longToIp(lowIp) + " - " + longToIp(highIp);
        }
    }

    public static String getFirstAndLastRangeOrSubnet2(String input) {
        String[] parts = input.split("/");
        String ipPart = parts[0];
        int subnetPrefix = Integer.parseInt(parts[1]);

        long lowIp, highIp;

        if (!ipPart.contains("-")) {
            long[] range = getNetworkRange(ipPart, subnetPrefix);
            lowIp = range[0];
            highIp = range[1];
        } else {
            long[] ips = parseHyphenatedIP2(ipPart);
            lowIp = ips[0];
            highIp = ips[1];
        }

        if (ipPart.contains("-") && isLikelySubnet(ipPart)) {
            return getFirstAndLastSubnetRange(input);
        } else {
            return longToIp(lowIp) + " - " + longToIp(highIp);
        }
    }

    public static String getFirstAndLastRangeOrSubnet3(String input) {
        String[] parts = input.split("/");
        String ipPart = parts[0];
        int subnetPrefix = parts.length > 1 ? Integer.parseInt(parts[1]) : -1;

        long lowIp, highIp;

        if (ipPart.contains("-")) {
            // Handle hyphenated IPs, including short formats like 10.10.10.11-15
            long[] ips = parseHyphenatedIP3(ipPart);
            lowIp = ips[0];
            highIp = ips[1];

            if (subnetPrefix != -1 && isLikelySubnet(ipPart)) {
                return getFirstAndLastSubnetRange(input);
            } else {
                return longToIp(lowIp) + " - " + longToIp(highIp);
            }

        } else if (subnetPrefix != -1) {
            long ip = ipToLong(ipPart);
            if (isNetworkBaseAddress(ip, subnetPrefix)) {
                long[] range = getNetworkRange(ipPart, subnetPrefix);
                return longToIp(range[0]) + " - " + longToIp(range[1]);
            } else {
                return longToIp(ip) + " - " + longToIp(ip); // treat as host IP
            }
        } else {
            long ip = ipToLong(ipPart);
            return longToIp(ip) + " - " + longToIp(ip);
        }
    }

    public static String getFirstAndLastSubnetRange(String input) {
        String[] parts = input.split("/");
        String ipRange = parts[0];
        int subnetPrefix = Integer.parseInt(parts[1]);

        long subnetBlockSize = 1L << (32 - subnetPrefix);

        long[] ipRangeBounds = parseHyphenatedIP(ipRange);
        long rangeStart = ipRangeBounds[0];
        long rangeEnd = ipRangeBounds[1];

        List<Long> subnetStarts = new ArrayList<>();
        List<Long> subnetEnds = new ArrayList<>();

        long current = rangeStart - (rangeStart % subnetBlockSize);

        while (current <= rangeEnd) {
            long subnetStart = current;
            long subnetEnd = subnetStart + subnetBlockSize - 1;

            if (subnetStart >= rangeStart && subnetEnd <= rangeEnd) {
                subnetStarts.add(subnetStart);
                subnetEnds.add(subnetEnd);
            }

            current += subnetBlockSize;
        }

        if (subnetStarts.isEmpty()) {
            return "No fully contained subnets found";
        }

        long firstLow = subnetStarts.get(0);
        long lastHigh = subnetEnds.get(subnetEnds.size() - 1);
        return longToIp(firstLow) + " - " + longToIp(lastHigh);
    }


    public static List<String> getFullyContainedSubnets(String input) {
        String[] parts = input.split("/");
        String ipRange = parts[0];
        int subnetPrefix = Integer.parseInt(parts[1]);

        long subnetBlockSize = 1L << (32 - subnetPrefix);

        // Parse low and high IP from custom "10.10-20.0.0" range
        long[] ipRangeBounds = parseHyphenatedIP(ipRange);
        long rangeStart = ipRangeBounds[0];
        long rangeEnd = ipRangeBounds[1];

        List<String> results = new ArrayList<>();

        // Align to nearest subnet block start
        long current = rangeStart - (rangeStart % subnetBlockSize);

        while (current <= rangeEnd) {
            long subnetStart = current;
            long subnetEnd = subnetStart + subnetBlockSize - 1;

            // Keep only those fully within the given range
            if (subnetStart >= rangeStart && subnetEnd <= rangeEnd) {
                results.add(longToIp(subnetStart) + " - " + longToIp(subnetEnd));
            }

            current += subnetBlockSize;
        }

        return results;
    }

    private static long[] parseHyphenatedIP(String ip) {
        String[] octets = ip.split("\\.");
        long[] low = new long[4];
        long[] high = new long[4];

        for (int i = 0; i < 4; i++) {
            if (octets[i].contains("-")) {
                String[] range = octets[i].split("-");
                low[i] = Integer.parseInt(range[0]);
                high[i] = Integer.parseInt(range[1]);
            } else {
                low[i] = high[i] = Integer.parseInt(octets[i]);
            }
        }

        long ipLow = (low[0] << 24) | (low[1] << 16) | (low[2] << 8) | low[3];
        long ipHigh = (high[0] << 24) | (high[1] << 16) | (255 << 8) | 255; // Include full host range

        return new long[]{ipLow, ipHigh};
    }

    public static long[] parseHyphenatedIP2(String ipRange) {
        String[] parts = ipRange.split("\\.");
        int[] low = new int[4];
        int[] high = new int[4];

        for (int i = 0; i < 4; i++) {
            if (parts[i].contains("-")) {
                String[] range = parts[i].split("-");
                low[i] = Integer.parseInt(range[0]);
                high[i] = Integer.parseInt(range[1]);
            } else {
                low[i] = high[i] = Integer.parseInt(parts[i]);
            }
        }

        long lowIp = ipToLong(low);
        long highIp = ipToLong(high);

        return new long[]{lowIp, highIp};
    }

    public static long[] parseHyphenatedIP3(String ipRange) {
        String[] parts = ipRange.split("\\.");
        int[] low = new int[4];
        int[] high = new int[4];

        for (int i = 0; i < 4; i++) {
            if (parts[i].contains("-")) {
                String[] range = parts[i].split("-");
                low[i] = Integer.parseInt(range[0]);
                high[i] = Integer.parseInt(range[1]);
            } else {
                low[i] = high[i] = Integer.parseInt(parts[i]);
            }
        }

        // Handle case like "10.10.10.11-15" => expand 4th octet only
        if (parts.length == 4 && parts[3].contains("-") && !parts[0].contains("-") &&
                !parts[1].contains("-") && !parts[2].contains("-")) {
            // Already handled above
        }

        return new long[]{ipToLong(low), ipToLong(high)};
    }

    public static long ipToLong(int[] octets) {
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result |= ((long) octets[i] & 0xFF) << (24 - (8 * i));
        }
        return result;
    }

    private static String longToIp(long ip) {
        return String.format("%d.%d.%d.%d",
                (ip >> 24) & 0xFF,
                (ip >> 16) & 0xFF,
                (ip >> 8) & 0xFF,
                ip & 0xFF);
    }

    private static List<String> sanitizeHyphenatedIP(String ipRange) {
        String[] parts = ipRange.split("/");
        String ipPart = parts[0];
        if(!isLikelySubnet(ipPart)){
            String[] octets = ipPart.split("\\.");
            List<String> sanitized = new ArrayList<>();
            if(octets[0].trim().contains("-")){
                String[] firstOctetRange = octets[0].trim().split("-");
                for (int i = Integer.parseInt(firstOctetRange[0]); i <= Integer.parseInt(firstOctetRange[1]); i++) {
                    sanitized.add(i + "." + octets[1] + "." + octets[2] + "." + octets[3]);
                }
                return sanitized;
            } else if(octets[1].trim().contains("-")){
                String[] secondOctetRange = octets[1].trim().split("-");
                for (int i = Integer.parseInt(secondOctetRange[0]); i <= Integer.parseInt(secondOctetRange[1]); i++) {
                    sanitized.add(octets[0] + "." + i + "." + octets[2] + "." + octets[3]);
                }
                return sanitized;
            } else if(octets[2].trim().contains("-")){
                String[] thirdOctetRange = octets[2].trim().split("-");
                for (int i = Integer.parseInt(thirdOctetRange[0]); i <= Integer.parseInt(thirdOctetRange[1]); i++) {
                    sanitized.add(octets[0] + "." + octets[1] + "." + i + "." + octets[3]);
                }
                return sanitized;
            } else {
                return List.of(ipRange);
            }
        }
        return List.of(ipRange);
    }
}
