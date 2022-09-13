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

        User ivan = new User("Ivan", "Ivanov", "ivan@mail.ru", new Car("lada", 2012));
        User sasha = new User("Sasha", "Sashkov", "sasha@mail.ru", new Car("kia", 2011));
        User vasya = new User("Vasya", "Vasilev", "vasya@mail.ru", new Car("bmw", 2015));
        User oleg = new User("Oleg", "Olegov", "oleg@mail.ru", new Car("audi", 2020));

        userService.add(ivan);
        userService.add(sasha);
        userService.add(vasya);
        userService.add(oleg);


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
