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
public class FrequencyService {

    // IMPORTANTE: Sempre verifica frequencia no semestre anterior

    private Set<String> infrequentSet = new HashSet<>();

    public Set<String> importInfrequency() {
        readFile();
        return infrequentSet;
    }

    private void readFile() {
        InputStream inputStream;
        try {
            String CAMINHO_ARQUIVO = "/home/castro/Downloads/";
            String ARQUIVO_LEITURA = CAMINHO_ARQUIVO + "2018-1-Frequencia.csv";
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
        if (lineArray[25].trim().contentEquals("false")) {
            infrequentSet.add(lineArray[3].trim());
        }
    }
}
