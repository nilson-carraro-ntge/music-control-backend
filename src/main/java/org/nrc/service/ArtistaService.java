package org.nrc.service;

import org.nrc.entity.Artista;
import org.nrc.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;
    
    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }
    
    public Artista criarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }
    
    public Optional<Artista> buscarArtistaPorId(Long id) {
        return artistaRepository.findById(id);
    }
    
    public void deletarArtista(Long id) {
        artistaRepository.deleteById(id);
    }
    
    public Artista atualizarArtista(Long id, Artista artista) {
    	Optional<Artista> artistaExistenteOptional = artistaRepository.findById(id);
        if (artistaExistenteOptional.isPresent()) {
            Artista artistaExistente = artistaExistenteOptional.get();
            artistaExistente.setNome(artista.getNome());
            artistaExistente.setNacionalidade(artista.getNacionalidade());
            artistaExistente.setEnderecoSite(artista.getEnderecoSite());
            artistaExistente.setImagemPerfil(artista.getImagemPerfil());
            return artistaRepository.save(artistaExistente);
        } else {
            throw new RuntimeException("Artista não encontrado com ID: " + id);
        }
    }
}
