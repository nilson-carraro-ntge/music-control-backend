package org.nrc.repository;

import org.nrc.entity.Album;
import org.nrc.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByArtista(Artista artista);
}
