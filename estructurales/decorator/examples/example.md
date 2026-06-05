# Ejemplo de ejecución

## Escenario

Una empresa desea enviar notificaciones a sus clientes.

Inicialmente, las notificaciones se envían únicamente por correo electrónico.

Mediante el patrón Decorator se agregan nuevas funcionalidades sin modificar la clase original.

## Código utilizado

```java
Notifier notifier =
    new WhatsAppDecorator(
        new SMSDecorator(
            new EmailNotifier()
        )
    );

notifier.send("Nueva promoción");
```

## Salida esperada

```text
Correo enviado: Nueva promoción
SMS enviado
WhatsApp enviado
```

## Explicación

1. EmailNotifier envía la notificación principal.
2. SMSDecorator agrega el envío por SMS.
3. WhatsAppDecorator agrega el envío por WhatsApp.
4. Los decoradores permiten añadir funcionalidades dinámicamente.
```