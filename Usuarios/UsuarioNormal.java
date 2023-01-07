package Usuarios;
import java.util.*;
import Biblioteca.*;
import Archivos.Archivo;
public class UsuarioNormal extends Usuario {
    public UsuarioNormal(String usuario, String password, String nombre, String apellido, int edad, ArrayList<Libro> favoritos) {
        super(usuario, password, nombre, apellido, edad, favoritos);
    }
    public void menu(){
    System.out.println("\t\t...");
    boolean rep = true;
    while(rep == true){
        System.out.println("1.Buscar ejemplar");
        System.out.println("2.Ver lista de favoritos");
        System.out.println("3.Solicitar prestamo");
        /*Cambiar método Ingresar Opcion a excepciones */
        int opcion = 1;
        switch(opcion){
            case 1:

            break;
                    
            case 2:
                favoritos();
            break;
            case 3:
                
                break;
            case 4:
                rep=false;
                break;
        }
    }
    }
    public void favoritos(){
        ArrayList<Libro> libros = Archivo.getInstance().LeerArchivoLibro(); 
        for(int i = 0; i < libros.size() ; i ++){
            System.out.printf("Libro %d\n", i+1);
            libros.get(i).datosRelevantes();
        }
    }
}
