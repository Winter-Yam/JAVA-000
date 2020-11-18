package my.homework.bean;


public class AutoBean {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("test auto bean");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
