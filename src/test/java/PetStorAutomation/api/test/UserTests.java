package PetStorAutomation.api.test;

import PetStorAutomation.api.datagenerator.UserDataGeneration;
import PetStorAutomation.api.enpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests extends UserDataGeneration {

    @Test(priority = 1)
    public void testCreateUser()
    {
        logger.info("******** Creating User **************");
        Response response = UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** User Created **************");
    }

    @Test(priority = 2)
    public void testGetUser()
    {
        logger.info("******** Getting  User Info **************");
        Response response = UserEndPoints.ReadUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.body().jsonPath().get("username"),this.userPayload.getUsername());
        logger.info("******** User info Displayed  **************");
    }

    @Test(priority = 3)
    public void testUpdateUser()
    {
        logger.info("******** Updating User **************");
        //the new names will be generated to update the data
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        Response response = UserEndPoints.updateUser(userPayload,this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** User is updated **************");

    }
    @Test(priority = 4)
    public void testDeleteUser()
    {
        logger.info("******** Deleting User **************");
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** User Deleted **************");
    }
}
