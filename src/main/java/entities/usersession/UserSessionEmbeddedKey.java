package entities.usersession;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
public class UserSessionEmbeddedKey implements Serializable {
    private UUID userId;
    private UUID sessionId;
}
