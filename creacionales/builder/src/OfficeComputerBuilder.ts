// ─────────────────────────────────────────────────────────────
//  ConcreteBuilder para oficina
// ─────────────────────────────────────────────────────────────
//    setGPU() ignora el parámetro intencionalmente
//    y documenta por qué. Decisión de diseño explícita y visible.
// ─────────────────────────────────────────────────────────────

import { BaseComputerBuilder } from './BaseComputerBuilder';

export class OfficeComputerBuilder extends BaseComputerBuilder {
  public setGPU(gpu: string): this {
    //las PCs de oficina ignoran GPUs dedicadas 
    return this; 
  }
}