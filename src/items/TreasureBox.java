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

public class TreasureBox extends Item implements Unlockable {
    private ArrayList<Item> container;
    private String source;

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

    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        if (crewMember.hasCapability(Ability.UNLOCK)) {
            actions.add(new UnlockAction(this));
        }
        return actions;
    }

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
