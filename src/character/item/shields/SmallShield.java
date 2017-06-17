package character.item.shields;

/**
 * @author Matthias Dröge
 */
public class SmallShield extends Shield
{
    public SmallShield()
    {
        this.setName(this.getClass().getSimpleName());
        this.setType(this.getClass().getSimpleName());
        this.setArmorValue(1);
        this.setCat("shields");
    }

    public SmallShield(String inputName, int inputArmorValue)
    {
        this.setName(inputName);
        this.setType(this.getClass().getSimpleName());
        this.setArmorValue(inputArmorValue);
    }
}
