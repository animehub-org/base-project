package entities.accessSession;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class AccessSessionEmbeddedKey implements Serializable {
    @Column(name = "session_id")
    private UUID sessionId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "access_id")
    private UUID accessId;
}
