import java.util.function.IntBinaryOperator;

public class TesteLambdas {
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };
        intBinaryOperator.applyAsInt(1,1);


    }
}