/// <reference types="cypress" />

describe('Testes para a home', () => {
    beforeEach(() => {
        cy.visit('https://agenda-contatos-react.vercel.app/')
    })

    it('Deve incluir um contato na Agenda', () => {
        cy.get('[type="text"]').type('Teste')
        cy.get('[type="email"]').type('teste@exercicio.com')
        cy.get('[type="tel"]').type('+55 11 91234-5678')
        cy.get('.adicionar').click()

        cy.contains('.contato', 'Teste').should('exist')
        cy.contains('.contato', 'teste@exercicio.com').should('exist')
        cy.contains('.contato', '+55 11 91234-5678').should('exist')
    })

    it('Deve alterar um contato na agenda', () => {
        cy.get('.edit').first().click()

        cy.get('[type="email"]').clear().type('Nome@email.com')
        cy.get('[type="tel"]').clear().type('+55 11 91234-5687')
        cy.get('.alterar').click()

        cy.contains('Nome@email.com').should('be.visible')
    });

    it('Deve Remover um contato na Agenda', () => {
        cy.get('.delete').first().click()
        cy.contains('Nome@email.com').should('not.exist')
    });

})