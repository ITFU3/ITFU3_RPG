package character.item;

import enums.Proficiency;

public abstract class Item {
    private String name;
    private Proficiency cat;
    private Proficiency type;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
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

