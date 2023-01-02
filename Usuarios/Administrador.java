package Usuarios;
import java.util.*;
import Biblioteca.*;
import Builders.*;
public class Administrador extends Usuario {
    private LibroBuilder builder = new LibroBuilder();


    public Administrador(String nombre, String apellido,int edad){
        super(nombre, apellido, edad, new ArrayList<Libro>());
    }

    public void registrarLibro() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el codigo: ");
        builder.setCodigo(sc.nextInt());
        System.out.print("\nIngresa el titulo: ");
        builder.setTitulo(sc.nextLine());
        System.out.print("\nIngresa el autor: ");
        builder.setAutor(sc.nextLine());
        System.out.print("\nIngresa el año de publicación: ");
        builder.setCodigo(sc.nextInt());
        System.out.print("\nIngresa el genero");
        builder.setGenero(sc.nextLine());
        System.out.print("\nIngresa la editorial");
        builder.setEditorial(sc.nextLine());
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

}
