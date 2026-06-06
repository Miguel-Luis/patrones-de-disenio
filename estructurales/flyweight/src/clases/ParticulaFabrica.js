import { ParticulaFlyweight } from "./ParticulaFlyweight.js";

/* ==========================================================
   FLYWEIGHT FACTORY
========================================================== */
class ParticulaFabrica {
    constructor() {
        this.flyweights = new Map();
    }

    obtenerFlyweight(color, radius) {
        const key = `${color}-${radius}`;

        if (!this.flyweights.has(key)) {
            this.flyweights.set(
                key,
                new ParticulaFlyweight(color, radius)
            );
        }

        return this.flyweights.get(key);
    }

    contar() {
        return this.flyweights.size;
    }
}

export { ParticulaFabrica };
