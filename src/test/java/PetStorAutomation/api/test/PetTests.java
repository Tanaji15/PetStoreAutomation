package PetStorAutomation.api.test;

import PetStorAutomation.api.datagenerator.PetDataGeneration;
import PetStorAutomation.api.enpoints.PetEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetTests extends PetDataGeneration {

    @Test(priority = 1)
    public void testCreateNewPet(){
        logger.info("******** Creating New Pet **************");
        Response response = PetEndPoints.createNewPet(petPayload);
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** New Pet Created **************");
    }

    @Test(priority = 2)
    public void testGetPetDetails(){
        logger.info("********* Get Pet Details **************");
        Response response = PetEndPoints.getPetDetailsByID(this.petPayload.getId());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** Pet Details displayed **************");
    }

    @Test(priority = 3)
    public void testUpdatePetDetailsByID(){

        petPayload.setName(faker.animal().name());
        petPayload.setStatus("1");
        logger.info("******** Update Pet record by ID **************");
        Response response = PetEndPoints.updatePetDetailsByID(petPayload);
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** Pet Record Updated **************");
    }

    @Test(priority = 4)
    public void testDeletePetByID(){
        logger.info("******** Delete Pet record by ID **************");
        Response response = PetEndPoints.deletePetDetailsByID(this.petPayload.getId());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** Pet Record Deleted **************");
    }

    @Test(priority = 5)
    public void testGetPetDetailsByStatus(){
        logger.info("******** Get pet details by status **************");
        Response response = PetEndPoints.getPetDetailsByStatus("available");
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** pet details dispalyed **************");
    }
}
