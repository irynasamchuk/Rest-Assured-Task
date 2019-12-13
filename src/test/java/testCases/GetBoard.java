package testCases;

import base.BaseTest;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseBody;
import object.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetBoard extends BaseTest {

    @BeforeClass
    public void getBoard() throws InterruptedException {
        RestAssured.baseURI = baseURL;

        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, endpoint + boardId + "?token=" + token + "&key=" + key);
        //response = httpRequest.request(Method.GET, String.format("%s%s?token=%s&key=%s", endpoint, boardId, token, key));

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
    public void checkBoardNameWithResponceBody(){
        ResponseBody body = response.getBody();
        Board board = body.as(Board.class);
        String expectedBoardName =  board.getName();

        Assert.assertEquals(expectedBoardName, boardName);
    }
}
