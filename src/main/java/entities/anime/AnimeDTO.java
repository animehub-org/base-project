package entities.anime;

import entities.character.CharacterDTO;
import entities.creator.CreatorDTO;
import entities.genre.Genre;
import entities.genre.GenreDTO;
import entities.producer.ProducerSummaryDTO;
import entities.season.SeasonDTO;
import entities.state.StateDTO;
import entities.studio.StudioDTO;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record AnimeDTO (
    UUID id,
    double averageEpTime,
    OffsetDateTime dateAdded,
    String description,
    Set<GenreDTO> genre,
    String language,
    String name,
    String name2,
    String quality,
    boolean visible,
    String weekday,
    Set<ProducerSummaryDTO> producers,
    Set<CreatorDTO> creators,
    Set<StudioDTO> studios,
    Set<CharacterDTO> characters,
    StateDTO state,
    Date releaseDate,
    Set<SeasonDTO> seasons
) implements Serializable {

    public static AnimeDTO fromEntity(Anime entity) {
        return new AnimeDTO(
                entity.getId(),
                0, // averageEpTime: calculável depois ou pegar de entity.getAverageEptime()
                entity.getDateAdded(),
                entity.getDescription(),
                entity.getGenres().stream().map(Genre::toDTO).collect(Collectors.toSet()),
                entity.getLanguage(),
                entity.getName(),
                entity.getName2(),
                entity.getQuality(),
                entity.isVisible(),
                entity.getWeekday(),
                entity.getProducers() == null ? Set.of() :
                        entity.getProducers().stream()
                                .map(ProducerSummaryDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getCreators() == null ? Set.of() :
                        entity.getCreators().stream()
                                .map(CreatorDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getStudios() == null ? Set.of() :
                        entity.getStudios().stream()
                                .map(StudioDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getCharacters() == null ? Set.of() :
                        entity.getCharacters().stream()
                                .map(CharacterDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getState() != null ? StateDTO.fromEntity(entity.getState()) : null,
                entity.getReleaseDate(),
                entity.getSeasons() == null ? Set.of() :
                        entity.getSeasons().stream()
                                .map(SeasonDTO::fromEntity)
                                .collect(Collectors.toSet())
        );
    }
}
