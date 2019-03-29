package br.edu.gedaam.util;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class FileReader {

    protected void readFile(String filePath) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
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

    protected abstract void processLine(String line);



}
