package entities.user;

import entities.role.RoleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import entities.role.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;


@Entity
@Table(name = "users", schema = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String username;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String salt;

    @Column(name = "superuser")
    private Boolean superUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            schema = "users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    public UserDTO toUserDTO() {
        List<RoleDTO> roleDTOs = new ArrayList<>();
        if (this.roles != null) {
            roleDTOs = this.roles.stream()
                    .map(Role::toDTO)
                    .collect(Collectors.toList());
        }
        return new UserDTO(
                this.id,
                this.name,
                this.surname,
                this.username,
                this.birthDate,
                this.email,
                this.superUser,
                roleDTOs
        );
    }

//    public User() {
//    }

//    public User(Date birthDate, String name, String surname, String username, String email, String password, String salt, Boolean superUser, Set<Role> roles) {
//        this.name = name;
//        this.surname = surname;
//        this.username = username;
//        this.birthDate = birthDate;
//        this.email = email;
//        this.password = password;
//        this.salt = salt;
//        this.superUser = superUser;
//        this.roles = roles;
//    }

    public boolean isLoginCorrect(String password, PasswordEncoder bCryptPasswordEncoder) {
        return bCryptPasswordEncoder.matches(password, this.password);
    }
}
