package factory;

import pojo.Pet.AddPet;
import pojo.Pet.Category;
import pojo.Pet.Tag;

import java.util.ArrayList;
import java.util.List;

public class Post_Put_Pet {
    //This class is for creating payload, to add data to the payload
    public AddPet createPet(){
        Category category = new Category();
        Tag tag1 = new Tag();
        Tag tag2 = new Tag();
        List<Tag> tags = new ArrayList<Tag>();
        AddPet addPet = new AddPet();

        //Setting up Category values and it's object
        category.setId(103);
        category.setName("cat");

        //Saving Tag object in List of Tag type as in AddPet POJO class there is a list of type Tag
        tag1.setId(1);
        tag1.setName("Alpha");
        tag2.setId(2);
        tag2.setName("Alpha");
        tags.add(tag1);
        tags.add(tag2);

        //Saving values to remaining field
        addPet.setCategory(category);
        addPet.setTags(tags);
        addPet.setId(103);
        addPet.setName("Alpha");
        addPet.setPhotoUrls(new ArrayList<>());
        addPet.setStatus("Available");

        return addPet;
    }


}
