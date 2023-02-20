package pp.controller;

//стандартный контроллер для вывода приветственного сообщения

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pp.service.UserService;

@Controller
public class HalloController {

    private final UserService userService;

    @Autowired
    public HalloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String sayHallo() {
        return "/index";
    }

}
