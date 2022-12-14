
package dao;

import java.util.List; 

/**
 *
 * @param <Generic>
 * @Jeferson Palomino
 */
public interface ICRUD<Generic> {
    
    public void registrar(Generic generic) throws Exception;
    
    public void modificar(Generic generic) throws Exception;
    
    public void eliminar(Generic generic) throws Exception;
    
    public List<Generic> listar() throws Exception;
}
