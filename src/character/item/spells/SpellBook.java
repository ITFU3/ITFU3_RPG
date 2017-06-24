package character.item.spells;

import java.util.ArrayList;

public class SpellBook {
    private ArrayList<Spell> listOfSpells;
    private String primarySpell;

    public SpellBook() {
        this.setSpellList(new ArrayList<Spell>());
        this.setPrimarySpell(null);
    }

    public void addSpell(Spell input) {
        this.getSpellList().add(input);
    }

    public String showSpellBook() {
        String output = "";
        for (int i = 0; i < this.getSpellList().size(); i++) {
            output += "Name: \t" + this.getSpellList().get(i).getClass().getSimpleName() + "\n"
                + "Range: \t" + this.getSpellList().get(i).getSpellRange() + "\n"
                + "dmg count: \t" + this.getSpellList().get(i).getDieCount() + "\n"
                + "dmg: \t" + this.getSpellList().get(i).getDamageDie() + "\n"
                + " - - - \n";
        }
        return output;
    }

    public void copyIntoSpellBook(SpellBook input) {
        this.getSpellList().addAll(input.getSpellList());
    }

    public Spell getSpellByName(String spellname) {
        Spell output = new Spell();
        for (int i = 0; i < this.listOfSpells.size(); i++) {
            output = this.listOfSpells.get(i);
            if (output.getName().equalsIgnoreCase(spellname)) {
                return output;
            }
        }
        return output;
    }

    /**
     * If spell with a specific Effect exists in the spellbook
     *
     * @param input - SpellEffect as String
     * @return boolean
     */
    public boolean containsSpellWithEffect(String input) {
        boolean output = false;
        for (Spell spell : listOfSpells) {
            if (spell.getSpellEffect().equalsIgnoreCase(input)) {
                output = true;
                break;
            }
        }
        return output;
    }

    /**
     * If spell with a specific name exists in the spellbook
     *
     * @param input - SpellName as String
     * @return boolean
     */
    public boolean conainsSpellWithName(String input) {
        boolean output = false;
        for (Spell spell : listOfSpells) {
            if (spell.getName().equalsIgnoreCase(input)) {
                output = true;
                break;
            }
        }
        return output;
    }

    /**
     * Check if the Spellbook is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return listOfSpells.isEmpty();
    }

// ######### Getter / Setter #########
    public ArrayList<Spell> getSpellList() {
        return listOfSpells;
    }
    public void setSpellList(ArrayList<Spell> spellBook) {
        this.listOfSpells = spellBook;
    }
    public String getPrimarySpell() {
        return primarySpell;
    }
    public void setPrimarySpell(String primarySpell) {
        this.primarySpell = primarySpell;
    }
}
