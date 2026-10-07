import java.sql.Connection;
import java.sql.SQLException;
import BD.Cnx;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Testando conexão com o banco de dados...");
          try (Connection conexao = Cnx.getConexao()) {
            if (conexao != null && !conexao.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Falha ao conectar ao banco de dados:");
            e.printStackTrace();
        }



    }
}

