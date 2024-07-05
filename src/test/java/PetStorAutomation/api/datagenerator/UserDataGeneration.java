package PetStorAutomation.api.datagenerator;

import PetStorAutomation.api.payload.User.UserPOJO;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class UserDataGeneration {
    public static Faker faker;
    public static UserPOJO userPayload;
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
}
