package com.bank.jan.cliente.service;

import com.bank.jan.cliente.dto.ClienteRequest;
import com.bank.jan.cliente.dto.ClienteResponse;
import com.bank.jan.cliente.entity.Cliente;
import com.bank.jan.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse registrarCliente(ClienteRequest clienteRequest) {

        // 1. Buscar cliente por DNI(validamos si existe)
        clienteRepository.findByDni(clienteRequest.getDni())
                .ifPresent(existe -> {
                    throw new IllegalStateException("ya existe el documento: "+ clienteRequest.getDni());
                });
        // 2. Crear Cliente nuevo con builder
        Cliente clienteNuevo = Cliente.builder()
                .dni(clienteRequest.getDni())
                .nombre(clienteRequest.getNombre())
                .email(clienteRequest.getEmail())
                .telefono(clienteRequest.getTelefono())
                .direccion(clienteRequest.getDireccion())
                .tipoCliente(clienteRequest.getTipoCliente())
                .fechaRegistro(clienteRequest.getFechaRegistro())
                .estado(clienteRequest.getEstado())
                .build();
        // 3. Guardar Cliente nuevo
        var clienteGuardado = clienteRepository.save(clienteNuevo);

        //4. Debe retornar la clase ClienteResponse
        return ClienteResponse.builder()
                .id(clienteGuardado.getId())
                .dni(clienteGuardado.getDni())
                .nombre(clienteGuardado.getNombre())
                .estado(clienteGuardado.getEstado())
                .build();

    };

}
