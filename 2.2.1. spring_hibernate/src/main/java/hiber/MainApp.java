package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("Ivam", "Ivanov", "ivan@mail.ru", new Car("lada", 2012)));
        userService.add(new User("Sasha", "Sashkov", "sasha@mail.ru", new Car("kia", 2011)));
        userService.add(new User("Vasya", "Vasilev", "vasya@mail.ru", new Car("bmw", 2015)));
        userService.add(new User("Oleg", "Olegov", "oleg@mail.ru", new Car("audi", 2020)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());

            System.out.println();
        }

        System.out.println(userService.getUserByCar("bmw", 2015));
        context.close();
    }
}
