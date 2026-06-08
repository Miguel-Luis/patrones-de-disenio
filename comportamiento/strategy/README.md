# Strategy

**Categoría:** De comportamiento 🟡 · **Responsable:** david florez

## 📌 Problema
Cuando el comportamiento de un objeto puede cambiar en tiempo de ejecución, conviene separar las reglas específicas en clases independientes.

Por ejemplo, una aplicación de comercio electrónico puede aceptar distintos métodos de pago: tarjeta, PayPal, criptomonedas, etc. Si mezclamos todas las reglas de pago en una sola clase, el código se vuelve difícil de mantener.

## 💡 Solución
El patrón Strategy define una familia de algoritmos o comportamientos intercambiables y encapsula cada uno en una clase independiente.

- Se crea una interfaz común (`PaymentStrategy`).
- Cada estrategia concreta implementa esa interfaz (`CreditCardPayment`, `PayPalPayment`, `CryptoPayment`).
- El contexto (`Order`) utiliza la estrategia disponible y puede cambiarla dinámicamente.

Así el contexto no necesita conocer los detalles de cada algoritmo, solo delega el comportamiento en la estrategia actual.

## 🧭 Estructura / Diagrama
```
PaymentStrategy (interface)
├── CreditCardPayment
├── PayPalPayment
└── CryptoPayment

Order (contexto)
- payment_strategy: PaymentStrategy
- checkout()
```

## 🧪 Ejemplo de uso
Un sistema de pagos en línea puede cambiar el método de pago según lo seleccione el usuario:
- Al principio se paga con tarjeta de crédito.
- Después se cambia a PayPal.
- Finalmente se prueba con criptomonedas.

El `Order` mantiene el comportamiento y el usuario puede cambiar la estrategia sin modificar la clase del pedido.

## ▶️ Cómo ejecutar
1. Abre una terminal en `comportamiento/strategy`.
2. Ejecuta:

```bash
java examples/demo.py
```

3. Verás la salida con los tres métodos de pago:

- Pago con tarjeta de crédito.
- Pago con PayPal.
- Pago con criptomoneda.


## 🗂️ Estructura de la carpeta
```
strategy/
├── README.md
├── src/        # Código fuente
│   └── strategy.py
├── examples/   # Ejemplo(s) de uso
│   └── demo.py
├── diagrams/   # (Opcional) UML
└── tests/      # (Opcional) pruebas
```
