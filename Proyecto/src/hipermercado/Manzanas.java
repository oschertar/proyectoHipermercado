package hipermercado;

import java.util.Date;

public class Manzanas extends Fruteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2106946281316670351L;

	public Manzanas(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo, Origen pais,
			Date fechaCaducidad) throws ExistenciasInvalidasException, FechaCaducidadInvalidaException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo, pais,
				fechaCaducidad);
		// TODO Auto-generated constructor stub
	}

}
