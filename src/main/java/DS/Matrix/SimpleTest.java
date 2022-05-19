package DS.Matrix;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleTest {

    public void updateMap(){



       final String resource1 = "M";
       final String resource2 = "N";

        Thread thread1 = new Thread(){
            public void run(){
                synchronized (resource1){
                    System.out.println("thread 1 resource 1");
                }

                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }

                synchronized (resource2){
                    System.out.println("thread 1 resource 2");
                }
            }
        };


        Thread thread2 = new Thread(){
            public void run(){
                synchronized (resource2){
                    System.out.println("thread 2 resource 2");
                }

                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }

                synchronized (resource1){
                    System.out.println("thread 2 resource 1");
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
