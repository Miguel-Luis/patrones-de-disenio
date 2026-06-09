package com.patterns.abstractfactory.client;

import com.patterns.abstractfactory.factory.GameFactory;
import com.patterns.abstractfactory.factory.MedievalFactory;
import com.patterns.abstractfactory.factory.SciFiFactory;
import com.patterns.abstractfactory.products.character.Character;
import com.patterns.abstractfactory.products.weapon.Weapon;
import com.patterns.abstractfactory.products.mount.Mount;

/**
 * Cliente: GameDemo
 *
 * Demuestra el uso del patrón Abstract Factory.
 *
 * PUNTO CLAVE: el método playGame() recibe una GameFactory
 * por parámetro (Dependency Injection). Esto significa que:
 *
 *   1. No sabe qué familia de objetos va a recibir.
 *   2. No importa cuántas familias existan — nunca cambia.
 *   3. Solo conoce interfaces: Character, Weapon, Mount.
 *
 * La única línea que decide el mundo concreto es el main().
 * Ahí se elige la fábrica y se pasa al cliente.
 * Si mañana agregamos un nuevo mundo (ej: FantasyFactory),
 * este método no necesita modificarse en absoluto.
 */
public class GameDemo {

    /**
     * Ejecuta una sesión de juego usando los productos
     * creados por la fábrica recibida.
     *
     * @param factory la fábrica abstracta que determinará
     *                qué familia de productos se utilizará
     */
    public static void playGame(GameFactory factory) {
        // El cliente crea los productos a través de la fábrica.
        // No sabe si son Knight/Sword/Horse o Soldier/LaserGun/Spaceship.
        Character character = factory.createCharacter();
        Weapon    weapon    = factory.createWeapon();
        Mount     mount     = factory.createMount();

        System.out.println("=".repeat(50));
        System.out.printf("  World: %s | Weapon: %s | Mount: %s%n",
                character.getName(), weapon.getName(), mount.getName());
        System.out.println("=".repeat(50));

        System.out.println("\n>> Combat sequence:");
        character.attack();
        weapon.use();

        System.out.println("\n>> Retreat sequence:");
        character.defend();
        mount.move();

        System.out.printf("%nWeapon damage: %d | Mount speed: %d%n",
                weapon.getDamage(), mount.getSpeed());
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║       Abstract Factory Pattern Demo          ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // La fábrica concreta se elige aquí — en un solo lugar.
        // En una aplicación real esto podría venir de un config,
        // de un argumento de línea de comandos, o de una elección del usuario.

        System.out.println(">>> Launching MEDIEVAL world...\n");
        playGame(new MedievalFactory());

        System.out.println(">>> Launching SCI-FI world...\n");
        playGame(new SciFiFactory());
    }
}
