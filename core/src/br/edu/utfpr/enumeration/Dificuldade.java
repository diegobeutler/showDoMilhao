package br.edu.utfpr.enumeration;

public enum Dificuldade {
    FACIL("Fácil"),
    MEDIO("Médio"),
    DIFICIL("Difícil");

    private String value;

    Dificuldade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
