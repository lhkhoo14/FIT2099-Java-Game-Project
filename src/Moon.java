import java.util.ArrayList;
import java.util.List;

public class Moon {
    private CrewMember crewMember;
    private ArrayList<Item> items;

    public Moon() {
        this.crewMember = new CrewMember();
        this.items = new ArrayList<>();
        items.add(new Bottle("Aquafin", 0.5, 1.5));
        items.add(new SterilisationBox("pharmaeng", 5));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void listOutItems() {
        System.out.println("Here are the items we have on the moon:");
        for (Item item: this.items) {
            System.out.println(item);
        }
    }

    public List<Action> allowableActions(){
        List<Action> actions = new ArrayList<>();
        for (Item item: this.items) {
            actions.add(item.getPackAction());
        }
        return actions;
    }

    public void simulate() {
        int iterations = 5;  // number of times to run simulation

        while (iterations > 0) {
            List<Action> actions = new ArrayList<>();
            actions.addAll(this.allowableActions());
            actions.addAll(crewMember.allowableActions());

            System.out.println("########################################");

            crewMember.checkAllItems();
            System.out.println();
            this.listOutItems();
            System.out.println();

            System.out.println("########################################");

            Action action = Menu.showMenu(actions, crewMember);
            System.out.println(action.execute(crewMember, this));

            iterations--;  // decrease loop counter
        }
    }
}