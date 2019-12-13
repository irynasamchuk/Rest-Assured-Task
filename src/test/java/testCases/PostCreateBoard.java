package testCases;

import base.BaseTest;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;


public class PostCreateBoard extends BaseTest {
    @BeforeClass
    public void createBoard() throws InterruptedException {

        HashMap<String, String> jsonMap = new HashMap<>();
        jsonMap.put("name", boardName);
        jsonMap.put("key", key);
        jsonMap.put("token", token);

        String boardJson = new Gson().toJson(jsonMap);

        RestAssured.baseURI = baseURL;

        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(boardJson);

        response = httpRequest.request(Method.POST, endpoint);

        Thread.sleep(time);
    }

    @Test
    public void checkBody()  {
        String bodyContent = response.getBody().asString();

        Assert.assertTrue(bodyContent.contains(boardName));
    }

    @Test
    public void checkBoardName() {
        String expectedBoardName = response.jsonPath().get("name");

        Assert.assertEquals(expectedBoardName, boardName);
    }

    @Test
    public void checkStatusCode() {
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void checkResponseTime() {
        long responseTime = response.getTime();

        Assert.assertTrue(responseTime < 2000);
    }

    @Test
    public void checkStatusLine() {
        String statusLine = response.getStatusLine();

        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void checkContentType(){
        String contentType = response.header("Content-Type");

        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }
}
