package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @Jeferson Palomino
 */
public class ProductoImpl extends Conexion implements ICRUD<Producto> {

    @Override
    public void registrar(Producto pro) throws Exception {
        try {
            String sql = "INSERT INTO PRODUCTO\n"
                    + "(CODPRO,NOMPRO,DESPRO,PREPRO,IMAPRO,STOCPRO,CATPRO,ESTPRO)\n"
                    + "VALUES(?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setDouble(4, pro.getPrecio());
            ps.setString(5, pro.getImagen());
            ps.setInt(6, pro.getStock());
            ps.setString(7, pro.getCategoria());
            ps.setString(8, "A");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrar XD: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Producto pro) throws Exception {
        try {
            String sql = "UPDATE PRODUCTO SET NOMPRO =?,DESPRO=?,PREPRO=?,IMAPRO=?,STOCPRO=?,CATPRO=?,ESTPRO=? WHERE CODPRO = ?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setString(4, pro.getImagen());
            ps.setInt(5, pro.getStock());
            ps.setString(6, pro.getCategoria());
            ps.setString(7, pro.getEstado());
            ps.setString(8, pro.getCodigo());
            ps.executeQuery();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificar: " +e.getMessage());
        }
    }

    @Override
    public void eliminar(Producto pro) throws Exception {
        try {
            String sql = "UPDATE PRODUCTO SET ESTPRO ='I' WHERE CODPRO = ?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar: " +e.getMessage());
        }
    }

    @Override
    public List<Producto> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List listaProducto() throws Exception{
        List<Producto> listado = null;
        String sql= "SELECT * FROM PRODUCTO";
        Producto pro;
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            pro = new Producto();
            pro.setCodigo(rs.getString("CODPRO"));
            pro.setNombre(rs.getString("NOMPRO"));
            pro.setDescripcion(rs.getString("DESPRO"));
            pro.setPrecio(rs.getDouble("PREPRO"));
            pro.setImagen(rs.getString("IMAPRO"));
            pro.setStock(rs.getInt("STOCPRO"));
            pro.setCategoria(rs.getString("CATPRO"));
            pro.setEstado(rs.getString("ESTPRO"));
            listado.add(pro);                
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error en listar: " +e.getMessage());
        }
        return listado ;
    }

}
