# Decorator

**Categoría:** Estructural 🟢 · **Responsable:** Yurani Álvarez 

## 📌 Problema

Cuando una aplicación necesita agregar funcionalidades a un objeto sin modificar su código ni crear muchas subclases.

Ejemplo: una biblioteca que inicialmente envía correos electrónicos, pero luego necesita enviar SMS y WhatsApp.

Sin Decorator aparecerían muchas clases:
- EmailNotifier
- EmailSMSNotifier
- EmailWhatsAppNotifier
- EmailSMSWhatsAppNotifier

Esto hace difícil mantener el código.

---

## 💡 Solución

Decorator permite envolver un objeto con otros objetos decoradores que agregan comportamiento adicional.

Cada decorador mantiene la misma interfaz del objeto original.

---

## 🧭 Estructura / Diagrama

Ver carpeta `diagrams/`.

---

## 🧪 Ejemplo de uso

Enviar una notificación por:

Correo → SMS → WhatsApp

---

## ▶️ Cómo ejecutar

Entrar a examples y ejecutar:

```bash
javac *.java ../src/*.java
java Demo