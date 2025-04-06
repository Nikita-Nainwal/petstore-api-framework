package pet_testCases;

import clientCall.Pet_Call;
import factory.Post_Put_Pet;
import io.restassured.response.Response;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Pet.AddPet;
import utils.JSONUtils;

public class Add_Update_pet {
    Post_Put_Pet createPet = new Post_Put_Pet();
    AddPet addPet= createPet.createPet();

    @Test(priority = 1)
    public void addPet() {
       //Add asking from user
        // in another test from excel
        JSONUtils.printPayload(addPet);
        Response response = Pet_Call.postPet(addPet);
        AddPet res = response.as(AddPet.class);
        JSONUtils.printPayload(res);
        try {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals(response.jsonPath().getString("name"), "Mini");
            Assert.assertEquals(response.jsonPath().getString("category.name"), "dog");
            Assert.assertEquals(response.jsonPath().getString("tags[0].name"), "Mini");
            Assert.assertEquals(response.jsonPath().getString("tags[1].name"), "Mini");
            System.out.println("Pet Added Successfully");
        }
        catch (Exception e) {
            System.out.println("Pet Added Failed, please check the logs");
            e.printStackTrace();
        }
    }
    @Test(priority = 2)
    public void uploadPetImage() {
         Response response = Pet_Call.postPhoto(addPet);
         Assert.assertEquals(response.getStatusCode(), 200);
         String s = response.jsonPath().getString("message");
         Assert.assertEquals(s.contains("File uploaded "),true);
    }

    @Test(priority = 3)
    public void updatePetFormData() {
        Response respose = Pet_Call.postFormData();
        System.out.println(respose.jsonPath().getString("message"));
        System.out.println(respose.jsonPath().getString("code"));
        System.out.println(respose.jsonPath().getString("type"));

    }
}
