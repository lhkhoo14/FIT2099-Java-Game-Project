import java.util.ArrayList;
import java.util.List;

/**
 * Represents the moon in the simulation
 * Contains scattered items on the surface that the crew member can pack
 */
public class Moon {
    private CrewMember crewMember;
    private ArrayList<Item> items;

    /**
     * Creates Moon object with a CrewMember and ArrayList containing scattered items on the moon
     */
    public Moon() {
        this.crewMember = new CrewMember();
        this.items = new ArrayList<>();

        //Setting up values
        items.add(new Bottle("Aquafin", 0.5, 1.5));
        items.add(new SterilisationBox("pharmaeng", 5));
    }

    /**
     * Adds item to the moon's surface
     * @param item - Moon attribute
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes item from the moon's surface
     * @param item - Moon attribute
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Prints all the scattered items on the moon to the console
     */
    public void listOutItems() {
        System.out.println("Here are the items we have on the moon:");
        for (Item item: this.items) {
            System.out.println(item);
        }
    }

    /**
     * Return an ArrayList of allowable pack actions of each item on the moon
     * @return actions - ArrayList containing PackAction object of each item on the moon
     */
    public List<Action> allowableActions(){
        List<Action> actions = new ArrayList<>();
        for (Item item: this.items) {
            actions.add(item.getPackAction());
        }
        return actions;
    }

    /**
     * Runs the simulation
     * Loops a fixed number of iterations, each loop displays the items on the moon and inside backpack
     * ,shows a menu of allowable actions and asks for input
     */
    public void simulate() {
        //while loop of five iterations
        int iterations = 5;

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