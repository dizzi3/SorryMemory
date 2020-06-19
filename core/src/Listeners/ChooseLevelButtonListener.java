package Listeners;

import Screens.GameScreen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.dizzie.game.MemoryGame;

public class ChooseLevelButtonListener extends HandCursorListener /** Klasa będąca Listenerem przycisku,
 odpowiada za uruchomienie odpowiedniego trybu gry na podstawie zmiennej nOfTiles przesłanej w jej konstruktorze. */{

private int nOfTiles;
    private MemoryGame game;

    public ChooseLevelButtonListener(MemoryGame game, int nOfTiles){
        super();

        this.game = game;
        this.nOfTiles = nOfTiles;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        game.setScreen(new GameScreen(game, nOfTiles));
    }
}
