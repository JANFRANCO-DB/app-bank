package com.bank.jan.cliente.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false,length = 150)
    private String email;

    @Column(nullable = false,length = 20)
    private String telefono;

    @Column(nullable = false,length = 200)
    private String direccion;

    private String tipoCliente;

    private LocalDateTime fechaRegistro;

    private String estado;

}
