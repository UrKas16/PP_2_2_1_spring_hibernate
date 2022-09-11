package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;


    @Column
    private String model;
    @Column
    private int series;

//    @OneToOne(mappedBy = "car")
//    private User user;

    public Car() {

    }

    @Autowired
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(carId, car.carId) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, model, series);
    }
}
