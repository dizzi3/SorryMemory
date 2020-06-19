package Screens;

import Listeners.MainMenuButtonListener;
import Styles.DefaultButtonStyle;
import Styles.TriesLabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dizzie.game.MemoryGame;

public class AuthorsScreen extends AbstractScreen
/** Ekran odpowiadający za wyświetlenie informacji o autorach gry. */{

    private Label label;
    private TextButton button;

    public AuthorsScreen(MemoryGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        button = new TextButton("Main Menu", new DefaultButtonStyle());
        button.setPosition(game.WIDTH / 2 - button.getWidth() / 2, game.HEIGHT - 500);
        button.addListener(new MainMenuButtonListener(game));
        stage.addActor(button);

        String labelTxt = "Authors:\n\nMichal Zapala\n\nKamil Wolka";

        label = new Label(labelTxt, new TriesLabelStyle());
        label.setPosition(game.WIDTH / 2 - label.getWidth() / 2, game.HEIGHT - 360);
        stage.addActor(label);
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
