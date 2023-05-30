package KataPP.PlayersTable.controller;


import KataPP.PlayersTable.model.User;
import KataPP.PlayersTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String printUsersList(ModelMap model) {
        model.addAttribute("usersList", userService.getUsersList());
        return "pages/index";
    }

    @GetMapping("{id}")
    public String printOneUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findUserById(id));
        return "pages/show";
    }

    @GetMapping("new")
    public String printAddForm(@ModelAttribute("user") User user) {
        return "pages/new";
    }

    @GetMapping("{id}/edit")
    public String printEditForm(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findUserById(id));
        return "pages/edit";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user, ModelMap model) {
        userService.addUser(user);
        model.addAttribute("user");
        printOneUser(user.getId(), model);
        return "pages/show";
    }

    @PatchMapping("{id}")
    public String editChosenUser(@ModelAttribute("user") User user) {
        userService.modifyUser(user);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String deletePlayer(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}