import java.util.List;
import java.util.ArrayList;

public class CrewMember {
    private String name;
    private Backpack backpack;
    private int energy;

    public CrewMember() {
        this.name = "Steve";
        this.backpack = new Backpack();
        this.energy = 30;
    }

    public void checkAllItems() {
        //gets array of items from backpack
        List<Item> items = backpack.getItems();
        System.out.println("Crew Member " + name + "'s Backpack contains :");

        for (int i = 0;i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    public List<Action> allowableActions(){
        List<Action> actions = new ArrayList<>();
        actions = backpack.allowableActions(); //call the backpack's allowable actions
        return actions;
    }

    //Getter for Moon.java to access the backpack
    public Backpack getBackpack() {
        return backpack;
    }
    //Getter to access crewMember name
    public String getName(){
        return name;
    }
    //Getter to access energy
    public int getEnergy(){
        return energy;
    }
}