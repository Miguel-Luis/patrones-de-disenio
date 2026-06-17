# Adapter

**Categoría:** Estructural 🟢 · **Responsable:** Sebastian Galvis Gutierrez

## 📌 Problema
Un cliente espera usar un enchufe americano (AmericanPlug), pero el dispositivo disponible tiene un enchufe europeo (EuropeanPlug). El patrón Adapter resuelve la incompatibilidad entre estas dos interfaces.

## 💡 Solución
Se crea un adaptador (PlugAdapter) que implementa la interfaz americana y usa internamente un enchufe europeo. De esta forma, el cliente puede conectar el dispositivo europeo en una toma americana sin cambiar el código del cliente ni del dispositivo.

## 🧩 Clases en el ejemplo
- AmericanPlug: interfaz esperada por el cliente.
- EuropeanPlug: clase existente con método connectToEuropeanSocket().
- PlugAdapter: adaptador que implementa AmericanPlug y delega la conexión al EuropeanPlug.
- Main: demo de uso donde se adapta un enchufe europeo para una toma americana.

## 🧭 Comportamiento
1. El cliente crea un EuropeanPlu`.
2. Envuelve el EuropeanPlug en un PlugAdapter.
3. El cliente usa connectToAmericanSocket() en el adaptador.
4. El adaptador notifica la conversión y llama a `connectToEuropeanSocket()`.

## ▶️ Cómo ejecutar
1. Abre una terminal en `patrones-de-disenio/estructurales/adapter/Examples`.
2. Compila los archivos Java:
   ```
   javac *.java
   ```
3. Ejecuta la clase principal:
   ```
   java Main
   ```
4. Verás en consola el proceso de adaptación.

## 🗂️ Estructura de la carpeta
```
adapter/
├── README.md
└── src/
    ├── AmericanPlug.java
    ├── EuropeanPlug.java
    ├── PlugAdapter.java
    └── Main.java
```
