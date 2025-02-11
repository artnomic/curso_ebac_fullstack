/// <reference types="cypress" />

describe('Testes para a página de Candidatura', () => {
    beforeEach(() => {
        cy.visit('https://ebac-jobs-e2e.vercel.app/')
    })


    it('Deve levar o usuário até o formulário de inscrição', () => {
        cy.get('.Vaga_vagaLink__DeFkk').first().click()
        cy.get('input').should('have.length', 7)
        cy.screenshot('tela-inscricao')
    });

    it('Deve preencher o formulário de inscrição', () => {
        cy.get('.Vaga_vagaLink__DeFkk').first().click()
        cy.get('input[name="nome-completo"]').type('Arthur Berson')
        cy.get('input[name="email"]').type('arthur@berson.com')
        cy.get('input[name="telefone"]').type('+55 11 97719-1778')
        cy.get('input[name="endereco"]').type('R. Ernest Renam, 605')
        cy.get('#linux').check()
        cy.get('select[name="escolaridade"]').select('tecnologo')
        cy.get('.Aplicacao_button__tw2AE').click()

        cy.on('window:alert', (conteudo) => {
            expect(conteudo).contain('Obrigado pela candidatura!')
        })

        cy.screenshot('tela-inscricao-preenchida')
    })
})