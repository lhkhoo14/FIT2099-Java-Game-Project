package areas;

import actions.Action;
import core.Ability;
import core.CrewMember;
import items.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Factory implements Explorable{
    private int stamina_consumption;
    private double discover_chance;

    public Factory(){
        this.stamina_consumption = 4;
        this.discover_chance = 0.1;
    }

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
            TreasureBox treasureBox = new TreasureBox();
            crewMember.pack(treasureBox);
            System.out.println("You discovered a TreasureBox and packed it into your backpack!");
        } else {
            System.out.println("There is nothing here.");
        }
        return this.getClass().getSimpleName() + " is being explored by " + crewMember.getName() +
                " and it decreases the energy level by " + stamina_consumption;
    }

    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ExploreAction(this));
        return actions;
    }
}
