import Paragrafo from '../Paragrafo'
import Titulo from '../Titulo'

import { Card, LinkBotao } from './styles'

const Projeto = () => (
  <div>
    <Card>
      <Titulo fontSize={16}>Projeto</Titulo>
      <Paragrafo tipo="secundario">
        Lista de Tarefas feitas com VueJS.
      </Paragrafo>
      <LinkBotao href="https://github.com/artnomic/vuejs-lista-tarefas">
        Visualizar
      </LinkBotao>
    </Card>
  </div>
)

export default Projeto
