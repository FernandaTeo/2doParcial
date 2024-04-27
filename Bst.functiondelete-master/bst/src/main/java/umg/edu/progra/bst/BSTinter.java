package umg.edu.progra.bst;

public interface BSTinter {
    void insertar(Empleado emp);

    boolean existe(int id);

    Empleado obtener(int id);

    boolean esHoja();

    boolean esVacio();

    void preOrden();

    void postOrden();

    void inOrden();

    void eliminar(int id);
}
