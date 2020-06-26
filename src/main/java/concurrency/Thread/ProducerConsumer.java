package concurrency.Thread;

import java.util.LinkedList;

/**
 * Lets understand how our produce and consume method works.
 *
 * 1. First of all, use of synchronized block ensures that only one thread at a time runs. Also since there is a sleep method just at the beginning of consume loop, the produce thread gets a kickstart.
 * 2. When the wait is called in produce method, it does two things. Firstly it releases the lock it holds on PC object. Secondly it makes the produce thread to go on a waiting state until all other threads have terminated, that is it can again acquire a lock on PC object and some other method wakes it up by invoking notify or notifyAll on the same object.
 * 3. Therefore we see that as soon as wait is called, the control transfers to consume thread and it prints -“Waiting for return key”.
 * 4. After we press the return key, consume method invokes notify(). It also does 2 things- Firstly, unlike wait(), it does not releases the lock on shared resource therefore for getting the desired result, it is advised to use notify only at the end of your method. Secondly, it notifies the waiting threads that now they can wake up but only after the current method terminates.
 * 5. As you might have observed that even after notifying, the control does not immediately passes over to the produce thread. The reason for it being that we have called Thread.sleep() after notify(). As we already know that the consume thread is holding a lock on PC object, another thread cannot access it until it has released the lock. Hence only after the consume thread finishes its sleep time and thereafter terminates by itself, the produce thread cannot take back the control.
 * 6. After a 2 second pause, the program terminates to its completion.
 */
public class ProducerConsumer {

  public static void main (String[] args) throws InterruptedException {
    PC2 pc = new PC2 ();

    Thread producer = new Thread (new Runnable () {

      @Override public void run () {
        try {
          pc.produce ();
        } catch (InterruptedException e) {
          e.printStackTrace ();
        }
      }
    });
    producer.setName ("producer-Thread");

    Thread consumer = new Thread (new Runnable () {

      @Override public void run () {
        try {
          pc.consume ();
        } catch (InterruptedException e) {
          e.printStackTrace ();
        }
      }
    });

    consumer.setName ("consumer-thread");


    producer.start ();
    consumer.start ();

//    producer.join ();
//    consumer.join ();
  }

}

class PC2{

  LinkedList<Integer> list = new LinkedList<> ();
  int capacity = 2;


  public void produce() throws InterruptedException {
//    while (true) {
//
//      synchronized (stack){
//        System.out.println (Thread.currentThread ().getName () + " stack size:" + stack.size ());
//        if (stack.size () == 5) {
//
//          notify ();
//          System.out.println ("Producer: notify consumer");
//          System.out.println (Thread.currentThread ().getName () + " is waiting");
//          wait ();
//          Thread.sleep (1000);
//        } else {
//          i++;
//          stack.push (i);
//          System.out.println (
//              "Producer: " + Thread.currentThread ().getName () + " stack size:" + stack.size () + " put " + i);
//
//        }
//      }
//
//    }


    int value = 0;
    while (true) {
      synchronized (list)
      {
        // producer thread waits while list
        // is full
        while (list.size() == capacity)
          wait();

        System.out.println("Producer produced-"
                           + value);

        // to insert the jobs in the list
        list.add(value++);

        // notifies the consumer thread that
        // now it can start consuming
        notify();

        // makes the working of program easier
        // to  understand
        Thread.sleep(1000);
      }
    }
  }


  public void consume() throws InterruptedException
  {
    while (true) {
      synchronized (this)
      {
        // consumer thread waits while list
        // is empty
        while (list.size() == 0)
          wait();

        // to retrive the ifrst job in the list
        int val = list.removeFirst();

        System.out.println("Consumer consumed-"
                           + val);

        // Wake up producer thread
        notify();

        // and sleep
        Thread.sleep(1000);
      }
    }
  }

//  public void consume() throws InterruptedException {
//    System.out.println ("Consumer: "+Thread.currentThread ().getName ()+" begin");
//      System.out.println ("Consumer: start");
//      while (true) {
//
//        synchronized (this) {
//
//                  while (list.size() == 0)
//                    wait();
//
//          if (stack.size () == 0){
//            wait ();
//            Thread.sleep (1000);
//            notify ();
//            System.out.println ("consumer notify producer");
//          }else{
//            int pop = (int) stack.pop ();
//            System.out.println ("Consumer pop: " + pop);
//          }
//        }
//      }
//
//    }



}
