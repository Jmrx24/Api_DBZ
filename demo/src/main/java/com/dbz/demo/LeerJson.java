package com.dbz.demo;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.ParameterizedTypeReference;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeerJson {


    public static ArrayList<Personaje> leerFicheroPersonajes(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Personaje> listaJSON = new ArrayList<>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Personaje>>() {}.getType());


            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
    public static ArrayList<Fusion> leerFicheroFusiones(String ruta){
        //En esta clase se lee el fichero JSON de menores de 60
        ArrayList <Fusion> listaJSON = new ArrayList<>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<Fusion>>() {}.getType());


            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
    static ArrayList<Parameters> leerPeticiones() {
        Gson gson = new Gson();

        Type listType = new TypeToken<ArrayList<Parameters>>() {
        }.getType();

        try {
            return gson.fromJson(new FileReader("Peticiones.json", StandardCharsets.UTF_8), listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
