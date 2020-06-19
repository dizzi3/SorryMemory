package Tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;
import java.util.Random;

public class RandomTileTexture
/** Klasa przechowująca wszystkie tekstury wykorzystane w grze oraz
 * pozwalająca na pseudolosowe pobranie pojedynczej tekstury.
 * Przechowuje ona informacje o poprzednio pobranych teksturach tak,
 * żeby nie wystąpiła sytuacja w której dana tekstura zostanie pobrana dwa razy*/{

    public static ArrayList<Integer> alreadyUsedTextureIndexes = new ArrayList<>();

    public static Texture get(){

        ArrayList<Texture> textures = new ArrayList<>();
        textures.add(new Texture(Gdx.files.internal("tiles/pizza.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/zombie.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/telephone.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/alien.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/baloon.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/cartoon_girl.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/haunted_house.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/lion.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/printer.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/pumpkin.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/turtle.png")));
        textures.add(new Texture(Gdx.files.internal("tiles/virus.png")));

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
