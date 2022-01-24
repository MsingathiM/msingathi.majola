package featureSteps;

public class AddPet {

    private String name;
    private String availability;
    private int id;

    public AddPet(String status, String name) {
        this.availability = availability;
        this.name = name;
    }

    public String getStatus() {
        return availability;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
