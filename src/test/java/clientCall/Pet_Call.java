package clientCall;

import config.Config;
import factory.Post_Put_Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Pet.AddPet;

import java.io.File;
import java.util.List;

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

    public static Response putPet(AddPet addPet) {
        return request.contentType("application/json").body(addPet).when().put();
    };

    public static List<AddPet> getPet() {
        String[] status = new String[] {"available" , "pending"};
        List<AddPet> pet_list = RestAssured.given().baseUri(Config.BASE_URI).accept("application/json")
                .queryParam("status" , status ).when().get("/findByStatus").then()
                .extract().body().jsonPath().getList("", AddPet.class);
        return pet_list;

    }

    public static Response getPetById(long id) {
     return  RestAssured.given().baseUri(Config.BASE_URI).accept("application/json")
                .pathParam("petId", id).when().get("/{petId}");

    }


    public static Response deleteRecord(long id) {
       return  RestAssured.given().baseUri(Config.BASE_URI).accept("application/json")
              .header("api_key" , "special-key").pathParam("petId", id).when().delete("/{petId}");

    }
}

