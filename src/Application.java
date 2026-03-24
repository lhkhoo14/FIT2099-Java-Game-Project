/**
 * Implement the Application class
 * Creates Moon object to run the simulation
 * Core class to get the whole program running
 */
public class Application {

    /**
     * Creates Moon object and run simulate method by calling moon.simulate()
     * Static method so it can run without an Application object
     * @param args arguments (not-used)
     */
    public static void main(String[] args){

        //Create an instance named moon
        Moon moon = new Moon();
        //call simulate method
        moon.simulate();

    }
}
