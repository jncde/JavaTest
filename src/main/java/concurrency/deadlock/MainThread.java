package concurrency.deadlock;

public class MainThread {

  public static void main (String[] args) {
    Thread mainT = Thread.currentThread ();

    try {

      System.out.println ("enter into deadlock, the thread wait for itself");
      mainT.join ();
      System.out.println ("thie line will never be executed");
    } catch (InterruptedException e) {
      e.printStackTrace ();
    }

  }
}
