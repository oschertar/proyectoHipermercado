package hipermercado;

import java.io.Serializable;
import java.util.Date;

public class Carne extends Alimentacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3757282640811113867L;

	public Carne(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo, Date fechaCaducidad) throws ExistenciasInvalidasException, FechaCaducidadInvalidaException{
		super(nombre, codigoBarras, precio, zona, existencias, minimo,
				fechaCaducidad);
		// TODO Auto-generated constructor stub
	}

}
