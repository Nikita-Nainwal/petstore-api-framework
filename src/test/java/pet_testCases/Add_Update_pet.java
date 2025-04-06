package pet_testCases;

import clientCall.Pet_Call;
import factory.Post_Put_Pet;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Pet.AddPet;
import utils.JSONUtils;

public class Add_Update_pet {
    Post_Put_Pet createPet = new Post_Put_Pet();
    @Test
    public void addPet() {
       //Add asking from user
        // in another test from excel
        AddPet addPet= createPet.createPet();
        JSONUtils.printPayload(addPet);
        Response response = Pet_Call.postPet(addPet);
        AddPet res = response.as(AddPet.class);
        JSONUtils.printPayload(res);
        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals(response.jsonPath().getString("name"), "Mini");
            Assert.assertEquals(response.jsonPath().getString("category.name"), "dog");
            Assert.assertEquals(response.jsonPath().getString("tags[0].name"), "Mini");
            Assert.assertEquals(response.jsonPath().getString("tags[1].name"), "Mino");
            System.out.println("Pet Added Successfully");
        }
        catch (Exception e) {
            System.out.println("Pet Added Failed, please check the logs");
            e.printStackTrace();
        }
    }
}
