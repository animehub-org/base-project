package entities.accessSession;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccessSessionRepository extends JpaRepository<AccessSession, AccessSessionEmbeddedKey> {
    Optional<AccessSession> findByAccessSessionId_AccessId(UUID accessSessionIdAccessId);

    Optional<List<AccessSession>> findByAccessSessionId_SessionId(UUID accessSessionIdSessionId);

    Optional<List<AccessSession>> findByAccessSessionId_UserId(UUID accessSessionIdUserId);
}
