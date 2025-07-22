package anotacao;

@PrimeiraAnotacao(value = "ArtB",bairros = {"Jd. Irene", "Capão"},numeroCasa = 55, valores = 40)
public class ClasseComAnotacao {

    @PrimeiraAnotacao(value = "ArtB",bairros = {"PZS"},numeroCasa = 35L)
    private String nome;

    @PrimeiraAnotacao(value = "ArtB",bairros = {"PZS"},numeroCasa = 455L)
    public ClasseComAnotacao(String nome) {
        this.nome = nome;
    }
}
