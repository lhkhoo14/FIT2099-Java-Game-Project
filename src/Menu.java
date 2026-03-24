import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Implements a menu showing all allowable actions for the CrewMember to execute
 * returns the corresponding Action object that has been selected
 * Has a static method so it can be called without instantiate a Menu object
 */
public class Menu {
    /**
     * a static method that display a menu of allowable actions for CrewMember,
     * reads user input and returns the corresponding action object
     * can be executed without a Menu object
     * @param actions List of Action objects
     * @param crewMember CrewMember object
     * @return the Action object selected
     */
    public static Action showMenu(List<Action> actions, CrewMember crewMember) {
        Scanner scanner = new Scanner(System.in);
        Character startChar = 'a';

        Map<Character, Action> keyToActionMap = new HashMap<>();

        //prints out option "a,b,c,..." each with their corresponding actions
        for (Action action: actions) {
            keyToActionMap.put(startChar, action);
            System.out.println(startChar + ": " + action.menuDescription(crewMember));
            startChar++;
        }

        //while loop to keep asking for input if the input wasn't an option
        char key;
        do {
            key = scanner.next().charAt(0);
        } while (!keyToActionMap.containsKey(key));

        //return the object created by our chosen action
        return keyToActionMap.get(key);
    }
}
