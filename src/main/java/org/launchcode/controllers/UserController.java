package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.launchcode.Data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
  @GetMapping("add")
  public String displayAddUserForm(Model model){
  model.addAttribute(new User());
    return "/user/add";
  }

  @PostMapping("")
  public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
    if (!errors.hasErrors() && user.getPassword().equals(verify)) {
      //  model.addAttribute("username",user.getUsername());
      //model.addAttribute("email",user.getEmail());
      //model.addAttribute("error","Passwords do not match.");
      return "/user/index";
    } else {
      model.addAttribute("error","password do noy match");
    //  model.addAttribute("user", user);
      //model.addAttribute("users", UserData.getAll());
      return "/user/add";
    }
  }
  @GetMapping("/details/{id}")
  public String displayUserDetails(@PathVariable int id, Model model){
    model.addAttribute("user",UserData.getById(id));
    return"/user/details";
  }
}
