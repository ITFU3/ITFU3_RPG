package character.item.shields;

import enums.Proficiency;

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
        this.setCat(Proficiency.SHIELDS);
    }

    public MediumShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
