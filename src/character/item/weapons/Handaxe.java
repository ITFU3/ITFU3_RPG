package character.item.weapons;

import enums.Proficiency;

/**
 * @author Matthias Dröge
 */
public class Handaxe extends Weapon{
    public Handaxe()
    {
        this.setName("NoName");
        this.setDamageDie(6);
        this.setDieCount(1);
        this.setDurability(100);
        this.setType(this.getClass().getSimpleName());
        this.setCat(Proficiency.MELEE);
        this.setDistance(1);
        this.setWeaponGroup(Proficiency.SIMPLE_WEAPONS.toString());
        String[] prop = {
            Proficiency.SINGLEHANDED.toString(),
//            Proficiencies.THROWABLE.toString()
        };
        this.setProperties(prop);
    }

    public Handaxe(String name, int damageDie, int dieCount, int distance)
    {
        this();
        this.setName(name);
        this.setDamageDie(damageDie);
        this.setDieCount(dieCount);
        this.setDistance(distance);
    }
}
