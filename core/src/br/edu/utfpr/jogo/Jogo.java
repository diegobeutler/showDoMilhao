package br.edu.utfpr.jogo;

import br.edu.utfpr.enumeration.Rodada;

public class Jogo {
    private static Jogo jogo;
    private Integer pontuacao = 0;
    private Rodada rodada;
    private int quantidadePulos;

    private Jogo() {
        this.pontuacao = 0;
        quantidadePulos = 3;
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

    public int getQuantidePulos() {
        return quantidadePulos;
    }

    public void setQuantidadePulos(int quantidadePulos) {
        this.quantidadePulos = quantidadePulos;
    }
}
