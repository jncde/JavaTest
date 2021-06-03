package generic.recursiveGeneric.builder.rawversion;

import static generic.recursiveGeneric.builder.rawversion.NyPizzaNR.Size.*;
import static generic.recursiveGeneric.builder.rawversion.PizzaNR.Topping.*;

/**
 * if there is generic just row class, we need always to cast to the real class
 */
public class noclient {
  public static void main (String[] args) {
    //!!!!need cast here
    NyPizzaNR pizza = (NyPizzaNR) new NyPizzaNR.Builder(SMALL)
        .addTopping(SAUSAGE).addTopping(ONION).build();
    CalzoneNR.Builder builder = (CalzoneNR.Builder)(new CalzoneNR.Builder ().addTopping (HAM));
    CalzoneNR calzone = builder.sauceInside().build();

    System.out.println (pizza);
    System.out.println (calzone);
  }
}
