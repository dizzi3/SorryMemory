package Listeners;

import Screens.ChooseLevelScreen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.dizzie.game.MemoryGame;

public class StartGameButtonListener extends MenuButtonListener{

    private MemoryGame game;

    public StartGameButtonListener(MemoryGame game){
        this.game = game;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        game.setScreen(new ChooseLevelScreen(game));
    }
}
