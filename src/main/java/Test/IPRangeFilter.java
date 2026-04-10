package Test;

import java.util.*;

public class IPRangeFilter {

    public static void main(String[] args) {
        List<String> included = Arrays.asList(
                "172.16.0.0 - 172.16.0.255",
                "172.16.2.0 - 172.16.2.255",
                "192.168.100.200 - 192.168.100.255",
                "10.10.10.5 - 10.10.10.50"
        );

        List<String> excluded = Arrays.asList(
                "172.16.0.120 - 172.16.0.120",
                "10.10.10.11 - 10.10.10.15"
        );

        List<String> result = subtractExcludedRanges(included, excluded);
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

    private static long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (Long.parseLong(parts[i]) & 0xFF) << (24 - 8 * i);
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
}
