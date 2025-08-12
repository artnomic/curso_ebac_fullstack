package cadastro.domain;

import cadastro.anotation.TipoChave;

public class Produto implements IPersistente {

    @TipoChave("getCode")
    private Long code;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

}
