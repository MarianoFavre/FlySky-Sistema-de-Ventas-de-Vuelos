package com.codoacodo.flysky.demo.model.entity;


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
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVuelo;
    private Integer capacidad;
    private String aerolinea;
    private LocalDateTime fechaHoraPartida;
    private LocalDateTime fechaHoraLlegada;
    private Double precio;
    private String origen;
    private String destino;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Butaca> butacas;

    //Eager: realiza un Join entre la tabla Vuelo y Butaca, para poder cargar ambos objetos en el momento de obtener
    // el Vuelo desde la Base de datos.
    //Lazy: al traer un Vuelo, no nos traerá aún las Butacas asociada. Al traer el Vuelo se realizará un SELECT y otro
    // cuando se desee obtener la información de la Butacas.
}
