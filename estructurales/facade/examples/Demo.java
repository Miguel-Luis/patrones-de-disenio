package facade.examples; 

import facade.src.HomeTheaterFacade;

public class Demo {
    public static void main(String[] args) {
       // 1. Instanciamos solo la fachada (ella se encarga del resto)
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // 2. Controlamos todo el sistema con líneas simples
        homeTheater.comenzarPelicula("Interstellar");
        
        homeTheater.terminarPelicula();
    }
}
