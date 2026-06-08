// ─────────────────────────────────────────────────────────────
// Clase ABSTRACTA base
// ─────────────────────────────────────────────────────────────
//   toda la lógica común vive aquí. Las subclases solo sobreescriben
//          setGPU(), que es donde realmente difieren.
// Por qué abstracta y no concreta:
//   No queremos que nadie instancie BaseComputerBuilder directamente.
// ─────────────────────────────────────────────────────────────

import { Computer } from './Computer'
import { IComputerBuilder } from './IComputerBuilder'

export abstract class BaseComputerBuilder implements IComputerBuilder {

  protected computer: Computer = new Computer()

  private reset(): void {
    this.computer = new Computer()
  }

  // Setters comunes: implementados una sola vez para todos los builders.
  // Retornan 'this' para habilitar encadenamiento 
  setCPU(cpu: string): this {
    this.computer.setCpu(cpu)
    return this
  }

  setRAM(ram: string): this {
    this.computer.setRam(ram)
    return this
  }

  setStorage(storage: string): this {
    this.computer.setStorage(storage)
    return this
  }

  setOS(os: string): this {
    this.computer.setOperatingSystem(os)
    return this
  }

  setCooler(cooler: string): this {
    this.computer.setCooler(cooler)
    return this
  }

  // setGPU es abstracto: OBLIGA a cada subclase a decidir qué hace con la GPU.
  abstract setGPU(gpu: string): this

  // getResult() es concreto: siempre hace lo mismo en todos los builders.
  getResult(): Computer {
    const result = this.computer   // guarda referencia al objeto construido
    this.reset()                   // limpia el builder (privado, invisible al exterior)
    return result                  // retorna el producto terminado
  }
}