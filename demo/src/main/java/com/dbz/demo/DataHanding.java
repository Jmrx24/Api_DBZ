package com.dbz.demo;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;



public class DataHanding {

    public static String url = "https://dragonballapi-backend.vercel.app/%s/information/%s";
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

    public static void escribirFus(ArrayList<Fusion> listFusion) {

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
    public static void escribirPeticion(ArrayList<Parameters> listRequests) {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Peticiones.json")) {
            gson.toJson(listRequests, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
