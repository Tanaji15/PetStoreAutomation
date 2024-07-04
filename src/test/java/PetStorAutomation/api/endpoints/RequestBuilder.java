package PetStorAutomation.api.endpoints;

import PetStorAutomation.api.utilities.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.ResourceBundle;

public class RequestBuilder {

    public static ResourceBundle getURL()
    {
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setContentType("Application/JSON")
            .setAccept("Application/JSON")
            .build();

    public static void printRequestLogInReport(RequestSpecification requestSpecification)
    {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is "+queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is "+queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request Headers are ");
        ExtentReportManager.printHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    public static void printResponseLogInReport(Response response)
    {
        ExtentReportManager.logInfoDetails("status is "+ response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.printHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }
}
