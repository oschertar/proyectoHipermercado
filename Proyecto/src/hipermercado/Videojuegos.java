package hipermercado;

import java.io.Serializable;

public class Videojuegos extends Producto implements IVA, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2312987832656262021L;

	public Videojuegos(ListaProductos nombre, String codigoBarras,
			float precio, Zona zona, int existencias, int minimo) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float calcularIVA(float precio) {
		precio = (float) (precio * IVA._1_21); // 21% IVA aplicado en Videojuegos
		return precio;

	}

}
