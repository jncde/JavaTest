package pattern.Decorator;

public class Espresso implements Beverage {

  @Override public String getDescription () {
    return "esspresso";
  }

  @Override public int getCost () {
    return 3;
  }
}
