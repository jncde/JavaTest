package generic.recursiveGeneric.builder.rawversion;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder pattern for class hierarchies
public abstract class PizzaNR {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    //!!!!!!diference only for a warning??
    abstract static class Builder {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public Builder addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract PizzaNR build();

        // Subclasses must override this method to return "this"
        protected abstract Builder self();
    }

    PizzaNR (Builder builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}