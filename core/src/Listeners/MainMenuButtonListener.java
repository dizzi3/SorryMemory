package Listeners;

import Screens.MenuScreen;
import Tiles.RandomTileTexture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.dizzie.game.MemoryGame;

public class MainMenuButtonListener extends HandCursorListener /** Klasa będąca Listenerem przycisku,
 odpowiada za wyzerowanie użytych zmiennej przechowującej użyte wcześniej tekstury oraz
 za uruchomienie głównego menu gry. */ {

    private MemoryGame game;

    public MainMenuButtonListener(MemoryGame game) {
        this.game = game;
    }


    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        RandomTileTexture.alreadyUsedTextureIndexes.clear();
        game.setScreen(new MenuScreen(game));
    }
}
