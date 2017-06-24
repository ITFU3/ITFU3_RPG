package character.item.shields;

import enums.Proficiencies;

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
        this.setCat(Proficiencies.SHIELDS.toString());
    }

    public HeavyShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
