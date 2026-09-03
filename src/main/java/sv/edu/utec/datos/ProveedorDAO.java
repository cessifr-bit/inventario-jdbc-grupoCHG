package sv.edu.utec.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sv.edu.utec.modelo.Proveedor;

public class ProveedorDAO {
    public ProveedorDAO() {
    }

    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS proveedor (id INT PRIMARY KEY, nombre_empresa VARCHAR(100), telefono VARCHAR(20))";

        try (
                Connection cn = ConexionDB.obtenerConexion();
                Statement st = cn.createStatement();
        ) {
            st.execute(sql);
            System.out.println("Tabla 'proveedor' creada con exito.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }

    }

    public void insertar(Proveedor prov) {
        String sql = "INSERT INTO proveedor (id, nombre_empresa, telefono) VALUES (?, ?, ?)";

        try (
                Connection cn = ConexionDB.obtenerConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
        ) {
            ps.setInt(1, prov.getId());
            ps.setString(2, prov.getNombreEmpresa());
            ps.setString(3, prov.getTelefono());
            ps.executeUpdate();
            System.out.println("Proveedor insertado: " + prov.getNombreEmpresa());
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

    }

    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList();
        String sql = "SELECT id , nombre_empresa, telefono FROM proveedor";

        try (
                Connection cn = ConexionDB.obtenerConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()) {
                Proveedor p = new Proveedor(rs.getInt("id"), rs.getString("nombre_empresa"), rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }

    public void actualizar(Proveedor prov) {
        String sql = "UPDATE proveedor SET nombre_empresa = ?, telefono = ? WHERE id = ?";

        try (
                Connection cn = ConexionDB.obtenerConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
        ) {
            ps.setString(1, prov.getNombreEmpresa());
            ps.setString(2, prov.getTelefono());
            ps.setInt(3, prov.getId());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Proveedor actualizado con exito");
            } else {
                System.out.println("No se encontro un proveedor con el ID " + prov.getId());
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

    }

    public void eliminar(int id) {
        String sql = "DELETE FROM proveedor WHERE id = ?";

        try (
                Connection cn = ConexionDB.obtenerConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Proveedor eliminado correctamente.");
            } else {
                System.out.println("No se encontro proveedor para eliminar con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

    }
}
