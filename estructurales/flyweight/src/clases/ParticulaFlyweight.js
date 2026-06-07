/* ==========================================================
   FLYWEIGHT
   Estado compartido entre miles de partículas
========================================================== */
class ParticulaFlyweight {
    constructor(color, radio) {
        this.color = color;
        this.radio = radio;
    }

    dibujar(ctx, x, y, opacity) {
        ctx.save();
        ctx.globalAlpha = opacity;
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.arc(x, y, this.radio, 0, Math.PI * 2);
        ctx.fill();
        ctx.restore();
    }
}

export { ParticulaFlyweight };
