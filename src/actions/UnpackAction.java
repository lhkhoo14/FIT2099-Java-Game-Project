package actions;
import core.*;
import items.*;
/**
 * Implements the UnpackAction subclass
 * Creates an UnpackAction object with item attribute
 * Represents an Action object where the CrewMember unpacks items onto the moon
 */
public class UnpackAction extends Action{
    private Item item;

    /**
     * Creates UnpackAction object with specific item
     * @param item item object
     */
    public UnpackAction(Item item){
        this.item = item;
    }

    /**
     * Override execute method to unpack the item inside backpack onto the moon if it exists
     * @param crewMember crewMember object
     * @param moon Moon object
     * @return a String determining the result of the action
     */
    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        Backpack backpack = crewMember.getBackpack();
        //if item exist
        if (backpack.removeItem(this.item)) {
            moon.addItem(this.item);
            return crewMember.getName() + " unpacked " + this.item.getSimpleName() + " to the moon";
        }
        //if item doesnt exist
        return this.item.getSimpleName() + " can not be unpacked as it does not exist.";
    }

    /**
     * Override the menuDescription method to show allowable actions for the CrewMember
     * @param crewMember CrewMember Object
     * @return a String showing the executable action of the CrewMember
     */
    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " (Energy Level:"+ crewMember.getEnergy() + ") will unpack " + this.item.getSimpleName() + " to the moon";
    }
}