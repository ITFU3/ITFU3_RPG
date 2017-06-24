package character.item.shields;

import enums.Proficiencies;

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
        this.setCat(Proficiencies.SHIELDS.toString());
    }

    public MediumShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
