package com.bank.jan.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {

    @NotBlank
    private String dni;

    private String nombre;

    @Email
    private String email;
    private String telefono;
    private String direccion;
    private String tipoCliente;
    private LocalDateTime fechaRegistro;
    private String estado;
}
