package Usuarios;
import java.util.*;
import Biblioteca.*;
import Builders.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Archivos.Archivo;

public class Administrador extends Usuario {
    private LibroBuilder builder = new LibroBuilder();
    private Scanner sc = new Scanner(System.in);

    public Administrador(String usuario, String password, String nombre, String apellido,int edad){
        super(usuario, password, nombre, apellido, edad, new ArrayList<Libro>());
    }

    public void registrarLibro() {
        builder.setCodigo(ingresarCodigo());
        builder.setTitulo(IngresarTitulo());
        builder.setAutor(ingresarAutor());
        builder.setCodigo(ingresarAño());
        builder.setGenero(ingresarGenero());
        builder.setEditorial(ingresarEditorial());
        builder.setNumPaginas(ingresarPaginas());
        System.out.print("\nEstá disponible en físico?");
        System.out.print("\n1. Sí");
        System.out.print("\n2. No");
        int opcion = ingresarOpcion();
        switch (opcion) {
            case 1:
                System.out.print("\nIngresa el número de libros: ");
                builder.setFisico(true);
                builder.setNumFisicos(opcion);
                break;
            
            case 2:
                builder.setFisico(false);
                break;
        }
        Archivo.getInstance().GuardarLibro(builder.getResult());
    }

    private int ingresarCodigo(){
        System.out.print("Ingresa el codigo de 6 dígitos: ");
        try {
            Integer codigo = Integer.parseInt(sc.nextLine());
            return validarCodigo(codigo);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarCodigo();
        }
        return 0;
        
    }

    private int validarCodigo(Integer codigo){
        if(codigo.toString().length() != 6 ){
            try {
                throw new TamañoIncorrectoIntException("Se requiere un codigo de 6 digitos");
            } catch (TamañoIncorrectoIntException ex) {
                System.out.println(ex.getMessage());
                ingresarCodigo();
            }
        }
        return codigo;
    }

    private String IngresarTitulo(){
        System.out.print("\nIngresa el titulo: ");
        String titulo = sc.nextLine();
        Pattern pattern = Pattern.compile("^[^\s][a-zA-Z]{1,}");  
        Matcher matcher = pattern.matcher(titulo);
        if(!matcher.find()){ 
            try {
                throw new VerificarCadenaException("Ingresa un nombre correcto");
            } catch (VerificarCadenaException ex) {
                System.out.println(ex.getMessage());
                IngresarTitulo();
            }
        }
        return titulo;
    }

    private String ingresarAutor(){
        System.out.print("\nIngresa el autor: ");
        String autor = sc.nextLine();
        Pattern pattern = Pattern.compile("^[A-Za-z\s]+$");  
        Matcher matcher = pattern.matcher(autor);
        if(!matcher.find()){ 
            try {
                throw new VerificarCadenaException("Ingresa un nombre correcto");
            } catch (VerificarCadenaException ex) {
                System.out.println(ex.getMessage());
                ingresarAutor();
            }
        }
        return autor;
    }

    private int ingresarAño(){
        System.out.print("Ingresa el año de publicacion: ");
        try {
            Integer año = Integer.parseInt(sc.nextLine());
            return validarAño(año);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarCodigo();
        }
        return 0;
    }

    private int validarAño(Integer año){
        if(año > 2022 || año < 0 ){
            try {
                throw new VerificarRangoException("Se requiere un año entre 1 y 2022");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ingresarAño();
            }
        }
        return año;
    }
    private String ingresarGenero(){
        System.out.print("\nIngresa el autor: ");
        String autor = sc.nextLine();
        Pattern pattern = Pattern.compile("^[A-Za-z\s]+$");  
        Matcher matcher = pattern.matcher(autor);
        if(!matcher.find()){ 
            try {
                throw new VerificarCadenaException("Ingresa un genero correcto");
            } catch (VerificarCadenaException ex) {
                System.out.println(ex.getMessage());
                ingresarGenero();
            }
        }
        return autor;
    }

    private String ingresarEditorial(){
        System.out.print("\nIngresa la editorial: ");
        String autor = sc.nextLine();
        Pattern pattern = Pattern.compile("^[A-Za-z\s]+$");  
        Matcher matcher = pattern.matcher(autor);
        if(!matcher.find()){ 
            try {
                throw new VerificarCadenaException("Ingresa un nombre correcto");
            } catch (VerificarCadenaException ex) {
                System.out.println(ex.getMessage());
                ingresarEditorial();
            }
        }
        return autor;
    }

    private int ingresarPaginas(){
        System.out.print("Ingresa el número de páginas: ");
        try {
            Integer pag = Integer.parseInt(sc.nextLine());
            return validarPag(pag);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarPaginas();
        }
        return 0;
    }

    private int validarPag(Integer pag){
        if(pag > 3031 || pag < 0 ){
            try {
                throw new VerificarRangoException("Se requiere un numero de paginas entre 1 y 3031");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ingresarPaginas();
            }
        }
        return pag;
    }

    private int ingresarOpcion(){
        System.out.print("\nIngresa una opción: ");
        try {
            Integer opcion = Integer.parseInt(sc.nextLine());
            return validarOpcion(opcion);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarOpcion();
        }
        return 0;
    }

    private int validarOpcion(Integer opcion){
        if(opcion > 2 || opcion < 1 ){
            try {
                throw new VerificarRangoException("Ingresa una opción correcta");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ingresarAño();
            }
        }
        return opcion;
    }

}

class TamañoIncorrectoIntException extends Exception{
    public TamañoIncorrectoIntException(String message) {
        super(message);
    }
}

class VerificarCadenaException extends Exception{
    public VerificarCadenaException(String message) {
        super(message);
    }
    
} 

class VerificarRangoException extends Exception{
    public VerificarRangoException(String message){
        super(message);
    }


}
