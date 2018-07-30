package a_ioc;

import com.kulgeiko.spring_prep.a_ioc.configjava.Config;
import com.kulgeiko.spring_prep.a_ioc.configjava.Config2nd;
import com.kulgeiko.spring_prep.a_ioc.configjava.stereo.Disc;
import com.kulgeiko.spring_prep.a_ioc.configjava.stereo.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, Config2nd.class})
public class TestIoC {

    @Autowired
    @Qualifier("disc2")
    Disc disc;

    @Test
    public void testIoC() {

        assertThat(disc, instanceOf(Disc.class));
        assertEquals("Aqua", disc.getName());

    }


}
