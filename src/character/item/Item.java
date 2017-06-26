package character.item;

import enums.Proficiency;

public abstract class Item {
    private Proficiency cat;
    private Proficiency type;
    
    public Proficiency getCat() {
        return cat;
    }
    public void setCat(Proficiency cat) {
        this.cat = cat;
    }
    public Proficiency getType() {
        return type;
    }
    public void setType(Proficiency type) {
        this.type = type;
    }
    @Override
    public String toString()
    {
        return this.getType().toString();
    }
}

