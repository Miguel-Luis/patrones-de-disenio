/* ==========================================================
   PARTICLE
   Estado extrínseco
========================================================== */
class ParticulaContexto {
    constructor(x, y, velocidadX, velocidadY, vida, flyweight) {
        this.x = x;
        this.y = y;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.flyweight = flyweight;
    }

    actualizar() {
        this.x += this.velocidadX;
        this.y += this.velocidadY;
        this.vida--;
    }

    dibujar(ctx) {
        const opacity = this.vida / this.vidaMaxima;
        this.flyweight.dibujar(ctx, this.x, this.y, opacity);
    }

    estaMuerta() {
        return this.vida <= 0;
    }
}

export { ParticulaContexto };
