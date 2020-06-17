package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.dizzie.game.MemoryGame;

import java.util.ArrayList;

public class GameScreen extends AbstractScreen{

    private int nOfTiles;
    private ImageButton[] tiles;
    private Table table;
    private static final Texture coveredTileTexture = new Texture(Gdx.files.internal("tiles/covered_tile.png"));
    private ArrayList<Texture> tileTextures = new ArrayList<>();

    public GameScreen(MemoryGame game, int numberOfTiles){
        super(game);

        nOfTiles = numberOfTiles;
        tiles = new ImageButton[numberOfTiles];
        initialize();
    }

    private void initialize(){
        initializeTable();
        initializeTileTextures();
        initializeTiles();
    }

    private void initializeTileTextures() {
        tileTextures.add(new Texture(Gdx.files.internal("tiles/pizza.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/zombie.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/telephone.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/alien.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/baloon.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/cartoon_girl.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/haunted_house.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/lion.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/printer.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/pumpkin.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/turtle.png")));
        tileTextures.add(new Texture(Gdx.files.internal("tiles/virus.png")));
    }

    private void initializeTable() {
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
    }

    private void initializeTiles(){
        for(int i = 0; i < tiles.length; i++){
            tiles[i] = new ImageButton(new TextureRegionDrawable(coveredTileTexture));
            table.add(tiles[i]).padRight(30).padBottom(30);

            if((i+1) % 6 == 0)
                table.row();
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

    @Override
    protected void init() {

    }
}
