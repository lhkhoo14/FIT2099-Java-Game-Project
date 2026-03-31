package areas;

import actions.Action;
import actions.ExploreAction;
import actions.UnlockRoomAction;
import core.Ability;
import core.CrewMember;
import items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the Mansion area that can be explored by the crew member
 * Added Feature to unlock room in Mansion
 */
public class Mansion implements Explorable {
    private int stamina_consumption;

    /**
     * Constructs a Mansion area with a specific stamina consumption
     */
    public Mansion() {
        this.stamina_consumption = 6;
    }

    /**
     * Allows a crew member to explore the Mansion
     * @param crewMember - crew member in the simulation
     * @return a String describing the results of exploring the Mansion
     */
    @Override
    public String exploredBy(CrewMember crewMember) {
        double discover_chance = 0;
        crewMember.decreaseEnergyLevelBy(stamina_consumption);
        if (crewMember.hasCapability(Ability.UNLOCK)) {
            discover_chance = 1;
        } else {
            discover_chance = 0;
        }

        Random random = new Random();
        if (random.nextDouble() <= discover_chance) {
            TreasureBox treasureBox = new TreasureBox("Mansion");
            crewMember.pack(treasureBox);
            System.out.println("You discovered a TreasureBox and packed it into your backpack!");
        } else {
            System.out.println("There is nothing here.");
        }
        return this.getClass().getSimpleName() + " is being explored by " + crewMember.getName() +
                " and it decreases the energy level by " + stamina_consumption;
    }

    /**
     * Returns the list of allowable actions that a Crew Member can perform in the Mansion
     * Adds unlock room action if crew member has a usable lockpick
     * @param crewMember - crew member in the simulation
     * @return actions - an ArrayList of the allowable actions the crew member can perform
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ExploreAction(this));

        if (crewMember.hasCapability(Ability.UNLOCK)) {
            actions.add(new UnlockRoomAction(this));
        }
        return actions;
    }
}
