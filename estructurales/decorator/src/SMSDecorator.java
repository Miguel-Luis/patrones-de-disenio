public class SMSDecorator
extends NotifierDecorator {

    public SMSDecorator(
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
            "SMS enviado"
        );

    }

}
