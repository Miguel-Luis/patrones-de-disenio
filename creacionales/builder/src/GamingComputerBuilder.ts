// ─────────────────────────────────────────────────────────────
// ConcreteBuilder para gaming
// ─────────────────────────────────────────────────────────────
//   Solo sobreescribe setGPU() con lógica propia.
//   Principio Open/Closed en acción ya que Todo lo demás lo hereda de BaseComputerBuilder.
// ─────────────────────────────────────────────────────────────

import { BaseComputerBuilder } from './BaseComputerBuilder'

export class GamingComputerBuilder extends BaseComputerBuilder {
    
  setGPU(gpu: string): this {
    if (!gpu || gpu.trim() === '') {
      throw new Error(
        'Un equipo gaming requiere GPU dedicada. ' +
        'Usa setGPU() con un modelo válido (ej: "RTX 4090").'
      )
    }
    this.computer.setGpu(gpu)
    return this
  }
}