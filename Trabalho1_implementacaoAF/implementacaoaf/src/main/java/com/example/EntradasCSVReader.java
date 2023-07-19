package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntradasCSVReader {
    public static String[] lerEntradas(String arquivo) {
        List<String> entradas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                entradas.add(linha.split(";")[0]); // Assume que a primeira coluna contém a entrada de teste
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entradas.toArray(new String[0]);
    }
}
