package Tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Random;

public class RandomTileTexture {

    public static ArrayList<Integer> alreadyUsedTextureIndexes = new ArrayList<>();
    private static final ArrayList<Texture> textures = new ArrayList<>(List.of(
            new Texture(Gdx.files.internal("tiles/pizza.png")),
            new Texture(Gdx.files.internal("tiles/zombie.png")),
            new Texture(Gdx.files.internal("tiles/telephone.png")),
            new Texture(Gdx.files.internal("tiles/alien.png")),
            new Texture(Gdx.files.internal("tiles/baloon.png")),
            new Texture(Gdx.files.internal("tiles/cartoon_girl.png")),
            new Texture(Gdx.files.internal("tiles/haunted_house.png")),
            new Texture(Gdx.files.internal("tiles/lion.png")),
            new Texture(Gdx.files.internal("tiles/printer.png")),
            new Texture(Gdx.files.internal("tiles/pumpkin.png")),
            new Texture(Gdx.files.internal("tiles/turtle.png")),
            new Texture(Gdx.files.internal("tiles/virus.png"))
    ));

    public static Texture get(){

        Random rand = new Random();
        Texture texture;
        int randTextureIndex;

        do{
            randTextureIndex = rand.nextInt(textures.size());
            texture = textures.get(randTextureIndex);
        }while(alreadyUsedTextureIndexes.contains(randTextureIndex));

        alreadyUsedTextureIndexes.add(randTextureIndex);

        return texture;
    }

}
