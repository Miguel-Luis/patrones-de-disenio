# Abstract Factory Pattern - Video Game Asset Generator

## Descripción del Proyecto

Este proyecto implementa el patrón de diseño **Abstract Factory**, perteneciente a la categoría de **patrones creacionales** del catálogo Gang of Four (GoF), utilizando Java.

La implementación simula un generador de elementos para videojuegos donde diferentes ambientaciones producen familias completas de objetos relacionados, manteniendo un bajo acoplamiento entre el cliente y las implementaciones concretas.

## Objetivo Académico

- Comprender el funcionamiento del patrón Abstract Factory.
- Aplicar programación orientada a interfaces.
- Implementar inyección de dependencias.
- Evidenciar el cumplimiento del principio Open/Closed.
- Diferenciar Abstract Factory de Factory Method.

## Problema que Resuelve

En aplicaciones donde existen múltiples familias de objetos relacionados, la creación directa de objetos concretos genera un fuerte acoplamiento entre el cliente y las implementaciones específicas.

En el contexto de este proyecto, si `GameDemo` instanciara directamente clases como `Knight`, `Sword`, `Horse`, `Soldier`, `LaserGun` o `Spaceship`, cualquier cambio o incorporación de nuevas ambientaciones requeriría modificar el código del cliente.

Esto dificultaría el mantenimiento del sistema y violaría el principio de programar contra interfaces.

Además, el cliente sería responsable de garantizar que los objetos creados pertenezcan a la misma familia, aumentando el riesgo de inconsistencias, como combinar elementos medievales con elementos de ciencia ficción.

## Solución Propuesta

Para resolver este problema, se implementa el patrón de diseño **Abstract Factory**, el cual proporciona una interfaz común (`GameFactory`) para crear familias completas de objetos relacionados sin depender de sus implementaciones concretas.

La interfaz `GameFactory` define los métodos:

```java
createCharacter()
createWeapon()
createMount()
```

Cada fábrica concreta es responsable de crear productos compatibles entre sí:

### MedievalFactory

Produce la familia medieval compuesta por:

- Knight
- Sword
- Horse

### SciFiFactory

Produce la familia de ciencia ficción compuesta por:

- Soldier
- LaserGun
- Spaceship

El cliente (`GameDemo`) recibe una instancia de `GameFactory` mediante inyección de dependencias y trabaja exclusivamente con las abstracciones:

- Character
- Weapon
- Mount

De esta manera, `GameDemo` nunca necesita conocer ni instanciar directamente clases concretas, reduciendo el acoplamiento y facilitando la incorporación de nuevas familias de productos.

La selección de la fábrica concreta ocurre únicamente en el método `main()`, permitiendo modificar la ambientación del juego sin alterar la lógica del cliente.

## Principios de Diseño Aplicados

### Programar contra interfaces y no contra implementaciones

El cliente (`GameDemo`) interactúa únicamente con las abstracciones definidas en el sistema:

- GameFactory
- Character
- Weapon
- Mount

En ningún momento el cliente conoce o instancia directamente clases concretas como:

- Knight
- Soldier
- Sword
- LaserGun
- Horse
- Spaceship

Esto reduce el acoplamiento entre los componentes del sistema y facilita la sustitución o extensión de nuevas familias de productos.

### Open/Closed Principle (OCP)

La implementación cumple con el principio **Abierto/Cerrado**, el cual establece que las entidades de software deben estar abiertas para extensión pero cerradas para modificación.

En este proyecto, es posible agregar nuevas familias completas de productos mediante la creación de nuevas fábricas concretas sin modificar el código existente de `GameDemo`.

Por ejemplo, podría incorporarse una nueva ambientación del juego implementando una nueva fábrica concreta, manteniendo intacta la lógica del cliente.

### Dependency Injection

`GameDemo` recibe una instancia de `GameFactory` mediante inyección de dependencias.

Gracias a este enfoque, el cliente no es responsable de crear las fábricas concretas, sino únicamente de utilizarlas a través de la interfaz común.

Esto incrementa la flexibilidad del diseño y favorece la reutilización del código.

## Comparación entre Factory Method y Abstract Factory

Aunque ambos pertenecen a los patrones creacionales, su propósito es diferente.

| Factory Method | Abstract Factory |
|----------------|------------------|
| Se enfoca en la creación de un único tipo de producto. | Se enfoca en la creación de familias completas de productos relacionados. |
| Generalmente define un solo método fábrica. | Define múltiples métodos fábrica para cada producto de la familia. |
| Tiene una estructura más simple. | Presenta un mayor nivel de abstracción. |
| El cliente obtiene un único objeto. | El cliente obtiene un conjunto de objetos compatibles entre sí. |

En este proyecto, si únicamente existiera el método:

```java
createCharacter()
```

la implementación sería similar a un **Factory Method**.

Sin embargo, `GameFactory` define múltiples métodos de creación:

```java
createCharacter()
createWeapon()
createMount()
```

permitiendo generar familias completas de objetos compatibles, lo cual corresponde al patrón **Abstract Factory**.

Por lo tanto, este proyecto demuestra claramente la principal diferencia entre ambos patrones: **Abstract Factory coordina la creación de varios productos relacionados, mientras que Factory Method se centra en un único producto.**

## Ventajas

- Reduce el acoplamiento entre el cliente y las implementaciones concretas.
- Garantiza que los productos creados pertenezcan a la misma familia y sean compatibles entre sí.
- Facilita la incorporación de nuevas familias de productos sin modificar el código del cliente.
- Favorece el cumplimiento del principio Open/Closed Principle (OCP).
- Promueve la programación orientada a interfaces.
- Mejora la mantenibilidad y escalabilidad del sistema.

## Desventajas

- Incrementa el número de interfaces y clases en el sistema.
- Puede añadir complejidad innecesaria en aplicaciones pequeñas o simples.
- Si se requiere agregar un nuevo tipo de producto (por ejemplo, `Armor`), es necesario modificar la fábrica abstracta (`GameFactory`) y todas las fábricas concretas existentes.
- La estructura inicial puede ser más difícil de comprender para desarrolladores con poca experiencia en patrones de diseño.

## Casos de Uso Reales

El patrón Abstract Factory es ampliamente utilizado en sistemas que requieren la creación de familias completas de objetos relacionados.

### Frameworks de Interfaces Gráficas

Permite generar componentes gráficos específicos para diferentes sistemas operativos, garantizando que todos los elementos visuales mantengan una apariencia consistente.

Ejemplos:

- Windows
- macOS
- Linux

### Motores de Videojuegos

Facilita la creación de elementos pertenecientes a una misma ambientación o temática.

Ejemplos:

- Fantasía medieval
- Ciencia ficción
- Mundo postapocalíptico

El proyecto desarrollado representa este caso de uso mediante las fábricas `MedievalFactory` y `SciFiFactory`.

### Drivers de Bases de Datos

Permite crear objetos específicos para diferentes motores de bases de datos manteniendo una interfaz común.

Ejemplos:

- MySQL
- PostgreSQL
- Oracle

### Sistemas Multiplataforma

Facilita la generación de componentes adaptados a diferentes entornos de ejecución sin afectar la lógica principal de la aplicación.

## Conclusiones

La implementación desarrollada demuestra adecuadamente el funcionamiento del patrón de diseño **Abstract Factory**, evidenciando cómo es posible crear familias completas de objetos relacionados sin depender de clases concretas.

El uso de `GameFactory`, junto con las fábricas concretas `MedievalFactory` y `SciFiFactory`, permite desacoplar al cliente (`GameDemo`) de las implementaciones específicas, favoreciendo una arquitectura más flexible y mantenible.

Además, la solución implementada promueve buenas prácticas de diseño orientado a objetos, como la programación basada en interfaces, la inyección de dependencias y el cumplimiento del principio Open/Closed Principle.

Finalmente, este proyecto permite comprender claramente la diferencia entre **Factory Method** y **Abstract Factory**, destacando la capacidad de este último para gestionar familias completas de productos compatibles entre sí.

## Autores

- **Andrea** – Documentación técnica, README, UML, material académico y apoyo para la sustentación.
- **Jhonny** – Implementación del patrón Abstract Factory en Java.

## Estructura del Proyecto

```text
abstract-factory/

├── README.md
├── src/
├── diagrams/
├── examples/
└── tests/
```

## Componentes del Patrón

### Abstract Factory

- GameFactory

### Concrete Factories

- MedievalFactory
- SciFiFactory

### Abstract Products

- Character
- Weapon
- Mount

### Concrete Products

#### Ambientación Medieval

- Knight
- Sword
- Horse

#### Ambientación Ciencia Ficción

- Soldier
- LaserGun
- Spaceship

### Cliente

- GameDemo