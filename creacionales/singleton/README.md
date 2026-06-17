# Singleton

**Categoría:** Creacional 🟣 · **Responsable:** _DavinsonColoradoAgudelo

## 📌 Problema
_Describe el problema que resuelve este patrón (¿por qué existe?)._

En algunas aplicaciones es necesario asegurar que una clase tenga una única instancia durante toda la ejecución del programa. Crear múltiples objetos podría generar inconsistencias o desperdicio de recursos.


## 💡 Solución
_Explica cómo lo resuelve._

El patrón Singleton restringe la creación de objetos de una clase y proporciona un punto global de acceso a la única instancia existente.

## 🧭 Estructura / Diagrama
_Agrega aquí el diagrama UML o la estructura de clases._

Singleton

instancia única
constructor privado
método getInstancia()

## 🧪 Ejemplo de uso
_Describe un ejemplo del mundo real._

Una aplicación puede tener una única configuración global que sea compartida por todos los módulos del sistema.

## ▶️ Cómo ejecutar
_Instrucciones para correr tu demo._

## 🗂️ Estructura de la carpeta
```
singleton/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
