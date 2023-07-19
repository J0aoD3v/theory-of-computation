package com.example;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class AutomatoJsonReader {
    public static AutomatoFinito lerAutomato(String arquivo) {
        try (FileReader reader = new FileReader(arquivo)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, AutomatoFinito.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
