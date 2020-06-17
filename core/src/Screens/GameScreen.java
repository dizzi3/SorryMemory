package Screens;

import Tiles.RandomTileTexture;
import Tiles.Tile;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.dizzie.game.MemoryGame;


public class GameScreen extends AbstractScreen{

    private int nOfTiles;
    private Tile[] tiles;
    private Table table;

    public GameScreen(MemoryGame game, int numberOfTiles){
        super(game);

        nOfTiles = numberOfTiles;
        tiles = new Tile[numberOfTiles];
        initialize();
    }

    private void initialize(){
        initializeTable();
        initializeTiles();
    }

    private void initializeTable() {
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
    }

    private void initializeTiles(){
        for(int i = 0; i < tiles.length; i++){
            //tiles[i] = new ImageButton(new TextureRegionDrawable(coveredTileTexture));
            if(i < 12)
                tiles[i] = new Tile(RandomTileTexture.get());
            else
                tiles[i] = new Tile(tiles[i - 12].getTexture());

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
