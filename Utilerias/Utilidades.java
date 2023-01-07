package Utilerias;
import Archivos.Archivo;
import Biblioteca.*;
import java.util.*;

public class Utilidades {
    /*Busqueda por titulo, autor y genero */ 
    public int search(int codigo){
        ArrayList<Libro> libros = Archivo.getInstance().LeerArchivoLibro();
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if(libro.getCodigo()==codigo) {
                return i;
            }
        }
            return -1;
        }
}
