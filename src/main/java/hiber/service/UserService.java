package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void addUserWithCar(User user, Car car);
    List<User> listUsers();
    List<User> getUserByCar(String model, int series);
}