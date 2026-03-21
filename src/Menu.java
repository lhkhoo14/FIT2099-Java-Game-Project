import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    //static method so can be used without instantiating an object
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
