// ─────────────────────────────────────────────────────────────
// El DIRECTOR
// ─────────────────────────────────────────────────────────────
//   el builder se inyecta por constructor → es IMPOSIBLE crear un
//   Director sin builder. 
// Por qué el builder es readonly:
//   El Director no debería cambiar de builder a mitad de su vida.
//   Si necesitas otro builder, crea otro Director.
//   Responsabilidad única: el Director dirige, no entrega.
// ─────────────────────────────────────────────────────────────
import { IComputerBuilder } from './IComputerBuilder';

export class Director {
  // Inyección de dependencia a través del constructor
  constructor(private builder: IComputerBuilder) {}

  // Permite cambiar el builder dinámicamente si se requiere
  public setBuilder(builder: IComputerBuilder): void {
    this.builder = builder;
  }

  // Computadora de gama alta para juegos
  public buildHighEndGaming(): void {
    this.builder
      .setCPU('Intel Core i9-14900K')
      .setRAM('64GB DDR5')
      .setStorage('2TB NVMe SSD')
      .setGPU('NVIDIA RTX 4090')
      .setOS('Windows 11 Pro')
      .setCooler('Liquid Cooling 360mm');
  }

  //Estación de trabajo básica para oficina
  public buildOfficeBasic(): void {
    this.builder
      .setCPU('Intel Core i5-13400')
      .setRAM('16GB DDR4')
      .setStorage('512GB NVMe SSD')
      .setGPU('') 
      .setOS('Windows 11 Home')
      .setCooler('Stock Cooler');
  }

  //Estación de desarrollo de software
  public buildDevWorkstation(): void {
    this.builder
      .setCPU('AMD Ryzen 9 7950X')
      .setRAM('32GB DDR5')
      .setStorage('1TB NVMe SSD')
      .setGPU('NVIDIA RTX 4060') 
      .setOS('Ubuntu 24.04 LTS')
      .setCooler('Noctua NH-D15');
  }
}