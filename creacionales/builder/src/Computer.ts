// ─────────────────────────────────────────────────────────────
// Computer.ts — El PRODUCTO
// ─────────────────────────────────────────────────────────────
//   Campos privados con solo getter → inmutable tras construirse.
//   El Builder asigna los valores internamente; el cliente solo lee.
// ─────────────────────────────────────────────────────────────

export class Computer {
  // _ es convención para indicar que no se accede directamente.
  private _cpu: string = ''
  private _ram: string = ''
  private _storage: string = ''
  private _gpu: string = ''
  private _operatingSystem: string = ''
  private _cooler: string = ''

  // Getters de solo lectura — el cliente puede leer pero no escribir.
  
  get cpu(): string            { return this._cpu }
  get ram(): string            { return this._ram }
  get storage(): string        { return this._storage }
  get gpu(): string            { return this._gpu }
  get operatingSystem(): string{ return this._operatingSystem }
  get cooler(): string         { return this._cooler }

  // Setters internos con visibilidad de paquete.
  // Solo los llama BaseComputerBuilder; el cliente no los ve
  /** @internal */ setCpu(v: string)            { this._cpu = v }
  /** @internal */ setRam(v: string)            { this._ram = v }
  /** @internal */ setStorage(v: string)        { this._storage = v }
  /** @internal */ setGpu(v: string)            { this._gpu = v }
  /** @internal */ setOperatingSystem(v: string){ this._operatingSystem = v }
  /** @internal */ setCooler(v: string)         { this._cooler = v }

  // toString() usa array + join para que cada línea sea fácil de agregar/quitar.
  toString(): string {
    return [
      `💻 Computador ensamblado:`,
      `   CPU     : ${this._cpu            || '—'}`,
      `   RAM     : ${this._ram            || '—'}`,
      `   Storage : ${this._storage        || '—'}`,
      `   GPU     : ${this._gpu            || 'Gráfica integrada'}`,
      `   OS      : ${this._operatingSystem|| '—'}`,
      `   Cooler  : ${this._cooler         || '—'}`,
    ].join('\n')
  }
}