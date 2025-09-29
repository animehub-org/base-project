package entities.genre;

import java.io.Serializable;

public record GenreDTO(
    Integer id,
    String name
) implements Serializable {
    public GenreDTO fromEntity(Genre genre) {
        return new GenreDTO(genre.getId(), genre.getName());
    }
}
