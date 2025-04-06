package clientCall;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Pet.AddPet;

import java.io.File;

public class  Pet_Call {
    //Create a request and get a response for the APIs
    //Post Put Delete Get add pet with form data
    static final RequestSpecification request = RestAssured.given().baseUri(Config.BASE_URI).accept("application/json");
    public static Response postPet (AddPet addPet) {
        return request.contentType("application/json").body(addPet).when().post();
    };

    public static Response postPhoto(AddPet addPet) {
       return request.contentType("multipart/form-data")
               .multiPart("file", new File("D:\\Projects\\petstore_APIs\\src\\main\\resources\\petphoto.jpg"))
               .formParam("additionalMetadata", "adding pet image")
               .when().post("/"+addPet.getId()+"/uploadImage");
    }

    public static Response postFormData() {
        //Avoid using same RequestSpecification between: multipart uploads and form-based submissions
       return RestAssured.given().baseUri("https://petstore.swagger.io/v2")
                .contentType("application/x-www-form-urlencoded")
                .formParam("name" , "Mini")
                .formParam("status", "unavailable")
                .when().post("/pet/102");

    }

}

