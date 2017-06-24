package character.item.shields;

import enums.Proficiencies;

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
        this.setCat(Proficiencies.SHIELDS.toString());
    }

    public SmallShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
