package Screens;

import Tiles.RandomTileTexture;
import Tiles.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.dizzie.game.MemoryGame;

import java.util.Arrays;
import java.util.Random;


public class GameScreen extends AbstractScreen{

    private Tile[] tiles;
    private Table table;

    public GameScreen(MemoryGame game, int numberOfTiles){
        super(game);

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
        Arrays.fill(tiles, null);

        do{
            Texture texture = RandomTileTexture.get();
            tiles[getRandomEmptyTileIndex()] = new Tile(texture, this);
            tiles[getRandomEmptyTileIndex()] = new Tile(texture, this);

        }while(isThereAnEmptyTile());


        for(int i = 0; i < tiles.length; i++){
            table.add(tiles[i]).padRight(30).padBottom(30);

            if((i+1) % 6 == 0)
                table.row();
        }
    }

    private boolean isThereAnEmptyTile(){
        for(int i = 0; i < tiles.length; i++){
            if(tiles[i] == null)
                return true;
        }

        return false;
    }

    private int getRandomEmptyTileIndex(){
        Random rand = new Random();
        int emptyTileIndex;
        do{
            emptyTileIndex = rand.nextInt(tiles.length);
        }while(tiles[emptyTileIndex] != null);

        return emptyTileIndex;
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

    public void setAllTilesDisabled(){
        for(int i = 0; i < tiles.length; i++) {
            tiles[i].setDisabled(true);
            tiles[i].setClicked(true);
        }
    }

    public void undisableTiles(){
        for(int i = 0; i < tiles.length; i++) {
            if(!tiles[i].isUncovered()) {
                tiles[i].setDisabled(false);
                tiles[i].setClicked(false);
            }
        }
    }

    @Override
    protected void init() {

    }
}
