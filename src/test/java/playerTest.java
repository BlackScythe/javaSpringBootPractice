import io.data.highscores.player.player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class playerTest {
    @Test
    public void evaluatePlayerConstructor() {
        player player = new player("a",1,1,1,1,1);
        assertEquals(5, player.getxp());
    }
}
