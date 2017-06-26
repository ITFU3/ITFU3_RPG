package character.item.shields;

import enums.Proficiency;

/**
 * @author Matthias Dröge
 */
public class MediumShield extends Shield
{
    public MediumShield()
    {
        super();
        this.setArmorValue(2);
        this.setType(Proficiency.MEDIUM_SHIELD);
        this.setCat(Proficiency.SHIELD);
    }

    public MediumShield(String inputName, int inputArmorValue)
    {
        this();
        this.setName(inputName);
        this.setArmorValue(inputArmorValue);
    }
}
