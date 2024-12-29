# REST API Test

Tests for REST API are described using JSON files. A JSON file can contain
multiple tests.

Below is an example of test JSON file. It has a single test for Google search.

```json
[
  {
    "name": "google search",
    "request": {
      "url": "https://www.google.com/search?q=java",
      "method": "GET"
    },
    "response": {
      "code": 200
    }
  }
]
```

This JSON file is parsed into a list of `RestApiTest` objects. `RestApiTest` has
the `verify` method to verify the API request
using [REST Assured](https://rest-assured.io/).

Below is an example of REST API test. The `@RestApiJsonTest` annotation provides
the resource name of the JSON file. `RestApiTest` objects will be passed as
parameters.

```java

@DisplayName("Google search")
@ExtendWith(RestApiTestJsonInvocationContextProvider.class)
public class GoogleSearchTest {

  @DisplayName("google search")
  @RestApiJsonTest("/google-search.json")
  void testSearch(RestApiTest restApiTest) {
    restApiTest.verify();
  }
}
```