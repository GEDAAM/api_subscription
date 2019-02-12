package br.edu.gedaam.service;

import br.edu.gedaam.util.FileLocation;
import br.edu.gedaam.util.FileReader;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FrequencyService extends FileReader {

    // IMPORTANTE: Sempre verifica frequencia no semestre anterior

    private Set<String> infrequentSet = new HashSet<>();

    public Set<String> importData() {
        readFile(FileLocation.FREQUENCY.getPath());
        return infrequentSet;
    }

    protected void processLine(String line) {
        String[] lineArray = line.split(",");
        if (lineArray[25].trim().contentEquals("false")) {
            infrequentSet.add(lineArray[3].trim());
        }
    }
}
