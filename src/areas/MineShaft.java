package areas;

import actions.Action;
import actions.ExploreAction;
import core.Ability;
import core.CrewMember;
import items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the MineShaft area that a crew member can explore
 */
public class MineShaft implements Explorable{
    private int stamina_consumption;
    private double discover_chance;

    /**
     * Constructs a MineShaft area with a specific stamina consumption and discover chance of treasure boxes
     */
    public MineShaft(){
        this.stamina_consumption = 5;
        this.discover_chance = 0.3;
    }

    /**
     * Allows the crew member to explore the MineShaft
     * @param crewMember - crew member in the simulation
     * @return a String describing the results of the exploration and energy loss
     */
    @Override
    public String exploredBy(CrewMember crewMember) {
        crewMember.decreaseEnergyLevelBy(stamina_consumption);
        if (crewMember.hasCapability(Ability.STERILISE)) {
            crewMember.pack(new NutCan("IGA"));
            System.out.println("You found a NutCan and packed it into your backpack.");
        }

        Random random = new Random();
        if (random.nextDouble() <= discover_chance) {
            TreasureBox treasureBox = new TreasureBox("MineShaft");
            crewMember.pack(treasureBox);
            System.out.println("You discovered a TreasureBox and packed it into your backpack!");
        } else {
            System.out.println("There is nothing here.");
        }
        return this.getClass().getSimpleName() + " is being explored by " + crewMember.getName() +
                " and it decreases the energy level by " + stamina_consumption;
    }

    /**
     * Returns a list of allowable actions that a crew member can perform in the MineShaft
     * @param crewMember - crew member in the simulation
     * @return actions - an ArrayList of the allowable actions that the crew member can perform
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ExploreAction(this));
        return actions;
    }
}
