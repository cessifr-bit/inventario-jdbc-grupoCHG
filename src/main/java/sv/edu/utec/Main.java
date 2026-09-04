package sv.edu.utec;

import sv.edu.utec.datos.ConexionDB;
import sv.edu.utec.datos.ProveedorDAO;
import sv.edu.utec.modelo.Proveedor;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public class Main{
    public static void main(String[] args){

        //1. Probando la conexion
        probarConexion();
        ProveedorDAO dao = new ProveedorDAO();

        //2. Crear la tabla
        dao.crearTabla();

        //3. Insertar datos
        Proveedor p1 = new Proveedor(1, "Tecnología Blobal S.A", "2233-4455");
        Proveedor p2 = new Proveedor(2, "Suministros Rapido", "2211-0099");

        dao.insertar(p1);
        dao.insertar(p2);

        //4. Leer/Listar datos
        System.out.println("\n**** Lista de Proveedores ****");
        List<Proveedor> lista = dao.listar();
        for(Proveedor p : lista){
            System.out.println(p.toString());
        }

        //5. Actualizar un registro
        System.out.println("\n**** Actualizando Proveedor 1 ****");
        Proveedor pAct = new Proveedor(1, "Tecnología Global S.A de C.V.", "2234-9765");
        dao.actualizar(pAct);

        //6. Eliminar un registro
        System.out.println("\n**** Eliminando Proveedor 2 ****");
        dao.eliminar(2);

        //Listar de nuevo para ver los resultado finales
        List<Proveedor> listaFinal = dao.listar();
        for(Proveedor p : listaFinal){
            System.out.println(p.toString());
        }

    }

    private static void probarConexion(){
        try(Connection cn = ConexionDB.obtenerConexion()){
            if(cn != null && !cn.isClosed()){
                System.out.println("Conexion exitosa a " + cn.getMetaData().getURL());
            }
        }catch(SQLException e){
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
}