import { ParticulaContexto } from "./ParticulaContexto.js";
import { ParticulaFabrica } from "./ParticulaFabrica.js";

/* ==========================================================
   PARTICLE SYSTEM
========================================================== */
class SistemaParticulas {
    constructor() {
        this.particulas = [];
        this.fabrica = new ParticulaFabrica();
    }

    crearParticulas(mouseX, mouseY) {
        const colores = [
            "#00F5FF",
            "#7f8a1c",
            "#635611",
            "#287c55",
            "#ff0000"
        ];

        for (let i = 0; i < 20; i++) {
            const angle = Math.random() * Math.PI * 2;
            const speed = Math.random() * 3 + 1;

            const velocidadX = Math.cos(angle) * speed;
            const velocidadY = Math.sin(angle) * speed;

            const color = colores[Math.floor(Math.random() * colores.length)];
            const radius = Math.floor(Math.random() * 4) + 4;

            const flyweight = this.fabrica.obtenerTipoParticula(color, radius);

            this.particulas.push(
                new ParticulaContexto(
                    mouseX,
                    mouseY,
                    velocidadX,
                    velocidadY,
                    60,
                    flyweight
                )
            );
        }
    }

    actualizar() {
        for (let i = this.particulas.length - 1; i >= 0; i--) {
            const particula = this.particulas[i];
            particula.actualizar();

            if (particula.estaMuerta()) {
                this.particulas.splice(i, 1);
            }
        }
    }

    dibujar(ctx) {
        this.particulas.forEach(particula => particula.dibujar(ctx));
    }
}

export { SistemaParticulas };