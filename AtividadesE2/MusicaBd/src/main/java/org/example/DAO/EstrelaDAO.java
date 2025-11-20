package org.example.DAO;

import org.example.classes.Estrela;
import org.example.conexoes.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstrelaDAO {

    // CREATE
    public void inserir(Estrela estrela) {
        String sql = "INSERT INTO estrela (nome, cor, tamanho, dist_terra) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estrela.getNome());
            stmt.setString(2, estrela.getCor());
            stmt.setDouble(3, estrela.getTamanho());
            stmt.setDouble(4, estrela.getDistTerra());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (listar todos)
    public List<Estrela> listarTodos() {
        List<Estrela> lista = new ArrayList<>();
        String sql = "SELECT * FROM estrela";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cor = rs.getString("cor");
                double tamanho = rs.getDouble("tamanho");
                double distTerra = rs.getDouble("dist_terra");
                lista.add(new Estrela(id, nome, cor, tamanho, distTerra));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    // UPDATE
    public void atualizar( Estrela estrela) {
        String sql = "UPDATE estrela SET nome = ?, cor = ?, tamanho = ?, dist_terra = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estrela.getNome());
            stmt.setString(2, estrela.getCor());
            stmt.setDouble(3, estrela.getTamanho());
            stmt.setDouble(4, estrela.getDistTerra());
            stmt.setInt(5, estrela.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(Estrela estrela) {
        String sql = "DELETE FROM estrela WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estrela.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
