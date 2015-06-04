package hipermercado;

import java.util.Date;

public class Melocotones extends Fruteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6134603890541036633L;

	public Melocotones(ListaProductos nombre, String codigoBarras,
			float precio, Zona zona, int existencias, int minimo, Origen pais,
			Date fechaCaducidad) throws ExistenciasInvalidasException, FechaCaducidadInvalidaException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo, pais,
				fechaCaducidad);
		// TODO Auto-generated constructor stub
	}

}
