package testCases;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteBoard extends BaseTest {
    @BeforeClass
    public void deleteBoard() throws InterruptedException {
        RestAssured.baseURI = baseURL;

        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/members/5df0f509bbf5b47921bf22f1/boards?" + "token=" + token + "&key=" + key);
        JsonPath jsonPath = response.jsonPath();
        String boardId = jsonPath.get("id[0]");

        response = httpRequest.request(Method.DELETE, endpoint + boardId + "?token=" + token + "&key=" + key);

        Thread.sleep(time);
    }

    @Test
    public void checkBody(){
        String bodyContent = response.getBody().asString();

        Assert.assertTrue(bodyContent.contains("null"));
    }
}
