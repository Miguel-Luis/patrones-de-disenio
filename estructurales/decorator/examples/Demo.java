public class Demo {

    public static void main(
        String[] args
    ) {

        Notifier notifier =
            new WhatsAppDecorator(
                new SMSDecorator(
                    new EmailNotifier()
                )
            );

        notifier.send(
            "Nueva promoción"
        );

    }

}
