/* ==========================================================
   PARTICLE
   Estado extrínseco
========================================================== */
class ParticulaContexto {
    constructor(x, y, velocidadX, velocidadY, vida, ParticulaFlyweight) {
        this.x = x;
        this.y = y;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.tipoParticula = ParticulaFlyweight;
    }

    actualizar() {
        this.x += this.velocidadX;
        this.y += this.velocidadY;
        this.vida--;
    }

    dibujar(ctx) {
        const opacity = this.vida / this.vidaMaxima;
        this.tipoParticula.dibujar(ctx, this.x, this.y, opacity);
    }

    estaMuerta() {
        return this.vida <= 0;
    }
}

export { ParticulaContexto };
