package spells;
import java.util.ArrayList;

public class SpellBook
{
  private ArrayList listOfSpells;
  
  public SpellBook()
  {
	listOfSpells = new ArrayList();
  }

  public void addSpell(Spell input)
  {
	listOfSpells.add(input);
  }
  
  public String showSpellBook()
  {
	return "";
  }
  
  public void copyIntoSpellBook(SpellBook input)
  {
	listOfSpells.addAll(input.getSpellBook());
  }
  
  public ArrayList getSpellBook() {
	return listOfSpells;
  }
  public void setSpellBook(ArrayList spellBook) {
	this.listOfSpells = spellBook;
  }
}
