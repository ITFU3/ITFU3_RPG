package spells;
import java.util.ArrayList;

public class SpellBook
{
  private ArrayList<Spell> listOfSpells;
  
  public SpellBook()
  {
    this.setSpellBook(new ArrayList<Spell>());
  }

  public void addSpell(Spell input)
  {
    this.getSpellBook().add(input);
  }
  
  public String showSpellBook()
  {
    String output = "";
    for(int i = 0; i < this.getSpellBook().size(); i++)
    {
        output += this.getSpellBook().get(i).getClass().getSimpleName() 
               + (((i+1) < this.getSpellBook().size())? ", ":"\n");
    }
    return output;
  }
  
  public void copyIntoSpellBook(SpellBook input)
  {
    this.getSpellBook().addAll(input.getSpellBook());
  }
  
  public Spell getSpellByName(String spellname)
  {
    Spell output = new Spell();
    for(int i = 0; i < this.listOfSpells.size(); i++)
    {
      output = (Spell) this.listOfSpells.get(i);
      if(output.getName().equalsIgnoreCase(spellname))
      {
        return output;
      }
    }
    return output;
  }
// ######### Getter / Setter #########
  public ArrayList<Spell> getSpellBook() {
    return listOfSpells;
  }
  public void setSpellBook(ArrayList<Spell> spellBook) {
    this.listOfSpells = spellBook;
  }
}
