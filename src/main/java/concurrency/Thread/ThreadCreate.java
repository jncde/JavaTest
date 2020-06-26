package concurrency.Thread;

/**
 * how to create a thread and start
 *
 * output:
 * Thread 13 is running!
 * Thread 15 is running!
 * Thread 14 is running!
 * Thread 12 is running!
 * Thread 16 is running!
 * Thread 17 is running!
 * Thread 18 is running!
 * Thread 21 is running!
 * Thread 19 is running!
 * Thread 20 is running!
 */
public class ThreadCreate {

  public static void main (String[] args) {
    for (int i = 0; i < 10; i++) {

      Thread tRunable = new Thread (new TRunable ());
      tRunable.start ();

    }
  }
}

/**
 * create a runable,
 */
class TRunable implements Runnable{

  @Override public void run () {
    System.out.println ("Thread "+ Thread.currentThread ().getId ()+ " is running!");
  }
}

