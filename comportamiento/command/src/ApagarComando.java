public class ApagarComando implements Comando {
    private Lampara lampara;
    
    public ApagarComando(Lampara lampara) {
        this.lampara = lampara;
    }
    
    @Override
    public void ejecutar() {
        lampara.apagar();
    }
    
    @Override
    public void deshacer() {
        lampara.encender();
    }
}
