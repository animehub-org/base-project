package entities.anime;

import entities.genre.Genre;
import entities.genre.GenreDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record AnimeSummaryDTO(
    UUID id,
//    double averageEpTime,
    String description,
    Set<GenreDTO> genre,
    String name,
    String name2,
    String quality,
    String language
) implements Serializable {
    public static AnimeSummaryDTO fromEntity(Anime anime) {
        return new AnimeSummaryDTO(
            anime.getId(),
            anime.getDescription(),
            anime.getGenres().stream().map(Genre::toDTO).collect(Collectors.toSet()),
            anime.getName(),
            anime.getName2(),
            anime.getQuality(),
            anime.getLanguage()
        );
    }
}
