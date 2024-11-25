import styled from 'styled-components'

import { Props } from '.'

export const Titulo = styled.h3<Props>`
  color: ${(props) => props.theme.corPrincipal};
  font-size: ${(props) => props.fontSize || 14}px;
  font-weight: bold;
  margin-bottom: 16px;
`
