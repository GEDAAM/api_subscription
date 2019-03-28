package br.edu.gedaam.util;

public enum FileLocation {

    SIMPOSIUM_PRESENCE("/home/castro/Downloads/2018-2-Simposio.csv"),
    FREQUENCY("/home/castro/Downloads/2018-1-Frequencia.csv"),
    SUBSCRIPTION("/home/castro/Downloads/2018-2-Respostas_GEDAAM.csv"),
    CAMINHO_ARQUIVO("/home/castro/");

    private String path;

    public String getPath() {
        return path;
    }

    FileLocation(String path) {
        this.path = path;

    }
}
