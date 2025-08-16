package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
    public static RequestSpecification req;
    public RequestSpecification resquestSpecification() throws IOException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getglobalproperties("baseUrl")).
                    addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .addHeader("content-type", "application/json").build();
            return req;
        }
        return  req;
    }
    public static String getglobalproperties(String key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("F:\\Apiframweworkcasestudy\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
    public String getjsonpathvalue(Response response,String Keyvalue)
    {
        String finaladdplaceresponce = response.asString();
        JsonPath path = new JsonPath(finaladdplaceresponce);
       return path.get(Keyvalue);
    }



}
