package actions;
import core.*;
/**
 * Abstract parent class for concrete class PackAction and UnpackAction
 */
public abstract class Action {
    /**
     * Execute the given action
     * @param crewMember crewMember object
     * @param moon Moon object
     * @return a String determining the results of the action
     */
    public abstract String execute(CrewMember crewMember, Moon moon);

    /**
     * Shows the allowable actions in the menu
     * @param crewMember CrewMember Object
     * @return a String showing all the allowable actions for the menu
     */
    public  abstract String menuDescription(CrewMember crewMember);

}
