package com.bank.jan.cliente.controller;

import com.bank.jan.cliente.dto.ClienteRequest;
import com.bank.jan.cliente.dto.ClienteResponse;
import com.bank.jan.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/api")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/clientes")
    public ClienteResponse registrar (@RequestBody ClienteRequest clienteRequest){
        return clienteService.registrarCliente(clienteRequest);
    }

}
