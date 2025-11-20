package org.example.DAO;

import org.example.classes.Papel;
import org.example.conexoes.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PapelDAO {

    // CREATE
    public void inserir(Papel papel) {
        String sql = "INSERT INTO papel (cor, tamanho, desenhado) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, papel.getCor());
            stmt.setInt(2, papel.getTamanho());
            stmt.setBoolean(3, papel.isDesenhado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (listar todos)
    public List<Papel> listarTodos() {
        List<Papel> lista = new ArrayList<>();
        String sql = "SELECT * FROM papel";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String cor = rs.getString("cor");
                int tamanho = rs.getInt("tamanho");
                boolean desenhado = rs.getBoolean("desenhado");
                lista.add(new Papel(id, cor, tamanho, desenhado));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    // UPDATE
    public void atualizar(Papel papel) {
        String sql = "UPDATE papel SET cor = ?, tamanho = ?, desenhado = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, papel.getCor());
            stmt.setInt(2, papel.getTamanho());
            stmt.setBoolean(3, papel.isDesenhado());
            stmt.setInt(4, papel.getId()); // o ID precisa estar no objeto

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(Papel papel) {
        String sql = "DELETE FROM papel WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, papel.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
