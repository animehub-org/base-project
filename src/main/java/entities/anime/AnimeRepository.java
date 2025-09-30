package entities.anime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    @Override
    Page<Anime> findAll(Pageable pageable);

    List<Anime> findAllByVisible(boolean visible);

    Page<Anime> findAllByVisible(boolean visible, Pageable pageable);
}
