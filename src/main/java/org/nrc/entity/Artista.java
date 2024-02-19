package org.nrc.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;
    private String enderecoSite;
    private String imagemPerfil;
}
