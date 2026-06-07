public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {

        System.out.println(
            "Correo enviado: "
            + message
        );

    }

}