public class UnpackAction extends Action{
    private Item item;

    public UnpackAction(Item item){
        this.item = item;
    }

    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        Backpack backpack = crewMember.getBackpack();

        if (backpack.removeItem(this.item)) {
            moon.addItem(this.item);
            return crewMember.getName() + " unpacked " + this.item.getSimpleName() + " to the moon";
        }
        //if item doesnt exist
        return this.item.getSimpleName() + " can not be packed as it will exceed the backpack limit";
    }

    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " (Energy Level:"+ crewMember.getEnergy() + ") will unpack " + this.item.getSimpleName() + " to the moon";
    }
}