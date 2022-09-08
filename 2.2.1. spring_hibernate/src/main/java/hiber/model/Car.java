package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column
    private String model;
    @Column
    private int series;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "series", referencedColumnName = "series")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long id) {
        this.carId = carId;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "Машина отсутвует";
        }
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
