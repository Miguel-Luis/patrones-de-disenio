# Composite

**Categoría:** Estructural 🟢 · **Responsable:** Juan David Maldonado Cortez

## 📌 Problema

Cuando se trabaja con estructuras jerárquicas, como carpetas y archivos, menús y submenús, o departamentos y empleados, suele ser necesario tratar objetos individuales y grupos de objetos de manera uniforme.

Sin el patrón Composite, el código debe distinguir constantemente si está trabajando con un objeto simple o con un conjunto de objetos, generando múltiples condicionales (`if`, `instanceof`) y aumentando la complejidad del sistema.

## 💡 Solución

El patrón Composite permite componer objetos en estructuras de árbol para representar relaciones parte-todo.

Este patrón define una interfaz común para todos los elementos de la estructura, de manera que los objetos individuales (Leaf) y los objetos compuestos (Composite) puedan ser tratados de la misma forma.

En este ejemplo:

* **Empleado** → Componente (Component)
* **Desarrollador** → Hoja (Leaf)
* **Gerente** → Compuesto (Composite)

El gerente puede contener una colección de empleados y ejecutar operaciones sobre todos ellos sin importar si son hojas o compuestos.

## 🧭 Estructura / Diagrama

```text
                +----------------+
                |   Empleado     |
                +----------------+
                | mostrarDetalles() |
                +--------^-------+
                         |
           +-------------+-------------+
           |                           |
+-------------------+     +-------------------+
|  Desarrollador    |     |      Gerente      |
+-------------------+     +-------------------+
| nombre            |     | nombre            |
+-------------------+     | empleados         |
| mostrarDetalles() |     +-------------------+
+-------------------+     | agregarEmpleado() |
                          | mostrarDetalles() |
                          +-------------------+
```

## 🧪 Ejemplo de uso

Supongamos una empresa donde un gerente tiene varios desarrolladores a cargo.

Al invocar:

```java
gerente.mostrarDetalles();
```

se mostrará la información del gerente y de todos los empleados que tiene asociados.

Salida esperada:

```text
Gerente: Carlos
Desarrollador: Juan
Desarrollador: Pedro
```

Este mismo concepto puede aplicarse a:

* Carpetas y archivos.
* Menús y submenús.
* Organigramas empresariales.
* Categorías y subcategorías.
* Comentarios y respuestas en redes sociales.

## ▶️ Cómo ejecutar

1. Abrir el proyecto en VS Code o cualquier IDE Java.
2. Navegar a la carpeta:

```composite
src/
```

3. Ejecutar la clase:

```java
Main.java
```

4. Verificar la salida en consola.


## ✅ Ventajas

* Permite tratar objetos simples y grupos de objetos de la misma forma.
* Facilita la creación de estructuras jerárquicas.
* Reduce el uso de condicionales.
* Permite agregar nuevos tipos de objetos fácilmente.

## ❌ Desventajas

* Puede aumentar la cantidad de clases del proyecto.
* Algunas operaciones pueden no tener sentido para todos los objetos.
* Requiere diseñar correctamente la estructura de clases.


