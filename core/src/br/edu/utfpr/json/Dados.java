package br.edu.utfpr.json;

import br.edu.utfpr.enumeration.Dificuldade;

import java.util.List;
import java.util.Random;

public class Dados {
    private List<Questao> faceis;
    private List<Questao> medias;
    private List<Questao> dificeis;

    public List<Questao> getFaceis() {
        return faceis;
    }

    public List<Questao> getMedias() {
        return medias;
    }

    public List<Questao> getDificeis() {
        return dificeis;
    }


    public Questao getQuestao(Dificuldade dificuldade) {
        switch (dificuldade) {
            case FACIL:
                return faceis.get(new Random().nextInt(faceis.size()));

            case MEDIO:
                return medias.get(new Random().nextInt(medias.size()));

            case DIFICIL:
                return dificeis.get(new Random().nextInt(dificeis.size()));
            default: throw new IllegalStateException("Unexpected value: " + dificuldade);
        }
    }
}
