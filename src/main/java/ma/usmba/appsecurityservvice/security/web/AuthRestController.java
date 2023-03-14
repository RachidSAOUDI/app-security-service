package ma.usmba.appsecurityservvice.security.web;

import ma.usmba.appsecurityservvice.security.entities.AppRole;
import ma.usmba.appsecurityservvice.security.entities.AppUser;
import ma.usmba.appsecurityservvice.security.entities.RoleUserForm;
import ma.usmba.appsecurityservvice.security.services.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthRestController {
    private AuthService authService;

    public AuthRestController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return authService.listUsers();
    }

    @PostMapping(path = "/users")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return authService.addNewUser(appUser);
    }

    @PostMapping(path = "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return authService.addNewRole(appRole);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        authService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }

}
