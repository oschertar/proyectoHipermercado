package hipermercado;



public class TV extends Tecnologia {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8921606168090315537L;

	public TV(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int articulos, int minimo, Fabricante fabricante) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, articulos, minimo, fabricante);
		
	}

}
