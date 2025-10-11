package services;

import entities.genre.Genre;
import entities.genre.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreRepository repo;

    public GenreService(GenreRepository repo) {
        this.repo = repo;
    }

    public Set<Genre> getFromList(List<String> list) {
        return list.stream().map(g->{
            return this.repo.findByName(g).orElse(null);
        }).collect(Collectors.toSet());
    }

    public List<Genre> getAll() {
        return this.repo.findAll();
    }

    public Genre save(Genre genre) {
        return this.save(genre);
    }
}
