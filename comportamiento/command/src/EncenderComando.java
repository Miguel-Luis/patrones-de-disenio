public class EncenderComando implements Comando {
    private Lampara lampara;
    
    public EncenderComando(Lampara lampara) {
        this.lampara = lampara;
    }
    
    @Override
    public void ejecutar() {
        lampara.encender();
    }
    
    @Override
    public void deshacer() {
        lampara.apagar();
    }
}
