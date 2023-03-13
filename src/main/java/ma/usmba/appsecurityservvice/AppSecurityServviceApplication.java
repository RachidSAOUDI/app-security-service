package ma.usmba.appsecurityservvice;

import ma.usmba.appsecurityservvice.security.entities.AppRole;
import ma.usmba.appsecurityservvice.security.entities.AppUser;
import ma.usmba.appsecurityservvice.security.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AppSecurityServviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSecurityServviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AuthService authService){
        return args -> {
            authService.addNewRole(new AppRole(null,"USER"));
            authService.addNewRole(new AppRole(null,"ADMIN"));
            authService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
            authService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
            authService.addNewRole(new AppRole(null,"BILLS_MANAGER"));

            authService.addNewUser(new AppUser(null,"user1","1234",new ArrayList<>()));
            authService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));
            authService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<>()));
            authService.addNewUser(new AppUser(null,"user3","1234",new ArrayList<>()));
            authService.addNewUser(new AppUser(null,"user4","1234",new ArrayList<>()));

            authService.addRoleToUser("user1","USER");
            authService.addRoleToUser("admin","USER");
            authService.addRoleToUser("admin","ADMIN");
            authService.addRoleToUser("user2","USER");
            authService.addRoleToUser("user2","CUSTOMER_MANAGER");
            authService.addRoleToUser("user3","USER");
            authService.addRoleToUser("user3","PRODUCT_MANAGER");
            authService.addRoleToUser("user4","USER");
            authService.addRoleToUser("user4","BILLS_MANAGER");
        };
    }

}
