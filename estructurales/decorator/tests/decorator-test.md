# Prueba del patrón Decorator

## Objetivo

Verificar que el patrón Decorator agregue funcionalidades adicionales sin modificar el comportamiento del objeto original.

## Caso de prueba

Se crea una notificación utilizando la siguiente secuencia:

```text
EmailNotifier
↓
SMSDecorator
↓
WhatsAppDecorator
```

## Entrada

```text
Nueva promoción
```

## Resultado esperado

```text
Correo enviado: Nueva promoción
SMS enviado
WhatsApp enviado
```

## Resultado obtenido

La ejecución fue exitosa.

La notificación se envió correctamente utilizando múltiples decoradores sin modificar la implementación base.
```