# Command

**Categoría:** De comportamiento 🟡 · **Responsable:** _Samuel Murillo_

## 📌 Problema
Imaginen que estamos creando un editor de texto con una barra de herramientas, un menú y atajos de teclado. Cada botón debe realizar una acción distinta: copiar, pegar, cortar, etc.

La forma de hacerlo sería crear una subclase de Botón para cada acción BotonCopiar, BotonPegar, BotonCortar. Pero eso genera demasiadas subclases. Cualquier cambio en la lógica nos obliga a modificar muchas clases dispersas.

## 💡 Solución
El patrón Command propone convertir una solicitud en un objeto independiente que contiene toda la información necesaria para ejecutarla: el método a llamar, los argumentos y el objeto receptor.
El objeto de la interfaz (emisor) ya no llama directamente a la lógica de negocio. En su lugar, tiene una referencia a un comando y ejecuta su método ejecutar().

El comando concreto se encarga de invocar al receptor adecuado.

Como todos los comandos siguen la misma interfaz, puedes intercambiarlos fácilmente.

Ventajas: 
Principio abierto/cerrado: añadir una nueva acción solo requiere crear una nueva clase comando; el resto del código no se modifica.

El emisor no necesita saber qué hace el comando ni quién lo ejecuta.

Guardando los comandos ejecutados en una pila, implementas deshacer/rehacer

## 🧭 Estructura / Diagrama
_Agrega aquí el diagrama UML o la estructura de clases._

## 🧪 Ejemplo de uso
_Describe un ejemplo del mundo real._

## ▶️ Cómo ejecutar
Ir a la carpeta command/src, y ejecutar el archivo Main.java

## 🗂️ Estructura de la carpeta
```
command/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
