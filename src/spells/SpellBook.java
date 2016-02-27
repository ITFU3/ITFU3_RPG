package spells;
import java.util.ArrayList;

public class SpellBook
{
  private ArrayList listOfSpells;
  
  public SpellBook()
  {
	setSpellBook(new ArrayList());
  }

  public void addSpell(Spell input)
  {
	getSpellBook().add(input);
  }
  
  public String showSpellBook()
  {
    String output = "";
    for(int i = 0; i < getSpellBook().size(); i++)
    {
        output += getSpellBook().get(i).getClass().getSimpleName() + (((i+1) < getSpellBook().size())? ", ":"\n");
    }
    return output;
  }
  
  public void copyIntoSpellBook(SpellBook input)
  {
	getSpellBook().addAll(input.getSpellBook());
  }
  
// ######### Getter / Setter #########
  public ArrayList getSpellBook() {
	return listOfSpells;
  }
  public void setSpellBook(ArrayList spellBook) {
	this.listOfSpells = spellBook;
  }
}
