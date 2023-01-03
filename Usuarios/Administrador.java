package Usuarios;
import java.util.*;
import Biblioteca.*;
import Builders.*;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Administrador extends Usuario {
    private LibroBuilder builder = new LibroBuilder();
    private Scanner sc = new Scanner(System.in);

    public Administrador(String nombre, String apellido,int edad){
        super(nombre, apellido, edad, new ArrayList<Libro>());
    }

    public void registrarLibro() {
        builder.setCodigo(ingresarCodigo());
        builder.setTitulo(IngresarTitulo());
        builder.setAutor(ingresarString("autor"));
        builder.setCodigo(ingresarAño());
        builder.setGenero(ingresarString("genero"));
        builder.setEditorial(ingresarString("editorial"));
        System.out.print("\nIngresa el número de páginas");
        builder.setNumPaginas(sc.nextInt());
        System.out.print("\nEstá disponible en físico?");
        System.out.print("\n1. Sí");
        System.out.print("\n2. No");
        System.out.print("\nIngresa una opción: ");
        switch (sc.nextInt()) {
            case 1:
                System.out.print("\nIngresa el número de libros: ");
                builder.setFisico(true);
                builder.setNumFisicos(sc.nextInt());
                break;
            
            case 2:
                builder.setFisico(false);
                break;
        
            default:
                System.out.print("Ingrese una opción correcta");
                break;
        }

        Libro libro = this.builder.getResult();

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

    private String ingresarString(String dato){
        System.out.printf("\nIngresa el %s: ", dato);
        String autor = sc.nextLine();
        Pattern pattern = Pattern.compile("^[A-Za-z\s]+$");  
        Matcher matcher = pattern.matcher(autor);
        if(!matcher.find()){ 
            try {
                throw new VerificarCadenaException("Ingresa un nombre correcto");
            } catch (VerificarCadenaException ex) {
                System.out.println(ex.getMessage());
                ingresarString(dato);
            }
        }
        return autor;
    }

    private int ingresarAño(){
        System.out.print("Ingresa el año de publicacion: ");
        try {
            Integer año = Integer.parseInt(sc.nextLine());
            return validarTamañoAño(año);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarCodigo();
        }
        return 0;
    }

    private int validarTamañoAño(Integer año){
        if(año.toString().length() > 4  && año.toString().length() < 1){
            try {
                throw new TamañoIncorrectoIntException("Tamaño incorrecto");
            } catch (TamañoIncorrectoIntException ex) {
                System.out.println(ex.getMessage());
                ingresarAño();
            }
        }
        return validarAño(año);
    }

    private int validarAño(Integer año){
        if(año <= 2022 && año > 0 ){
            try {
                throw new VerificarRangoException("Se requiere un año entre 1 y 2022");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ingresarAño();
            }
        }
        return año;
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
