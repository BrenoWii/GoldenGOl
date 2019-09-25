package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Campeonato {
    private String nome;
    private List<Time> times = new ArrayList<>();
    private List<Jogo> jogos = new ArrayList<>();

    public boolean cadastrarTime() {
        if (this.times.size() >= 10) {
            System.out.println("não é possivel cadastrar mais de 10 times");
            return false;
        }
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome");
        String nome = ler.nextLine();
        System.out.println("Digite a Sigla");
        String sigla = ler.nextLine();

        Time time = new Time(nome, sigla);
        this.times.add(time);

        System.out.println(this.times);
        return true;

    }

    public boolean simularJogos() {
        Scanner ler = new Scanner(System.in);

        System.out.println("Selectione o primeiro time");

        for (int i = 0; i < this.times.size(); i++) {
            Time time = this.times.get(i);
            System.out.println(i + " - " + time.getNome());
        }

        int indiceTime1 = ler.nextInt();
        System.out.println("Selectione o segundo time");

        for (int i = 0; i < this.times.size(); i++) {
            Time time = this.times.get(i);
            System.out.println(i + " - " + time.getNome());
        }
        int indiceTime2 = ler.nextInt();

        Jogo partida = new Jogo(this.times.get(indiceTime1), this.times.get(indiceTime2));

        partida.enfrentar();
        this.jogos.add(partida);
        return true;

    }

    public void imprimirInformacoes() {
        JTable tabelaCampeonato = new JTable();

        String[] nomesColunas = {"nome", "vitorias", "empate", "derrota", "pontos", "Gols Sofridos" , "Gols Marcados", "Saldo de Gols"};

        DefaultTableModel model = new DefaultTableModel();
        for (String col : nomesColunas) {
            model.addColumn(col);
        }

        for (Time time : this.times) {
            model.addRow(
                    new String[]{
                            time.getNome(),
                            Integer.toString(time.getVitorias()),
                            Integer.toString(time.getEmpates()),
                            Integer.toString(time.getDerrotas()),
                            Integer.toString(time.getPontos()),
                            Integer.toString(time.getGolsSofridos()),
                            Integer.toString(time.getGolsMarcados()),
                            Integer.toString((time.getGolsMarcados() - time.getGolsSofridos()))
                            });
        }

        tabelaCampeonato.setModel(model);
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(new JScrollPane(tabelaCampeonato),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
}
