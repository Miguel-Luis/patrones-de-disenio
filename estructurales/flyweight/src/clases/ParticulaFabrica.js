import { ParticulaFlyweight } from "./ParticulaFlyweight.js";

/* ==========================================================
   FLYWEIGHT FACTORY
========================================================== */
class ParticulaFabrica {
    constructor() {
        this.particulaTipos = new Map();
    }

    obtenerTipoParticula(color, radius) {
        const key = `${color}-${radius}`;

        if (!this.particulaTipos.has(key)) {
            this.particulaTipos.set(
                key,
                new ParticulaFlyweight(color, radius)
            );
        }

        return this.particulaTipos.get(key);
    }

    contar() {
        return this.particulaTipos.size;
    }
}

export { ParticulaFabrica };
