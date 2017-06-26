package character.item.shields;

import enums.Proficiency;

/**
 * @author Matthias Dröge
 */
public class SmallShield extends Shield
{
    public SmallShield()
    {
        super();
        this.setArmorValue(1);
        this.setType(Proficiency.SMALL_SHIELD);
        this.setCat(Proficiency.SHIELD);
    }

    public SmallShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
