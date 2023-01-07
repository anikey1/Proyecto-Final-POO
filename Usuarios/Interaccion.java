package Usuarios;
import Biblioteca.Libro;
public interface Interaccion {
    public void verLibros();
    public void busqueda(String dato);
    public void Prestamo(Libro Libro);
    public void añadirFavoritos(Libro libro);
}
