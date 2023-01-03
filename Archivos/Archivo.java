package Archivos;
import java.io.*;;
public class Archivo {
    private static Archivo archivo;
    private File archivoLibro = new File("Libros");
    private File archivoUsuario = new File("Usuarios");

    private Archivo(){
        if(!archivo.archivoLibro.exists()){
            try {
                archivo.archivoLibro.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
        }
        if(!archivo.archivoUsuario.exists()){
            try {
                archivo.archivoUsuario.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public static Archivo getInstance() {
        if (archivo == null) {
            archivo = new Archivo();
        }
        return archivo;
    }

    public File getArchivoLibro() {
        return archivoLibro;
    }

    public File getArchivoUsuario() {
        return archivoUsuario;
    }
}
