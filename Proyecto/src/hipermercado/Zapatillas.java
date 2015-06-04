package hipermercado;



public class Zapatillas extends Ropa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1057350087936333701L;
	int talla;
	public Zapatillas(ListaProductos nombre, String codigoBarras, float precio,
			Zona zona, int articulos, int minimo, int talla, Marca marca) throws ExistenciasInvalidasException {
		super(nombre, codigoBarras, precio, zona, articulos, minimo, marca);
		this.talla=talla;
	}
	public int getTalla() {
		return talla;
	}
	private void setTalla(int talla) {
		this.talla = talla;
	}

}
