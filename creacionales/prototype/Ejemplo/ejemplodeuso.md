## Ejemplo de uso

## Escenario

Una tienda de tecnología ofrece computadores
con configuraciones base para diferentes tipos
de usuarios (Gamer y Oficina).

Inicialmente, el sistema ya cuenta con estos prototipos preconfigurados. 
Cuando un cliente realiza un pedido, no se crea el computador desde cero,
sino que se clona un prototipo existente y luego se realizan
pequeñas modificaciones según lo solicitado.

---

## Código utilizado

```java
CatalogoComputadores catalogo = new CatalogoComputadores();

Cliente juan = new Cliente("Juan");
Cliente maria = new Cliente("María");

// Clonar prototipo Gamer
Computador pedidoJuan =
        (Computador) catalogo.getGamer().clone();

pedidoJuan.setRam(32);

// Clonar prototipo Oficina
Computador pedidoMaria =
        (Computador) catalogo.getOficina().clone();

pedidoMaria.setAlmacenamiento("1TB SSD");

juan.mostrarPedido(pedidoJuan);
maria.mostrarPedido(pedidoMaria);
```

---

## Salida esperada

```
Cliente: Juan
Computador{tipo='Gamer', procesador='Intel i7', ram=32GB, almacenamiento='1TB SSD', tarjetaGrafica='RTX 4070'}

Cliente: María
Computador{tipo='Oficina', procesador='Intel i5', ram=8GB, almacenamiento='1TB SSD', tarjetaGrafica='Integrada'}
```
