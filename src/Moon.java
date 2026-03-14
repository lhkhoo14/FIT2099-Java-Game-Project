import java.util.concurrent.locks.Lock;

public class Moon {
    private CrewMember crewMember;

    public Moon() {
        this.crewMember = new CrewMember();
    }

    public void simulate(){
        System.out.println("Welcome to FIT2099 Moon\n");

        //the following method will be implemented in the next few requirements
        crewMember.checkAllItems();

        System.out.println("All the best with the exploration!");
    }
}
