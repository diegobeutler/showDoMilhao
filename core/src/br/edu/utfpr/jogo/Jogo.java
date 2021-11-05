package br.edu.utfpr.jogo;

import br.edu.utfpr.enumeration.Dificuldade;

import java.math.BigInteger;

public class Jogo {
    private static Jogo jogo;
    private Dificuldade dificuldade;
    private Integer pontuacao;
    private Rodada rodada;

    private Jogo() {
        this.dificuldade = Dificuldade.FACIL;
        this.pontuacao = 0;
        this.rodada = new Rodada(1);

    }

    public static Jogo getJogo() {
        if (jogo == null) {
            jogo = new Jogo();
        }
        return jogo;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }
}
