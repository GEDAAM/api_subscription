package br.edu.gedaam.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Service
public class SimposiumService {


    private Set<String> simposiumPresent = new HashSet<>();

    public Set<String> importSimposiumPresence() {
        readFile();
        return simposiumPresent;
    }

    private void readFile() {
        InputStream inputStream;
        try {
            String CAMINHO_ARQUIVO = "/home/castro/Downloads/";
            String ARQUIVO_LEITURA = CAMINHO_ARQUIVO + "2018-2-Simposio.csv";
            inputStream = new FileInputStream(ARQUIVO_LEITURA);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            while (br.ready()) {
                String linha = br.readLine();
                processLine(linha);
            } // while

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processLine(String line) {
        String[] lineArray = line.split(",");
        simposiumPresent.add(lineArray[1].trim());
    }
}
