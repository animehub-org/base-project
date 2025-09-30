package services;

import entities.creator.CreatorRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {
    private final CreatorRepository creatorRepository;

    public CreatorService(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }
}
