package Screens;

import Listeners.MainMenuButtonListener;
import Styles.DefaultButtonStyle;
import Styles.TriesLabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dizzie.game.MemoryGame;

public class EndGameScreen extends AbstractScreen
/** Ekran końca gry, wyświetla on informacje o wygranej lub przegranej
 * oraz zawiera przycisk przekierowujący gracza do głównego menu gry. */{

    private boolean won;
    private Label label;
    private TextButton button;

    public EndGameScreen(MemoryGame game, boolean won) {
        super(game);

        this.won = won;
        initialize();
    }

    @Override
    protected void init() {

    }

    private void initialize() {
        button = new TextButton("Main Menu", new DefaultButtonStyle());
        button.setPosition(game.WIDTH / 2 - button.getWidth() / 2, game.HEIGHT - 430);
        button.addListener(new MainMenuButtonListener(game));
        stage.addActor(button);

        String labelTxt;
        if(won)
            labelTxt = "Congratulations, You've won!";
        else
            labelTxt = "Unfortunately You've lost, try again!";

        label = new Label(labelTxt, new TriesLabelStyle());
        label.setPosition(game.WIDTH / 2 - label.getWidth() / 2, game.HEIGHT - 300);
        stage.addActor(label);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }
}
