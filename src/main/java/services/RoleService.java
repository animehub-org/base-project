package services;

import entities.role.Role;
import entities.role.RoleName;
import entities.role.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository repo;

    public RoleService(RoleRepository repo) {
        this.repo = repo;
    }

    public Optional<Role> findByName(String name){
        return this.repo.findByName(name);
    }
    public Optional<Role> findByName(RoleName name){
        return this.findByName(name.name());
    }

    public boolean existsByName(String name){
        return this.repo.existsByName(name);
    }
    public boolean existsByName(RoleName name){
        return this.existsByName(name.name());
    }

    public void save(Role role){
        this.repo.save(role);
    }
}
