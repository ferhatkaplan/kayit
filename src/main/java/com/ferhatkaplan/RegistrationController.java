package com.ferhatkaplan;


import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("userData", new UserData());
        return "account/register";

        @PostMapping("/register")
        public String userRegistration(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
            if(bindingResult.hasErrors()){
                model.addAttribute("registrationForm", userData);
                return "account/register";
            }
            try {
                userService.register(userData);
            }catch (UserAlreadyExistException e){
                bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
                model.addAttribute("registrationForm", userData);
                return "account/register";
            }
            return REDIRECT+"/starter";
        }
}
