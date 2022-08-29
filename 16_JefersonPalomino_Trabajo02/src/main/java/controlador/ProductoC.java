
package controlador;

import dao.ProductoImpl;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Producto;

@Named(value="ProductoC")
@SessionScoped
public class ProductoC implements Serializable{
    //modelos
    private Producto pro;
    private ProductoImpl dao;
    //listado
    private List<Producto> listaProducto;
    
    public ProductoC(){
        pro = new Producto();
        dao = new ProductoImpl();
        
    }
    
    public void registrar(){
        try {
            dao.registrar(pro);
        } catch (Exception e) {
            System.out.println("Error en registrar");
        }
    }
    
    public void eliminar(String codigo){
        try {
            pro.setCodigo(codigo);
            dao.eliminar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"OK","Se elimino el producto"));
        } catch (Exception e) {
            System.out.println("Error en eliminarC: "+e.getMessage());
        }
    }
    
    public void listar(){
        try {
            listaProducto = dao.listaProducto();
        } catch (Exception e) {
            System.out.println("Error en listarC: " +e.getMessage());
        }
    }
    
    public void save(){
        addMessage("Se guardo correctamente");
    }
    
    public void update(){
        addMessage("Se actualizo correctamente");
    }
    
    public void delete(){
        addMessage("Se elimino correctamente");
    }
    
    public void botonPrueba(){
        addMessage("Bienvenido a Primefaces");
//        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Hola","Bienvenido a Primefaces"));
    } 
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public ProductoImpl getDao() {
        return dao;
    }

    public void setDao(ProductoImpl dao) {
        this.dao = dao;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    
}
