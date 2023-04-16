package com.crud.testeassertiva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.testeassertiva.model.Cliente;
import com.crud.testeassertiva.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    public List<Cliente> listarPorDddCelular(String ddd) {
        return clienteRepository.listarPorDddCelular(ddd);
    }

    public List<Cliente> listarPorNome(String nome) {
        return clienteRepository.listarPorNome(nome);
    }

    public Cliente salvar(Cliente cliente) throws Exception {
        if (cliente.getId() != null) {
            throw new IllegalArgumentException("Não é possível salvar um cliente que já possui ID.");
        }
        validarCliente(cliente);
        return clienteRepository.salvar(cliente);
    }

    public Cliente atualizar(Cliente cliente) throws Exception {
        if (cliente.getId() == null) {
            throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
        }
        validarCliente(cliente);
        return clienteRepository.atualizar(cliente.getId(), cliente);
    }

    public boolean deletar(Long id) {
        return clienteRepository.deletar(id);
    }

    private void validarCliente(Cliente cliente) throws Exception {
        validarCpf(cliente.getCpf());
        validarNome(cliente.getNome());
        validarCelulares(cliente.getCelulares());
        validarEmails(cliente.getEmails());
    }

    private void validarCpf(String cpf) throws Exception {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new Exception("CPF inválido");
        }
    }

    private void validarNome(String nome) throws Exception {
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome inválido");
        }
    }

    private void validarCelulares(List<String> celulares) throws Exception {
        if (celulares == null || celulares.isEmpty()) {
            throw new Exception("Pelo menos um celular deve ser informado");
        } else {
            for (String celular : celulares) {
                if (celular == null || !celular.matches("\\d{2}\\d{9}")) {
                    throw new Exception("Celular inválido");
                }
            }
        }
    }

    private void validarEmails(List<String> emails) throws Exception {
        if (emails == null || emails.isEmpty()) {
            throw new Exception("Pelo menos um e-mail deve ser informado");
        } else {
            for (String email : emails) {
                if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    throw new Exception("E-mail inválido");
                }
            }
        }
    }
}