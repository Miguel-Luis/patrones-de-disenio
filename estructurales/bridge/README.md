# Bridge

**Categoría:** Estructural 🟢 · **Responsable:** Jose Manuel Mesa

## 📌 Problema
_Describe el problema que resuelve este patrón (¿por qué existe?)._

Cuando una aplicación tiene varias abstracciones y varias implementaciones, el número de clases puede crecer rápidamente. Por ejemplo, si existen diferentes tipos de controles remotos y diferentes dispositivos electrónicos, sería necesario crear una clase para cada combinación posible.

## 💡 Solución
_Explica cómo lo resuelve._

La solución consiste en crear un puente entre el control remoto y los dispositivos mediante la interfaz Device. De esta forma, el control remoto no necesita saber si está trabajando con una TV o una Radio. Solo utiliza los métodos definidos en la interfaz, permitiendo que ambas partes evolucionen de manera independiente." 
en este ejemplo el control remoto es lo que representa la abstracion y los dispositivos eletronicos son los que representan las implementaciones 

## 🧭 Estructura / Diagrama
_Agrega aquí el diagrama UML o la estructura de clases._

## 🧪 Ejemplo de uso
_Describe un ejemplo del mundo real._

Un control remoto universal que puede controlar distintos dispositivos electrónicos, como televisores y radios, utilizando la misma interfaz de control.

## ▶️ Cómo ejecutar
_Instrucciones para correr tu demo._

## 🗂️ Estructura de la carpeta
```
bridge/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
