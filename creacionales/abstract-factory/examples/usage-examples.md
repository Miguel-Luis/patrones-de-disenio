# Ejemplos de Uso - Abstract Factory

## Ejemplo 1: Ambientación Medieval

En este escenario, el sistema utiliza `MedievalFactory` para generar una familia completa de objetos pertenecientes a la temática medieval.

### Productos generados

| Tipo de Producto | Implementación Concreta |
| ---------------- | ----------------------- |
| Character        | Knight                  |
| Weapon           | Sword                   |
| Mount            | Horse                   |

### Flujo de ejecución

1. `main()` selecciona `MedievalFactory`.
2. La fábrica se inyecta en `GameDemo`.
3. `GameDemo` solicita:

   * `createCharacter()`
   * `createWeapon()`
   * `createMount()`
4. La fábrica devuelve:

   * Knight
   * Sword
   * Horse
5. `GameDemo` interactúa únicamente con las interfaces (`Character`, `Weapon` y `Mount`).

### Beneficio obtenido

Se garantiza que todos los objetos pertenecen a la misma familia y son compatibles entre sí.

---

## Ejemplo 2: Ambientación de Ciencia Ficción

En este escenario, el sistema utiliza `SciFiFactory` para generar una familia completa de objetos pertenecientes a una ambientación futurista.

### Productos generados

| Tipo de Producto | Implementación Concreta |
| ---------------- | ----------------------- |
| Character        | Soldier                 |
| Weapon           | LaserGun                |
| Mount            | Spaceship               |

### Flujo de ejecución

1. `main()` selecciona `SciFiFactory`.
2. La fábrica se inyecta en `GameDemo`.
3. `GameDemo` solicita:

   * `createCharacter()`
   * `createWeapon()`
   * `createMount()`
4. La fábrica devuelve:

   * Soldier
   * LaserGun
   * Spaceship
5. `GameDemo` continúa trabajando únicamente con las interfaces.

### Beneficio obtenido

Es posible cambiar completamente la ambientación del juego sin modificar el código del cliente.

---

## Ejemplo 3: Extensibilidad del Sistema

El diseño implementado permite incorporar nuevas familias completas de productos mediante la creación de nuevas fábricas concretas que implementen `GameFactory`.

Gracias a esto, `GameDemo` no requiere modificaciones para soportar nuevas ambientaciones, cumpliendo con el principio Open/Closed Principle (OCP).

### Beneficios de esta aproximación

* Bajo acoplamiento.
* Mayor mantenibilidad.
* Facilidad para extender el sistema.
* Consistencia entre productos relacionados.
