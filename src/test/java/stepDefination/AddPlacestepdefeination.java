package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import resources.APIResourses;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
public class AddPlacestepdefeination  extends Utils{
    RequestSpecification response;
    Response responsepostrequest;
    ResponseSpecification res;
    TestDataBuild testDataBuild = new TestDataBuild();
    @Given("add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        res = new ResponseSpecBuilder().expectStatusCode(200).build();
        response = given().spec(resquestSpecification()).body(testDataBuild.addplacepayload(name,language,address));
    }

    @When("user call {string} with {string} http request")
    public void user_call_with_http_request(String resources, String method) {
        //constructor will be called the value of resources with the value of resources

        APIResourses apiResourses=APIResourses.valueOf(resources);
        System.out.println(apiResourses.getresourses());
        if(method.equalsIgnoreCase("POST"))
        responsepostrequest = response.when().post(apiResourses.getresourses());
        else if(method.equalsIgnoreCase("GET"))
            responsepostrequest = response.when().get(apiResourses.getresourses());

    }

    @Then("the api call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(responsepostrequest.getStatusCode(), int1);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String val) {

        Assert.assertEquals(getjsonpathvalue(responsepostrequest,key), val);
    }
    @Then("Verify place_id is map to {string} by using {string}")
    public void verify_place_id_is_map_to_by_using(String expectedname, String resourcehit) throws IOException {

        response=given().spec(resquestSpecification()).queryParam
               ("place_id",getjsonpathvalue(responsepostrequest,"place_id"));
        user_call_with_http_request(resourcehit,"GET");
        String nam=getjsonpathvalue(responsepostrequest,"name");
        Assert.assertEquals(nam,expectedname);




    }
}
