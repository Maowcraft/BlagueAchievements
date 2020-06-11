package maowcraft.blagueachievements;

import java.util.HashMap;

/**
 * An interface which holds all the code pertaining to how achievements function.
 */
@SuppressWarnings("unused")
public interface AchievementSpecification {
    /**
     * What to do when the achievement is completed.
     */
    void onCompletion();

    /**
     * A list of all 'requirements', a String and boolean, that need to be completed before the associated Achievement is completed.
     * The String acts as a key for the boolean, if all booleans == true, then the associated Achievement is complete.
     *
     * @return HashMap
     */
    HashMap<? extends String, ? extends Boolean> requirements();

    /**
     * The specification which this specification belongs to, used for branching achievements together.
     *
     * @return AchievementSpecification
     */
    default AchievementSpecification parent() { return null; }

    /**
     * A method which checks to make sure all requirements are completed, used to check if the achievement is completed.
     *
     * @return boolean
     */
    default boolean areRequirementsComplete() { return !requirements().containsValue(false); }

    /**
     * A method which checks to see if the associated Achievement is completed.
     * Also used in parent specifications to see if the child specification can be accessed.
     *
     * @return boolean
     */
    default boolean isAchievementCompleted() { return areRequirementsComplete(); }

    /**
     * A method which checks to see if the associated Achievement is accessible.
     *
     * @return boolean
     */
    default boolean isAchievementAccessible() {
        if (parent() != null) {
            return parent().isAchievementCompleted();
        }
        return true;
    }


}
