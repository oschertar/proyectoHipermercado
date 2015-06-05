package hipermercado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Hipermercado implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean modificado = false;
	public Producto producto;

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

	public boolean annadir(Producto producto, String barras)
			throws ProductoYaExistenteException {
		if (getProducto(barras))
			throw new ProductoYaExistenteException("El producto ya existe");

		setModificado(true);
		return hipermercado.add(producto);
	}

	@Override
	public String toString() {
		return "Hipermercado [" + hipermercado + "]";
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

	public Producto get(String barras) throws CodigoBarrasNoValidoException,
			ProductoNoExistenteException {
		Iterator<Producto> elemento = hipermercado.iterator();
		while (elemento.hasNext()) {
			producto = elemento.next();
			if (producto.getCodigoBarras().equals(barras)) {
				return producto;
			}
		} 
			throw new ProductoNoExistenteException("El producto no existe");

		
	}

	public Producto get(int index) {
		if (hipermercado.isEmpty() | index < 0
				| index > hipermercado.size() - 1)
			return null;
		return hipermercado.get(index);

	}

	private boolean getProducto(String barras) {

		for (Producto productoAux : hipermercado) {
			if (productoAux.getCodigoBarras().equals(barras)) {
				producto = productoAux;
			}
		}
		if (hipermercado.contains(producto))
			return true;
		return false;
	}

}
