# State

**Categoría:** De comportamiento 🟡 · **Responsable:** Esteban663

## 📌 Problema
Un sistema de logística de transporte necesita gestionar los estados de cada ruta o autobús (EnEspera, Abordando, EnTránsito, Mantenimiento). El comportamiento del sistema de taquilla (venta de tiquetes, modificación de asientos) cambia drásticamente según el estado actual. Implementar esto con condicionales (`if`/`switch`) provocaría código monolítico, difícil de mantener y extender ante nuevos estados.

## 💡 Solución
Aplicamos el patrón State. Extraemos los comportamientos específicos de cada estado a clases separadas que implementan una interfaz común. El contexto (`Ruta`) delega en el objeto estado actual, eliminando condicionales y facilitando añadir nuevos estados sin modificar el contexto ni los estados existentes.

## 🧭 Estructura / Diagrama
classDiagram
    class Ruta {
        - String nombre
        - Estado estadoActual
        - int asientosDisponibles
        + Ruta(String, int)
        + void venderTicket(int)
        + void modificarAsiento(int)
        + void iniciarAbordaje()
        + void iniciarViaje()
        + void llegarDestino()
        + void ingresarMantenimiento()
        + void finalizarMantenimiento()
        + int getAsientosDisponibles()
        + void setAsientosDisponibles(int)
        + String getNombre()
        + void setEstado(Estado)  // package-private
    }

    class Estado {
        <<interface>>
        + void venderTicket(Ruta, int)
        + void modificarAsiento(Ruta, int)
        + void iniciarAbordaje(Ruta)
        + void iniciarViaje(Ruta)
        + void llegarDestino(Ruta)
        + void ingresarMantenimiento(Ruta)
        + void finalizarMantenimiento(Ruta)
        + String getNombre()
    }

    class EnEspera {
        + void venderTicket(Ruta, int)
        + void modificarAsiento(Ruta, int)
        + void iniciarAbordaje(Ruta)
        + void iniciarViaje(Ruta)
        + void llegarDestino(Ruta)
        + void ingresarMantenimiento(Ruta)
        + void finalizarMantenimiento(Ruta)
        + String getNombre()
    }

    class Abordando {
        + void venderTicket(Ruta, int)
        + void modificarAsiento(Ruta, int)
        + void iniciarAbordaje(Ruta)
        + void iniciarViaje(Ruta)
        + void llegarDestino(Ruta)
        + void ingresarMantenimiento(Ruta)
        + void finalizarMantenimiento(Ruta)
        + String getNombre()
    }

    class EnTransito {
        + void venderTicket(Ruta, int)
        + void modificarAsiento(Ruta, int)
        + void iniciarAbordaje(Ruta)
        + void iniciarViaje(Ruta)
        + void llegarDestino(Ruta)
        + void ingresarMantenimiento(Ruta)
        + void finalizarMantenimiento(Ruta)
        + String getNombre()
    }

    class Mantenimiento {
        + void venderTicket(Ruta, int)
        + void modificarAsiento(Ruta, int)
        + void iniciarAbordaje(Ruta)
        + void iniciarViaje(Ruta)
        + void llegarDestino(Ruta)
        + void ingresarMantenimiento(Ruta)
        + void finalizarMantenimiento(Ruta)
        + String getNombre()
    }

    Ruta --> Estado : estadoActual
    Estado <|.. EnEspera
    Estado <|.. Abordando
    Estado <|.. EnTransito
    Estado <|.. Mantenimiento

## 🧪 Ejemplo de uso
- Una ruta en `EnEspera` permite vender tickets y modificar asientos.
- Al cambiar a `Abordando`, se permiten ventas de últimos tickets.
- En `EnTránsito` el sistema bloquea automáticamente cualquier venta o modificación.
- En `Mantenimiento` todas las operaciones de venta están prohibidas hasta finalizar.

## ▶️ Cómo ejecutar
1. Asegúrate de tener JDK 8+.
2. Clona o descarga la carpeta `state/`.
3. Compila:
        java.exe' -cp bin Logistica

## 🗂️ Estructura de la carpeta
state/
├── README.md
├── src/
│   └── transporte/
│       ├── Estado.java
│       ├── Ruta.java
│       ├── EnEspera.java
│       ├── Abordando.java
│       ├── EnTransito.java
│       └── Mantenimiento.java
├── demo/
│   └── Logistica.java
├── diagramas/ 
    └── Diagrama_UML.png
