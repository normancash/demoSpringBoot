package org.uam.demospringboot.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uam.demospringboot.dto.ClienteDTO;
import org.uam.demospringboot.mapper.ClienteMapper;
import org.uam.demospringboot.model.Cliente;
import org.uam.demospringboot.service.ServicioCliente;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {

    private final ServicioCliente servicioCliente;
    private final ClienteMapper clienteMapper;

    public ControllerCliente(ServicioCliente servicioCliente, ClienteMapper clienteMapper) {
        this.servicioCliente = servicioCliente;
        this.clienteMapper = clienteMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> all(){
        return ResponseEntity.ok(
          servicioCliente.findAll().stream()
                  .map(clienteMapper::clienteToClienteDTO).toList()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente =  clienteMapper.clienteDTOToCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteMapper.clienteToClienteDTO(servicioCliente.create(cliente)));
    }
}
