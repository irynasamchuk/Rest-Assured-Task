package cucumber.stepsDefinitions;
import base.BaseTest;
import endpoints.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.testng.Assert;

import java.util.Map;

public class GetStepsDefinition extends BaseTest {
    @Given("the trello API with {string} endpoint")
    public void the_trello_API_with_endpoint(String string) {
        RestAssured.baseURI = baseURL;
        httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
    }

    @When("request has folowing paramethers")
    public void request_has_folowing_paramethers(Map<String, String> data) {
        String id = data.get("id");
        httpRequest.pathParam("id", id);
    }

    @When("method POST")
    public void method(String string) {
        response = httpRequest.request(Method.POST, EndPoints.BOARD);
    }

    @Then("response status code has {int}")
    public void response_status_code_has(int expectedStatusCode) {
       int currentStatusCode = response.getStatusCode();

        Assert.assertEquals(expectedStatusCode, currentStatusCode);
    }
}
