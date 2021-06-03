package concurrency.Thread.JavaTutorialCurrency;

/**
 * <pre>
 *   why should both funtions(bow and backbow) be syncronizd? 
 *   why is there no deadlock any more, if i remove one of the syncronaize from one function?
 *   ans: if no syncronize, then Thread do not need acquire Intrinsic  lock for a friend object. if no lock, then no deadlock.
 *   When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object and releases it when the method returns. 
 *   The lock release occurs even if the return was caused by an uncaught exception.
 *   
 *   why occurs the deadlock here?
 * 
 * 1. thread 1: alphonse.bow(). To enter this method, thread 1 acquires the lock of alphonse, since the bow() method is synchronized.
 * 2. thread 2: gaston.bow(). To enter this method, thread 2 acquires the lock of gaston, since the bow() method is synchronized.
 * 3. thread 1: gaston.bowBack(). To enter this method, thread 1 needs to acquire the lock of gaston, since the bowBack() method is synchronized. It waits until thread 2 has released the lock of gaston
 * 4. thread 2: alphonse.bowBack(). To enter this method, thread 2 needs to acquire the lock of alphonse, since the bowBack() method is synchronized. It waits until thread 1 has released the lock of alphonse
 * 
 * 
 * </pre>
 */
public class Deadlock {

  static class Friend {

    private final String name;

    public Friend (String name) {
      this.name = name;
    }

    public String getName () {
      return this.name;
    }

    public synchronized void bow (Friend bower) {
      System.out.format ("%s call bow !%n", this.name);
      try {
        Thread.sleep (2000);
      } catch (InterruptedException e) {
        e.printStackTrace ();
      }
      System.out.format ("%s: %s" + "  has bowed to me!%n", this.name, bower.getName ());
      bower.bowBack (this);

    }

    public synchronized void bowBack (Friend bower) {
      System.out.format ("%s: %s" + " has bowed back to me!%n", this.name, bower.getName ());
    }
  }

  public static void main (String[] args) {
    final Friend alphonse = new Friend ("Alphonse");
    final Friend gaston = new Friend ("Gaston");
    new Thread (new Runnable () {

      public void run () {
        alphonse.bow (gaston);
      }
    }).start ();
    new Thread (new Runnable () {

      public void run () {
        gaston.bow (alphonse);
      }
    }).start ();
  }
}
