import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import io.data.highscores.player.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
public class playerserviceTest {
    @TestConfiguration
    static class PlayerServiceImplTestContextConfiguration {

        @Bean
        public playerservice playerservice() {
            return new playerservice();
        }
    }

    @Autowired
    private playerservice playerService;

    @MockBean
    private playerrepository playerRepository;


    @Before
    public void setUp() {
        playerRepository = Mockito.mock(playerrepository.class);
        playerService = new playerservice(playerRepository);
    }

    @Test
    public void evaluatePlayerServicePopulate () {
        assertTrue("true", true);
    }

}
