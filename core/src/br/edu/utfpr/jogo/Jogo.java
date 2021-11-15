package br.edu.utfpr.jogo;

import br.edu.utfpr.enumeration.Rodada;

public class Jogo {
    private static Jogo jogo;
    private Integer pontuacao = 0;
    private Rodada rodada;
    private int quantidadePulos;
    private boolean possuiElimina2;

    public boolean getPossuiElimina2() {
        return possuiElimina2;
    }

    public void setPossuiElimina2(boolean possuiElimina2) {
        this.possuiElimina2 = possuiElimina2;
    }

    private Jogo() {
        this.pontuacao = 0;
        quantidadePulos = 3;
        possuiElimina2 = true;
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
