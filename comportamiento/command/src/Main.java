//Cliente (programa principal)
public class Main {
    public static void main(String[] args) {
        // Instanciar receptor
        Lampara lampara = new Lampara();
        
        // Instanciar comandos
        EncenderComando encender = new EncenderComando(lampara);
        ApagarComando apagar = new ApagarComando(lampara);
        
        // Instanciar emisor (control remoto)
        ControlRemoto control = new ControlRemoto();
        
        System.out.println("------ Control remoto de la lámpara ------");
        
        // Encender
        control.asignarComando(encender);
        control.presionarBoton();   // Lámpara encendida
        
        // Apagar
        control.asignarComando(apagar);
        control.presionarBoton();   // Lámpara apagada
        
        // Volver a encender
        control.asignarComando(encender);
        control.presionarBoton();   // Lámpara encendida
        
        // Deshacer las tres acciones
        control.presionarDeshacer(); // deshace encender y la apaga
        control.presionarDeshacer(); // deshace apagar y la enciende
        control.presionarDeshacer(); // deshace encender y la apaga
        control.presionarDeshacer(); // ya no hay más acciones
    }
}
