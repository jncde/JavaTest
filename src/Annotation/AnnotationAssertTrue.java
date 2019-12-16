package Annotation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

/**
 * https://www.baeldung.com/javax-validation
 */
public class AnnotationAssertTrue {



  public static void main (String[] args){

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    
    User user = new User ();
    user.setWorking (false);

    Set<ConstraintViolation<User>> violations = validator.validate (user);

    for (ConstraintViolation<User> violation : violations) {
      System.out.println (violation.getMessage());
    }

//    testP(false,true);


  }

  public  static  void testP (@AssertTrue boolean p1,@AssertFalse boolean p2) {
    System.out.println ("p1 is "+String.valueOf (p1));
  }

}
