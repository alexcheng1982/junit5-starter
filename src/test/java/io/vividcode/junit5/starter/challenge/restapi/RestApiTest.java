package io.vividcode.junit5.starter.challenge.restapi;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

public class RestApiTest {

  public String name;
  public Request request;
  public Response response;

  public static class Request {

    public String url;
    public String method;
    public String body;
  }

  public static class Response {

    public int code;
    public Map<String, String> headers = new HashMap<>();
  }

  public void verify() {
    RequestSpecification req = given()
        .request();
    if (request.body != null) {
      req.body(request.body);
    }
    req
        .then()
        .expect()
        .statusCode(response.code)
        .headers(response.headers)
        .when()
        .request(request.method, request.url);

  }
}
