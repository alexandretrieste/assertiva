package com.crud.testeassertiva.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.crud.testeassertiva.model.Cliente;
import com.crud.testeassertiva.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = clienteService.listarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) throws Exception {
        Cliente cliente = clienteService.buscarPorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> listarPorNome(@PathVariable String nome) {
        List<Cliente> clientes = clienteService.listarPorNome(nome);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/ddd/{ddd}")
    public ResponseEntity<List<Cliente>> listarPorDddCelular(@PathVariable String ddd) {
        List<Cliente> clientes = clienteService.listarPorDddCelular(ddd);
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable("id") Long id) throws Exception {
        clienteService.deletar(id);
        return new ResponseEntity<>("Cliente removido com sucesso.", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> addCliente(@Valid @RequestBody Cliente cliente) throws Exception {
        cliente = clienteService.salvar(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) throws Exception {
        cliente.setId(id);
        Cliente clienteAtualizado = clienteService.atualizar(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
