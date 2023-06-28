package com.dbz.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    @GetMapping("/Car")
    public ArrayList<Personaje> listaCoches()
    {
        LeerJson reader = new LeerJson();
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Personaje> listaC = reader.LeerFichero("Personajes.json");
        //Mostramos los elementos leidos
        return listaC;
    }

    @PostMapping("/addCoche")
    public ArrayList<Personaje> create(@RequestBody Personaje per1)
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
