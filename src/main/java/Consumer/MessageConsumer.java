package Consumer;

import java.util.List;
import java.util.Queue;

public class MessageConsumer extends Thread {

    @Override
    public void run(){

    }

    public void consumeMessage(Queue<String> queue, List<String> emailListerners){
        if(!queue.isEmpty()){
            String msg = queue.poll();
            if(msg.contains("red")) {
                System.out.println(msg);
                triggerEmailNotification(msg, emailListerners);
            }
        }
    }

    private void triggerEmailNotification(String msg, List<String> emailListerners){
        if(null != emailListerners && emailListerners.size() > 0){
            for(String emailID : emailListerners){
                System.out.println("Email being sent to: "+emailID+" , message: "+msg);
            }
        }
    }
}
