package gameshop.gameshop.web.controllers;

import gameshop.gameshop.domain.models.binding.UserRegisterBindingModel;
import gameshop.gameshop.domain.models.service.UserServiceModel;
import gameshop.gameshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute(name = "model")UserRegisterBindingModel registerModel) {
        if(!registerModel.getPassword().equals(registerModel.getConfirmPassword())) {
            return "register";
        }

        this.userService.registerUser(this.modelMapper.map(registerModel, UserServiceModel.class));

        return "redirect:/login";
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
