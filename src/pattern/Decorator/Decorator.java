package pattern.Decorator;

public abstract class Decorator implements Beverage {

  protected Beverage beverage;

  public abstract String getDescription ();

  public Decorator(Beverage b){
    this.beverage=b;
  }
  
}
