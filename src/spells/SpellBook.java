package spells;
import java.util.ArrayList;

public class SpellBook
{
  private ArrayList listOfSpells;
  
  public SpellBook()
  {
    this.setSpellBook(new ArrayList());
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
    for(int i = 0; i < this.listOfSpells.size(); i++)
    {
      Spell tmp = (Spell) this.listOfSpells.get(i);
      if(tmp.getName().equalsIgnoreCase(spellname))
      {
        return tmp;
      }
    }
    return new Spell();
  }
// ######### Getter / Setter #########
  public ArrayList getSpellBook() {
    return listOfSpells;
  }
  public void setSpellBook(ArrayList spellBook) {
    this.listOfSpells = spellBook;
  }
}
