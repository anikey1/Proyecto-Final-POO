package Builders;

import Biblioteca.Libro;

public class LibroBuilder implements Builder {
    private String titulo;
    private String autor;
    private int añoEd;
    private String genero;
    private String editorial;
    private int codigo;
    private int numPaginas;
    private boolean fisico;
    private int numFisicos;

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void setAñoEd(int añoEd) {
        this.añoEd = añoEd;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void setNumFisicos(int numFisicos) {
        this.numFisicos = numFisicos;
    }

    @Override
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Libro getResult() {
        return new Libro(titulo, autor, añoEd, genero, editorial, codigo, numPaginas, fisico, numFisicos);
    }

}
