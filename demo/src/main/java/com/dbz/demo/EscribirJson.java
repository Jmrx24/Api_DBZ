package com.dbz.demo;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribirJson {

    public static void escribirFichero(ArrayList<Personaje> coches) {

        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            FileWriter writer = new FileWriter("Personajes.json");
            try {
                gson.toJson(coches, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
