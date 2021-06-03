package jvm.init;

/**
 * <pre>
 * execution orders:
 * 1. preparation static variable (count1 and count2) with default value 0 
 * 2. execute constructor 
 * 3.init static variable constructor at
 * </pre>
 */
public class StaticVariableLoadOrder {

  public static void main (String[] args) {
    Singleton singleton = Singleton.getInstance ();
    System.out.println ("counter1:" + Singleton.counter1);
    System.out.println ("counter2:" + Singleton.counter2);
  }
}

class Singleton {

  public static Singleton instance = new Singleton ();
  public static int       counter1 = 1;

  private Singleton () {
    counter1++;
    counter2++;
    System.out.println ("构造方法里：counter1:" + counter1 + ",counter2:" + counter2);
  }

  public static int counter2 = 0;

  public static Singleton getInstance () {
    return instance;
  }
}
