package org.nrc.repository;

import org.nrc.entity.Album;
import org.nrc.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    List<Musica> findByAlbumOrderByNumeroFaixa(Album album);
    List<Musica> findByAlbumOrderByTitulo(Album album);
}