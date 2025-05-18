package paqueteprincipal;

public class Excepciones {
    public static class CampoVacioException extends Exception {
        public CampoVacioException(String mensaje) { super(mensaje); }
    }
    public static class ValorNegativoException extends Exception {
        public ValorNegativoException(String mensaje) { super(mensaje); }
    }
    public static class FormatoIncorrectoException extends Exception {
        public FormatoIncorrectoException(String mensaje) { super(mensaje); }
    }
    // NUEVAS EXCEPCIONES
    public static class PrecioInvalidoException extends Exception {
        public PrecioInvalidoException(String mensaje) { super(mensaje); }
    }
    public static class DatosDuplicadosException extends Exception {
        public DatosDuplicadosException(String mensaje) { super(mensaje); }
    }
}
