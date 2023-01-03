package Archivos;
import java.io.*;
import Biblioteca.*;
import java.util.*;
import Usuarios.*;

public class Archivo {
    private static Archivo archivo;
    private ObjectOutputStream archivoLibroOut;
    private ObjectOutputStream archivoUsuarioOut;
    private ObjectInputStream archivoLibroIn;
    private ObjectInputStream archivoUsuarioIn;

    private Archivo(){
        File archivoLibro = new File("Libros");
        File archivoUsuario = new File("Usuarios");
        if(archivoLibro.exists()){
            try {
                archivoLibro.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            } 
        }
        if(archivoUsuario.exists()){
            try {
                archivoUsuario.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        try {
            this.archivoLibroOut = new ObjectOutputStream(new FileOutputStream(archivoLibro));
            this.archivoLibroIn = new ObjectInputStream(new FileInputStream(archivoLibro));
            this.archivoUsuarioOut = new ObjectOutputStream(new FileOutputStream(archivoUsuario));
            this.archivoUsuarioIn = new ObjectInputStream(new FileInputStream(archivoUsuario));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }

    public ArrayList<Libro> LeerArchivoLibro(){
        ArrayList<Libro> Libro = new ArrayList<>();
        try {
            Libro = (ArrayList<Libro>) this.archivoLibroIn.readObject();
            this.archivoLibroIn.close();
            return Libro;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return Libro;
    }

    public void GuardarLibro(Libro libro){
        ArrayList<Libro> libros = LeerArchivoLibro();
        libros.add(libro);
        try {
            this.archivoLibroOut.writeObject(libros);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static Archivo getInstance() {
        if (archivo == null) {
            archivo = new Archivo();
        }
        return archivo;
    }
}
