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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Ford", 12345)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Ferrari", 54321)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Subaru", 111)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Nissan", 333)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }

      System.out.println("Поиск по машине(Ford, 12345):");

      List<User> usersByCar = userService.getUserByCar("Ford", 12345);
      for (User user : usersByCar) {
         System.out.println(user);
         System.out.println();
      }

      context.close();
   }
}