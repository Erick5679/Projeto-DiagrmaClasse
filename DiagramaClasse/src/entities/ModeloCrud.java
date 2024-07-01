package entities;

public interface ModeloCrud<T> {
    void incluir(T t);
    void alterar(int id);
    void excluir(int id);
    void recuperar(int id);
    void validar(int id);
}

