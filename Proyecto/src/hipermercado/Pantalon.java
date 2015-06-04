package hipermercado;



public class Pantalon extends Ropa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 826258850387133700L;
	
	private Talla talla;
	public Pantalon(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int articulos, int minimo, Marca marca, Talla talla) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, articulos, minimo, marca);
		this.talla=talla;
		
	}
	
	private Talla getTalla() {
		return talla;
	}
	private void setTalla(Talla talla) {
		this.talla = talla;
	}

}
