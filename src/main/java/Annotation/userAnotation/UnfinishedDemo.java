package Annotation.userAnotation;

@Unfinished (value = "Class scope",priority=Unfinished.Priority.LOW)
public class UnfinishedDemo {
  @Unfinished("Constructor scope")
  public UnfinishedDemo() { }

  @Unfinished(owners="Jason", value="Method scope")
  public void foo() { }
}
