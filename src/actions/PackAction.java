package actions;
import items.*;
import core.*;
/**
 * Implements the PackAction subclass
 * creates a PackAction object with item attribute
 * represents an action where the crewMember packs an item into their backpack
 */
public class PackAction extends Action{
    private Item item;

    /**
     * creates a PackAction object for the specific item
     * @param item item object
     */
    public PackAction(Item item){
        this.item = item;
    }

    /**
     * Override the execute function to pack items into backpack if it doesn't exceed weight limit
     * @param crewMember crewMember object
     * @param moon Moon object
     * @return a String showing the result of the action
     */
    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        Backpack backpack = crewMember.getBackpack();
        //check if backpack will overweight
        if (backpack.add(this.item)) {
            moon.removeItem(this.item);
            return crewMember.getName() + " packed " + this.item.getSimpleName() + " to the backpack";
        }
        return this.item.getSimpleName() + " can not be packed as it will exceed the backpack limit";
    }

    /**
     * Override the method to show allowable actions of the crewMember
     * @param crewMember CrewMember Object
     * @return a String showing the allowable actions the Crew Member can take
     */
    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " (Energy Level:" + crewMember.getEnergy() + ") will pack " + this.item.getSimpleName() + " to the backpack";
    }
}
