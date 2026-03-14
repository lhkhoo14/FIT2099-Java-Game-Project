public class CrewMember {
    private String name;
    private Backpack backpack;

    public CrewMember() {
        this.name = "Steve";
        this.backpack = new Backpack();
    }

    public void checkAllItems() {
        //gets array of items from backpack
        Item[] items = backpack.getItems();
        System.out.println("Crew Member " + name + "'s Backpack contains :");

        for (int i = 0;i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    //Getter for Moon.java to access the backpack
    public Backpack getBackpack() {
        return backpack;
    }
}
