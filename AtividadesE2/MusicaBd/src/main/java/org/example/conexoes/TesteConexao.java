package org.example.conexoes;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexão com o banco 'adriana' estabelecida com sucesso!");
            } else {
                System.out.println("⚠️ Falha ao conectar.");
            }
        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
