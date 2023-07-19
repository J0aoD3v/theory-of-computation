package com.example;

import java.util.HashMap;
import java.util.Map;

class AutomatoFinito {
    private int estadoInicial;
    private int[] estadosFinais;
    private Map<String, Integer> transicoes;

    public AutomatoFinito(int estadoInicial, int[] estadosFinais, HashMap<String, Integer> transicoes) {
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.transicoes = transicoes;
    }

    public boolean simular(String entrada) {
        int estadoAtual = estadoInicial;

        for (char simbolo : entrada.toCharArray()) {
            String chaveTransicao = estadoAtual + "," + simbolo;
            estadoAtual = transicoes.getOrDefault(chaveTransicao, -1);
            if (estadoAtual == -1) {
                return false; // A transição não existe para o símbolo atual
            }
        }

        // Verifica se o estado atual é um estado final
        for (int estadoFinal : estadosFinais) {
            if (estadoAtual == estadoFinal) {
                return true; // A entrada foi aceita pelo autômato
            }
        }

        return false; // A entrada foi rejeitada pelo autômato
    }
}
