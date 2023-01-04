package Builders;

public interface Builder {
    public void setTitulo(String titulo);
    public void setAutor(String autor);
    public void setAñoEd(int añoEd);
    public void setCodigo(int codigo);
    public void setEditorial(String editorial);
    public void setFisico(boolean fisico);
    public void setGenero(String genero);
    public void setNumFisicos(int numFisicos);
    public void setNumPaginas(int numPaginas);
    public void setExclusivo(boolean exclusivo);
}