package br.edu.utfpr.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Rodada {
    RODADA_1 {
        @Override
        public Integer getAcertar() {
            return 1000;
        }

        @Override
        public Integer getParar() {
            return 0;
        }

        @Override
        public Integer getErrar() {
            return 0;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_2;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.FACIL;
        }
    },
    RODADA_2 {
        @Override
        public Integer getAcertar() {
            return 2000;
        }

        @Override
        public Integer getParar() {
            return 1000;
        }

        @Override
        public Integer getErrar() {
            return 500;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_3;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.FACIL;
        }
    },
    RODADA_3 {
        @Override
        public Integer getAcertar() {
            return 3000;
        }

        @Override
        public Integer getParar() {
            return 2000;
        }

        @Override
        public Integer getErrar() {
            return 1000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_4;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.FACIL;
        }
    },
    RODADA_4 {
        @Override
        public Integer getAcertar() {
            return 4000;
        }

        @Override
        public Integer getParar() {
            return 3000;
        }

        @Override
        public Integer getErrar() {
            return 1500;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_5;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.FACIL;
        }
    },
    RODADA_5 {
        @Override
        public Integer getAcertar() {
            return 5000;
        }

        @Override
        public Integer getParar() {
            return 4000;
        }

        @Override
        public Integer getErrar() {
            return 2000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_6;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.FACIL;
        }
    },
    RODADA_6 {
        @Override
        public Integer getAcertar() {
            return 10000;
        }

        @Override
        public Integer getParar() {
            return 5000;
        }

        @Override
        public Integer getErrar() {
            return 2500;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_7;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.MEDIO;
        }
    },
    RODADA_7 {
        @Override
        public Integer getAcertar() {
            return 20000;
        }

        @Override
        public Integer getParar() {
            return 10000;
        }

        @Override
        public Integer getErrar() {
            return 5000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_8;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.MEDIO;
        }
    },
    RODADA_8 {
        @Override
        public Integer getAcertar() {
            return 30000;
        }

        @Override
        public Integer getParar() {
            return 20000;
        }

        @Override
        public Integer getErrar() {
            return 10000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_9;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.MEDIO;
        }
    },
    RODADA_9 {
        @Override
        public Integer getAcertar() {
            return 40000;
        }

        @Override
        public Integer getParar() {
            return 30000;
        }

        @Override
        public Integer getErrar() {
            return 15000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_10;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.MEDIO;
        }
    },
    RODADA_10 {
        @Override
        public Integer getAcertar() {
            return 50000;
        }

        @Override
        public Integer getParar() {
            return 40000;
        }

        @Override
        public Integer getErrar() {
            return 20000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_11;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.MEDIO;
        }
    },
    RODADA_11 {
        @Override
        public Integer getAcertar() {
            return 100000;
        }

        @Override
        public Integer getParar() {
            return 50000;
        }

        @Override
        public Integer getErrar() {
            return 25000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_12;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.DIFICIL;
        }
    },
    RODADA_12 {
        @Override
        public Integer getAcertar() {
            return 200000;
        }

        @Override
        public Integer getParar() {
            return 100000;
        }

        @Override
        public Integer getErrar() {
            return 50000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_13;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.DIFICIL;
        }
    },
    RODADA_13 {
        @Override
        public Integer getAcertar() {
            return 300000;
        }

        @Override
        public Integer getParar() {
            return 200000;
        }

        @Override
        public Integer getErrar() {
            return 100000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_14;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.DIFICIL;
        }
    },
    RODADA_14 {
        @Override
        public Integer getAcertar() {
            return 400000;
        }

        @Override
        public Integer getParar() {
            return 300000;
        }

        @Override
        public Integer getErrar() {
            return 150000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_15;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.DIFICIL;
        }
    },
    RODADA_15 {
        @Override
        public Integer getAcertar() {
            return 500000;
        }

        @Override
        public Integer getParar() {
            return 400000;
        }

        @Override
        public Integer getErrar() {
            return 200000;
        }

        @Override
        public Rodada getProximaRodada() {
            return RODADA_16;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.DIFICIL;
        }
    },
    RODADA_16 {
        @Override
        public Integer getAcertar() {
            return 1000000;
        }

        @Override
        public Integer getParar() {
            return 500000;
        }

        @Override
        public Integer getErrar() {
            return 0;
        }

        @Override
        public Rodada getProximaRodada() {
            return null;
        }

        @Override
        public Dificuldade getDificuldade() {
            return Dificuldade.DIFICIL;
        }
    };

    public abstract Integer getAcertar();
    public abstract Integer getParar();
    public abstract Integer getErrar();
    public abstract Rodada getProximaRodada();
    public abstract Dificuldade getDificuldade();

}
