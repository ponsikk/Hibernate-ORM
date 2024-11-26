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

      Car car = new Car();
      car.setModel("BMW");
      car.setSeries(1);
      User user55 = new User();
      user55.setFirstName("User55");
      user55.setLastName("LastUser55");
      user55.setEmail("User55@gmail.com");
      user55.setCar(car);
      userService.addUser(user55);

      Car car3 = new Car();
      car3.setModel("Mercedes");
      car3.setSeries(3);
      User user3 = new User();
      user3.setFirstName("User33");
      user3.setLastName("Lastname33");
      user3.setEmail("user33@mail.ru");
      user3.setCar(car3);
      userService.addUser(user3);

      Car car4 = new Car();
      car4.setModel("Tesla");
      car4.setSeries(4);
      User user4 = new User();
      user4.setFirstName("User44");
      user4.setLastName("Lastname44");
      user4.setEmail("user44@mail.ru");
      user4.setCar(car4);
      userService.addUser(user4);


      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
