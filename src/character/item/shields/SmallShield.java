package character.item.shields;

import enums.Proficiency;

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
        this.setCat(Proficiency.SHIELDS);
    }

    public SmallShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
