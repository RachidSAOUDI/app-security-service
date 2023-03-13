package ma.usmba.appsecurityservvice.security.services;

import ma.usmba.appsecurityservvice.security.entities.AppRole;
import ma.usmba.appsecurityservvice.security.entities.AppUser;

import java.util.List;

public interface AuthService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
