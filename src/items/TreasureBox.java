package items;

import actions.Action;
import actions.ActionCapable;
import actions.UnlockAction;
import actions.Unlockable;
import areas.Explorable;
import areas.Factory;
import core.Ability;
import core.CrewMember;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * Represents a TreasureBox that contains items inside
 * Can be unlocked with a usable lockpick
 */
public class TreasureBox extends Item implements Unlockable {
    private ArrayList<Item> container;
    private String source;

    /**
     * Constructs a TreasureBox object with different items inside depending on the source area
     * @param source - the area where the TreasureBox was found
     */
    public TreasureBox(String  source) {
        this.source = source;
        this.container = new ArrayList<>();
        this.weight = 0.5;

        if (this.source.equals("Factory")) {
            container.add(new NutCan("IGA"));
            container.add(new Lockpick("lock", 0.2));
        } else if (this.source.equals("Mansion")) {
            container.add(new TortillaPack("Coles"));
            container.add(new NutCan("IGA"));
        } else if (this.source.equals("MineShaft")) {
            container.add(new TortillaPack("Coles"));
            container.add(new Lockpick("lock", 0.2));
        }
    }

    /**
     * Represents the allowable actions of Treasure Box if crew member has a usable lockpick
     * @param crewMember - Crew Member object interacting with this item
     * @return actions - an ArrayList containing all the allowable actions
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        if (crewMember.hasCapability(Ability.UNLOCK)) {
            actions.add(new UnlockAction(this));
        }
        return actions;
    }

    /**
     * Represents the unlock action
     * @param crewMember - crew member in the simulation
     * @return a String showing the result of the unlock action
     */
    @Override
    public String unlockedBy(CrewMember crewMember) {
        crewMember.removeCapability(Ability.UNLOCK);
        String items = "";
        for (Item item: this.container) {
            crewMember.pack(item);
            items += item + "\n";
        }

        return crewMember.getName() + " unlocked the Treasure Box and obtained:\n" + items;
    }
}
