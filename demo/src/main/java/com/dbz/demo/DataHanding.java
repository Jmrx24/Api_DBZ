package com.dbz.demo;

import java.util.ArrayList;



public class DataHanding {
    public ArrayList<Personaje> AnadirObjeto1(Personaje per1, String ruta)
    {
        //En esta funcion se añaden los nuevos elementos enviados desde el front a un ArrayList para posteriormente actualizar la BBDD
        LeerJson reader = new LeerJson();
        ArrayList<Personaje> listaAux = reader.LeerFichero(ruta);
        listaAux.add(per1);
        return listaAux;
    }

    public ArrayList<Personaje> EliminarObjeto (String name, String ruta)
    {
        //Primero leemos la lista que hay, y vamos recorriendola hasta encontrar el id que queremos borrar
        LeerJson reader = new LeerJson();
        ArrayList<Personaje> listaAux = reader.LeerFichero(ruta);
        for (int i = 0; i < listaAux.size() ; i++ )
        {
            if(listaAux.get(i).getName().equals(name))
            {
                listaAux.remove(i);
            }
        }
        //Devolvemos la lista con el elemento ya borrado
        return listaAux;
    }

}
