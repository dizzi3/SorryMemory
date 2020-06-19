package Screens;

import Listeners.ChooseLevelButtonListener;
import Styles.DefaultButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dizzie.game.MemoryGame;

public class ChooseLevelScreen extends AbstractScreen
/** Ekran odpowiedzialny za wyświetlenie wyboru trzech możliwych poziomów trudności gry.
 * Ilość pól każdego z poziomów jest zdefiniowana w stałych zmiennych statycznych.
 * Przyciski dzięki któremu możliwy jest wybór poziomów dodane są do obiektu klasy Table,
 * przez co w bardzo łatwy sposób możemy ustawić zamierzony layout ekranu.*/{

    private static final int LVL_EASY_TILES = 12;
    private static final int LVL_MEDIUM_TILES = 18;
    private static final int LVL_HARD_TILES = 24;

    private Table table;

    private TextButton lvlEasyButton;
    private TextButton lvlMediumButton;
    private TextButton lvlHardButton;

    public ChooseLevelScreen(MemoryGame game){
        super(game);
    }

    @Override
    protected void init() {
        initializeButtons();
        initializeTable();
    }

    private void initializeButtons() {
        lvlEasyButton = new TextButton("Easy - " + LVL_EASY_TILES + " pairs", new DefaultButtonStyle());
        lvlMediumButton = new TextButton("Medium - " + LVL_MEDIUM_TILES + " pairs", new DefaultButtonStyle());
        lvlHardButton = new TextButton("Hard - " + LVL_HARD_TILES + " pairs", new DefaultButtonStyle());

        lvlEasyButton.addListener(new ChooseLevelButtonListener(game, LVL_EASY_TILES));
        lvlMediumButton.addListener(new ChooseLevelButtonListener(game, LVL_MEDIUM_TILES));
        lvlHardButton.addListener(new ChooseLevelButtonListener(game, LVL_HARD_TILES));
    }

    private void initializeTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(lvlEasyButton).padBottom(40);
        table.row();
        table.add(lvlMediumButton).padBottom(40);
        table.row();
        table.add(lvlHardButton);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act();
        stage.draw();
    }

}
