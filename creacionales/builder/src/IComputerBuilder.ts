// ─────────────────────────────────────────────────────────────
// La INTERFAZ Builder
// ─────────────────────────────────────────────────────────────
//   La interfaz solo declara lo que el Director y el cliente necesitan.
//   La interfaz garantiza el contrato; 
// ─────────────────────────────────────────────────────────────

import { Computer } from './Computer';

export interface IComputerBuilder {
  setCPU(cpu: string): this;
  setRAM(ram: string): this;
  setStorage(storage: string): this;
  setGPU(gpu: string): this;       
  setOS(os: string): this;
  setCooler(cooler: string): this;
  getResult(): Computer; // Devuelve el producto final y reinicia el Builder
}