package org.nrc.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @Min(value = 0, message = "A duração deve ser positiva")
    private int duracaoMinutos;
    @Min(value = 0, message = "A duração deve ser positiva")
    @Max(value = 59, message = "A duração deve ser inferior a 60 segundos")
    private int duracaoSegundos;
    @Min(value = 1, message = "O número da faixa deve ser positivo")
    private int numeroFaixa;
    
    @ManyToOne
    private Album album;
}
