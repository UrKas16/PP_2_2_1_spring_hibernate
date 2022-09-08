package hiber.service;

import hiber.model.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarService {

    void add(Car car);


    List<Car> listCar();
}
