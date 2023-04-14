@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente buscarPorId(Long id) {
        String query = "SELECT * FROM clientes WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new ClienteRowMapper());
    }

    public List<Cliente> listarTodos() {
        String query = "SELECT * FROM clientes";
        return jdbcTemplate.query(query, new ClienteRowMapper());
    }

    public List<Cliente> listarPorDddCelular(String ddd) {
        String query = "SELECT * FROM clientes WHERE celulares LIKE ?";
        return jdbcTemplate.query(query, new Object[]{"%" + ddd + "%"}, new ClienteRowMapper());
    }

    public List<Cliente> listarPorNome(String nome) {
        String query = "SELECT * FROM clientes WHERE nome LIKE ?";
        return jdbcTemplate.query(query, new Object[]{"%" + nome + "%"}, new ClienteRowMapper());
    }

    public Cliente salvar(Cliente cliente) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO clientes (cpf, nome, celulares, emails) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, String.join(",", cliente.getCelulares()));
            ps.setString(4, String.join(",", cliente.getEmails()));
            return ps;
        }, keyHolder);
        cliente.setId(keyHolder.getKey().longValue());
        return cliente;
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        String query = "UPDATE clientes SET cpf = ?, nome = ?, celulares = ?, emails = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(query, cliente.getCpf(), cliente.getNome(),
                String.join(",", cliente.getCelulares()), String.join(",", cliente.getEmails()), id);
        if (rowsAffected > 0) {
            cliente.setId(id);
            return cliente;
        } else {
            return null;
        }
    }

    public boolean deletar(Long id) {
        String query = "DELETE FROM clientes WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(query, id);
        return rowsAffected > 0;
    }

    private static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String cpf = rs.getString("cpf");
            String nome = rs.getString("nome");
            String[] celulares = rs.getString("celulares").split(",");
            String[] emails = rs.getString("emails").split(",");
            return new Cliente(id, cpf, nome, Arrays.asList(celulares), Arrays.asList(emails));
        }
    }
}
