package com.dbz.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    public static ArrayList<Personaje> listPerson = LeerJson.leerFicheroPersonajes("Personajes.json");
    public static ArrayList<Parameters> listRequests = LeerJson.leerPeticiones();
    public static ArrayList<Fusion> listFus = LeerJson.leerFicheroFusiones("Fusiones.json");

    @PostMapping("/personaje")
    public ArrayList<Personaje> create(@RequestBody Parameters param)
    {
        if (listRequests==null){
            listRequests= new ArrayList<>();
        }
        listRequests.add(param);

        //listRequest = Metodos.mandarParametros(param);
        if (param.getTipo().equals("fusion")){

            Fusion fus = DataHanding.getFusion(param);
            listFus.add(fus);

            //Ahora escribimos en el fichero JSON
            DataHanding.escribirFus(listFus);

        }else {
            if (listPerson ==null){
                listPerson = new ArrayList<Personaje>();
            }
            //Cogemos una persona de la API
            Personaje person = DataHanding.getPersonaje(param);
            //Los añadimos a la lista
            listPerson.add(person);

            //Ahora escribimos en el fichero JSON
            DataHanding.escribirPersonaje(listPerson);

        }
        DataHanding.escribirPeticion(listRequests);
        return listPerson;
    }

    //Vamos a borrar buscando el id
    /*@DeleteMapping("/Personaje")
    public ArrayList<Personaje> delete(@RequestParam String name)
    {
        DataHanding dataHanding = new DataHanding();
        ArrayList<Personaje> listaC;
        listaC = dataHanding.EliminarObjeto(name,"Personajes.json");
        //Despues de eliminar, sobreescribes la lista devuelta
        EscribirJson escribirJSON = new EscribirJson();
        escribirJSON.escribirFichero(listaC);
        return listaC;
    }*/




}
