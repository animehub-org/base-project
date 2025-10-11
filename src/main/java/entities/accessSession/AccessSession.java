package entities.accessSession;

import entities.user.User;
import entities.usersession.UserSession;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "access_session", schema = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessSession {
    @EmbeddedId
    private AccessSessionEmbeddedKey accessSessionId;

    @MapsId("userSessionKey") // Use um nome que represente a chave composta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    })
    private UserSession userSession;

    @Column(name = "created")
    private Date createdAt;

    @Column
    private boolean active;

}