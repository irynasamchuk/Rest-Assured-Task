package testCases;

import base.BaseTest;
import com.google.gson.Gson;
import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import object.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestData;

import java.util.HashMap;

public class PostBoardLabel extends BaseTest {
    private String boardId = "5df751a0c0ecd04fad4b823e";
    private String name = "Test Label 5";
    private String color = "green";

    @BeforeClass
    public void addLabel() throws InterruptedException {
        String json = new TestData().getLabelTestData(name,color);

        RestAssured.baseURI = baseURL;
        httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.body(json);
        httpRequest.pathParam("id", boardId);

        response = httpRequest.request(Method.POST, EndPoints.BOARD + EndPoints.LABEL);

        Thread.sleep(time);
    }

    @Test
    public  void checkStatusCode(){
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void checkBody(){
        String bodyContent = response.getBody().asString();
        System.out.println(bodyContent);
    }

    @Test
    public void extractBodyAsObject(){
        Board board = new Gson().fromJson(response.getBody().asString(), Board.class);
        String expectedColor = board.getColor();

        Assert.assertFalse(expectedColor.isEmpty());
    }

}
