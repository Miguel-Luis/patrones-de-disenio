<div align="center">

# 🎨 Patrones de Diseño

### Proyecto colaborativo · Arquitectura de Software Empresarial

_Un patrón de diseño por estudiante. Un repositorio limpio, ordenado y fácil de mantener._

![Patrones](https://img.shields.io/badge/Patrones-22-6C5CE7?style=for-the-badge)
![Categorías](https://img.shields.io/badge/Categorías-3-00B894?style=for-the-badge)
![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-FDCB6E?style=for-the-badge)

</div>

---

## 📌 ¿De qué trata este proyecto?

Este repositorio reúne la implementación de los **patrones de diseño** clásicos (basados en el catálogo de la *Gang of Four*). El objetivo es que cada estudiante **se haga responsable de desarrollar un patrón** de principio a fin: su explicación, su implementación y un ejemplo de uso.

> 🎯 **Regla de oro:** cada quien es dueño de su patrón. La calidad, el orden y la claridad de su carpeta son responsabilidad de quien la desarrolla.

---

## ⬇️ Clonar el repositorio

Para descargar el proyecto en tu computador, ejecuta:

```bash
git clone https://github.com/Miguel-Luis/patrones-de-disenio.git
```

---

## 👥 Asignación: un estudiante, un patrón

- Cada estudiante elige (o recibe) **un único patrón de diseño**.
- Trabaja **exclusivamente dentro de la carpeta de ese patrón**, sin tocar el trabajo de los demás.
- Es responsable de que su carpeta esté **completa, documentada y funcional**.

Así evitamos conflictos, mantenemos el repositorio ordenado y cada contribución es fácil de identificar y evaluar.

### 👫 Distribución: 24 estudiantes, 22 patrones

Como somos **24 estudiantes** y hay **22 patrones**, los números cuadran así:

- **20 patrones** se desarrollan de forma **individual** (1 estudiante cada uno).
- **2 patrones** se desarrollan **en pareja** (2 estudiantes cada uno), cubriendo a los 4 estudiantes restantes.

Las dos parejas se asignan a los patrones más extensos y complejos:

| Patrón | Modalidad |
| --- | --- |
| **Visitor** (`comportamiento/visitor`) | 👫 Pareja |
| **Abstract Factory** (`creacionales/abstract-factory`) | 👫 Pareja |
| _Todos los demás_ | 👤 Individual |

> 🤝 **Para las parejas:** comparten **una sola rama**, **una sola carpeta** y abren **un único Pull Request** hacia `develop`. En la columna _Responsable_ anotan **los dos nombres** separados por coma.

#### 🧑‍🤝‍🧑 Cómo trabaja una pareja

Aunque compartan una sola rama y una sola carpeta, **pueden distribuirse el trabajo** entre los dos. La idea es que **cada uno trabaje desde su propio computador**:

- Se ponen de acuerdo para repartir las tareas dentro del patrón.
- Si uno necesita que el otro use sus avances, **sube sus cambios a la rama** sin ningún problema:

```bash
git add .
git commit -m "feat: avance del patrón"
git push origin feature/nombre-rama
```

- El compañero **descarga esos cambios** con:

```bash
git pull
```

- Al final, **solo uno de los dos** abre el **Pull Request** hacia `develop`.

---

## 🧩 Categorías y patrones disponibles

El repositorio organiza los patrones en las **tres familias** clásicas:

### 🟣 Creacionales
> Se ocupan de **cómo se crean los objetos**.

| Patrón | Carpeta | Responsable |
| --- | --- | --- |
| Abstract Factory | `creacionales/abstract-factory` | _por asignar_ |
| Builder | `creacionales/builder` | _por asignar_ |
| Factory Method | `creacionales/factory-method` | _por asignar_ |
| Prototype | `creacionales/prototype` | _por asignar_ |
| Singleton | `creacionales/singleton` | _por asignar_ |

### 🟢 Estructurales
> Se ocupan de **cómo se componen las clases y objetos** en estructuras más grandes.

| Patrón | Carpeta | Responsable |
| --- | --- | --- |
| Adapter | `estructurales/adapter` | _por asignar_ |
| Bridge | `estructurales/bridge` | _por asignar_ |
| Composite | `estructurales/composite` | _por asignar_ |
| Decorator | `estructurales/decorator` | _por asignar_ |
| Facade | `estructurales/facade` | _por asignar_ |
| Flyweight | `estructurales/flyweight` | _por asignar_ |
| Proxy | `estructurales/proxy` | Juan Pablo Ramírez González |

### 🟡 De comportamiento
> Se ocupan de **cómo se comunican y colaboran** los objetos entre sí.

| Patrón | Carpeta | Responsable |
| --- | --- | --- |
| Chain of Responsibility | `comportamiento/chain-of-responsibility` | _por asignar_ |
| Command | `comportamiento/command` | _Samuel Murillo_ |
| Iterator | `comportamiento/iterator` | _por asignar_ |
| Mediator | `comportamiento/mediator` | _por asignar_ |
| Memento | `comportamiento/memento` | _por asignar_ |
| Observer | `comportamiento/observer` | _por asignar_ |
| State | `comportamiento/state` | _por asignar_ |
| Strategy | `comportamiento/strategy` | _por asignar_ |
| Template Method | `comportamiento/template-method` | _por asignar_ |
| Visitor | `comportamiento/visitor` | _por asignar_ |

> ✍️ Cuando tomes un patrón, reemplaza _por asignar_ con tu nombre en la tabla correspondiente.

---

## 🗂️ Estructura interna de cada carpeta

La estructura debe ser **clara, fácil de mantener y lógica**: agrupa las cosas por lo que son y por lo que hacen. Un compañero (o el profesor) debería entender tu carpeta **sin tener que preguntarte nada**.

```
<categoria>/<nombre-del-patron>/
├── README.md          # Qué es el patrón, cuándo usarlo y cómo correr tu ejemplo
├── src/               # Código fuente del patrón (clases / interfaces)
│   ├── ...
│   └── ...
├── examples/          # Ejemplo(s) de uso del patrón en acción
│   └── demo.*
├── diagrams/          # (Opcional) diagrama UML o imagen explicativa
│   └── uml.*
└── tests/             # (Opcional) pruebas que validan el comportamiento
    └── ...
```

### ✅ Principios para una buena estructura

1. **Agrupa por responsabilidad.** El código va en `src/`, los ejemplos en `examples/`, las pruebas en `tests/`. No mezcles todo en la raíz.
2. **Nombres claros y consistentes.** Usa nombres descriptivos en minúsculas con guiones (`factory-method`, no `FM` ni `pat1`).
3. **Un solo idioma de nombres.** Mantén coherencia: si nombras en inglés los archivos de código, hazlo en todos.
4. **Cada carpeta tiene su propio `README.md`** explicando el patrón y cómo ejecutarlo.
5. **Nada de archivos sueltos sin sentido.** Si algo no aporta, no va en el repositorio.

---

## 📝 Qué debe contener tu `README.md` de patrón

Para que tu entrega esté completa, incluye al menos:

- **Nombre y categoría** del patrón.
- **Problema** que resuelve (¿por qué existe?).
- **Solución** que propone (¿cómo lo resuelve?).
- **Diagrama o estructura** de clases.
- **Ejemplo de uso** del mundo real.
- **Instrucciones** para ejecutar tu demo.

---

## 🚀 Cómo contribuir

Trabajamos con un flujo basado en ramas a partir de **`develop`**. Cada patrón vive en su propia rama, así nunca se pisa el trabajo de los demás.

1. **Crea tu rama desde GitHub** con el nombre de tu patrón, asegurándote de que **salga de la rama `develop`** (no de `main`). El nombre de la rama **debe empezar por `feature/`**, seguido del nombre del patrón (por ejemplo, `feature/singleton`).
2. **Descarga tu rama** en tu equipo:

```bash
git fetch && git checkout feature/nombre-rama
```

3. Ubica la carpeta de **tu** patrón dentro de su categoría y desarrolla tu código siguiendo la estructura sugerida arriba.
4. Documenta todo en el `README.md` de tu carpeta y anota tu nombre en la tabla de este README.
5. Revisa que **solo modificaste tu carpeta** antes de entregar.
6. **Sube tus cambios** al repositorio:

```bash
git add .
git commit -m "feat: implementa el patrón nombre-rama"
git push origin feature/nombre-rama
```

7. **Solicita un Pull Request** de tu rama hacia **`develop`** para integrar tu código.

> 🔀 Toda rama debe iniciar con el prefijo `feature/`. Reemplaza `nombre-rama` por el nombre real de tu patrón (por ejemplo, `feature/singleton` o `feature/factory-method`).

---

<div align="center">

_Mantener el orden no es opcional: un repositorio limpio refleja un equipo profesional._ 🧹✨

</div>
