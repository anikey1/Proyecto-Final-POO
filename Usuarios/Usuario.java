package Usuarios;

import java.util.*;
import Biblioteca.*;
public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected ArrayList<Libro> favoritos;

    public Usuario(String nombre, String apellido, int edad, ArrayList<Libro> favoritos){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.favoritos = favoritos;
    }

}
