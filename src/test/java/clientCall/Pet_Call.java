package clientCall;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Pet.AddPet;

public class Pet_Call {
    //Create a request and get a response for the APIs
    //Post Put Delete Get add pet with form data
    public Response postPet (AddPet addPet) {
        return RestAssured.given().baseUri(Config.BASE_URI).contentType("application/json").
        accept("application/json").body(addPet).when().post();
    };


}
