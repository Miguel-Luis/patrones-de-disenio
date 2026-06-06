# Flyweight

**Categoría:** Estructural 🟢 · **Responsable:** _Victor Manuel Fernandez Valencia_

## 📌 Problema
Este patron de diseño resuelve el problema de cargar muchas instancias de un objeto en memoria, 
los cuales tengan atributos iguales lo cual hace que se sature la memoria RAM.

## 💡 Solución
Para solucionar el problema este patron propene crear una clase **Flyweight** la cual va a contener 
los atributos que no cambien o que sean inmutables y muy pesados para que haci la clase que tenga los atributos 
cambiantes sea mas ligera y no carge tanto peso, para esto se debe de crear una clase **Factory** la cual se va a 
encargar de dar los datos de las instancias pesadas que guardan los atrubutos inmutables.

## 🧭 Estructura / Diagrama
_Agrega aquí el diagrama UML o la estructura de clases._

## 🧪 Ejemplo de uso
_Describe un ejemplo del mundo real._

## ▶️ Cómo ejecutar
_Instrucciones para correr tu demo._

## 🗂️ Estructura de la carpeta
```
flyweight/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
