package entities.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role", schema = "users")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public void setName(RoleName roleName) {
        this.name = roleName.toString();
    }

    public RoleName getRoleName(){
        return RoleName.valueOf(this.name);
    }

    public RoleDTO toDTO() {
        return new RoleDTO(this.id, this.name);
    }
}
