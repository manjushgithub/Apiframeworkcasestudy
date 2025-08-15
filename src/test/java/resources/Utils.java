package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Utils {
    RequestSpecification req;
    public RequestSpecification resquestSpecification()
    {
         req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
                addQueryParam("key", "qaclick123").
                addHeader("content-type", "application/json").build();
        return req;
    }

}
