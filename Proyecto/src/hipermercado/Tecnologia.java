package hipermercado;

public  class Tecnologia extends Producto implements IVA {
	//private Fabricante fabricante;
	
	public Tecnologia(ListaProductos nombre, String codigoBarras, float precio, Zona zona, int articulos, int minimo) {
		super(nombre, codigoBarras, precio, zona, articulos, minimo);
		//this.fabricante=fabricante;
	}
	@Override
	public double calcularIVA(double precio){
		precio=precio*0.21; //21% IVA aplicado en Ropa
		return precio;
	}

	
	
	
}