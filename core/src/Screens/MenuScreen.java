package Screens;

import Listeners.AuthorsListener;
import Listeners.StartGameButtonListener;
import Styles.DefaultButtonStyle;
import Styles.GameNameLabel;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dizzie.game.MemoryGame;

public class MenuScreen extends AbstractScreen
/** Ekran wyświetlający nazwe gry oraz przyciski do rozpoczęcia rozgrywki jak również
 * wyświetlenia ekranu z informacjami o autorach. */{

    private Label gameNameLabel;
    private TextButton startGameButton;
    private TextButton authorsButton;

    private Table table;

    public MenuScreen(MemoryGame game){
        super(game);
    }

    @Override
    protected void init() {
        initializeLabel();
        initializeButtons();
        initializeTable();
    }

    private void initializeLabel() {
        gameNameLabel = new Label("SORRY MEMORY", new GameNameLabel());
    }

    private void initializeButtons() {
        startGameButton = new TextButton("START GAME", new DefaultButtonStyle());
        startGameButton.addListener(new StartGameButtonListener(game));

        authorsButton = new TextButton("ABOUT AUTHORS", new DefaultButtonStyle());
        authorsButton.addListener(new AuthorsListener(game));
    }

    private void initializeTable(){
        table = new Table();
        table.moveBy(0, 50);
        table.setFillParent(true);
        table.add(gameNameLabel).padBottom(100);
        table.row();
        table.add(startGameButton).padBottom(38);
        table.row();
        table.add(authorsButton);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
