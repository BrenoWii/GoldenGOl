package com.company;

import java.util.Random;

public class Jogo {
    private Time mandante;
    private Time visitante;
    private Integer golsTimeA;
    private Integer golsTimeB;

    Jogo(Time timeA,Time timeB){
        mandante = timeA;
        visitante = timeB;
    }

    public void enfrentar() {
        this.decidirPartida();
        if (golsTimeA>golsTimeB) {
            System.out.println( golsTimeA +' '+this.mandante.getNome() + " Foi vencedor em cima do time  " + golsTimeB + ' ' +this.visitante.getNome());
        }else if (golsTimeB>golsTimeA){
            System.out.println( this.visitante.getNome() + " Foi vencedor em cima do time " + this.mandante.getNome());
        }else {
            System.out.println( this.visitante.getNome() + " deu empate com  " + this.mandante.getNome());
        }

    }

    private void decidirPartida() {
        Random r = new Random();
        this.golsTimeA = r.nextInt((10 - 0) + 1 ) + 0;
        this.golsTimeB = r.nextInt((10 - 0) + 1 ) + 0;

        this.mandante.atualizaDadosTime(golsTimeA, golsTimeB);
        this.visitante.atualizaDadosTime(golsTimeB,golsTimeA);

    }

}
