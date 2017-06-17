package character.item.shields;

/**
 * @author Matthias Dröge
 */
public class MediumShield extends Shield
{
    public MediumShield()
    {
        this.setName(this.getClass().getSimpleName());
        this.setType(this.getClass().getSimpleName());
        this.setArmorValue(2);
        this.setCat("shield");
    }

    public MediumShield(String inputName, int inputArmorValue)
    {
        this.setName(inputName);
        this.setType(this.getClass().getSimpleName());
        this.setArmorValue(inputArmorValue);
    }
}
