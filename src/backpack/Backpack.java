package backpack;
public class Backpack {

	private String name;
    private double pStrength;
    private Object[] backpack;
    private int baseBackpackSpaces;
    
    public Backpack()
	{
		setName(this.getClass().getSimpleName());
		setBaseBackpackSpaces(6);
        setBackpack(new Object[getBaseBackpackSpaces()]);
    }
	
	public Backpack(String name, double pStrength, Object[] backpack, int baseBackpackSpaces)
	{
		setName(name);
		setPStrength(pStrength);
		setBaseBackpackSpaces(baseBackpackSpaces);
		setBackpack(backpack);
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPStrength(double pStrength){
		this.pStrength = pStrength;
	}
    public double getPStrength(){
		return this.pStrength;
	}
	public void setBackpack(Object[] backpack){
		this.backpack = backpack;
	}
	public Object[] getBackpack(){
		return this.backpack;
	}
	public void setBaseBackpackSpaces(int baseBackpackSpaces){
		this.baseBackpackSpaces = setBaseBackpackSpaces;
	}
	public int getBaseBackpackSpaces(){
		return this.setBaseBackpackSpaces;
	}
}
