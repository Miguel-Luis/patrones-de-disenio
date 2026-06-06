# Factory Method

**Categoría:** Creacional / factory method🟣 · **Responsable:** Rodolfo agudelo cruz

## 📌 Problema
El problema surge cuando una aplicación debe crear objetos de diversos tipos pero no puede anticipar cuál clase exacta necesitará hasta el tiempo de ejecución. Si el código usa `new ClaseConcreta()`, se vuelve rígido y difícil de extender (por ejemplo, si quieres agregar un nuevo tipo de transporte, tendrías que cambiar todo el código existente).

## 💡 Solución
El patrón **Factory Method** sugiere que, en lugar de instanciar objetos directamente, se llame a un método "fábrica". Las subclases pueden sobrescribir este método para cambiar el tipo de objetos que se crearán, permitiendo que el código sea flexible y desacoplado de las clases específicas.

## 🧭 Estructura / Diagrama
1. **Producto (Interface):** Define la interfaz de los objetos que la fábrica crea.
2. **Productos Concretos:** Diferentes implementaciones de la interfaz.
3. **Creador (Clase Abstracta):** Declara el método fábrica.
4. **Creadores Concretos:** Sobrescriben el método fábrica para devolver una instancia de un producto concreto.

## 🧪 Ejemplo de uso
Un sistema de logística donde, dependiendo de la ruta, se decide si se usa un **Camión** (vía terrestre) o un **Barco** (vía marítima), ambos cumpliendo la función de transportar mercancía.

## ▶️ Cómo ejecutar
Desde la raíz de la carpeta `factory-method`:
1. Compila el código:
   ```bash
   javac src/*.java examples/Demo.java
   ```
2. Ejecuta la demo:
   ```bash
   java -cp . examples/Demo
   ```

## 🗂️ Estructura de la carpeta
```
factory-method/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
