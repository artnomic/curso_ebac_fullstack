package br.com.artnomic.builder;

public class CheeseBurguerBuilder extends BurguerBuilder {

    @Override
    void buildBun() {
        burguer.setBun("White Bread");
    }

    @Override
    void buildMeat() {
        burguer.setMeat("Beef");
    }

    @Override
    void buildSalad() {
        burguer.setSalad("Iceberg");
    }

    @Override
    void buildCheese() {
        burguer.setCheese("American Cheese");
    }

    @Override
    void buildSauce() {
        burguer.setSauce("Secret Sauce");
    }
}
