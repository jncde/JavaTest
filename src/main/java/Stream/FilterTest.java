package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class FilterTest extends TestCase {

  @Before
  public void createData(){
    System.out.println ("it works");
  }

  @Test
  public void testFilterNull(){

    List<Person> persons = Arrays.asList (new Person ("p1", 30),
                                          new Person ("p2", 20),
                                          new Person ("p3", 40),
                                          new Person (null,10));

    List<Person> collect = persons.stream ().filter (x -> "jack".equals (x.getName ())).collect (Collectors.toList ());


    List<Person> empty = persons.stream ().filter (x -> "xxxxx".equals (x.getName ())).sorted ((Person a1,
                                                                                                Person a2) -> a1.getName ().compareTo (a2.getName ())).collect (Collectors.toList ());

    Person result1 = persons.stream () // Convert to steam
                            .filter (x -> "jack".equals (x.getName ())) // we want "jack" only
                            .findAny () // If 'findAny' then return found
                            .orElse (null); // If not found, return null

    System.out.println (result1);

    Person result2 = persons.stream ().filter (x -> "noboody".equals (x.getName ())).findAny ().orElse (null);

    assertNull (result2);

  }

  @Test public void testEmptyResult () {

    List<Integer> integers = Arrays.asList (1, 2, 3, 4, 5, 6, 7);

    Set<Integer> collect = integers.stream ().filter (a -> a > 10).collect (Collectors.toSet ());

    assertEquals (0,collect.size ());

  }

}
