# Facade

**Categoría:** Estructural 🟢 · **Responsable:** _John Deivid Sanchez Hoyos_

## 📌 Problema
_En el desarrollo de software, a medida que un sistema crece, tiende a dividirse en múltiples subsistemas o librerías complejas. Para realizar una tarea simple, el código cliente (el que usa estas librerías) a menudo tiene que interactuar directamente con decenas de clases, configurar objetos, manejar dependencias y entender el orden exacto en el que deben ejecutarse los métodos._

Esto genera varios inconvenientes:
* **Alto acoplamiento:** El cliente se vuelve fuertemente dependiente de la estructura interna y de la implementación de los subsistemas. Si algo cambia en el subsistema, el código cliente se rompe.
* **Dificultad de uso:** Aprender a usar un sistema complejo requiere una curva de aprendizaje alta para otros desarrolladores.
* **Código repetitivo y sucio:** Se termina duplicando el código de inicialización y configuración en diferentes partes de la aplicación.

## 💡 Solución
_El patrón **Facade** resuelve este problema proporcionando una **interfaz unificada, simplificada y de alto nivel** que sirve como un único punto de acceso a un conjunto de interfaces o clases de un subsistema más complejo._

_En lugar de obligar al cliente a interactuar directamente con un "bosque" de clases, la Fachada expone solo los métodos estrictamente necesarios para cumplir con los casos de uso más comunes._ 

> **Nota:** La fachada no oculta por completo el subsistema. Si un desarrollador necesita una funcionalidad avanzada o un control más granular, aún puede acceder directamente a las clases subyacentes._

## 🧭 Estructura / Diagrama
_El patrón se compone principalmente de:_
1. **Fachada (Facade):** Conoce qué clases del subsistema son responsables de una petición y delega el trabajo de manera ordenada.
2. **Subsistemas Complejos (Subsystems):** El conjunto de clases que realizan el trabajo real. No conocen la existencia de la Fachada.
3. **Cliente (Client):** Utiliza la Fachada en lugar de llamar directamente a los subsistemas.

```mermaid
graph TD
    Demo[Demo <br><i>Código cliente: Alto nivel</i>] 
    --> HomeTheaterFacade[HomeTheaterFacade <br><i>La Fachada Simplificada</i>]

    HomeTheaterFacade --> LucesTenues[LucesTenues]
    HomeTheaterFacade --> Proyector[Proyector]
    HomeTheaterFacade --> SistemaAudio[SistemaAudio]
    
    style Demo fill:#f9f,stroke:#333,stroke-width:2px
    style HomeTheaterFacade fill:#bbf,stroke:#333,stroke-width:2px
    ```

> **Nota:** El diagrama UML se encuentra en facade/diagrams

## 🧪 Ejemplo de uso
_Imagina que quieres armar un sistema de Cine en Casa (Home Theater). Para ver una película, normalmente tendrías que hacer todo esto manualmente en tu código:._

* Encender las luces de la sala y atenuarlas al 10%.
* Encender la máquina de palomitas de maíz y ponerla a cocinar.
* Encender el proyector y configurar la entrada HDMI.
* Encender el amplificador de sonido y subir el volumen.
* Reproducir la película.

_Con el patrón **Facade**, creas una clase llamada **HomeTheaterFacade** que expone 2 únicos métodos: **comenzarPelicula("Batman: The Dark Knight Rises")** y **terminarPelicula()**. Por dentro, la fachada se encarga de hablar con las luces, la máquina de palomitas, el proyector, el sistema de audio y el reproductor de video en el orden correcto. Cuando termina la función, el método **terminarPelicula()** apaga todo con una sola línea de código desde el cliente (Demo.java)._

## ▶️ Cómo ejecutar
Simplemente abre el archivo Demo.java dentro de la carpeta estructurales/facade/examples/ y haz clic en el botón Run ▶️ que proporciona tu entorno de desarrollo.

## 🗂️ Estructura de la carpeta
```
facade/
├── README.md
├── src/                           # Código fuente
    ├── HomeTheaterFacade.java     # Fachada
    └── subsystems/                # Subsistemas complejos
        ├── LucesTenues.java
        ├── MaquinaPalomitas.java
        ├── Proyector.java
        ├── ReproductorVideo.java
        ├── SistemaAudio.java

├── examples/                      # Ejemplo de uso
    └── Demo.java                  # Cliente 
├── diagrams/                      # UML
    └──TeatroEnCasa.jpg                     
```
