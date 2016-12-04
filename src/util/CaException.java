package util;

public class CaException extends Exception {

    private final String detalle;
    private final String clase;

    /**
     * Metodo constructor que recoge la descripci�n del error que genero la
     * excepci�n.
     *
     * @param clase
     * @param error cadena que contiene la descripci�n del error.
     */
    public CaException(String clase, String error) {
        super(error);
        this.clase = clase;
        detalle = error;
    }

    @Override
    public String toString() {
        return "[" + clase + "] " + detalle;
    }
}
