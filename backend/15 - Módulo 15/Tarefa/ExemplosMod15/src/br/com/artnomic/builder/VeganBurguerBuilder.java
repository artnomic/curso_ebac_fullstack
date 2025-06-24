package br.com.artnomic.builder;

public class VeganBurguerBuilder extends BurguerBuilder {

    @Override
    void buildBun() {
        burguer.setBun("Vegan White Bread");
    }

    @Override
    void buildMeat() {
        burguer.setMeat("Vegan Beef");
    }

    @Override
    void buildSalad() {
        burguer.setSalad("Vegan Iceberg");
    }

    @Override
    void buildCheese() {
        burguer.setCheese("Vegan American Cheese");
    }

    @Override
    void buildSauce() {
        burguer.setSauce("Vegan Secret Sauce");
    }
}
