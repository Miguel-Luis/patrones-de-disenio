# Casos de Prueba Sugeridos - Abstract Factory

## Objetivo

Verificar que la implementación del patrón Abstract Factory genere familias completas de objetos compatibles y que el cliente permanezca desacoplado de las implementaciones concretas.

---

## Caso de Prueba 1: Creación de Familia Medieval

### Descripción

Validar que `MedievalFactory` produzca correctamente todos los elementos de la familia medieval.

### Entrada

* Instanciar `MedievalFactory`.
* Solicitar:

  * `createCharacter()`
  * `createWeapon()`
  * `createMount()`

### Resultado Esperado

| Método            | Tipo esperado |
| ----------------- | ------------- |
| createCharacter() | Knight        |
| createWeapon()    | Sword         |
| createMount()     | Horse         |

### Criterio de Éxito

Todos los productos pertenecen a la familia medieval y son compatibles entre sí.

---

## Caso de Prueba 2: Creación de Familia SciFi

### Descripción

Validar que `SciFiFactory` produzca correctamente todos los elementos de la familia de ciencia ficción.

### Entrada

* Instanciar `SciFiFactory`.
* Solicitar:

  * `createCharacter()`
  * `createWeapon()`
  * `createMount()`

### Resultado Esperado

| Método            | Tipo esperado |
| ----------------- | ------------- |
| createCharacter() | Soldier       |
| createWeapon()    | LaserGun      |
| createMount()     | Spaceship     |

### Criterio de Éxito

Todos los productos pertenecen a la familia SciFi y mantienen consistencia entre sí.

---

## Caso de Prueba 3: Desacoplamiento del Cliente

### Descripción

Verificar que `GameDemo` utilice únicamente las interfaces y la fábrica abstracta.

### Validación

Comprobar que `GameDemo` solo depende de:

* GameFactory
* Character
* Weapon
* Mount

### Resultado Esperado

No existen referencias directas a:

* Knight
* Soldier
* Sword
* LaserGun
* Horse
* Spaceship

### Criterio de Éxito

El cliente permanece desacoplado de las implementaciones concretas.

---

## Caso de Prueba 4: Sustitución de Fábricas

### Descripción

Verificar que sea posible cambiar la ambientación del juego sustituyendo únicamente la fábrica concreta utilizada en `main()`.

### Entrada

Cambiar:

* MedievalFactory

por:

* SciFiFactory

### Resultado Esperado

`GameDemo` continúa funcionando sin modificaciones.

### Criterio de Éxito

El comportamiento del cliente permanece estable al incorporar nuevas familias de productos.

---

## Caso de Prueba 5: Cumplimiento del Open/Closed Principle

### Descripción

Evaluar la capacidad del sistema para extenderse sin modificar el cliente.

### Validación

Analizar si una nueva familia de productos podría agregarse implementando una nueva fábrica concreta basada en `GameFactory`.

### Resultado Esperado

No es necesario modificar `GameDemo`.

### Criterio de Éxito

La arquitectura favorece la extensión sin alterar componentes existentes.
