package hipermercado;





public enum ListaProductos {
	
	CAMISETA(Zona.ROPA),
	PANTALÓN(Zona.ROPA),
	ZAPATILLAS(Zona.ROPA),
	
	SOBREMESA(Zona.TECNOLOGIA),
	PORTÁTIL(Zona.TECNOLOGIA),
	TV(Zona.TECNOLOGIA),
	
	CARNE(Zona.ALIMENTACION),
	PESCADO(Zona.ALIMENTACION),
	PAN(Zona.ALIMENTACION),
	
	MANZANAS(Zona.FRUTERIA),
	NARANJAS(Zona.FRUTERIA),
	MELOCOTONES(Zona.FRUTERIA),
	
	PS4(Zona.VIDEOJUEGOS),
	XBOXONE(Zona.VIDEOJUEGOS),
	WII(Zona.VIDEOJUEGOS);
	
	private Zona zona;
	
	private ListaProductos(Zona zona) {
		this.zona = zona;
	}
	
	public String toString() {
		return name();

	}
	
	private static final ListaProductos[] VALUES = ListaProductos.values();
	/**
	 * Metodo que genera las opciones de un menu de modelos de coches
	 * @return devuelve un array de cadenas con los modelos posibles 
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (ListaProductos listaproductos : VALUES) {
			opcionesMenu[i++] = listaproductos.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	public static ListaProductos[] getValues() {
		return VALUES;
	}
	
	public Zona getZona() {
		return zona;
	}

}
