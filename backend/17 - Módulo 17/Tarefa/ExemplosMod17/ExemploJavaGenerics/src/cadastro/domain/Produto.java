package cadastro.domain;

public class Produto implements IPersistente {
    private Long code;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public Long getCodigo() {
        return this.code;
    }
}
