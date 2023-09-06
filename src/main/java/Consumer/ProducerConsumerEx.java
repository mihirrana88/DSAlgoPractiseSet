package Consumer;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerEx {

  public static void main(String[] args) throws InterruptedException {

    final PC pc = new PC();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pc.produce();
        }catch (InterruptedException e){
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pc.consume();
        }catch (InterruptedException e){
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }

  public static class PC{

    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 0;


    public void produce() throws InterruptedException {
      int val = 0;
      while(true){
        synchronized (this){
          while (capacity == list.size()){
            wait();
          }

          list.add(val++);

          System.out.println("Thread 1: "+list.getLast());

          notify();

          Thread.sleep(1000);
        }
      }
    }

    public void consume() throws InterruptedException {

      while (true){
        synchronized (this){
          while (list.size() == 0){
            wait();
          }

          int val = list.removeFirst();

          System.out.println("Thread 2: "+val);

          notify();

          Thread.sleep(1000);
        }
      }
    }
  }
}