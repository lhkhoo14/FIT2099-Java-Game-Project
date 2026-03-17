import java.util.ArrayList;

public class Moon {
    private CrewMember crewMember;
    private ArrayList<Item> items;

    public Moon() {
        this.crewMember = new CrewMember();
        this.items = new ArrayList<>();
    }

    public void simulate(){
        System.out.println("Welcome to FIT2099 Moon\n");

        //the following method will be implemented in the next few requirements
        crewMember.checkAllItems();

        System.out.println("All the best with the exploration!");
    }
}
