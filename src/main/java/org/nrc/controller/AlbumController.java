package org.nrc.controller;

import org.nrc.entity.Album;
import org.nrc.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albuns")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    
    @GetMapping
    public ResponseEntity<List<Album>> listarAlbuns() {
        List<Album> albuns = albumService.listarAlbuns();
        return ResponseEntity.ok(albuns);
    }
    
    @PostMapping
    public ResponseEntity<Album> criarAlbum(@RequestBody Album album) {
        Album novoAlbum = albumService.criarAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlbum);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Album> buscarAlbumPorId(@PathVariable Long id) {
        Optional<Album> album = albumService.buscarAlbumPorId(id);
        return album.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlbum(@PathVariable Long id) {
        albumService.deletarAlbum(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Album> atualizarAlbum(@PathVariable Long id, @RequestBody Album album) {
        Album albumAtualizado = albumService.atualizarAlbum(id, album);
        return ResponseEntity.ok(albumAtualizado);
    }
}
