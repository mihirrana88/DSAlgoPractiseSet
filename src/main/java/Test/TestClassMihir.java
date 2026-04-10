package Test;

import com.redseal.util.DigitalRandom;
import com.redseal.util.RedSealSecureRandom;

import java.security.SecureRandom;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestClassMihir {
    private static String txtBlock =
            """
            ,
            ip.alias_name AS interface,
            ip.description ,
            ip.vlan_id ,
            ip.address_as_string,
            ip.subnet_mask_as_long,
            ip.type AS ip_endpoint_type,
            ip.ip_subnet__id,
            ip.tunnel_local_address_as_bytea,
            ip.tunnel_remote_address_as_bytea,
            ip.v6_address,
            (select  COUNT(DISTINCT csys.computer_system_tree__id)
            FROM computer_system csys
            INNER JOIN computer_system__ip_endpoint cs_ipe on csys.id=cs_ipe.computer_system__id
            INNER JOIN ip_endpoint ipe ON cs_ipe.ip_endpoint__id=ipe.id
            INNER JOIN ip_subnet subnet ON ipe.ip_subnet__id=subnet.id
            WHERE csys.entity_state='NORMAL'
            AND csys.is_current_version=true
            AND csys.primary_capability != 'HOST'
            AND subnet.id = ip.ip_subnet__id
            ) AS subnet_device_count
            """;

    public static void main(String[] args) throws Exception {
        String str = txtBlock + "\nmihir, \n,";
        RedSealSecureRandom rsnm = null;
        //RedSealSecureRandom abc = new RedSealSecureRandom();
        RedSealWrapper rswrapper = new RedSealWrapper(true);
        RedSealWrapperMihir rswrapperMihir = new RedSealWrapperMihir(true);
        RedSealSecureRandom rs = new RedSealSecureRandom(true);
        System.out.println("---------- RS --------------"+rs.nextInt());

        System.out.println(rswrapper.nextInt());
        System.out.println(rswrapperMihir.nextInt());


        /*
        try {
            update();
            System.out.println(str);
        }catch (Exception e){
            System.out.println("in-main-method");
            e.printStackTrace();
        }*/

        /*getList().stream()
                .map(i -> new AbstractMap.SimpleEntry<>(i, i))
                .filter(entry -> entry.getKey()>3)
                .forEach(entry -> System.out.println(entry.getKey()));*/
    }

    public static List<Integer> getList(){
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);
        return lst;
    }

    public static void update() throws Exception {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        try {
            for(int i : lst){
                if(i == 3){
                    lst.add(4);
                }
            }
        } catch (Exception e){
            System.out.println("in-update-method");
            throw new Exception(e.toString());
        }
    }

    public static class RedSealWrapper{
        private RedSealSecureRandom rsr = null;

        RedSealWrapper() throws Exception {
            this(false);
            System.out.println("it is in default constructor");
        }

        RedSealWrapper(boolean strict) throws Exception {
            RedSealWrapper tempDigitalRandom = null;
            RedSealWrapper tempFallbackRandom = null;
            try {
                this.rsr = new RedSealSecureRandom(true);
            } catch (Exception e){
                if(!strict){
                    throw new Exception("Mihir-this-is-failed");
                }
                System.out.println("wasn't able to create redseal secure random");
            }
        }
        public int nextInt() {
            return this.rsr != null ? this.rsr.nextInt() : new SecureRandom().nextInt();
        }
        private RedSealSecureRandom getRedSealSecureRandom() throws Exception {
            return this.rsr;
        }
    }

    public static class RedSealWrapperMihir {
        private final SecureRandom fallbackRandom;
        private final DigitalRandom digitalRandom;
        private static final String SECURE_RANDOM_FAILURE_MESSAGE = "failed to create digital random";

        public RedSealWrapperMihir() throws UnsupportedOperationException {
            this(false);
        }

        public RedSealWrapperMihir(boolean useFallback) throws UnsupportedOperationException {
            DigitalRandom tempDigitalRandom = null;
            SecureRandom tempFallbackRandom = null;

            try {
                tempDigitalRandom = new DigitalRandom();
            } catch (Exception var5) {
                if (!useFallback) {
                    throw new UnsupportedOperationException(var5.toString().concat("failed to create digital random"));
                }

                tempFallbackRandom = new SecureRandom();
            }

            this.digitalRandom = tempDigitalRandom;
            this.fallbackRandom = tempFallbackRandom;
        }

        private boolean isDigitalRandom() {
            return this.digitalRandom != null;
        }

        public int nextInt() {
            System.out.println("it is not pure digital random "+isDigitalRandom());
            return this.isDigitalRandom() ? this.digitalRandom.nextInt() : this.fallbackRandom.nextInt();
        }

        public int nextInt(int bound) {
            return this.isDigitalRandom() ? this.digitalRandom.nextInt(bound) : this.fallbackRandom.nextInt(bound);
        }

        public boolean nextBoolean() {
            return this.isDigitalRandom() ? this.digitalRandom.nextBoolean() : this.fallbackRandom.nextBoolean();
        }

        public void nextBytes(byte[] bytes) {
            if (this.isDigitalRandom()) {
                this.digitalRandom.nextBytes(bytes);
            } else {
                this.fallbackRandom.nextBytes(bytes);
            }

        }

        public long nextLong() {
            return this.isDigitalRandom() ? this.digitalRandom.nextLong() : this.fallbackRandom.nextLong();
        }

        public double nextDouble() {
            return this.isDigitalRandom() ? this.digitalRandom.nextDouble() : this.fallbackRandom.nextDouble();
        }

        public UUID nextUUID() {
            return this.isDigitalRandom() ? this.digitalRandom.nextUUID() : UUID.randomUUID();
        }
    }
}


