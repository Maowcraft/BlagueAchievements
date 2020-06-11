package maowcraft.blagueachievements;

// I am not very good at writing javadocs.
/**
 * The main Achievement class, used to handle how an achievement is viewed, grabbed, etc.
 */
@SuppressWarnings("unused")
public final class Achievement {
    private final AchievementSpecification spec;
    private final String name;
    private final String description;
    private boolean isCompleted;
    private boolean isAccessible;

    public Achievement(Builder builder) {
        this.spec = builder.spec;
        this.name = builder.name;
        this.description = builder.description;
        this.isCompleted = spec.isAchievementCompleted();
        this.isAccessible = spec.isAchievementAccessible();
    }

    /**
     * A quick null-checker, should probably be used any time an Achievement instance is accessed and not previously null-checked.
     *
     * @return boolean
     */
    public boolean validate() {
        return spec != null && name != null && description != null;
    }

    /**
     * Updates the values for isCompleted and isAccessible.
     */
    public void update() {
        this.isCompleted = spec.isAchievementCompleted();
        this.isAccessible = spec.isAchievementAccessible();
    }

    public AchievementSpecification getSpecification() {
        return spec;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    /**
     * A builder inner-class that returns an instance of Achievement.
     */
    public static class Builder {
        private AchievementSpecification spec;
        private String name;
        private String description;

        public Builder() {}

        /**
         * Creates a new instance of Achievement.Builder.
         *
         * @return Builder
         */
        public static Builder newInstance() {
            return new Builder();
        }

        // Tip: Make sure you make a class that extends the AchievementSpecification interface.
        public Builder setSpecification(AchievementSpecification spec) {
            this.spec = spec;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Adds a new String to the description, essentially appending it.
         *
         * @param appended - A String that will be appended to the end of the description.
         * @return Builder
         */
        public Builder appendDescription(String appended) {
            this.description = description + " " + appended;
            return this;
        }

        /**
         * Creates a new instance of Achievement based on the given builder, also adds it to the util's all achievements list.
         *
         * @return Achievement
         */
        public Achievement build() {
            Achievement built = new Achievement(this);
            AchievementUtils.allAchievements.add(built);
            return built;
        }
    }
}
