package Test;

import java.util.Calendar;
import java.util.regex.Pattern;

public class RegexTestMihir {

    public static void main(String[] args){
        String s1 = "mnirvi-rbvhr-vr.abc89w8.gz";
        String s2 = "fhbsh-1brh13h_hsdvh-sh.0187.gz";
        String s3 = "dhvebhv-eb1038i1-13_rwwry_13fh-ahfs037.gz";
        String s4 = "fsbfbs-srfbsb-srbrsubrvs-sbrbs.gz";
        String s5 = "efwvejufw-bvwfbv-10.1.2.xml.gz";
        String s6 = "Sdbfshbfisr-wfhhqbfhq_Veve_Evrver_eve.gz";

        Pattern pattern = Pattern.compile("\\.[A-Za-z0-9]*\\.gz$");
        System.out.println(pattern.matcher(s1).find());
        System.out.println(s1.matches("\\.[A-Za-z0-9]*\\.gz$"));

        System.out.println(s1.endsWith("\\.[A-Za-z0-9]*\\.gz$") +"-------"+ pattern.matcher(s1).find());
        System.out.println(s2.endsWith("\\.[A-Za-z0-9]*\\.gz$") +"-------"+ pattern.matcher(s2).find());
        System.out.println(s3.endsWith("\\.[A-Za-z0-9]*\\.gz$") +"-------"+ pattern.matcher(s3).find());
        System.out.println(s4.endsWith("\\.[A-Za-z0-9]*\\.gz$") +"-------"+ pattern.matcher(s4).find());
        System.out.println(s5.endsWith("\\.[A-Za-z0-9]*\\.gz$") +"-------"+ pattern.matcher(s5).find());
        System.out.println(s6.endsWith("\\.[A-Za-z0-9]*\\.gz$") +"-------"+ pattern.matcher(s6).find());

        System.out.println("--------------Calendar--------------------");
        System.out.println(System.currentTimeMillis());
    }
}
