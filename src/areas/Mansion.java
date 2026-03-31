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

public class Mansion implements Explorable {
    private int stamina_consumption;

    public Mansion() {
        this.stamina_consumption = 6;
    }

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
