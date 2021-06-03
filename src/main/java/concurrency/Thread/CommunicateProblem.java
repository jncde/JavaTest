package concurrency.Thread;


// Java program to illustrate need
// of Synchronization


/**
 * <pre>
* problem
*
* 1.  1st thread fetches the value of count. (Currently value count is 0) and increases it by one, so value of variable count becomes 1.
* 2.  Now 2nd thread accesses the value of count that would be 0 as 1st thread did not store it back to its location.
* And 2nd thread also increment it and store it back to its location. And 1st also store it.
* 3.Finally value of variable count is 1. But it should be 2 by the effect of both threads. That’s why we need to synchronize the access to shared variable count.
 * 
 * </pre>
 * 
 */

class Geek
{
  String name = "";
  public int count = 0;

  public void geekName(String geek) throws InterruptedException {
    // Only one thread is permitted
    // to change geek's name at a time.
//    synchronized(this)
    {
      for (int i = 0; i < 10; i++) {
        count++; // how many threads change geek's name.
        name = geek;
        Thread.sleep (100);
        //if no syncronize: name and count will be parall changed by multi thread, and get a conflict
        // i is a fucntion variable, has no problem with multi Thread, every function call of thread has its own function variable in fucntion stack
        System.out.println ("Thread "+ Thread.currentThread ().getName ()+" name field:"+name+ "  count: "+count+"   i: "+i);
      }
    }


  }
}


class DemoThread extends Thread{

  Geek geek;
  String name;

  public DemoThread(Geek gk,String geekName){
    this.geek=gk;
    this.name=geekName;
  }

  @Override
  public void run () {
    try {
      geek.geekName (name);
    } catch (InterruptedException e) {
      e.printStackTrace ();
    }

  }
}

public class CommunicateProblem
{
  public static void main (String[] args)
  {
    Geek geek = new Geek ();

    //use the same object
    DemoThread t1 = new DemoThread ( geek,"t1");
    t1.setName ("t1");
    DemoThread t2 = new DemoThread ( geek,"t2");
    t2.setName ("t2");

    DemoThread t3 = new DemoThread (geek, "t3");
    t3.setName ("t3");

    t1.start ();
    t2.start ();
    t3.start ();




  }
}

