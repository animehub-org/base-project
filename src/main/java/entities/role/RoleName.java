package entities.role;

import lombok.Getter;

@Getter
public enum RoleName {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_DEVELOPER,
    ROLE_CREATOR,
    ROLE_SUPERUSER;

    @Override
    public String toString() {
        return this.name();
    }
}
