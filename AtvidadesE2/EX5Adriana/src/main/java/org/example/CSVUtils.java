package org.example;

import java.io.*;

public class CSVUtils {
    public static void salvar(String nomeArquivo, String cabecalho, String conteudo) throws IOException {
        File pasta = new File("arquivosCSV");
        if (!pasta.exists()) pasta.mkdir();

        File arquivo = new File(pasta, nomeArquivo);
        boolean jaExiste = arquivo.exists();

        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            if (!jaExiste) pw.println(cabecalho);
            pw.println(conteudo);
        }
    }
}
