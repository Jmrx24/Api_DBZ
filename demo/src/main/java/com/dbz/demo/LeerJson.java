package com.dbz.demo;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeerJson {

    public static String url = "https://dragonballapi-backend.vercel.app/%s/information/%s";
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

    public static Personaje getPersonaje(Parameters param) {
        Personaje person = null;
        String U = String.format(url,param.getTipo(),param.getName());

        try {
            //Aqui primero hacemos la peticion con la url
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(U)).GET().build();
            //Despues creamos la respuesta
            HttpResponse<String> respuesta = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            //Cogemos el resultado que es el objeto json
            String resultado = respuesta.body();

            //Lo convertimos con gson
            Gson gson = new Gson();
            person = gson.fromJson(resultado, Personaje.class);//Cuando es una lista utilizo el Typetoken

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Devolvemos la persona
        return person;
    }

    public static Fusion getFusion(Parameters param) {

        Fusion fu = null;
        String U = String.format(url,param.getTipo(),param.getName());

        try {
            //Aqui primero hacemos la peticion con la url
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(U)).GET().build();
            //Despues creamos la respuesta
            HttpResponse<String> respuesta = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            //Cogemos el resultado que es el objeto json
            String resultado = respuesta.body();

            //Lo convertimos con gson
            Gson gson = new Gson();
            fu = gson.fromJson(resultado, Fusion.class);//Cuando es una lista utilizo el Typetoken

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Devolvemos la star
        return fu;
    }
    public static void escribirPersonaje(ArrayList<Personaje> listPerson) {
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            FileWriter writer = new FileWriter("Personajes.json");
            try {
                gson.toJson(listPerson, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void escribirStarship(ArrayList<Fusion> listFusion) {

        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            FileWriter writer = new FileWriter("Fusiones.json");
            try {
                gson.toJson(listFusion, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
