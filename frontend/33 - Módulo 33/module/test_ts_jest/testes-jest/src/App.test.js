import App from "./App"
import { fireEvent, render, screen } from "@testing-library/react"


describe('Testes para o componente princioal', () => {
  test('Deve renderizar o componente', () => {
    render(<App />)
    expect(screen.getByText('Cadastrar')).toBeInTheDocument()
  })

  test('Deve adicionar "Estudar React" na lista', () => {
    render(<App />)
    fireEvent.change(screen.getByTestId('campo-tarefa'), {
      target: {
        value: 'Estudar React'
      }
    })
    fireEvent.click(screen.getByTestId('btn-cadastrar'))
    expect(screen.getByText('Estudar React')).toBeInTheDocument()
  })
})