package Stream;

public class Person {

  String name;
  int age;
  Gender gender;

  public Person (String n, int i) {
   this(n,i,null);
  }

  public Person (String n, int i,Gender g){
    name=n;
    age=i;
    gender=g;
  }

  public enum Gender{
    MAN,WOMAN
  }

  public String getName () {
    return name;
  }

  public int getAge () {
    return age;
  }

  public void setAge (int age) {
    this.age = age;
  }

  public void setName (String name) {
    this.name = name;
  }

  public Gender getGender () {
    return gender;
  }

  public void setGender (Gender gender) {
    this.gender = gender;
  }
}
