# Template Method

**Categoría:** De comportamiento template method🟡 · **Responsable:** kevinsanchez444

📌 Problema
Cuando varios procesos comparten la misma secuencia de pasos, pero cada uno necesita detalles distintos en su ejecución, el código tiende a duplicarse o volverse difícil de mantener.
Ejemplo: preparar diferentes comidas (hamburguesa, pizza, ensalada) siempre sigue un orden, pero cada plato tiene ingredientes y formas de cocinar diferentes.

💡 Solución
El patrón Template Method define la estructura fija del algoritmo en una clase abstracta y delega los pasos variables a las subclases.
De esta forma:

La superclase asegura que el flujo siempre se cumpla en el mismo orden.

Las subclases personalizan los pasos concretos sin alterar la secuencia general.

📊 Diagrama UML
Código
          +----------------------+
          |  PrepararComida      |  (abstract)
          +----------------------+
          | prepararPlato()      |  <-- Template Method
          | prepararIngredientes() (abstract)
          | cocinar()              (abstract)
          | servir()               (abstract)
          | AgregarExtras()        (hook)
          +----------------------+
                   ^
                   |
   -----------------------------------
   |                |                |
+-----------+   +-----------+   +-----------+
| Hamburguesa|  |   Pizza   |   |  Ensalada |
+-----------+   +-----------+   +-----------+
| prepararIngredientes() |   | prepararIngredientes() |
| cocinar()              |   | cocinar()              |
| servir()               |   | servir()               |
| AgregarExtras()        |   | AgregarExtras()        |
+------------------------+   +------------------------+
🧪 Ejemplo de uso
En el mundo real, el proceso de preparar un plato de comida siempre sigue el mismo flujo:

Preparar ingredientes

Cocinar

Servir

Agregar extras

Hamburguesa: freír carne, armar en pan, añadir papas fritas.

Pizza: preparar masa, hornear, cortar en porciones, añadir orégano.

Ensalada: cortar verduras, no cocinar, servir en bowl, añadir aderezo.

Cada plato se prepara distinto, pero todos respetan la misma secuencia.

▶️ Cómo ejecutar
Compila las clases:

bash
javac abstracta/PrepararComida.java clases/Hamburguesa.java clases/Pizza.java clases/Ensalada.java app/App.java
Ejecuta la clase principal:

bash
java app.App
La salida mostrará la preparación de cada plato siguiendo el mismo flujo, pero con pasos específicos según la subclase.

## 🗂️ Estructura de la carpeta
```
template-method/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
