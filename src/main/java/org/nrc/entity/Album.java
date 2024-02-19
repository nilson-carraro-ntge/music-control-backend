package org.nrc.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @Min(value = 1900, message = "Ano de lançamento inválido")
    @Max(value = 2100, message = "Ano de lançamento inválido")
    private int anoLancamento;
    private String imagemCapa;
    
    @ManyToOne
    private Artista artista;
}
