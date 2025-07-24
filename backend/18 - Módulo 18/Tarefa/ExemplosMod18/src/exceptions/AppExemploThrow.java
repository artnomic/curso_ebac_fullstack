package exceptions;

public class AppExemploThrow {
    public static void main(String[] args) {
//        exception();
        runtimeException();
    }

    private static void runtimeException() {
        ExemploThrow.saqueRuntimeException(500);
    }

    private static void exception() {
        try {
           ExemploThrow.saque(500);
        } catch (NullPointerException e) {
           System.out.println("ERRO: " + e.getMessage());
        } catch (LimiteSaqueException e) {
           System.out.println("ERRO: " + e.getMessage());
        } finally {
            System.out.println("Código é sempre executado!");
        }
    }
}
