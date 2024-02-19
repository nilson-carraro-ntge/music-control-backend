package org.nrc.controller;

import org.nrc.entity.Artista;
import org.nrc.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;
    
    @GetMapping
    public ResponseEntity<List<Artista>> listarArtistas() {
        List<Artista> artistas = artistaService.listarArtistas();
        return ResponseEntity.ok(artistas);
    }
    
    @PostMapping
    public ResponseEntity<Artista> criarArtista(@RequestBody Artista artista) {
        Artista novoArtista = artistaService.criarArtista(artista);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoArtista);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarArtistaPorId(@PathVariable Long id) {
        Optional<Artista> artista = artistaService.buscarArtistaPorId(id);
        return artista.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtista(@PathVariable Long id) {
        artistaService.deletarArtista(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizarArtista(@PathVariable Long id, @RequestBody Artista artista) {
        Artista artistaAtualizado = artistaService.atualizarArtista(id, artista);
        return ResponseEntity.ok(artistaAtualizado);
    }
}
