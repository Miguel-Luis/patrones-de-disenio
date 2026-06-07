# Proxy

**Categoría:** Estructural 🟢 · **Responsable:** Juan Pablo Ramírez González

## 📌 Problema
El patrón Proxy resuelve un problema fundamental en el diseño de software: cómo controlar el acceso a un objeto complejo, costoso o sensible sin cambiar la forma en que los clientes interactúan con él.

## 💡 Solución
El patrón Proxy resuelve esto introduciendo un intermediario (el Proxy) que se hace pasar por el objeto real. Engaña al cliente implementando su misma interfaz, intercepta todas las llamadas y decide qué hacer con ellas.

## 🧭 Estructura / Diagrama
Esta en la carpeta.

## 🧪 Ejemplo de uso
Si estamos desarrollando una aplicación como Instagram, y al abrir la app descarga todas las fotos que ha subido un usuario, esta se vería gravemente ralentizada, pero si se usan Proxys en su lugar para remplazar las fotos que no han cargado, y descargarlas poco a poco mejorara el rendimiento.

## ▶️ Cómo ejecutar
Para ejecutar esta demo, debes oprimir el botón Run Java arriba a la derecha de tu pantalla.

## Aclaración
En este caso se esta devolviendo un solo objeto por motivos de claridad, pero normalmente se suelen devolver listas o diccionarios.

## 🗂️ Estructura de la carpeta
```
proxy/
├── README.md
├── src/        # Código fuente
├── examples/   # Ejemplo(s) de uso
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
