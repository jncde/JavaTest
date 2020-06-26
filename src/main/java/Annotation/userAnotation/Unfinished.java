package Annotation.userAnotation;

/**
 * purpose: create an user defined annotation
 * https://www.oracle.com/technical-resources/articles/hunter-meta1.html
 */
public @interface Unfinished {


  public enum Priority { LOW, MEDIUM, HIGH }

  String value();
  String[] owners() default "";
  Priority priority() default Priority.MEDIUM;
}
