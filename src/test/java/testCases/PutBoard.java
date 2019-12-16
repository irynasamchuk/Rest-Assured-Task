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

public class PutBoard extends BaseTest {
    private String boardName = "Changed Board T4";
    protected String boardId = "5df753f376f5fd7a31d2b742";

    @BeforeClass
    public void changeBoardName() throws InterruptedException {

        String json =  new TestData().getBoardTestData(boardName);

        RestAssured.baseURI = baseURL;

        httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.body(json);
        httpRequest.pathParam("id", boardId);

        response = httpRequest.request(Method.PUT, EndPoints.BOARD);

        Thread.sleep(time);
    }

    @Test
    public void checkBoardName(){
        Board board = new Gson().fromJson(response.getBody().asString(), Board.class);
        String currentBoardName = board.getName();

        Assert.assertEquals(boardName, currentBoardName);
    }
}
