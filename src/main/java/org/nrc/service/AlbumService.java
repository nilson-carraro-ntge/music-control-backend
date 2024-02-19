package org.nrc.service;

import org.nrc.entity.Album;
import org.nrc.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    
    public List<Album> listarAlbuns() {
        return albumRepository.findAll();
    }
    
    public Album criarAlbum(Album album) {
        return albumRepository.save(album);
    }
    
    public Optional<Album> buscarAlbumPorId(Long id) {
        return albumRepository.findById(id);
    }
    
    public void deletarAlbum(Long id) {
        albumRepository.deleteById(id);
    }
    
    public Album atualizarAlbum(Long id, Album album) {
    	Optional<Album> albumExistenteOptional = albumRepository.findById(id);
        if (albumExistenteOptional.isPresent()) {
            Album albumExistente = albumExistenteOptional.get();
            albumExistente.setTitulo(album.getTitulo());
            albumExistente.setAnoLancamento(album.getAnoLancamento());
            albumExistente.setImagemCapa(album.getImagemCapa());
            albumExistente.setArtista(album.getArtista());
            return albumRepository.save(albumExistente);
        } else {
            throw new RuntimeException("Álbum não encontrado com ID: " + id);
        }
    }
}
