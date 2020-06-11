package maowcraft.blagueachievements;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that handles a single list used for registering and handling all achievements.
 */
@SuppressWarnings("unused")
public class AchievementUtils {
    public static List<Achievement> allAchievements = new ArrayList<>();

    /**
     * Grabs all achievements found to be completed from the list and returns them in a list.
     *
     * @param achievementList - A list of achievements.
     * @return completedAchievements - All completed achivements found in the list.
     */
    public static List<Achievement> getCompletedAchievementsList(List<Achievement> achievementList) {
        List<Achievement> completedAchievements = new ArrayList<>();
        for (Achievement achievement : achievementList) {
            if (achievement.getSpecification().isAchievementCompleted()) {
                completedAchievements.add(achievement);
            }
        }
        return completedAchievements;
    }

    /**
     * Grabs all achievements found to be inaccessible from the list and returns them in a list.
     *
     * @param achievementList - A list of achievements.
     * @return inaccessibleAchievements - All inaccessible achivements found in the list.
     */
    public static List<Achievement> getInaccessibleAchievementsList(List<Achievement> achievementList) {
        List<Achievement> inaccessibleAchievements = new ArrayList<>();
        for (Achievement achievement : achievementList) {
            if (!achievement.getSpecification().isAchievementAccessible()) {
                inaccessibleAchievements.add(achievement);
            }
        }
        return inaccessibleAchievements;
    }

    /**
     * Grabs all achievements found to be uncompleted from the list and returns them in a list.
     *
     * @param achievementList - A list of achievements.
     * @return uncompletedAchievements - All uncompleted achivements found in the list.
     */
    public static List<Achievement> getUncompletedAchievementsList(List<Achievement> achievementList) {
        List<Achievement> uncompletedAchievements = new ArrayList<>();
        for (Achievement achievement : achievementList) {
            if (achievement.getSpecification().isAchievementAccessible() && !achievement.getSpecification().isAchievementCompleted()) {
                uncompletedAchievements.add(achievement);
            }
        }
        return uncompletedAchievements;
    }

    /**
     * Grabs all achievements found to be in-progress from the list and returns them in a list.
     *
     * @param achievementList - A list of achievements.
     * @return inprogressAchievements - All in-progress achivements found in the list.
     */
    public static List<Achievement> getInProgressAchievementsList(List<Achievement> achievementList) {
        List<Achievement> inprogressAchievements = new ArrayList<>();
        for (Achievement achievement : achievementList) {
            if (achievement.getSpecification().isAchievementAccessible() && !achievement.getSpecification().isAchievementCompleted() && achievement.getSpecification().requirements().containsValue(true)) {
                inprogressAchievements.add(achievement);
            }
        }
        return inprogressAchievements;
    }

    /**
     * Updates all achievement's values.
     * Preferably would be run every time the achievements needed to be grabbed.
     *
     * @param achievementList = A list of achievements.
     */
    public void updateAll(List<Achievement> achievementList) {
        for (Achievement achievement : achievementList) {
            achievement.update();
        }
    }
}
