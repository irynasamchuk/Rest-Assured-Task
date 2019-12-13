package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
   protected RequestSpecification httpRequest;
   protected Response response;
   protected final String baseURL = "https://api.trello.com/1";
   protected final String endpoint = "/boards/";
   protected final String key = "";
   protected final String token = "";
   protected String boardName = "TestBoard";
   protected String boardId = "5df33f1937a92610ec096103";
   protected int time = 1000;
}
