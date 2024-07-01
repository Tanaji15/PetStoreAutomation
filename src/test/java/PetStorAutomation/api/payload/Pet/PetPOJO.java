package PetStorAutomation.api.payload.Pet;

import com.github.javafaker.IdNumber;

import java.util.ArrayList;

public class PetPOJO {

    public long id;
    public PetCategory category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<PetTags> tags;
    public String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<PetTags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<PetTags> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
