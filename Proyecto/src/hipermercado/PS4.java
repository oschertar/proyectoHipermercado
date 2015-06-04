package hipermercado;

public class PS4 extends Videojuegos {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4430713106992116869L;

	public PS4(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int existencias, int minimo) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, existencias, minimo);
		// TODO Auto-generated constructor stub
	}

}
