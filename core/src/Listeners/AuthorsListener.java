package Listeners;

import Screens.AuthorsScreen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.dizzie.game.MemoryGame;

public class AuthorsListener extends HandCursorListener {

    private MemoryGame game;

    public AuthorsListener(MemoryGame game){
        this.game = game;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        game.setScreen(new AuthorsScreen(game));
    }

}
