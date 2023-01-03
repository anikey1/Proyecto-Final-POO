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
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            libros = (ArrayList<Libro>) this.archivoLibroIn.readObject();
            this.archivoLibroIn.close();
            return libros;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return libros;
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


    public ArrayList<Usuario> LeerArchivoUsuario(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = (ArrayList<Usuario>) this.archivoUsuarioIn.readObject();
            this.archivoLibroIn.close();
            return usuarios;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return usuarios;
    }

    public void GuardarUsuario(Usuario usuario){
        ArrayList<Usuario> usuarios = LeerArchivoUsuario();
        usuarios.add(usuario);
        try {
            this.archivoUsuarioOut.writeObject(usuarios);
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
