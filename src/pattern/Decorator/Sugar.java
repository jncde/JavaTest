package pattern.Decorator;

public class Sugar extends Decorator {


  public Sugar(Beverage b){
    super(b);
  }

  @Override public String getDescription () {
    return beverage.getDescription ()+ " with milk";
  }

  @Override public int getCost () {
    return beverage.getCost ()+ 6;
  }
}
