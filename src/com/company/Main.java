package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Campeonato Campeonato = new Campeonato();

        int opcao;
        do{

            System.out.println("1 - CADASTRAR TIME");
            System.out.println("2 - SIMULAR JOGO");
            System.out.println("4 - Imprimir tabela");

            System.out.println("3 - SAIR");

            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    Campeonato.cadastrarTime();
                    break;
                case 2:
                    Campeonato.simularJogos();
                    break;
                case 4:
                    Campeonato.imprimirInformacoes();
                    break;

                case 3:
                    break;
            }


        }while (opcao != 3);

    }
}
