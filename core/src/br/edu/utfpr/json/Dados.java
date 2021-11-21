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
        Questao questao;
        switch (dificuldade) {
            case FACIL:
                questao = faceis.get(new Random().nextInt(faceis.size()));
                faceis.remove(questao);
                return questao;

            case MEDIO:
                questao = medias.get(new Random().nextInt(medias.size()));
                medias.remove(questao);
                return questao;

            case DIFICIL:
                questao = dificeis.get(new Random().nextInt(dificeis.size()));
                dificeis.remove(questao);
                return questao;
            default: throw new IllegalStateException("Unexpected value: " + dificuldade);
        }
    }
}
