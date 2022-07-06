package Producer;

import java.util.Queue;

public class MessageProducer extends Thread {

    public void produceMessage(Queue<String> queue, String message){
        queue.add(message);
    }

    @Override
    public void run(){

    }
}
