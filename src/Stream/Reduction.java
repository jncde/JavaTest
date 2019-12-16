package Stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reduction extends TestCase {

  @Test
  public void testReduce () {

    List<String> strings = Arrays.asList ("a", "b", "c", "d");
    String START_A_B_C_D = "start_a_b_c_d";

    BinaryOperator<String> bf = (a,
                                 b) -> a + "_" + b;

    String start = strings.stream ().reduce ("start", bf);
    assertEquals (START_A_B_C_D, start);

    Optional<String> nodefault = strings.stream ().reduce (bf);
    assertEquals ("a_b_c_d", nodefault.get ());
  }

  @Test
  public void testCollect () {
    List<String> strings = Arrays.asList ("a", "b", "c", "d");

    HashSet<Object> result = strings.stream ()
                                    .collect (HashSet::new,
                                              (set,
                                               s) -> set.add (s),
                                              (set1,
                                               set2) -> set1.addAll (set2));
    assertTrue (result.size () == 4);

    Collector<? super String, List<? super String>, List<? super String>> collector = new Collector<String, List<? super String>, List<? super String>> () {

      @Override
      public Supplier<List<? super String>> supplier () {
        return new Supplier<List<? super String>> () {

          @Override
          public List<? super String> get () {
            return new ArrayList<> ();
          }
        };
      }

      @Override
      public BiConsumer<List<? super String>, String> accumulator () {
        return new BiConsumer<List<? super String>, String> () {

          @Override
          public void accept (List<? super String> objects,
                              String s) {
            objects.add (s);
          }
        };
      }

      @Override
      public BinaryOperator<List<? super String>> combiner () {
        return new BinaryOperator<List<? super String>> () {

          @Override
          public List<? super String> apply (List<? super String> objects,
                                             List<? super String> objects2) {

            for (Object s2: objects2) {
              objects.add ((String) s2);
            }

            return objects;
          }
        };
      }

      @Override
      public Function<List<? super String>, List<? super String>> finisher () {
        return (a) -> {
          return a;
        };
      }

      @Override
      public Set<Characteristics> characteristics () {
        return new HashSet<> ();
      }
    };

    List<? super String> collect = strings.stream ().map (a -> a + 1).collect (collector);

    assertTrue (collect.size () == 4);

    List<String> collect2 = strings.stream ().map (a -> a + 1).collect (Collectors.toList ());

    assertTrue (collect2.size () == 4);

  }

  @Test
  public void testGroup () {
    List<Person> people = Arrays.asList (new Person ("tom", 13, Person.Gender.MAN),
                                         new Person ("tom2", 15, Person.Gender.WOMAN),
                                         new Person ("tom3", 3, Person.Gender.MAN),
                                         new Person ("tom4", 20, Person.Gender.MAN));

    Map<Person.Gender, Integer> group = people.stream ()
                                                .collect (Collectors.groupingBy (Person::getGender,
                                                                                 Collectors.reducing (0,
                                                                                                      Person::getAge,
                                                                                                      Integer::sum)));



    assertTrue (group.entrySet ().size ()==2);

    assertTrue (group.get (Person.Gender.MAN)==36);
    assertTrue (group.get (Person.Gender.WOMAN)==15);

  }

}
