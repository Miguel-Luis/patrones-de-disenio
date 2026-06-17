
public class CatalogoComputadores {

    private Computador gamer;
    private Computador oficina;
    private Computador diseno;

    public CatalogoComputadores() {
        gamer = new Computador(
                "Gamer",
                "Intel i7",
                16,
                "1TB SSD",
                "RTX 4070"
        );

        oficina = new Computador(
                "Oficina",
                "Intel i5",
                8,
                "512GB SSD",
                "Integrada"
        );

        diseno = new Computador(
                "Diseño",
                "Ryzen 9",
                32,
                "2TB SSD",
                "RTX 4080"
        );
    }

    public Computador getGamer() {
        return gamer;
    }

    public Computador getOficina() {
        return oficina;
    }

    public Computador getDiseno() {
        return diseno;
    }
}