package org.nrc.service;

import org.nrc.entity.Musica;
import org.nrc.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;
    
    public List<Musica> listarMusicas() {
        return musicaRepository.findAll();
    }
    
    public Musica criarMusica(Musica musica) {
        return musicaRepository.save(musica);
    }
    
    public Optional<Musica> buscarMusicaPorId(Long id) {
        return musicaRepository.findById(id);
    }
    
    public void deletarMusica(Long id) {
        musicaRepository.deleteById(id);
    }
    
    public Musica atualizarMusica(Long id, Musica musica) {
    	Optional<Musica> musicaExistenteOptional = musicaRepository.findById(id);
        if (musicaExistenteOptional.isPresent()) {
            Musica musicaExistente = musicaExistenteOptional.get();
            musicaExistente.setTitulo(musica.getTitulo());
            musicaExistente.setDuracaoMinutos(musica.getDuracaoMinutos());
            musicaExistente.setDuracaoSegundos(musica.getDuracaoSegundos());
            musicaExistente.setNumeroFaixa(musica.getNumeroFaixa());
            musicaExistente.setAlbum(musica.getAlbum());
            return musicaRepository.save(musicaExistente);
        } else {
            throw new RuntimeException("Música não encontrada com ID: " + id);
        }
    }
}
