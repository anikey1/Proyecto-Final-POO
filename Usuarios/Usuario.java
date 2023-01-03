package Usuarios;

import java.util.*;
import Biblioteca.*;
public abstract class Usuario {
    private String usuario;
    private String password;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected ArrayList<Libro> favoritos;

    public Usuario(String usuario, String password, String nombre, String apellido, int edad, ArrayList<Libro> favoritos){
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.favoritos = favoritos;
    }

}
