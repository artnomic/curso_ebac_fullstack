import Paragrafo from '../../components/Paragrafo'
import Titulo from '../../components/Titulo'
import { GithubSecao } from './styles'

const Sobre = () => (
  <section>
    <Titulo fontSize={16}>Sobre mim</Titulo>
    <Paragrafo tipo="principal">
      Lorem, ipsum dolor sit amet consectetur adipisicing elit. Minima, aperiam,
      laboriosam soluta voluptatem blanditiis dolores odit impedit ipsum
      exercitationem perferendis accusantium dolorem sint quae quidem deserunt,
      consequatur numquam distinctio quos!
    </Paragrafo>
    <GithubSecao>
      <img src="https://github-readme-stats.vercel.app/api?username=artnomic&show_icons=true&theme=dracula&include_all_commits=true" />
      <img src="https://github-readme-stats.vercel.app/api/top-langs/?username=artnomic&layout=compact&langs_count=7&theme=dracula" />
    </GithubSecao>
  </section>
)

export default Sobre
