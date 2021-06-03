package generic.recursiveGeneric.builder.recursiveG;

import static generic.recursiveGeneric.builder.recursiveG.NyPizza.Size.*;
import static generic.recursiveGeneric.builder.recursiveG.Pizza.Topping.*;

/**
 *
 * goal:  Java泛型让声明方法返回子类型（泛型递归模式）
 *
 *
 * https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual/blob/dev/Chapter-2/Chapter-2-Item-2-Consider-a-builder-when-faced-with-many-constructor-parameters.md
 *
 *Chapter 2. Creating and Destroying Objects
 *
 *
 *
 *
 *
 */
public class RGClient {

  public static void main (String[] args) {
    //!!!!do not need cast here
    NyPizza pizza = new NyPizza.Builder(SMALL)
        .addTopping(SAUSAGE).addTopping(ONION).build();
    Calzone calzone = new Calzone.Builder()
        .addTopping(HAM).sauceInside().build();

    System.out.println (pizza);
    System.out.println (calzone);
  }

}
