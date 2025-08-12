package cadastro.domain;

import cadastro.anotation.TipoChave;

import java.util.Objects;

public class Cliente implements IPersistente {
        private String nome;

        @TipoChave("getCpf")
        private Long cpf;
        private String tel;
        private String endereco;
        private String numero;
        private String cidade;
        private String estado;

        public Cliente(String nome, String cpf, String tel, String endereco, String numero, String cidade, String estado) {
            this.nome = nome;
            this.cpf = Long.valueOf(cpf);
            this.tel = tel;
            this.endereco = endereco;
            this.numero = numero;
            this.cidade = cidade;
            this.estado = estado;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Long getCpf() {
            return cpf;
        }

        public void setCpf(Long cpf) {
            this.cpf = cpf;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Cliente cliente = (Cliente) o;
            return Objects.equals(cpf, cliente.cpf);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(cpf);
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "cpf='" + cpf + '\'' +
                    ", nome='" + nome + '\'' +
                    '}';
        }

}

