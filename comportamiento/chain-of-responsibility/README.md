# Chain of Responsibility

**Categoría:** De comportamiento 🟡 · **Responsable:** Manuela Jaramillo

## 📌 Problema
En muchos sistemas una solicitud puede ser atendida por diferentes personas u objetos dependiendo de su tipo o nivel de complejidad. Sin este patrón, sería necesario utilizar múltiples estructuras condicionales (if o switch) para decidir quién debe procesar cada solicitud, haciendo que el código sea difícil de mantener y ampliar.

## 💡 Solución
El patrón Chain of Responsibility propone crear una cadena de objetos responsables. Cada objeto recibe una solicitud y decide si puede procesarla. Si no puede hacerlo, la envía al siguiente objeto de la cadena hasta que alguno la atienda.

De esta forma se reduce el acoplamiento entre quien envía la solicitud y quien finalmente la procesa.

## 🧭 Estructura / Diagrama
En este ejemplo se implementó una cadena de soporte técnico:

Solicitud
    ↓
Soporte Nivel 1
    ↓
Soporte Nivel 2
    ↓
Gerente

Clases principales:

*Handler: clase abstracta que define la estructura de la cadena.
*LevelOneSupport: atiende solicitudes de prioridad baja.
*LevelTwoSupport: atiende solicitudes de prioridad media.
*Manager: atiende solicitudes de prioridad alta.
*Request: representa la solicitud realizada.
*Demo: demuestra el funcionamiento del patrón.

## 🧪 Ejemplo de uso
Una empresa recibe solicitudes de soporte técnico.

*Las solicitudes de prioridad baja son atendidas por Soporte Nivel 1.
*Las solicitudes de prioridad media son atendidas por Soporte Nivel 2.
*Las solicitudes de prioridad alta son escaladas al Gerente.

Cada responsable decide si puede resolver el problema o si debe enviarlo al siguiente nivel.

## ▶️ Cómo ejecutar
1. Abrir el proyecto en Visual Studio Code.
2. Ubicarse en la carpeta chain-of-responsibility.
3. Ejecutar la clase Demo.java.
4. Observar cómo las solicitudes son procesadas por diferentes responsables según su prioridad.

Salida esperada:

Solicitud de prioridad BAJA:
Soporte Nivel 1 resolvió la solicitud.

Solicitud de prioridad MEDIA:
Soporte Nivel 2 resolvió la solicitud.

Solicitud de prioridad ALTA:
El gerente resolvió la solicitud.

## 🗂️ Estructura de la carpeta
```
chain-of-responsibility/ 
├── README.md 
├── src/ 
│ ├── handlers/
│ ├── model/
│ └── Demo/
├── examples/
├── diagrams/
└── tests/
