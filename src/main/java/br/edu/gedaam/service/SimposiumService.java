package br.edu.gedaam.service;

import br.edu.gedaam.util.FileLocation;
import br.edu.gedaam.util.FileReader;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SimposiumService extends FileReader {

    private Set<String> simposiumPresent = new HashSet<>();

    public Set<String> importData() {
        readFile(FileLocation.SIMPOSIUM_PRESENCE.getPath());
        return simposiumPresent;
    }

    protected void processLine(String line) {
        String[] lineArray = line.split(",");
        simposiumPresent.add(lineArray[1].trim());
    }
}
