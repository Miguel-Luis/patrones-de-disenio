import { SistemaParticulas } from "./SistemaParticulas.js";

/* ==========================================================
   APP
========================================================== */
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
const radioMargen = 40; // Radio alrededor del puntero

// Elementos de métricas
const fpsElement = document.getElementById("fps");
const particulasElement = document.getElementById("particulas");
const flyweightsElement = document.getElementById("flyweights");
const memoriaElement = document.getElementById("memoria");

// Métricas
let frameCount = 0;
let lastTime = Date.now();
let fps = 0;

function resizeCanvas() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
}

resizeCanvas();

window.addEventListener("resize", resizeCanvas);

const sistemaParticulas = new SistemaParticulas();

window.addEventListener("mousemove", (event) => {
    // Crear partículas en un radio alrededor del puntero
    const angle = Math.random() * Math.PI * 2;
    const distance = Math.random() * radioMargen;
    const offsetX = Math.cos(angle) * distance;
    const offsetY = Math.sin(angle) * distance;
    
    sistemaParticulas.crearParticulas(
        event.clientX + offsetX,
        event.clientY + offsetY
    );
});

function actualizarMetricas() {
    const ahora = Date.now();
    const tiempoTranscurrido = ahora - lastTime;
    
    if (tiempoTranscurrido >= 1000) {
        fps = frameCount;
        frameCount = 0;
        lastTime = ahora;
        
        fpsElement.textContent = fps;
        particulasElement.textContent = sistemaParticulas.particulas.length;
        flyweightsElement.textContent = sistemaParticulas.fabrica.contar();
        
        // Mostrar memoria si está disponible
        if (performance.memory) {
            const memoriaUsada = (performance.memory.usedJSHeapSize / 1048576).toFixed(2);
            memoriaElement.textContent = memoriaUsada;
        } else {
            memoriaElement.textContent = "N/A";
        }
    }
    
    frameCount++;
}

function animate() {
    ctx.fillStyle = "rgba(5,8,22,0.20)";
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    sistemaParticulas.actualizar();
    sistemaParticulas.dibujar(ctx);
    
    actualizarMetricas();

    requestAnimationFrame(animate);
}

animate();
