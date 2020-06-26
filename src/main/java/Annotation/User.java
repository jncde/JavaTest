package Annotation;

import javax.validation.constraints.AssertTrue;

public class User {

  @AssertTrue
  private boolean working;

  public boolean isWorking () {
    return working;
  }

  public void setWorking (boolean working) {
    this.working = working;
  }
}
