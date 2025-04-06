package clientCall;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Pet.AddPet;

public class Pet_Call {
    //Create a request and get a response for the APIs
    //Post Put Delete Get add pet with form data
    @Test
    public Response postPet (AddPet addPet) {
        return RestAssured.given().baseUri(Config.BASE_URI).contentType("application/json").
        accept("application/json").body(addPet).when().post();
    };


}
