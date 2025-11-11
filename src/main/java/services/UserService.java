package services;

import entities.role.Role;
import entities.role.RoleName;
import entities.user.User;
import entities.user.UserRepository;
import exception.AlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repo;
    private final RoleService roleService;

    public UserService(UserRepository repo, RoleService roleService) {
        this.repo = repo;
        this.roleService = roleService;
    }

    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return this.repo.findByUsername(username);
    }

    public User save(User user) throws AlreadyExistsException {
        if(this.repo.findByEmail(user.getEmail()).isPresent()) {
            throw new AlreadyExistsException("Email");
        }
        if(this.repo.findByUsername(user.getUsername()).isPresent()) {
            throw new AlreadyExistsException("Username");
        }
        return this.repo.save(user);
    }

    public Optional<User> findById(UUID id) {
        return this.repo.findById(id);
    }

    public boolean isRole(Role role, User user) {
        return user.getRoles().contains(role);
    }

    public boolean isAdmin(User user) {
        Role admin = roleService.findByName(RoleName.ROLE_ADMIN).orElseThrow(()-> new RuntimeException("Role Admin error"));

        return this.isRole(admin, user) || user.isSuperUser();
    }
}
