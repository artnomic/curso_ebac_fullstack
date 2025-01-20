const saudacao = require('./saudacao');

describe("Testes de Saudacao", () => {
    test('Diz ola para o nome Arthur', () => {
        const minhaSaudacao = saudacao.dizOla('Arthur');
        expect(minhaSaudacao).toBe('Olá Arthur!')
    });
})