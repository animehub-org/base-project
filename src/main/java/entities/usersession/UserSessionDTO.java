package entities.usersession;

import java.io.Serializable;
import java.util.UUID;

public record UserSessionDTO(
        UUID sessionId,
        UUID userId
)implements Serializable {
}
