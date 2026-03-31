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
 * Represents the Factory area that can be explored by the crew member
 */
public class Factory implements Explorable{
    private int stamina_consumption;
    private double discover_chance;

    /**
     * Constructs a Factory with specific stamina consumption and discover chance of treasure box
     */
    public Factory(){
        this.stamina_consumption = 4;
        this.discover_chance = 0.1;
    }

    /**
     * Allows a crew member to explore the Factory
     * Consumes crew member energy. and has a chance to discover treasure boxes
     * @param crewMember - crew member in the simulation
     * @return a String describing the results of exploring the Factory
     */
    @Override
    public String exploredBy(CrewMember crewMember) {
        crewMember.decreaseEnergyLevelBy(stamina_consumption);
        if (crewMember.hasCapability(Ability.ILLUMINATOR)) {
            this.discover_chance = 0.4;
        } else {
            this.discover_chance = 0.1;
        }

        Random random = new Random();
        if (random.nextDouble() <= discover_chance) {
            TreasureBox treasureBox = new TreasureBox("Factory");
            crewMember.pack(treasureBox);
            System.out.println("You discovered a TreasureBox and packed it into your backpack!");
        } else {
            System.out.println("There is nothing here.");
        }
        return this.getClass().getSimpleName() + " is being explored by " + crewMember.getName() +
                " and it decreases the energy level by " + stamina_consumption;
    }

    /**
     * Returns the list of allowable actions that a crew member can perform in the Factory
     * @param crewMember - crew member in the simulation
     * @return actions - ArrayList containing the allowable actions
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ExploreAction(this));
        return actions;
    }
}
