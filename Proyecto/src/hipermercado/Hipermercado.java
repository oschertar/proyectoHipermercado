package hipermercado;

import java.io.Serializable;
import java.util.ArrayList;





public class Hipermercado implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean modificado = false;
	
	public ArrayList<Producto> hipermercado = new ArrayList<Producto>();
	
	
	public boolean isModificado() {
		return modificado;
	}
	
	
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}
	
	
	public int size() {
		return hipermercado.size();
	}
	
	public boolean annadir(Producto producto) throws ProductoYaExistenteException{
		if (hipermercado.contains(producto))
			throw new ProductoYaExistenteException("El producto ya existe");
		setModificado(true);
		return hipermercado.add(producto);
	}
			 
		
	boolean eliminar(Producto producto) {
		return hipermercado.remove(producto);
	}
	
	
	boolean setCantidadMinima(Producto producto, int cantidad) {
		if (!hipermercado.contains(producto))
			return false;
		producto = hipermercado.get(hipermercado.indexOf(producto));
		producto.setMinimo(cantidad);
		return true;
	}

	
	boolean incrementarExistencias(Producto producto, int incremento)
			throws IncrementoNegativoException {
		if (!hipermercado.contains(producto))
			return false;
		producto = hipermercado.get(hipermercado.indexOf(producto));
		producto.incrementar(incremento);
		return true;
	}

	
	boolean decrementarExistencias(Producto producto, int decremento)
			throws ExistenciasInvalidasException, DecrementoInvalidoException {
		if (!hipermercado.contains(producto))
			return false;
		producto = hipermercado.get(hipermercado.indexOf(producto));
		producto.decrementar(decremento);
		return true;
	}

}
