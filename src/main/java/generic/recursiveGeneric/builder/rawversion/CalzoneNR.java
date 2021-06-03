package generic.recursiveGeneric.builder.rawversion;

public class CalzoneNR extends PizzaNR {
    private final boolean sauceInside;

    public static class Builder extends PizzaNR.Builder {
        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public CalzoneNR build() {
            return new CalzoneNR (this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private CalzoneNR (Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}