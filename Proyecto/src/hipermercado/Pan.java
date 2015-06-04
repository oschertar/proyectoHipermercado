package hipermercado;

import java.util.Date;

public class Pan extends Alimentacion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622208556002693997L;

	public Pan(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo, Date fechaCaducidad) throws ExistenciasInvalidasException, FechaCaducidadInvalidaException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo,
				fechaCaducidad);
		// TODO Auto-generated constructor stub
	}

}
