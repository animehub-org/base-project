package services;

import entities.accessSession.AccessSession;
import entities.accessSession.AccessSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccessService {

    private final AccessSessionRepository repo;

    public AccessService(AccessSessionRepository repo) {
        this.repo = repo;
    }

    public Optional<List<AccessSession>> findByUserId(UUID userId){
        return repo.findByAccessSessionId_UserId(userId);
    }

    public Optional<List<AccessSession>> findBySessionId(UUID sessionId){
        return repo.findByAccessSessionId_SessionId(sessionId);
    }

    public Optional<AccessSession> findByAccessId(UUID accessId){
        return repo.findByAccessSessionId_AccessId(accessId);
    }
}
