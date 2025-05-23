package pojo.Pet;

public class Category {
    private long  id;
    private String name;

    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
