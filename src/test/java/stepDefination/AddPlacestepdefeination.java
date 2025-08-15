package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
public class AddPlacestepdefeination  extends Utils{
    RequestSpecification response;
    Response responsepostrequest;
    ResponseSpecification res;
    TestDataBuild testDataBuild = new TestDataBuild();
    @Given("add place payload")
    public void add_place_payload() {
        res = new ResponseSpecBuilder().expectStatusCode(200).build();
        response = given().spec(resquestSpecification()).body(testDataBuild.addplacepayload());
    }

    @When("user call {string} with post http request")
    public void user_call_with_post_http_request(String string) {
        responsepostrequest = response.when().post("/maps/api/place/add/json").then().spec(res).extract().response();
    }

    @Then("the api call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(responsepostrequest.getStatusCode(), int1);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String val) {
        String finaladdplaceresponce = responsepostrequest.asString();
        JsonPath path = new JsonPath(finaladdplaceresponce);
        String val1 = path.get(key).toString();
        Assert.assertEquals(val1, val);
    }
}
