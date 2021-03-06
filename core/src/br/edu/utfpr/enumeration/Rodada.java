package br.edu.utfpr.enumeration;

public enum Rodada {
    RODADA_1("Rodada 1") {
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

        @Override
        public String getSom() {
            return null;
        }
    },
    RODADA_2("Rodada 2") {
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

        @Override
        public String getSom() {
            return "sons/2Rodada.wav";
        }

    },
    RODADA_3("Rodada 3") {
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

        @Override
        public String getSom() {
            return "sons/3Rodada.wav";
        }

    },
    RODADA_4("Rodada 4") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSonoraAgitado.mp3";
        }
    },
    RODADA_5("Rodada 5") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSonoraMeio.mp3";
        }

    },
    RODADA_6("Rodada 6") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSuspense.mp3";
        }

    },
    RODADA_7("Rodada 7") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSonoraAgitado.mp3";
        }
    },
    RODADA_8("Rodada 8") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSuspense.mp3";
        }

    },
    RODADA_9("Rodada 9") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSuspense.mp3";
        }
    },
    RODADA_10("Rodada 10") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSonoraCalmo.mp3";
        }
    },
    RODADA_11("Rodada 11") {
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

        @Override
        public String getSom() {
            return "sons/trilhaSuspense.mp3";
        }
    },
    RODADA_12("Rodada 12") {
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

        @Override
        public String getSom() {
            return "sons/200milCortado.mp3";
        }
    },
    RODADA_13("Rodada 13") {
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

        @Override
        public String getSom() {
            return "sons/300milCortado.mp3";
        }
    },
    RODADA_14("Rodada 14") {
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

        @Override
        public String getSom() {
            return "sons/400milCortado.mp3";
        }
    },
    RODADA_15("Rodada 15") {
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

        @Override
        public String getSom() {
            return "sons/500milCortado.mp3";
        }
    },
    RODADA_16("Rodada 16") {
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

        @Override
        public String getSom() {
            return "sons/1milhaoCortado.mp3";
        }
    };


    public String getLabel() {
        return label;
    }

    public abstract Integer getAcertar();

    public abstract Integer getParar();

    public abstract String getSom();

    public abstract Integer getErrar();

    public abstract Rodada getProximaRodada();

    public abstract Dificuldade getDificuldade();

    private String label;

    Rodada(String label) {
        this.label = label;
    }
}
