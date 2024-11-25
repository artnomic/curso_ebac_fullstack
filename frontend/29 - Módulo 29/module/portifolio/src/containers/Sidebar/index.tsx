import Avatar from '../../components/Avatar'
import Paragrafo from '../../components/Paragrafo'
import Titulo from '../../components/Titulo'

import { Descricao, BotaoTema, SidebarContainer } from './styles'

type Props = {
  changeTheme: () => void
}

const Sidebar = (props: Props) => (
  <aside>
    <SidebarContainer>
      <Avatar />
      <Titulo fontSize={20}>Arthur Berson</Titulo>
      <Paragrafo tipo="secundario" fontSize={16}>
        artnomic
      </Paragrafo>
      <Descricao tipo="principal" fontSize={16}>
        Front-end developer, loves to build cool stuffs
      </Descricao>
      <BotaoTema onClick={props.changeTheme}>Trocar Tema</BotaoTema>
    </SidebarContainer>
  </aside>
)

export default Sidebar
