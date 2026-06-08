// ─────────────────────────────────────────────────────────────
// tests/builder.test.ts — Suite completa de tests del patrón Builder v2
// ─────────────────────────────────────────────────────────────
//
// Organización:
//   1. Computer          → inmutabilidad, getters, toString
//   2. BaseComputerBuilder → comportamiento heredado (via Gaming)
//   3. GamingComputerBuilder → validación de GPU
//   4. OfficeComputerBuilder → GPU ignorada
//   5. Director          → cada receta, constructor obligatorio
//   6. Integración       → flujos completos de extremo a extremo
// ─────────────────────────────────────────────────────────────

import { Computer } from '../src/Computer'
import { GamingComputerBuilder } from '../src/GamingComputerBuilder'
import { OfficeComputerBuilder } from '../src/OfficeComputerBuilder'
import { Director } from '../src/Director'

// ─────────────────────────────────────────────────────────────
// 1. Computer (el Producto)
// ─────────────────────────────────────────────────────────────
describe('Computer', () => {

  describe('estado inicial', () => {
    it('todos los getters retornan string vacío al instanciar', () => {
      const c = new Computer()
      expect(c.cpu).toBe('')
      expect(c.ram).toBe('')
      expect(c.storage).toBe('')
      expect(c.gpu).toBe('')
      expect(c.operatingSystem).toBe('')
      expect(c.cooler).toBe('')
    })
  })

  describe('inmutabilidad', () => {
    it('no expone setters públicos: el cliente no puede mutar el producto', () => {
      const c = new Computer()
      // TypeScript no compila (c as any) en modo strict,
      // pero podemos verificar que la propiedad no es asignable directamente.
      expect(() => {
        // @ts-expect-error: cpu no tiene setter público
        c.cpu = 'hack'
      }).toThrow()
    })

    it('el producto retornado por getResult() es independiente del builder', () => {
      const builder = new GamingComputerBuilder()
      builder.setCPU('i9').setGPU('RTX 4090')
      const pc = builder.getResult()

      // Construir otro con el mismo builder no afecta el primero
      builder.setCPU('i5').setGPU('RTX 3060')
      builder.getResult()

      // El primer producto conserva sus valores originales
      expect(pc.cpu).toBe('i9')
      expect(pc.gpu).toBe('RTX 4090')
    })
  })

  describe('toString()', () => {
    it('muestra "—" cuando un campo está vacío', () => {
      const c = new Computer()
      const out = c.toString()
      // CPU, RAM, Storage, OS, Cooler vacíos → "—"
      expect(out).toContain('—')
    })

    it('muestra el valor asignado cuando el campo tiene contenido', () => {
      const builder = new GamingComputerBuilder()
      const pc = builder.setCPU('Intel i9').setGPU('RTX 4090').getResult()
      expect(pc.toString()).toContain('Intel i9')
      expect(pc.toString()).toContain('RTX 4090')
    })

    it('muestra "Gráfica integrada" cuando la GPU está vacía', () => {
      const builder = new OfficeComputerBuilder()
      const pc = builder.setCPU('Intel i5').getResult()
      expect(pc.toString()).toContain('Gráfica integrada')
    })

    it('incluye todas las etiquetas de campos en la salida', () => {
      const pc = new GamingComputerBuilder().setGPU('RTX').getResult()
      const out = pc.toString()
      expect(out).toContain('CPU')
      expect(out).toContain('RAM')
      expect(out).toContain('Storage')
      expect(out).toContain('GPU')
      expect(out).toContain('OS')
      expect(out).toContain('Cooler')
    })
  })
})

// ─────────────────────────────────────────────────────────────
// 2. BaseComputerBuilder (comportamiento heredado, testeado via Gaming)
// ─────────────────────────────────────────────────────────────
describe('BaseComputerBuilder (via GamingComputerBuilder)', () => {

  describe('fluent API — encadenamiento', () => {
    it('cada setter retorna la misma instancia del builder', () => {
      const b = new GamingComputerBuilder()
      expect(b.setCPU('i9')).toBe(b)
      expect(b.setRAM('64GB')).toBe(b)
      expect(b.setStorage('2TB')).toBe(b)
      expect(b.setOS('Win11')).toBe(b)
      expect(b.setCooler('Noctua')).toBe(b)
    })

    it('se pueden encadenar todos los setters en una expresión', () => {
      const pc = new GamingComputerBuilder()
        .setCPU('i9')
        .setRAM('64GB')
        .setStorage('2TB')
        .setGPU('RTX 4090')
        .setOS('Windows 11')
        .setCooler('Noctua')
        .getResult()

      expect(pc).toBeInstanceOf(Computer)
      expect(pc.cpu).toBe('i9')
    })
  })

  describe('reset automático tras getResult()', () => {
    it('después de getResult() el builder está limpio para el siguiente uso', () => {
      const b = new GamingComputerBuilder()
      b.setCPU('i9').setGPU('RTX 4090').getResult()

      // Ahora construimos otro sin asignar nada: debe estar vacío
      const pc2 = b.setGPU('RTX 3060').getResult()
      expect(pc2.cpu).toBe('')
      expect(pc2.gpu).toBe('RTX 3060')
    })

    it('dos productos consecutivos son instancias independientes', () => {
      const b = new GamingComputerBuilder()
      const pc1 = b.setCPU('i9').setGPU('RTX 4090').getResult()
      const pc2 = b.setCPU('i5').setGPU('RTX 3060').getResult()

      expect(pc1).not.toBe(pc2)
      expect(pc1.cpu).toBe('i9')
      expect(pc2.cpu).toBe('i5')
    })
  })

  describe('construcción parcial', () => {
    it('permite construir con solo algunos campos: el resto queda vacío', () => {
      const pc = new GamingComputerBuilder()
        .setCPU('i9')
        .setGPU('RTX 4090')
        .getResult()

      expect(pc.cpu).toBe('i9')
      expect(pc.gpu).toBe('RTX 4090')
      expect(pc.ram).toBe('')       // no asignado
      expect(pc.cooler).toBe('')    // no asignado
    })
  })
})

// ─────────────────────────────────────────────────────────────
// 3. GamingComputerBuilder — validación de GPU
// ─────────────────────────────────────────────────────────────
describe('GamingComputerBuilder', () => {

  describe('setGPU() — validación', () => {
    it('acepta una GPU con valor válido', () => {
      const b = new GamingComputerBuilder()
      expect(() => b.setGPU('RTX 4090')).not.toThrow()
    })

    it('lanza error si la GPU es string vacío', () => {
      const b = new GamingComputerBuilder()
      expect(() => b.setGPU('')).toThrow(
        'Un equipo gaming requiere GPU dedicada'
      )
    })

    it('lanza error si la GPU es solo espacios en blanco', () => {
      const b = new GamingComputerBuilder()
      expect(() => b.setGPU('   ')).toThrow(
        'Un equipo gaming requiere GPU dedicada'
      )
    })

    it('el mensaje de error incluye sugerencia de uso', () => {
      const b = new GamingComputerBuilder()
      try {
        b.setGPU('')
        fail('Debería haber lanzado un error')
      } catch (e: unknown) {
        expect(e instanceof Error).toBe(true)
        expect((e as Error).message).toContain('setGPU()')
      }
    })
  })
})

// ─────────────────────────────────────────────────────────────
// 4. OfficeComputerBuilder — GPU ignorada
// ─────────────────────────────────────────────────────────────
describe('OfficeComputerBuilder', () => {

  describe('setGPU() — ignorado intencionalmente', () => {
    it('no lanza error aunque se llame setGPU()', () => {
      const b = new OfficeComputerBuilder()
      expect(() => b.setGPU('RTX 4090')).not.toThrow()
    })

    it('la GPU del producto final siempre está vacía', () => {
      const pc = new OfficeComputerBuilder()
        .setCPU('i5')
        .setGPU('RTX 4090')   // llamado pero ignorado
        .getResult()

      expect(pc.gpu).toBe('')
    })

    it('retorna this tras setGPU() para mantener el encadenamiento', () => {
      const b = new OfficeComputerBuilder()
      expect(b.setGPU('RTX')).toBe(b)
    })
  })

  describe('demás setters (heredados de Base)', () => {
    it('construye correctamente CPU, RAM, storage, OS y cooler', () => {
      const pc = new OfficeComputerBuilder()
        .setCPU('Intel i5-13400')
        .setRAM('16GB DDR4')
        .setStorage('512GB SSD')
        .setOS('Windows 11 Home')
        .setCooler('Stock Intel')
        .getResult()

      expect(pc.cpu).toBe('Intel i5-13400')
      expect(pc.ram).toBe('16GB DDR4')
      expect(pc.storage).toBe('512GB SSD')
      expect(pc.operatingSystem).toBe('Windows 11 Home')
      expect(pc.cooler).toBe('Stock Intel')
    })
  })
})

// ─────────────────────────────────────────────────────────────
// 5. Director
// ─────────────────────────────────────────────────────────────
describe('Director', () => {

  describe('buildHighEndGaming()', () => {
    it('asigna todos los campos principales', () => {
      const b = new GamingComputerBuilder()
      const d = new Director(b)
      d.buildHighEndGaming()
      const pc = b.getResult()

      expect(pc.cpu).toBeTruthy()
      expect(pc.ram).toBeTruthy()
      expect(pc.storage).toBeTruthy()
      expect(pc.gpu).toBeTruthy()
      expect(pc.operatingSystem).toBeTruthy()
      expect(pc.cooler).toBeTruthy()
    })

    it('incluye GPU dedicada', () => {
      const b = new GamingComputerBuilder()
      new Director(b).buildHighEndGaming()
      expect(b.getResult().gpu).not.toBe('')
    })
  })

  describe('buildOfficeBasic()', () => {
    it('asigna CPU, RAM, storage, OS y cooler', () => {
      const b = new OfficeComputerBuilder()
      new Director(b).buildOfficeBasic()
      const pc = b.getResult()

      expect(pc.cpu).toBeTruthy()
      expect(pc.ram).toBeTruthy()
      expect(pc.storage).toBeTruthy()
      expect(pc.operatingSystem).toBeTruthy()
    })

    it('NO asigna GPU (usa gráfica integrada)', () => {
      const b = new OfficeComputerBuilder()
      new Director(b).buildOfficeBasic()
      expect(b.getResult().gpu).toBe('')
    })
  })

  describe('buildDevWorkstation()', () => {
    it('incluye un sistema operativo Linux', () => {
      const b = new GamingComputerBuilder()
      new Director(b).buildDevWorkstation()
      const pc = b.getResult()
      expect(pc.operatingSystem.toLowerCase()).toContain('ubuntu')
    })

    it('tiene más RAM que la PC de oficina básica', () => {
      const gb = new GamingComputerBuilder()
      new Director(gb).buildDevWorkstation()
      const workPC = gb.getResult()

      const ob = new OfficeComputerBuilder()
      new Director(ob).buildOfficeBasic()
      const officePC = ob.getResult()

      expect(parseInt(workPC.ram)).toBeGreaterThan(parseInt(officePC.ram))
    })
  })

  describe('comportamiento general', () => {
    it('el mismo tipo de Director con builders distintos produce PCs distintas', () => {
      const gb = new GamingComputerBuilder()
      new Director(gb).buildHighEndGaming()
      const gaming = gb.getResult()

      const ob = new OfficeComputerBuilder()
      new Director(ob).buildOfficeBasic()
      const office = ob.getResult()

      expect(gaming.cpu).not.toBe(office.cpu)
      expect(gaming.ram).not.toBe(office.ram)
    })

    it('puede ejecutar la misma receta dos veces seguidas con el mismo builder', () => {
      const b = new GamingComputerBuilder()
      const d = new Director(b)

      d.buildHighEndGaming()
      const pc1 = b.getResult()

      d.buildHighEndGaming()
      const pc2 = b.getResult()

      // Mismo contenido, instancias distintas
      expect(pc1.cpu).toBe(pc2.cpu)
      expect(pc1).not.toBe(pc2)
    })
  })
})

// ─────────────────────────────────────────────────────────────
// 6. Integración — flujos completos de extremo a extremo
// ─────────────────────────────────────────────────────────────
describe('Integración', () => {

  it('fluent API sin Director produce el producto correcto', () => {
    const pc = new GamingComputerBuilder()
      .setCPU('AMD Ryzen 7 7800X3D')
      .setRAM('32GB DDR5')
      .setStorage('1TB NVMe')
      .setGPU('AMD RX 7900 XTX')
      .setOS('Windows 11')
      .setCooler('AIO 240mm')
      .getResult()

    expect(pc).toBeInstanceOf(Computer)
    expect(pc.cpu).toBe('AMD Ryzen 7 7800X3D')
    expect(pc.gpu).toBe('AMD RX 7900 XTX')
  })

  it('dos builders distintos no comparten estado entre sí', () => {
    const b1 = new GamingComputerBuilder()
    const b2 = new GamingComputerBuilder()

    b1.setCPU('i9').setGPU('RTX 4090')
    b2.setCPU('i5').setGPU('RTX 3060')

    expect(b1.getResult().cpu).toBe('i9')
    expect(b2.getResult().cpu).toBe('i5')
  })

  it('el flujo completo Director → Builder → getResult() funciona end-to-end', () => {
    const builder = new GamingComputerBuilder()
    const director = new Director(builder)

    director.buildHighEndGaming()
    const pc = builder.getResult()

    expect(pc).toBeInstanceOf(Computer)
    expect(pc.cpu).not.toBe('')
    expect(pc.toString()).toContain('💻')
  })

  it('error en GamingBuilder se propaga correctamente al cliente', () => {
    expect(() => {
      new GamingComputerBuilder()
        .setCPU('i9')
        .setGPU('')
        .getResult()
    }).toThrow(Error)
  })
})