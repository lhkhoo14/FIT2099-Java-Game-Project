import javax.security.auth.login.CredentialException;

public class PackAction extends Action{
    private Item item;

    public PackAction(Item item){
        this.item = item;
    }

    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        return this.item.getSimpleName() + "can not be packed as it will exceed the backpack limit";
    }

    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember + "will pack" + this.item.getSimpleName() + "to the backpack";
    }
}
