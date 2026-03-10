public class Item {
    String brand;  //
    double weight; //item weight

    public Item(String brand, double weight) {
        this.brand = brand;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "The item = " + this.brand + ", weight = " + this.weight + "g";
    }

    public static void main(String[] args) {
        Item item = new Item("Bottle", 50);
        System.out.println(item);
    }
}

