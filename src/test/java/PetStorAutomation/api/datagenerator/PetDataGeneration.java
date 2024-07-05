package PetStorAutomation.api.datagenerator;

import PetStorAutomation.api.payload.Pet.PetCategory;
import PetStorAutomation.api.payload.Pet.PetPOJO;
import PetStorAutomation.api.payload.Pet.PetTags;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class PetDataGeneration {

    public static Faker faker;
    public static PetPOJO petPayload;
    PetCategory petCategory;
    PetTags petTags;
    public Logger logger;


    @BeforeClass
    public void setupPetData() {

        faker = new Faker();
        String URL = "https://www.shutterstock.com/image-photo/funny-dog-licking-lips-tongue-out-1761385949";
        ArrayList<String> fURL = new ArrayList<String>();
        fURL.add(URL);
        ArrayList<PetTags> tagDetails = new ArrayList<PetTags>();
        petTags = new PetTags();
        petTags.setId(faker.random().nextInt(500));
        petTags.setName(faker.animal().name());
        tagDetails.add(petTags);
        petCategory = new PetCategory();
        petCategory.setId(faker.random().nextLong(500));
        petCategory.setName(faker.funnyName().name());
        petPayload = new PetPOJO();
        petPayload.setId(faker.random().nextLong(500));
        petPayload.setCategory(petCategory);
        petPayload.setName(faker.animal().name());
        petPayload.setPhotoUrls(fURL);
        petPayload.setTags(tagDetails);
        petPayload.setStatus("0");

        logger = LogManager.getLogger(this.getClass());
        logger.debug("Debugging petStore API.....");

    }
}
