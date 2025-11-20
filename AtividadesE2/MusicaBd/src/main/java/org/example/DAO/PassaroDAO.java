package org.example.DAO;

import org.example.classes.Passaro;
import org.example.conexoes.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassaroDAO {

    // CREATE
    public void inserir(Passaro passaro) {
        String sql = "INSERT INTO passaro (especie, cor, peso) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, passaro.getEspecie());
            stmt.setString(2, passaro.getCor());
            stmt.setFloat(3, passaro.getPeso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (listar todos)
    public List<Passaro> listarTodos() {
        List<Passaro> lista = new ArrayList<>();
        String sql = "SELECT * FROM passaro";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String especie = rs.getString("especie");
                String cor = rs.getString("cor");
                float peso = rs.getFloat("peso");
                lista.add(new Passaro(id, especie, cor, peso));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    // UPDATE
    public void atualizar(Passaro Passaro) {
        String sql = "UPDATE passaro SET especie = ?, cor = ?, peso = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, Passaro.getEspecie());
            stmt.setString(2, Passaro.getCor());
            stmt.setFloat(3, Passaro.getPeso());
            stmt.setInt(4, Passaro.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(Passaro passaro) {
        String sql = "DELETE FROM passaro WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, passaro.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}