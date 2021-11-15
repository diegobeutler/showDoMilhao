package br.edu.utfpr.jogo;

import br.edu.utfpr.enumeration.Dificuldade;
import br.edu.utfpr.enumeration.Rodada;

import java.math.BigInteger;

public class Jogo {
    private static Jogo jogo;
    private Integer pontuacao = 0;
    private Rodada rodada;// talvee colocar a dificuldade aqui

    private Jogo() {
        this.pontuacao = 0;
        this.rodada = Rodada.RODADA_1;
    }

    public static Jogo getJogo() {
        if (jogo == null) {
            jogo = new Jogo();
        }
        return jogo;
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

    public void proximaRodada() {
        rodada = rodada.getProximaRodada();
    }

    public void reiniciar() {
        jogo = null;
    }
}
