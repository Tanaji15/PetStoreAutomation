package PetStorAutomation.api.payload.Pet;

import java.util.ArrayList;

public class PetTags {
    public int id;
    public String name;

    public PetTags() {

    }
    public PetTags(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
