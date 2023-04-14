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

    public Cliente salvar(Cliente cliente) throws Exception {
        if (cliente.getId() != null) {
            throw new IllegalArgumentException("Não é possível salvar um cliente que já possui ID.");
        }
        validarCliente(cliente);
        return clienteRepository.salvar(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) throws Exception {
        if (!id.equals(cliente.getId())) {
            throw new IllegalArgumentException("ID do cliente a ser atualizado difere do ID fornecido.");
        }
        validarCliente(cliente);
        return clienteRepository.atualizar(id, cliente);
    }

    public boolean deletar(Long id) {
        return clienteRepository.deletar(id);
    }

    private void validarCliente(Cliente cliente) throws Exception {
        if (cliente.getCpf() == null || !cliente.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new Exception("CPF inválido");
        }

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new Exception("Nome inválido");
        }

        if (cliente.getCelulares() == null || cliente.getCelulares().isEmpty()) {
            throw new Exception("Pelo menos um celular deve ser informado");
        } else {
            for (String celular : cliente.getCelulares()) {
                if (celular == null || !celular.matches("\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")) {
                    throw new Exception("Celular inválido");
                }
            }
        }

        if (cliente.getEmails() == null || cliente.getEmails().isEmpty()) {
            throw new Exception("Pelo menos um e-mail deve ser informado");
        } else {
            for (String email : cliente.getEmails()) {
                if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    throw new Exception("E-mail inválido");
                }
            }
        }
    }
}
