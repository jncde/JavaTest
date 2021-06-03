package generic.recursiveGeneric.builder.genericversion;

import java.util.Objects;

public class NyPizzaNR extends PizzaNR {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends PizzaNR.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizzaNR build() {
            return new NyPizzaNR (this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizzaNR (Builder builder) {
        super(builder);
        size = builder.size;
    }
}