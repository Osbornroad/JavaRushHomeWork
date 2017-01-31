package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

/**
 * Created by User on 31.01.2017.
 */
public class LevelLoader
{
    private Path levels;
    public LevelLoader(Path levels) {
        this.levels = levels;
    }
    public GameObjects getLevel(int level) {
        int x = FIELD_SELL_SIZE / 2;
        int y = FIELD_SELL_SIZE / 2;

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();

        Player player = new Player(x,y);

        walls.add(new Wall(x,y));
        walls.add(new Wall(x,y));
        walls.add(new Wall(x,y));

        boxes.add(new Box(x,y));
        homes.add(new Home(x,y));

        return new GameObjects(walls, boxes, homes, player);
    }
}
