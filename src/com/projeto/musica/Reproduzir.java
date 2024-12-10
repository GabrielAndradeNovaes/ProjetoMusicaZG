package com.projeto.musica;

import java.util.Scanner;

public class Reproduzir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a opção:");
        System.out.println("1. Reproduzir a música inteira");
        System.out.println("2. Reproduzir apenas a Parte 1");
        System.out.println("3. Reproduzir apenas a Parte 2");

        int escolha = scanner.nextInt();
        scanner.nextLine();
        String caminho = "C:\\Users\\gandr\\Downloads\\Padre-Marcelo-Rossi-Erguei-as-Mãos-_Ao-Vivo_.wav";

        switch (escolha) {
            case 1:
                executarParteCompleta(caminho);
                break;
            case 2:
                executarParte1(caminho);
                break;
            case 3:
                executarParte2(caminho);
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }

    private static void executarParteCompleta(String caminho) {
        Thread audioThread = new Thread(() -> ReproduzirAudio.tocarAudio(caminho));
        Thread letraThread = new Thread(() -> {
            reproduzirParte1(true, true);
            transicao();
            reproduzirParte2();
        });

        audioThread.start();
        letraThread.start();

        try {
            audioThread.join();
            letraThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void executarParte1(String caminho) {
        Thread audioThread = new Thread(() -> ReproduzirAudio.tocarAudioMetade1(caminho));
        Thread letraThread = new Thread(() -> reproduzirParte1(true, false));

        audioThread.start();
        letraThread.start();

        try {
            audioThread.join();
            letraThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void executarParte2(String caminho) {
        Thread audioThread = new Thread(() -> ReproduzirAudio.tocarAudioMetade2(caminho));
        Thread letraThread = new Thread(Reproduzir::reproduzirParte2);

        audioThread.start();
        letraThread.start();

        try {
            audioThread.join();
            letraThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void reproduzirParte1(boolean sincronizado, boolean pausaInicial) {
        String verso1 = "Erguei as mãos e dai glória a Deus";
        String refrão1 = "Erguei as mãos\nE cantai como os filhos do Senhor";
        String fraseRefrão = "como os filhos do Senhor";
        String[][] animais = {
            {"O elefante", "E os passarinhos, " + fraseRefrão},
            {"A minhoquinha", "E os pinguins, " + fraseRefrão},
            {"O canguru", "E o sapinho, " + fraseRefrão}
        };
        String noe = "Deus disse a Noé: Constrói uma arca\n";
        String construção = "Deus disse a Noé: Constrói uma arca\nQue seja feita\nDe madeira para os filhos do Senhor";

        
        
        try {
        	
        	if (pausaInicial) {
                Thread.sleep(22000); // 22 segundos de pausa
            }
        	
            for (int i = 0; i < 2; i++) {
                System.out.println(verso1);
                if (sincronizado) Thread.sleep(4000);
            }
            System.out.println(refrão1 + "\n");
            if (sincronizado) Thread.sleep(8200);

            for (String[] par : animais) {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Os animaizinhos subiram de dois em dois");
                    if (sincronizado) Thread.sleep(3600);
                }
                System.out.println(par[0]);
                if (sincronizado) Thread.sleep(2000);
                System.out.println(par[1] + "\n");
                if (sincronizado) Thread.sleep(4600);
            }

            System.out.println(noe + "\n");
            if (sincronizado) Thread.sleep(3500);
            
            System.out.println(construção + "\n");
            if (sincronizado) Thread.sleep(12200);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.println(verso1);
                    if (sincronizado) Thread.sleep(4000);
                }
                System.out.println(refrão1 + "\n");
                if (sincronizado) Thread.sleep(8200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void transicao() {
        System.out.println("E atenção agora, porque\n");
    }

    private static void reproduzirParte2() {
        String estrofeBase = "O senhor tem muitos filhos\nMuitos filhos ele tem\nEu sou um deles, você também\nLouvemos ao senhor";

        String[] movimentos = {
            "Braço direito",
            "Braço esquerdo",
            "Perna direita",
            "Perna esquerda",
            "Balança a cabeça",
            "Dá uma voltinha",
            "Dá um pulinho",
            "Abraça o irmão"
        };

        try {
            StringBuilder movimentoAtual = new StringBuilder();
            for (int i = 0; i < movimentos.length; i++) {
                System.out.println(estrofeBase);
                Thread.sleep(12840);

                if (i > 0) movimentoAtual.append(", ");
                movimentoAtual.append(movimentos[i]);

                System.out.println(movimentoAtual.toString() + "\n");
                
                
                int numeroPalavras = movimentoAtual.toString().split(" ").length;
                int tempoPausa = 1000 + (numeroPalavras * 300); // Base de 1000ms + 300ms por palavra
                Thread.sleep(tempoPausa);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
