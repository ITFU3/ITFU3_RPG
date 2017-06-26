package character.item;

import enums.Proficiency;

public abstract class Item {
private Proficiency cat;


    public Proficiency getCat() {
        return cat;
    }

    public void setCat(Proficiency cat) {
        this.cat = cat;
    }
}

