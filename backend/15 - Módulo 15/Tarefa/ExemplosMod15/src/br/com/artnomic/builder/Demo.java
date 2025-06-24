package br.com.artnomic.builder;

public class Demo {
    public static void main(String[] args) {
        BurguerRestaurantDirector burguerRestaurant = new BurguerRestaurantDirector();

        burguerRestaurant.setBuilder(new CheeseBurguerBuilder());
        buildBurguer(burguerRestaurant);

        burguerRestaurant.setBuilder(new VeganBurguerBuilder());
        buildBurguer(burguerRestaurant);
    }

    private static void buildBurguer(BurguerRestaurantDirector burguerRestaurant) {
        Burguer burguer = burguerRestaurant.buildBurguer();
        burguer.print();
    }
}
