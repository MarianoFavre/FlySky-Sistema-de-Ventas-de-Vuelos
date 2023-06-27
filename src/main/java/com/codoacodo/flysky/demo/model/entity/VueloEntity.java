package com.codoacodo.flysky.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vuelo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ReservaEntity> reservas;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ButacaEntity> butacas;

    private Boolean disponible;
    private Integer capacidad;
    private String aerolinea;
    private LocalDateTime horarioPartida;
    private LocalDateTime horarioLlegada;
    private Double precio;
    private String origen;
    private String destino;
}
