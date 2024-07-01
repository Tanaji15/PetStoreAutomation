package PetStorAutomation.api.payload.Pet;

public class PetCategory {

    public long id;
    public String name;

    public PetCategory() {

    }
    public PetCategory(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
