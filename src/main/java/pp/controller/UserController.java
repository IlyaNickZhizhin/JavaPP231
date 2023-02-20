package pp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//импорт модели и других библиотек
import pp.model.User;
import pp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;


@Controller
public class UserController {

    //создание объекта класса UserService
    private final UserService userService;

    //конструктор
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/start")
    public String showAllUsers(Model model) {
        System.out.println("Начинается обработка страницы /start");
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        System.out.println("Обработка страницы /start закончена");
        return "all-users";
    }

    @PostMapping(value = "/addNewUser")
    public String addNewUser(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "email") String email) {
        System.out.println("Начинается обработка добавления юзера");
        System.out.println("Получен юзер из браузера " + "name = " + name + "surname = " + surname + "email = " + email);
        User user = new User(name, surname, email);
        userService.saveUser(user);
        System.out.println("Обработка добавления юзера закончена");
        return "redirect:/start";
    }

    @PatchMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id,
                             Model model) {
        System.out.println("Начинается обработка обновления юзера");
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        System.out.println("Обработка обновления юзера закончена, юзер с ID# " + id + "добавлен в модель");
        return "/user-info";
    }
    @PutMapping("/saveUser")
    public String updateUser(@RequestParam("id") int id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "email") String email) {
        System.out.println("Начинается обработка сохранения юзера");
        User user = userService.getUser(id);
        System.out.println("Получен юзер с ID# " + id + " из БД" + "name = " + name + "surname = " + surname + "email = " + email);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        System.out.println("Изменен юзер с ID# " + id + " в модели");
        userService.saveUser(user);
        System.out.println("Обработка сохранения юзера закончена");
        return "redirect:/start";
    }

    @DeleteMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam(name = "id") int id) {
        System.out.println("Начинается обработка удаления юзера");
        userService.deleteUser(id);
        System.out.println("Обработка удаления юзера закончена");
        return "redirect:/start";
    }


}
