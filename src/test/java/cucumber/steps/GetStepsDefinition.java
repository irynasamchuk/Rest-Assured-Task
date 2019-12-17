package cucumber.steps;
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
    @Given("the trello API with BOARD endpoint")
    public void theTrelloAPIWithEndpoint(){
        RestAssured.baseURI = baseURL;
        httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
    }

    @When("request has following parameters")
    public void requestHasFollowingParameters(Map<String, String> data) {
        String id = data.get("id");
        httpRequest.pathParam("id", id);
    }

    @When("method GET")
    public void methodGET() {
        response = httpRequest.request(Method.GET, EndPoints.BOARD + "?token=" + token + "&key=" + key);
    }

    @Then("response status code has {int}")
    public void responseStatusCodeHasStatusCode(int expectedStatusCode) {
       int currentStatusCode = response.getStatusCode();

        Assert.assertEquals(expectedStatusCode, currentStatusCode);
    }
}
