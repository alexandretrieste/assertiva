package com.crud.testeassetiva.service;

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

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() != null) {
            throw new IllegalArgumentException("Não é possível salvar um cliente que já possui ID.");
        }
        validarCliente(cliente);
        return clienteRepository.salvar(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        if (!id.equals(cliente.getId())) {
            throw new IllegalArgumentException("ID do cliente a ser atualizado difere do ID fornecido.");
        }
        validarCliente(cliente);
        return clienteRepository.atualizar(id, cliente);
    }

    public boolean deletar(Long id) {
        return clienteRepository.deletar(id);
    }

    private void validarCliente(Cliente cliente) {
        // Validar CPF, nome, celulares e e-mails do cliente aqui
        // Lançar uma exceção caso algum campo seja inválido
    }
}
