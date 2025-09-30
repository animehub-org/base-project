package services;

import entities.studio.StudioRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }
}
