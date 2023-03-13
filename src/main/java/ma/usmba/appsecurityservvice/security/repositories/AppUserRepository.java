package ma.usmba.appsecurityservvice.security.repositories;

import ma.usmba.appsecurityservvice.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
