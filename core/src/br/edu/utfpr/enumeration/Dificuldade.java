package br.edu.utfpr.enumeration;

public enum Dificuldade {
    FACIL("Facil"),
    MEDIO("Medio"),
    DIFICIL("Dificil");

    private String value;

    Dificuldade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
