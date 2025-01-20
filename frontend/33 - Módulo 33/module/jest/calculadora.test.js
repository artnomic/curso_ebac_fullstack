const calculadora = require('./calculadora');


describe("Testes de Calculadora", () => {
    test('Somar 2 e 2 deve resultar em 4', () => {
        const minhaSoma = calculadora.soma(2, 2);
        expect(minhaSoma).toBe(4)
    });

    test('Multiplicar 2 e 5 deve resultar em 10', () => {
        const minhaMultiplicacao = calculadora.multiplicacao(2, 5);
        expect(minhaMultiplicacao).toBe(10)
    });

});