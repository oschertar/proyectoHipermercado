package hipermercado;

public class Sobremesa extends Tecnologia {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4525048434472818714L;

	public Sobremesa(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int articulos, int minimo, Fabricante fabricante) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, articulos, minimo, fabricante);
		// TODO Auto-generated constructor stub
	}

}
