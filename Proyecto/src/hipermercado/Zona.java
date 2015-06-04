package hipermercado;





public enum Zona {

	TECNOLOGIA, ROPA,  ALIMENTACION, FRUTERIA, VIDEOJUEGOS;
	
	private static final Zona[] VALUES = Zona.values();
	public static Zona[] getValues() {
		return VALUES;
	}
}
