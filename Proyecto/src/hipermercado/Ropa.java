package hipermercado;

public  class Ropa extends Producto implements IVA {
	protected int talla;
	protected Marca marca;
	public Ropa(ListaProductos listaProductos, String codigoBarras, float precio, Zona zona, int articulos, int minimo, int talla, Marca marca) {
		super(listaProductos, codigoBarras, precio, zona, articulos, minimo);
		this.talla = talla;
		this.marca=marca;
	}
	
	
	@Override
	public double calcularIVA(double precio){
		precio=precio*0.21; //21% IVA aplicado en Ropa
		return precio;
	}

	private int getTalla() {
		return talla;
	}

	private void setTalla(int talla) {
		this.talla = talla;
	}

	private Marca getMarca() {
		return marca;
	}

	private void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}
