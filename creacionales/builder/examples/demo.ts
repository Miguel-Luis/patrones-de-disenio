// ─────────────────────────────────────────────────────────────
// Demostración del patrón Builder
// ─────────────────────────────────────────────────────────────
//
// Ejecutar con: npx ts-node examples/demo.ts
//
// Este archivo muestra 4 formas distintas de usar el patrón:
//   1. Director + GamingBuilder   → receta predefinida gaming
//   2. Director + OfficeBuilder   → receta predefinida oficina
//   3. Director + GamingBuilder   → receta workstation (mismo Director, otro builder)
//   4. Sin Director               → fluent API personalizada
//   5. Error controlado           → GamingBuilder sin GPU lanza excepción
// ─────────────────────────────────────────────────────────────

import { Director } from '../src/Director'
import { GamingComputerBuilder } from '../src/GamingComputerBuilder'
import { OfficeComputerBuilder } from '../src/OfficeComputerBuilder'

const sep = '='.repeat(52)

console.log(sep)
console.log('   PATRÓN BUILDER — Demo de ensamble de PCs')
console.log(sep)

// ── Caso 1: PC gaming con Director ──────────────────────────
// El Director recibe el builder por constructor

console.log('\n[1] PC Gaming de alta gama (via Director)\n')
const gamingBuilder = new GamingComputerBuilder()
const gamingDirector = new Director(gamingBuilder)
gamingDirector.buildHighEndGaming()
console.log(gamingBuilder.getResult().toString())

// ── Caso 2: PC oficina con Director ─────────────────────────

console.log('\n[2] PC de oficina básica (via Director)\n')
const officeBuilder = new OfficeComputerBuilder()
const officeDirector = new Director(officeBuilder)
officeDirector.buildOfficeBasic()
console.log(officeBuilder.getResult().toString())

// ── Caso 3: Workstation con Director ────────────────────────

console.log('\n[3] Workstation para desarrollo (via Director)\n')
const workBuilder = new GamingComputerBuilder()
const workDirector = new Director(workBuilder)
workDirector.buildDevWorkstation()
console.log(workBuilder.getResult().toString())

// ── Caso 4: Sin Director — fluent API personalizada ──────────
// El cliente encadena los métodos directamente.

console.log('\n[4] PC personalizada sin Director (fluent API)\n')
const customPC = new GamingComputerBuilder()
  .setCPU('AMD Ryzen 7 7800X3D')
  .setRAM('32GB DDR5 6000MHz')
  .setStorage('1TB NVMe SSD')
  .setGPU('AMD RX 7900 XTX 24GB')
  .setOS('Windows 11 Pro')
  .getResult()
console.log(customPC.toString())

// ── Caso 5: Error controlado ─────────────────────────────────

console.log('\n[5] GamingBuilder sin GPU → error controlado\n')
try {
  new GamingComputerBuilder()
    .setCPU('Intel i9')
    .setRAM('32GB')
    .setGPU('')          
    .getResult()
} catch (error: unknown) {
  if (error instanceof Error) {
    console.log(`✅ Error capturado correctamente:\n   ${error.message}`)
  }
}

console.log('\n' + sep)
console.log('Observa: mismo patrón, comportamientos distintos')
console.log('según qué ConcreteBuilder se use.')
console.log(sep)