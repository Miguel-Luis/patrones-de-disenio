package com.patterns.abstractfactory.factory;

import com.patterns.abstractfactory.products.character.Character;
import com.patterns.abstractfactory.products.character.Soldier;
import com.patterns.abstractfactory.products.weapon.Weapon;
import com.patterns.abstractfactory.products.weapon.LaserGun;
import com.patterns.abstractfactory.products.mount.Mount;
import com.patterns.abstractfactory.products.mount.Spaceship;

/**
 * Fábrica Concreta: SciFiFactory
 *
 * Produce exclusivamente objetos de la familia Sci-Fi:
 * Soldier + LaserGun + Spaceship.
 *
 * Garantiza que todos los productos creados son
 * compatibles entre sí — tienen sentido juntos dentro
 * del mundo futurista del juego.
 *
 * Para agregar un nuevo mundo (ej: Fantasy), solo hay
 * que crear una nueva fábrica concreta. El cliente
 * no necesita ningún cambio. Eso es Open/Closed Principle.
 */
public class SciFiFactory implements GameFactory {

    @Override
    public Character createCharacter() {
        return new Soldier();
    }

    @Override
    public Weapon createWeapon() {
        return new LaserGun();
    }

    @Override
    public Mount createMount() {
        return new Spaceship();
    }
}
