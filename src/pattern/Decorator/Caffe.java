package pattern.Decorator;

public class Caffe implements Beverage {

  @Override public String getDescription () {
    return "caffe";
  }

  @Override public int getCost () {
    return 4;
  }
}
