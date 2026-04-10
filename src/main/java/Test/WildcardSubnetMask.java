package Test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.SubnetUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class WildcardSubnetMask {
    public static void main(String[] args){
        /*SubnetUtils utils = new SubnetUtils("10.0.0.193", "255.0.0.255");
        System.out.println("startIpv4::: "+utils.getInfo().getAddress());
        System.out.println("endIpv4::: "+utils.getInfo().getHighAddress());
        System.out.println("-----------------------------------------------");
        String[] output = convertWildcardToSubnetMask("172.16.0.128", "255.240.0.240");
        System.out.println("startIpv4::: "+output[0]);
        System.out.println("endIpv4::: "+output[1]);*/

        String ipAddress = "192.168.7.1";
        String wildcardMask = "255.255.7.255";

        String[] result = calculateLowHighAddress(ipAddress, wildcardMask);
        System.out.println("Low Address: " + result[0]);
        System.out.println("High Address: " + result[1]);

    }

    public static String[] convertWildcardToSubnetMask(String address, String mask) {
        String octet = "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        String ipRegex = "^(" + octet + "\\.){3}" + octet + "$";
        if (StringUtils.isEmpty(address) ||
                StringUtils.isEmpty(mask) ||
                !Pattern.matches(ipRegex, address) ||
                !Pattern.matches(ipRegex, mask)) {
            throw new IllegalArgumentException("Invalid input arguments detected!");
        }
        String[] startAndEnd = new String[2];
        startAndEnd[0] = address;
        startAndEnd[1] = address;
        String[] octetsAddress = address.trim().split("\\.");
        String[] octetsMask = mask.trim().split("\\.");

        if(octetsAddress.length != 4 || octetsMask.length != 4) {
            throw new IllegalArgumentException("Invalid IP address or mask format. Both should be in the format x.x.x.x");
        }

        StringBuilder endAddress = new StringBuilder();

        for(int i=0; i<4; i++) {
            if(octetsMask[i].equals("0")) {
                // If the mask octet is 0, it means the corresponding address octet is 255 for end ip address
                endAddress.append("255");
            } else if (octetsMask[i].equals("255")) {
                // If the mask octet is 255, it means the corresponding address octet is the exact same for end ip address
                endAddress.append(octetsAddress[i]);
            } else {
                // If the mask octet is neither 0 nor 255, it means we need to use as it is
                endAddress.append(octetsMask[i]);
            }

            if(i<3) {
                endAddress.append(".");
            }
        }

        String endIpAddress = endAddress.toString();

        if(StringUtils.isEmpty(endIpAddress) || endIpAddress.trim().split("\\.").length !=4) {
            throw new IllegalArgumentException("Invalid wildcard mask provided: " + mask);
        }

        startAndEnd[1] = endIpAddress;

        return startAndEnd;
    }
    public static String[] calculateLowHighAddress(String address, String maskAddress) {
        String octet = "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        String ipRegex = "^(" + octet + "\\.){3}" + octet + "$";
        if (StringUtils.isEmpty(address) ||
                StringUtils.isEmpty(maskAddress) ||
                !Pattern.matches(ipRegex, address) ||
                !Pattern.matches(ipRegex, maskAddress)) {
            throw new IllegalArgumentException("Invalid input arguments detected!");
        }
        String[] ipOctets = address.split("\\.");
        String[] maskOctets = maskAddress.split("\\.");
        int[] lowOctets = new int[4];
        int[] highOctets = new int[4];

        for (int i = 0; i < 4; i++) {
            int ip = Integer.parseInt(ipOctets[i]);
            int mask = Integer.parseInt(maskOctets[i]);

            if (mask == 255) {
                lowOctets[i] = ip;
                highOctets[i] = ip;
            } else if (mask == 0) {
                lowOctets[i] = 0;
                highOctets[i] = 255;
            } else {
                int wildcardRange = 255-mask;
                lowOctets[i] = ip;
                highOctets[i] = ip+wildcardRange;
            }
        }

        String lowAddress = lowOctets[0] + "." +
                lowOctets[1] + "." +
                lowOctets[2] + "." +
                lowOctets[3];

        String highAddress = highOctets[0] + "." +
                highOctets[1] + "." +
                highOctets[2] + "." +
                highOctets[3];

        return new String[]{lowAddress, highAddress};
    }
}
