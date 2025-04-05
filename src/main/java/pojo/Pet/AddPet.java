package pojo.Pet;

import java.util.List;

public class AddPet {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tag;
    private String status;


    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tag> getTags() {
        return tag;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(List<Tag> tags) {
        this.tag = tag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
}

