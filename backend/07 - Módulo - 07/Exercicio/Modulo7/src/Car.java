/**
 * @author arthur.berson
 */

public class Car {
    private String model;
    private String brand;
    private String year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    //Faz o barulho do motor ao acelerar
    public void speedUp() {
        System.out.println("Vruuuuuum!");
    }
}
