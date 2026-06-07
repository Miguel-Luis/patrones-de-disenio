public class WhatsAppDecorator
extends NotifierDecorator {

    public WhatsAppDecorator(
        Notifier notifier
    ) {

        super(notifier);

    }

    @Override
    public void send(
        String message
    ) {

        super.send(message);

        System.out.println(
            "WhatsApp enviado"
        );

    }

}