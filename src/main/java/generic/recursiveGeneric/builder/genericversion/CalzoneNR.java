package generic.recursiveGeneric.builder.genericversion;

public class CalzoneNR extends PizzaNR {
    private final boolean sauceInside;

    public static class Builder extends PizzaNR.Builder<Builder> {
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