package hipermercado;

import java.util.Date;

public class Pescado extends Alimentacion {

	public Pescado(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo, Date fechaCaducidad) throws ExistenciasInvalidasException, FechaCaducidadInvalidaException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo,
				fechaCaducidad);
		// TODO Auto-generated constructor stub
	}

	

}
