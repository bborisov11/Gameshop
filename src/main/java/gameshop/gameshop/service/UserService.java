package gameshop.gameshop.service;

import gameshop.gameshop.domain.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean registerUser(UserServiceModel userServiceModel);
}
