package entities.anime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import entities.character.Character;
import entities.creator.Creator;
import entities.genre.Genre;
import entities.producer.Producer;
import entities.season.Season;
import entities.state.State;
import entities.studio.Studio;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "anime", schema = "anime")
@Getter
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    @Column(name = "averageeptime", nullable = false)
//    private Double averageEptime;

    @Column(name = "date_added", nullable = false)
    private OffsetDateTime dateAdded;

    private String description;

//    @JdbcTypeCode(SqlTypes.ARRAY)
//    @Column(nullable = false, columnDefinition = "text[]")
//    private List<String> genre = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "anime_genre",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private Set<Genre> genres;

    @NotNull
    @Column(nullable = false)
    private String language;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String name2;

    @NotNull
    @Column(nullable = false)
    private String quality;

    @NotNull
    @Column(nullable = false)
    private boolean visible;

    private String weekday;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_producers",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "producer_id")}
    )
    private Set<Producer> producers;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_creators",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "creator_id")}
    )
    private Set<Creator> creators;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_studios",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "studio_id")}
    )
    private Set<Studio> studios;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_characters",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state")
    private State state;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id", insertable = false, updatable = false)
    private Set<Season> seasons = new HashSet<>();


    @Column(name = "releasedate")
    private Date releaseDate;

    public Anime(){}

    public Anime(
            String name,
            String name2,
            String description,
            Set<Genre> genres,
            State state,
            String quality
    ) {
        this.name = name;
        this.name2 = name2;
        this.description = description;
        this.genres = genres;
        this.state = state;
        this.quality = quality;
        this.visible = false;
    }

    public AnimeDTO toDTO() {
        return AnimeDTO.fromEntity(this);
    }

    public AnimeSummaryDTO toSummaryDTO() {
        return AnimeSummaryDTO.fromEntity(this);
    }
}
