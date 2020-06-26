package Annotation;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

import junit.framework.TestCase;

public class TestAssertTrue extends TestCase {

  @Test
  public void test () {

    asserTureFunc(false);

  }

  private void asserTureFunc(@AssertTrue Boolean mustBeTrue){

  }

  private  void f2(){
    asserTureFunc (false);
  }


}
