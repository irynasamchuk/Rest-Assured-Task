package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
   protected RequestSpecification httpRequest;
   protected Response response;
   protected final String baseURL = "https://api.trello.com/1";
   protected final String key = "";
   protected final String token = "";
   protected int time = 1000;
}
