package character.item.shields;

/**
 * @author Matthias Dröge
 */
public class HeavyShield extends Shield
{
    public HeavyShield()
    {
        this.setName(this.getClass().getSimpleName());
        this.setType(this.getClass().getSimpleName());
        this.setArmorValue(3);
        this.setCat("shield");
    }

    public HeavyShield(String inputName, int inputArmorValue)
    {
        this.setName(inputName);
        this.setType(this.getClass().getSimpleName());
        this.setArmorValue(inputArmorValue);
    }
}
