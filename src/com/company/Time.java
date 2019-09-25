package com.company;

public class Time {

    private String nome;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;
    private String sigla;
    private Integer pontos;
    private Integer golsMarcados;
    private Integer golsSofridos;

    Time (String nome, String sigla ){
        this.nome = nome;
        this.sigla = sigla;
        this.vitorias = 0 ;
        this.derrotas = 0;
        this.empates = 0;
        this.pontos = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }

    public String getNome() {
        return nome;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public String getSigla() {
        return sigla;
    }

    public Integer getPontos() {
        return pontos;
    }

    public Integer getGolsMarcados() {
        return golsMarcados;
    }

    public Integer getGolsSofridos() {
        return golsSofridos;
    }

    public boolean atualizaDadosTime (int golsMarcados, int golsSofridos){
        if(golsMarcados>golsSofridos){
            this.vitorias++;
            this.golsSofridos = golsSofridos;
            this.golsMarcados = golsMarcados;
            this.pontos = this.pontos + 3;
        }
        else if(golsSofridos>golsMarcados){
            this.derrotas++;
            this.golsSofridos = golsSofridos;
            this.golsMarcados = golsMarcados;
        }
        else {
            this.empates ++;
            this.golsSofridos = golsSofridos;
            this.golsMarcados = golsMarcados;
            this.pontos = this.pontos + 1;
        }
        return true;

    }
}
