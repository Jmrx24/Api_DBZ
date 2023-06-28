package com.dbz.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    public static ArrayList<Personaje> listPeople = DataHanding.LeerFicheroPeople("Personajes.json");
    public static ArrayList<Parameters> listRequests = DataHanding.leerPeticiones();
    public static ArrayList<Fusion> listStarship = DataHanding.LeerFicheroStarships("Fusiones.json");

    @GetMapping("/Personaje")
    public ArrayList<Personaje> listaCoches()
    {
        LeerJson reader = new LeerJson();
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Personaje> listaC = reader.LeerFichero("Personajes.json");
        //Mostramos los elementos leidos
        return listaC;
    }

    @PostMapping("/personaje")
    public ArrayList<Personaje> create(@RequestBody Parameters param)
    {
        DataHanding dataHanding = new DataHanding();
        ArrayList<Personaje> listaC;
        listaC = dataHanding.AnadirObjeto1(per1,"Personajes.json");
        EscribirJson escribirJSON = new EscribirJson();
        escribirJSON.escribirFichero(listaC);
        return listaC;
    }

    //Vamos a borrar buscando el id
    @DeleteMapping("/Personaje")
    public ArrayList<Personaje> delete(@RequestParam String name)
    {
        DataHanding dataHanding = new DataHanding();
        ArrayList<Personaje> listaC;
        listaC = dataHanding.EliminarObjeto(name,"Personajes.json");
        //Despues de eliminar, sobreescribes la lista devuelta
        EscribirJson escribirJSON = new EscribirJson();
        escribirJSON.escribirFichero(listaC);
        return listaC;
    }




}
