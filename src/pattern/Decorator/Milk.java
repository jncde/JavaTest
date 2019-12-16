package pattern.Decorator;

public class Milk extends Decorator {

  public Milk(Beverage b){
    super (b);
    beverage=b;
  }

  @Override public String getDescription () {
    return beverage.getDescription ()+ " and Milk";
  }

  @Override public int getCost () {
    return beverage.getCost () + 1;
  }
}
