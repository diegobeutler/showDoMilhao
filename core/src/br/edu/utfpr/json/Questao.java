package br.edu.utfpr.json;

import java.util.List;

public class Questao {
    private String dificuldade;
    private String key;
    private String pergunta;
    private List<Resposta> respostas;

    public String getDificuldade() {
        return dificuldade;
    }

    public String getKey() {
        return key;
    }

    public String getPergunta() {
        return pergunta;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }
}
