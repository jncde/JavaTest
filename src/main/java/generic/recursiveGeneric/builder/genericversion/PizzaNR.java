package generic.recursiveGeneric.builder.genericversion;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder pattern for class hierarchies
public abstract class PizzaNR {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    //!!!!!!diference only for a warning??
    abstract static class Builder<T extends Builder> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract PizzaNR build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    PizzaNR (Builder builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}