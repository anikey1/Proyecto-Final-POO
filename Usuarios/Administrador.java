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
        if(ingresarOpcion(2) == 1){
            builder.setFisico(true);
                builder.setNumFisicos(ingresarNumFisicos());
        }
        else{
            builder.setFisico(false);
        }
        
        System.out.print("\nSerá exclusivo?");
        System.out.print("\n1. Sí");
        System.out.print("\n2. No");
        if(ingresarOpcion(2) == 1){
            builder.setExclusivo(true);
        }else{
            builder.setExclusivo(false);
        }
        Archivo.getInstance().GuardarLibro(builder.getResult());
    }

    public void editarLibros(){
        ArrayList<Libro> libros = Archivo.getInstance().LeerArchivoLibro();
        for(int i = 0; i < libros.size() ; i ++){
            System.out.printf("Libro %d\n", i+1);
            libros.get(i).datosRelevantes();
        }
        boolean ciclo = true;
        int numLibro = ElegirLibro(libros.size()) - 1;
        while(ciclo == true){
            System.out.print("\n1. Editar Codigo");
            System.out.print("\n2. Editar Titulo");
            System.out.print("\n3. Editar Autor");
            System.out.print("\n4. Editar Año publicación");
            System.out.print("\n5. Editar Genero");
            System.out.print("\n6. Editar Editorial");
            System.out.print("\n7. Editar Numero de paginas");
            System.out.print("\n8. Editar Disponibilidad fisica");
            System.out.print("\n9. Editar Exclusividad");
            System.out.print("\n10. Terminar de editar");
            switch (ingresarOpcion(10)) {
                case 1:
                    libros.get(numLibro).setCodigo(ingresarCodigo());
                    break;
    
                case 2:
                    libros.get(numLibro).setTitulo(IngresarTitulo());
                    break;
                
                case 3:
                    libros.get(numLibro).setAutor(ingresarAutor());
                    break;
    
                case 4:
                    libros.get(numLibro).setAñoEd(ingresarAño());
                    break;
    
                case 5:
                    libros.get(numLibro).setGenero(ingresarGenero());
                    break;
                
                case 6:
                    libros.get(numLibro).setEditorial(ingresarEditorial());
                    break;
    
                case 7:
                    libros.get(numLibro).setNumPaginas(ingresarPaginas());
                    break;
    
                case 8:
                    System.out.print("\nEstá disponible en físico?");
                    System.out.print("\n1. Sí");
                    System.out.print("\n2. No");
                    if(ingresarOpcion(2) == 1){
                        libros.get(numLibro).setFisico(true);
                        libros.get(numLibro).setNumFisicos(ingresarNumFisicos());
                    }
                    else{
                        libros.get(numLibro).setFisico(false);
                        libros.get(numLibro).setNumFisicos(0);
                        
                    }
                    break;
    
                case 9:
                    System.out.print("\nSerá exclusivo?");
                    System.out.print("\n1. Sí");
                    System.out.print("\n2. No");
                    if(ingresarOpcion(2) == 1){
                        libros.get(numLibro).setExclusivo(true);
                    }else{
                        libros.get(numLibro).setExclusivo(false);
                    }
                    break;
    
                case 10:
                    ciclo = false;
                    Archivo.getInstance().ActualizarLibro(libros);
                    break;
                
                default:
                    break;
            }
        }
        
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
        System.out.print("\nIngresa el genero: ");
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

    private int ingresarOpcion(int numOpcion){
        System.out.print("\nIngresa una opción: ");
        try {
            Integer opcion = Integer.parseInt(sc.nextLine());
            return validarOpcion(opcion, numOpcion);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarOpcion(numOpcion);
        }
        return 0;
    }

    private int validarOpcion(Integer opcion, int numOpcion){
        if(opcion > numOpcion || opcion < 1 ){
            try {
                throw new VerificarRangoException("Ingresa una opción correcta");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ingresarAño();
            }
        }
        return opcion;
    }

    private int ingresarNumFisicos(){
        System.out.print("\nIngresa el número de libros: ");
        try {
            Integer num = Integer.parseInt(sc.nextLine());
            return validarNumFisicos(num);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ingresarNumFisicos();
        }
        return 0;
    }

    private int validarNumFisicos(int num){
        if(num < 1 ){
            try {
                throw new VerificarRangoException("Ingresa una opción correcta");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ingresarNumFisicos();
            }
        }
        return num;
    }
    

    private int ElegirLibro(int numLibros){
        System.out.print("\nIngresa el número de libros: ");
        try {
            Integer num = Integer.parseInt(sc.nextLine());
            return validarNumLibro(numLibros, num);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar números");
            ElegirLibro(numLibros);
        }
        return 0;
    }

    private int validarNumLibro(int numLibro, int num){
        if(num > numLibro || num < 1 ){
            try {
                throw new VerificarRangoException("Ingresa una opción correcta");
            } catch ( VerificarRangoException ex) {
                System.out.println(ex.getMessage());
                ElegirLibro(numLibro);
            }
        }
        return num;
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
