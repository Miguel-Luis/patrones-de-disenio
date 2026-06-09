# 💬 Patrón de Diseño: Mediator (Mediador)

## 📌 Nombre y Categoría del Patrón
* **Nombre:** Mediator (Mediador)
* **Categoría:** Patrón de Comportamiento (Behavioral Pattern)
* **Patrón Adicional Aplicado:** Modelo-Vista-Controlador (MVC) para la arquitectura de la interfaz gráfica.

---

## 🚨 Problema que resuelve (¿Por qué existe?)
En sistemas complejos donde múltiples objetos necesitan interactuar entre sí (por ejemplo, múltiples usuarios en una sala de chat), la comunicación directa entre ellos genera un **acoplamiento fuerte** (código espagueti). Si la "Clase A" tiene que conocer directamente a la "Clase B", "Clase C" y "Clase D" para enviarles un mensaje, el sistema se vuelve casi imposible de mantener, escalar o modificar. Si un usuario se desconecta o cambia, habría que actualizar el código de todos los demás usuarios.

---

## ✅ Solución que propone (¿Cómo lo resuelve?)
El patrón Mediator propone **restringir las comunicaciones directas** entre los objetos y obligarlos a colaborar únicamente a través de un objeto "Mediador". 

En lugar de que los usuarios se envíen mensajes entre sí, todos envían sus mensajes al `Mediator`. El mediador contiene la lógica para enrutar y distribuir esos mensajes a los destinatarios correctos. De esta forma, los objetos `User` son completamente independientes entre sí; solo necesitan conocer la existencia del Mediador.

---
## 🌍 Ejemplos del Mundo Real

### ✈️ Torre de Control del Aeropuerto

Los aviones no se comunican directamente entre sí para decidir quién aterriza primero. En cambio, se comunican con la **Torre de Control (Mediador)**, que coordina el uso de las pistas y el orden de aterrizaje.

### 💬 Sistemas de Chat (Nuestra Aplicación)

Aplicaciones como **WhatsApp** o **Discord** no conectan tu teléfono directamente con el de tu amigo. Tu dispositivo envía el mensaje a un **servidor central (Mediador)**, y el servidor lo reenvía al destinatario.

### 🏠 Sistemas de Hogar Inteligente

Un botón inteligente no está programado para encender una bombilla específica directamente. En cambio, notifica al **Concentrador Central (Mediador)** que se ha pulsado, y el concentrador decide qué dispositivos deben reaccionar (luces, persianas, alarmas, etc.).

---

# 🚀 Ejecución de la demo

## Requisitos previos

- Kit de desarrollo de Java (JDK 8 o superior) instalado.

- Un editor de código o IDE como:

- VS Code

- IntelliJ IDEA

- Eclipse
- O acceso a una terminal/línea de comandos.

--

## Compilación y ejecución

### 1. Clonar o descargar el repositorio

Clonar o descargar el repositorio en su equipo local.

### 2. Navega al directorio del proyecto

Abre una terminal y navega al directorio raíz del proyecto:

```bash
cd src
```

### 3. Compila el proyecto

Compila todos los archivos Java:

```bash
javac src/**/*.java
```

### 4. Ejecuta la aplicación

Ejecuta la clase `Main`:

```bash
java src.examples.Main
```

---

## 🖥️ Uso de la demo

Después de ejecutar la aplicación:

1. Aparecerán tres ventanas:

- Lorena

- Carlos

- Daniel

2. Escribe un mensaje en la ventana de cualquier usuario.

3. Pulsa el botón **Enviar** o la tecla **Intro**.

4. Observa cómo el **Mediador** intercepta el mensaje y lo distribuye a los demás usuarios.

5. El **Controlador** actualiza automáticamente cada interfaz gráfica, asegurando que todos los participantes reciban el mensaje.

--

## 🏗️ Roles del Patrón en este Proyecto

### Mediador

Coordina la comunicación entre usuarios y evita dependencias directas entre ellos.

### Compañeros (Usuarios)

Representan a los participantes del chat. Se comunican únicamente a través del mediador.

### Controlador

Gestiona las interacciones del usuario y actualiza la vista.

### Vista (Capa de Usuario)

Responsable de mostrar los mensajes y recopilar la información del usuario.

### Modelo (Usuario)

Contiene la lógica de negocio de la aplicación y los datos del usuario.

--

## 📌 Beneficios del Patrón Mediador

- Reduce el acoplamiento entre objetos.

- Centraliza la lógica de comunicación.

- Mejora la mantenibilidad.

- Facilita la extensión del sistema.

- Simplifica la gestión de la interacción entre múltiples componentes.


## 🏗️ Estructura de Clases

Nuestra implementación separa claramente la lógica de negocio (Model) de la interfaz gráfica (View) utilizando un Controlador, mientras el Mediador maneja la red.

```mermaid
classDiagram
    class Mediator {
        <<interface>>
        +sendmessage(user: User, message: String)
        +addUser(user: User)
    }

    class MediadorImplement {
        -List~User~ users
        +sendmessage(user: User, message: String)
        +addUser(user: User)
    }

    class MessageListener {
        <<interface>>
        +onMessageReceived(message: String)
    }

    class User {
        <<abstract>>
        #id: int
        #name: String
        #mediator: Mediator
        +send(message: String)*
        +receive(message: String)*
    }

    class UserImpl {
        -listener: MessageListener
        +send(message: String)
        +receive(message: String)
        +setMessageListener(listener: MessageListener)
    }

    class UserController {
        -model: UserImpl
        -view: UserLayer
        +onMessageReceived(message: String)
        -handleSend()
    }

    class UserLayer {
        -chatArea: JTextArea
        -inputfield: JTextField
        +SetGUI(user: User)
        +displayMessage(message: String)
    }

    %% Network relationships
    Mediator <|.. MediadorImplement : implements
    User <|-- UserImpl : extends
    UserImpl --> Mediator : uses
    MediadorImplement "1" o-- "*" User : manages >

    %% The new Observer Pattern connections
    MessageListener <|.. UserController : implements
    UserImpl --> MessageListener : notifies >

    %% Controller acting on the MVC components
    UserController --> UserImpl : acts on (Model)
    UserController --> UserLayer : acts on (View)






