package com.alura.conversormoneda.aplicacion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ConversorAPI {
    private static final String API_KEY = "c854938682c62d2db4cfbd73";

    public static double obtenerTasaDeCambio(String base, String objetivo) throws IOException {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + base;

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Verifica el código de respuesta HTTP
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error en la conexión: Código " + responseCode);
        }

        // Leer la respuesta JSON
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        // Parsear la respuesta JSON
        JsonObject data = JsonParser.parseString(inline.toString()).getAsJsonObject();
        JsonObject rates = data.getAsJsonObject("conversion_rates");

        return rates.get(objetivo).getAsDouble();
    }
}
