package br.com.artnomic.builder;

public class BurguerRestaurantDirector {

    private BurguerBuilder burguerBuilder;

    public void setBuilder(BurguerBuilder burguerBuilder) {
        this.burguerBuilder = burguerBuilder;
    }

    public Burguer buildBurguer() {
        burguerBuilder.buildBun();
        burguerBuilder.buildMeat();
        burguerBuilder.buildSalad();
        burguerBuilder.buildCheese();
        burguerBuilder.buildSauce();

        return burguerBuilder.build();
    }
}
