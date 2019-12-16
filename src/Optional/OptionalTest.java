package Optional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
 */

class Usb{

}

class SoundCard {

  String code;

  SoundCard (String code) {
    this.code = code;
  }

  @Override public int hashCode () {
    return code.hashCode ();
  }

  public String getCode () {
    return code;
  }
}

public class OptionalTest {

  public static void main (String[] args) {
    SoundCard s1 = new SoundCard ("s1");
    Optional<SoundCard> sc = Optional.of (s1);

    SoundCard sNul = null;
    try {
      Optional<SoundCard> s21 = Optional.of (sNul);
    } catch (Exception e) {
      e.printStackTrace ();
    }

    Optional<SoundCard> os3 = Optional.ofNullable (sNul);

    System.out.println (os3);
    try {
      System.out.println (os3.get ());
    } catch (Exception e) {
      e.printStackTrace ();
    }

    System.out.println (os3.orElse (new SoundCard ("empty")));

    ArrayList<SoundCard> scs = new ArrayList<> ();
    scs.add (s1);
    scs.add (new SoundCard (null));

    //null point
    try {
      scs.stream ().map (SoundCard::getCode).collect (Collectors.toSet ());
    } catch (Exception e) {
      System.out.println ("hashcode null");
      e.printStackTrace ();
    }


    scs = new ArrayList<> ();
    scs.add (s1);
    scs.add (new SoundCard (null));
    Set<String> codes = scs.stream ()
                                       .map (SoundCard::getCode).collect (Collectors.toSet ());

    System.out.println (codes.toString ());

  }
}
