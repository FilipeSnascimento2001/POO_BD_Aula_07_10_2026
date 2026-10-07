package DAO;

import BD.Cnx;
import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UsuarioDAO implements DAO<Usuario> {

    @Override
    public int cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (login, senha, admin) VALUES (?, ?, ?)";
        try (Connection conexao = Cnx.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getAdmin());
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // retorna o ID gerado
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
    

