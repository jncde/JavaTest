package generic.recursiveGeneric.builder.genericversion;

import static generic.recursiveGeneric.builder.genericversion.NyPizzaNR.Size.*;
import static generic.recursiveGeneric.builder.genericversion.PizzaNR.Topping.*;

/**
 * if there is generic just row class, we need always to cast to the real class
 */
public class noclient {
  public static void main (String[] args) {
    NyPizzaNR pizza =  new NyPizzaNR.Builder(SMALL)
        .addTopping(SAUSAGE).addTopping(ONION).build();
    CalzoneNR calzone = new CalzoneNR.Builder ().addTopping (HAM).sauceInside().build();

    System.out.println (pizza);
    System.out.println (calzone);
  }
}
