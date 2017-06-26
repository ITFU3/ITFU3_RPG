package character.item.shields;

import enums.Proficiency;

/**
 * @author Matthias Dröge
 */
public class HeavyShield extends Shield
{
    public HeavyShield()
    {
        super();
        this.setArmorValue(3);
        this.setType(Proficiency.HEAVY_SHIELD);
        this.setCat(Proficiency.SHIELD);
    }

    public HeavyShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
