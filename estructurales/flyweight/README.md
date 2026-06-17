# Flyweight

**Categoría:** Estructural 🟢 · **Responsable:** _Victor Manuel Fernandez Valencia_

## 📌 Problema

Este patron de diseño resuelve el problema de cargar muchas instancias de un objeto en memoria,
los cuales tengan atributos iguales lo cual hace que se sature la memoria RAM.

Cuando se crean miles de objetos de forma continua (por ejemplo, partículas en una animación), cada instancia ocupa espacio en memoria con todos sus atributos. Si muchos de esos objetos comparten datos idénticos (como el color y el tamaño), se desperdicia memoria RAM almacenando la misma información repetida cientos o miles de veces.

En este proyecto, al mover el mouse se generan **20 partículas por frame**, y cada una podría tener solo 5 colores distintos y 4 tamaños posibles, lo que da un máximo de **20 combinaciones únicas**. Sin el patrón Flyweight, cada una de las miles de partículas almacenaría su propio objeto con color y radio, duplicando datos innecesariamente.

## 💡 Solución

Para solucionar el problema este patron propene crear una clase **Flyweight** la cual va a contener
los atributos que no cambien o que sean inmutables y muy pesados para que haci la clase que tenga los atributos
cambiantes sea mas ligera y no carge tanto peso, para esto se debe de crear una clase **Factory** la cual se va a
encargar de dar los datos de las instancias pesadas que guardan los atrubutos inmutables.

El patrón **Flyweight** separa el estado de un objeto en dos partes:

| Tipo de estado                     | Descripción                                                                            | Clase que lo maneja    |
| ---------------------------------- | --------------------------------------------------------------------------------------- | ---------------------- |
| **Intrínseco** (compartido) | Datos que no cambian:`color`, `radio`                                               | `ParticulaFlyweight` |
| **Extrínseco** (único)     | Datos que cambian por partícula:`x`, `y`, `velocidadX`, `velocidadY`, `vida` | `ParticulaContexto`  |

La clase `ParticulaFlyweight` encapsula los datos compartidos y es reutilizada por múltiples partículas al mismo tiempo. La clase `ParticulaFabrica` actúa como caché: si ya existe un flyweight con una combinación `color-radio` determinada, lo retorna sin crear uno nuevo.

De esta forma, en lugar de tener 2000 objetos con datos repetidos, el sistema mantiene solo **hasta 20 flyweights únicos** independientemente de cuántas partículas haya en pantalla.

## 🧭 Estructura / Diagrama

```
┌─────────────────────────────────┐
│         ParticulaFlyweight      │
│─────────────────────────────────│
│ - color : string                │
│ - radio : number                │
│─────────────────────────────────│
│ + dibujar(ctx, x, y, opacity)   │
└──────────────┬──────────────────┘
               │ usa (referencia compartida)
               │
┌──────────────┴──────────────────┐        ┌──────────────────────────────┐
│        ParticulaContexto        │        │       ParticulaFabrica       │
│─────────────────────────────────│        │──────────────────────────────│
│ - x : number                    │        │ - particulaTipos : Map        │
│ - y : number                    │        │   <String, ParticulaFlyweight>│
│ - velocidadX : number           │        │──────────────────────────────│
│ - velocidadY : number           │        │ + obtenerTipoParticula(       │
│ - vida : number                 │        │     color, radio)            │
│ - vidaMaxima : number           │        │ + contar() : number          │
│ - tipoParticula: Flyweight      │        └──────────────┬───────────────┘
│─────────────────────────────────│                       │ crea/cachea
│ + actualizar() : void           │                       │
│ + dibujar(ctx) : void           │        ┌──────────────┴───────────────┐
│ + estaMuerta() : boolean        │        │       SistemaParticulas      │
└─────────────────────────────────┘        │──────────────────────────────│
               ▲                           │ - particulas: ParticulaCtx[] │
               │ contiene lista de         │ - fabrica: ParticulaFabrica  │
               └───────────────────────────│──────────────────────────────│
                                           │ + crearParticulas(x, y)      │
                                           │ + actualizar()               │
                                           │ + dibujar(ctx)               │
                                           └──────────────┬───────────────┘
                                                          │ orquesta
                                                          │
                                           ┌──────────────┴───────────────┐
                                           │             App              │
                                           │──────────────────────────────│
                                           │ + canvas, ctx                │
                                           │ + sistemaParticulas          │
                                           │ + resizeCanvas()             │
                                           │ + actualizarMetricas()       │
                                           │ + animate()                  │
                                           └──────────────────────────────┘
```

## 🧪 Ejemplo de uso

### Mundo real: Procesadores de texto

Un editor de texto como Microsoft Word puede tener millones de caracteres en un documento. Cada carácter (la letra "a") comparte la misma fuente, tamaño y estilo con cientos de otras letras iguales. En lugar de duplicar esos datos en cada objeto-carácter, el patrón Flyweight mantiene un único objeto con el estilo compartido y cada carácter solo guarda su posición en el documento.

### En este proyecto

```javascript
// SistemaParticulas.js — crearParticulas()

// En lugar de crear un nuevo objeto con color y radio por cada partícula:
// ❌ Sin Flyweight
const particula = new Particula(x, y, vx, vy, vida, color, radio); // datos duplicados

// ✅ Con Flyweight: la fábrica reutiliza el flyweight si ya existe
const flyweight = this.fabrica.obtenerTipoParticula(color, radius);
//   → internamente hace: key = "color-radio"
//   → si ya existe en el Map, lo retorna directamente (sin crear nada nuevo)
//   → si no existe, crea uno nuevo y lo guarda

const particula = new ParticulaContexto(x, y, vx, vy, vida, flyweight);
//   → la partícula no guarda color ni radio propios
//   → simplemente referencia al flyweight compartido
```

Con **20 colores × 4 tamaños = 20 combinaciones posibles**, el sistema nunca superará los **20 flyweights** en memoria, aunque haya 5000 partículas activas simultáneamente en pantalla.

## ▶️ Cómo ejecutar

Abre `index.html` directamente en el navegador, o usando las extensiones **Live Server** o **Live Preview** de VS Code.

Una vez abierto, **mueve el mouse** sobre el canvas para generar partículas y observa las métricas en tiempo real.

## 🗂️ Estructura de la carpeta

```
flyweight/
├── README.md
├── examples/
├   └── Particulas.html             # ejemplo sin implementacion del patron
├── src/
├   ├── clases/
├   ├   ├── App.js                  # Loop de animación y eventos del mouse
├   ├   ├── SistemaParticulas.js    # Orquesta creación, actualización y dibujado
├   ├   ├── ParticulaContexto.js    # Estado extrínseco (posición, velocidad, vida)
├   ├   ├── ParticulaFlyweight.js   # Estado intrínseco compartido (color, radio)
├   ├   └── ParticulaFabrica.js     # Caché de flyweights (Map<string, Flyweight>)
├   ├── css/
├   ├   └── styles.css		    # estilos del html
├   ├── html/
├   ├   └── index.html		    # pagina html donde se muestra el proyecto
├── tests/
```
