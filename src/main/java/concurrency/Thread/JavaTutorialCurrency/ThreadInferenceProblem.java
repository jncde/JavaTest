package concurrency.Thread.JavaTutorialCurrency;

// Java program to illustrate need
// of Synchronization

/**
 * <pre>
* problem
*
* https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
 * 
 * </pre>
 * 
 */

public class ThreadInferenceProblem {

  public static void main (String[] args) {
    GeekCounter geek = new GeekCounter ();

    // use the same object
    CounterThread t1 = new CounterThread (geek);
    CounterThread t2 = new CounterThread (geek);
    CounterThread t3 = new CounterThread (geek);
    CounterThread t4 = new CounterThread (geek);
    CounterThread t5 = new CounterThread (geek);

    t1.start ();
    t2.start ();
    t3.start ();
    t4.start ();
    t5.start ();

    try {
      t1.join ();
      t2.join ();
      t3.join ();
      t4.join ();
      t5.join ();
    } catch (InterruptedException e) {
      e.printStackTrace ();
    }

    // expected is 3000*5=15000
    System.out.println ("geek count" + geek.count);

  }

  private static class GeekCounter {

    public int count = 0;

    public void increaseCounter () {
      // synchronized(this)
      {
        for (int i = 0; i < 3000; i++) {
          count++; // how many threads change geek's name.
        }
      }

    }
  }

  static class CounterThread extends Thread {

    GeekCounter geek;

    public CounterThread (GeekCounter gk) {
      this.geek = gk;
    }

    @Override
    public void run () {
      geek.increaseCounter ();

    }
  }

}
