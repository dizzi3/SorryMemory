package Screens;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.dizzie.game.MemoryGame;

public class GameScreen extends AbstractScreen{

    private int nOfTiles;
    private ImageButton[] tiles;

    public GameScreen(MemoryGame game, int numberOfTiles){
        super(game);

        nOfTiles = numberOfTiles;
        tiles = new ImageButton[numberOfTiles];
    }

    @Override
    protected void init() {

    }
}
