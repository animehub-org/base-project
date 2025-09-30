package services;

import entities.season.SeasonRepository;
import org.springframework.stereotype.Service;

@Service
public class SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }
}
