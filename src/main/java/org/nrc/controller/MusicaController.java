package org.nrc.controller;

import org.nrc.entity.Musica;
import org.nrc.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;
    
    @GetMapping
    public ResponseEntity<List<Musica>> listarMusicas() {
        List<Musica> musicas = musicaService.listarMusicas();
        return ResponseEntity.ok(musicas);
    }
    
    @PostMapping
    public ResponseEntity<Musica> criarMusica(@RequestBody Musica musica) {
        Musica novaMusica = musicaService.criarMusica(musica);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMusica);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarMusicaPorId(@PathVariable Long id) {
        Optional<Musica> musica = musicaService.buscarMusicaPorId(id);
        return musica.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
     
}