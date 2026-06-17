# Builder

**Categoría:** Creacional 🟣 · **Responsable: Maria de los Angeles García Giraldo**

## 📌 Problema
_Describe el problema que resuelve este patrón (¿por qué existe?)._

_Imagina que necesitas crear un objeto complejo que requiere una sincronización laboriosa de muchos campos y objetos anidados._
_Si intentas usar un constructor tradicional, terminarás con un "Constructor Monstruoso" const auto = new Automovil("V8", 4, true, false, "Rojo", true, false, true);_

## 💡 Solución
_Explica cómo lo resuelve._

_El patrón Builder propone extraer el código de construcción del objeto fuera de su propia clase y colocarlo en objetos independientes llamados Builders.La construcción del objeto se realiza paso a paso mediante una interfaz fluida. El objeto final no se extrae hasta que no se ejecutan todos los pasos necesarios, llamando a un método final (usualmente .build())_

## 🧭 Estructura / Diagrama
_Agrega aquí el diagrama UML o la estructura de clases._

## 🧪 Ejemplo de uso

_Vamos a modelar la fabricación de una Computadora Personalizada (PC Gaming / Oficina). Una PC puede tener CPU, RAM, Almacenamiento, Tarjeta Gráfica dedicada, Sistema de refrigeración líquida, etc. No todas las PCs necesitan tarjeta gráfica dedicada o refrigeración líquida, por lo que el Builder es perfecto_

## ▶️ Cómo ejecutar
_npm install_
_npm run demo_
_Para que las instrucciones de arriba funcionen, necesitamos crear un archivo `package.json` **dentro de tu carpeta** De esta forma, tu entorno queda aislado y no interfieres con los patrones de tus compañeros._
_Crea el archivo `creacionales/builder/package.json`_

## 🗂️ Estructura de la carpeta

```
builder/
├── README.md
├── package.json
├── tsconfig.json
├── jest.config.js
├── src/
│   ├── Computer.ts                 # Producto (inmutable)
│   ├── IComputerBuilder.ts         # Interfaz Builder
│   ├── BaseComputerBuilder.ts      # Clase abstracta base
│   ├── GamingComputerBuilder.ts    # ConcreteBuilder gaming
│   └── OfficeComputerBuilder.ts    # ConcreteBuilder oficina
│   └── Director.ts                 # Director con recetas
├── examples/
│   └── demo.ts
└── tests/
    └── builder.test.ts
```