package backpack;
public class Backpack {

    private String name;
    private int pStrength;
    private Object[] backpack;
    private int baseBackpackSpaces;
    
    public Backpack()
    {
      this.setName(this.getClass().getSimpleName());
      this.setBaseBackpackSpaces(6);
      this.setBackpack(new Object[getBaseBackpackSpaces()]);
    }
	
    public Backpack(String name, int pStrength, Object[] backpack, int baseBackpackSpaces)
    {
      this.setName(name);
      this.setPStrength(pStrength);
      this.setBaseBackpackSpaces(baseBackpackSpaces);
      this.setBackpack(backpack);
    }

    public void setName(String name){
      this.name = name;
    }
    public String getName(){
      return this.name;
    }
    public void setPStrength(int pStrength){
      this.pStrength = pStrength;
    }
    public int getPStrength(){
      return this.pStrength;
    }
    public void setBackpack(Object[] backpack){
      this.backpack = backpack;
    }
    public Object[] getBackpack(){
      return this.backpack;
    }
    public void setBaseBackpackSpaces(int baseBackpackSpaces){
      this.baseBackpackSpaces = baseBackpackSpaces;
    }
    public int getBaseBackpackSpaces(){
      return this.baseBackpackSpaces;
    }
}
