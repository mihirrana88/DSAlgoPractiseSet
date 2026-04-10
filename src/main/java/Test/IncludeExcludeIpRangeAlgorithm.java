package Test;

import java.util.*;

public class IncludeExcludeIpRangeAlgorithm {
    private static boolean isLikelySubnet(String ipRange) {
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

    public static String getIpAsRange(String input) {
        String[] parts = input.split("/");
        String ipPart = parts[0];
        int subnetPrefix = parts.length > 1 ? Integer.parseInt(parts[1]) : -1;

        long[] ipRange = parseHyphenatedIP(ipPart);

        if (ipPart.contains("-")) {
            if (subnetPrefix != -1 && isLikelySubnet(ipPart)) {
                return getFirstAndLastSubnetRange(input);
            } else {
                return longToIp(ipRange[0]) + " - " + longToIp(ipRange[1]);
            }
        } else if (subnetPrefix != -1) {
            long ip = ipToLong(ipPart);
            if (isNetworkBaseAddress(ip, subnetPrefix)) {
                long[] range = getNetworkRange(ipPart, subnetPrefix);
                return longToIp(range[0]) + " - " + longToIp(range[1]);
            } else {
                return longToIp(ip) + " - " + longToIp(ip);
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

    private static long[] parseHyphenatedIP(String ip) {
        String[] octets = ip.split("\\.");
        int[] low = new int[4];
        int[] high = new int[4];

        for (int i = 0; i < 4; i++) {
            if (octets[i].contains("-")) {
                String[] range = octets[i].split("-");
                low[i] = Integer.parseInt(range[0]);
                high[i] = Integer.parseInt(range[1]);
            } else {
                low[i] = high[i] = Integer.parseInt(octets[i]);
            }
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

    public static void main(String[] args) {

        List<String> included = Arrays.asList(
                "172.16.0.0/24",
                "172.16.2.0/24",
                "192.168.100.200-255/24",
                "10.10.10.5-50/30"
        );

        List<String> excluded = Arrays.asList(
                "172.16.0.120/28",
                "10.10.10.11-15"
        );

        List<String> includedRange = included.stream()
                .map(IncludeExcludeIpRangeAlgorithm::sanitizeHyphenatedIP)
                .flatMap(List::stream)
                .map(IncludeExcludeIpRangeAlgorithm::getIpAsRange)
                .toList();

        includedRange.forEach(System.out::println);

        List<String> excludedRange = excluded.stream()
                .map(IncludeExcludeIpRangeAlgorithm::sanitizeHyphenatedIP)
                .flatMap(List::stream)
                .map(IncludeExcludeIpRangeAlgorithm::getIpAsRange)
                .toList();

        excludedRange.forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------");

        List<String> result = subtractExcludedRanges(includedRange, excludedRange);
        result.forEach(System.out::println);
    }

    public static List<String> subtractExcludedRanges(List<String> included, List<String> excluded) {
        List<long[]> includedRanges = parseRanges(included);
        List<long[]> excludedRanges = parseRanges(excluded);

        List<long[]> resultRanges = new ArrayList<>();

        for (long[] include : includedRanges) {
            long start = include[0], end = include[1];
            List<long[]> temp = new ArrayList<>();
            temp.add(new long[]{start, end});

            for (long[] exclude : excludedRanges) {
                List<long[]> updated = new ArrayList<>();
                for (long[] current : temp) {
                    updated.addAll(subtract(current, exclude));
                }
                temp = updated;
            }

            resultRanges.addAll(temp);
        }

        resultRanges.sort(Comparator.comparingLong(a -> a[0]));
        List<String> result = new ArrayList<>();
        for (long[] range : resultRanges) {
            result.add(longToIp(range[0]) + " - " + longToIp(range[1]));
        }
        return result;
    }

    private static List<long[]> subtract(long[] include, long[] exclude) {
        long start = include[0], end = include[1];
        long exStart = exclude[0], exEnd = exclude[1];

        if (exEnd < start || exStart > end) {
            return Collections.singletonList(include);
        }

        List<long[]> result = new ArrayList<>();
        if (exStart > start) {
            result.add(new long[]{start, exStart - 1});
        }
        if (exEnd < end) {
            result.add(new long[]{exEnd + 1, end});
        }
        return result;
    }

    private static List<long[]> parseRanges(List<String> ranges) {
        List<long[]> result = new ArrayList<>();
        for (String range : ranges) {
            String[] parts = range.trim().split("-");
            long start = ipToLong(parts[0].trim());
            long end = ipToLong(parts[1].trim());
            result.add(new long[]{start, end});
        }
        return result;
    }
}
