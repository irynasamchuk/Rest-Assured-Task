package testCases;

import base.BaseTest;
import com.google.gson.Gson;
import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.http.Method;
import io.restassured.response.ResponseBody;
import object.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetBoard extends BaseTest {
    private String boardName = "Get Test Board";
    protected String boardId = "5df751a0c0ecd04fad4b823e";

    @BeforeClass
    public void getBoard() throws InterruptedException {
        RestAssured.baseURI = baseURL;

        httpRequest = RestAssured.given();
        httpRequest.pathParam("id", boardId);
        response = httpRequest.request(Method.GET, EndPoints.BOARD + "?token=" + token + "&key=" + key);

        Thread.sleep(time);
    }

    @Test
    public void checkBoardName(){
        String responseBody = response.getBody().asString();
        Board board = new Gson().fromJson(responseBody, Board.class);
        String expectedBoardName =  board.getName();

        Assert.assertEquals(expectedBoardName, boardName);
    }

    @Test
    public void checkBoardNameWithResponseBody(){
        ResponseBody body = response.getBody();
        Board board = body.as(Board.class);
        String expectedBoardName =  board.getName();

        Assert.assertEquals(expectedBoardName, boardName);
    }
}
