package PetStorAutomation.api.test;

import PetStorAutomation.api.endpoints.UserEndPoints;
import PetStorAutomation.api.payload.User.UserPOJO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests {

    Faker faker;
    UserPOJO userPayload;
    public Logger logger;
    @BeforeClass
    public void setup()
    {
        faker = new Faker();
        userPayload = new UserPOJO();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().phoneNumber());
        userPayload.setUserStatus(0);

        //logging initiation
        logger = LogManager.getLogger(this.getClass());
        logger.debug("Debugging .....");

    }

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
        //to verify if the new data has been updated or not can be used for debug purpose
     /*   Response responseAfterUpdate = UserEndPointsFromPropertiesFile.ReadUser(this.userPayload.getUsername());
        responseAfterUpdate.then().log().all(); */
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
