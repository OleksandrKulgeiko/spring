package d_data.jpa.jpaspringdata;

/**
 * Created by akulgeiko on 7/20/2018.
 */
import static org.junit.Assert.*;

import java.util.List;

import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Blogger;
import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository.BloggerRepository;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class BloggerRepositoryTest {

    @Autowired
    BloggerRepository bloggerRepository;

    @Test
    @Transactional
    public void count() {
        assertEquals(4, bloggerRepository.count());
    }

    @Test
    @Transactional
    public void findAll() {
        List<Blogger> spitters = bloggerRepository.findAll();
        assertEquals(4, spitters.size());
        assertBlogger(0, spitters.get(0));
        assertBlogger(1, spitters.get(1));
        assertBlogger(2, spitters.get(2));
        assertBlogger(3, spitters.get(3));
    }

    @Test
    @Transactional
    public void findByUsername() {
        assertBlogger(0, bloggerRepository.findByUsername("habuma"));
        assertBlogger(1, bloggerRepository.findByUsername("mwalls"));
        assertBlogger(2, bloggerRepository.findByUsername("chuck"));
        assertBlogger(3, bloggerRepository.findByUsername("artnames"));
    }

    @Test
    @Transactional
    public void findOne() {
        assertBlogger(0, bloggerRepository.findOne(1L));
        assertBlogger(1, bloggerRepository.findOne(2L));
        assertBlogger(2, bloggerRepository.findOne(3L));
        assertBlogger(3, bloggerRepository.findOne(4L));
    }

    @Test
    @Transactional
    public void save_newSpitter() {
        assertEquals(4, bloggerRepository.count());
        Blogger spitter = new Blogger(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        Blogger saved = bloggerRepository.save(spitter);
        assertEquals(5, bloggerRepository.count());
        assertBlogger(4, saved);
        assertBlogger(4, bloggerRepository.findOne(5L));
    }

    @Test
    @Transactional
    @Ignore
    public void save_existingSpitter() {
        assertEquals(4, bloggerRepository.count());
        Blogger spitter = new Blogger(4L, "arthur", "letmein", "Arthur Names", "arthur@habuma.com", false);
        Blogger saved = bloggerRepository.save(spitter);
        assertBlogger(5, saved);
        assertEquals(4, bloggerRepository.count());
        Blogger updated = bloggerRepository.findOne(4L);
        assertBlogger(5, updated);
    }

    private static void assertBlogger(int expectedSpitterIndex, Blogger actual) {
        assertBlogger(expectedSpitterIndex, actual, "Newbie");
    }

    private static void assertBlogger(int expectedSpitterIndex, Blogger actual, String expectedStatus) {
        Blogger expected = BLOGGERS[expectedSpitterIndex];
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getFullName(), actual.getFullName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
    }

    private static Blogger[] BLOGGERS = new Blogger[6];

    @BeforeClass
    public static void before() {
        BLOGGERS[0] = new Blogger(1L, "habuma", "password", "Craig Walls", "craig@habuma.com", false);
        BLOGGERS[1] = new Blogger(2L, "mwalls", "password", "Michael Walls", "mwalls@habuma.com", true);
        BLOGGERS[2] = new Blogger(3L, "chuck", "password", "Chuck Wagon", "chuck@habuma.com", false);
        BLOGGERS[3] = new Blogger(4L, "artnames", "password", "Art Names", "art@habuma.com", true);
        BLOGGERS[4] = new Blogger(5L, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        BLOGGERS[5] = new Blogger(4L, "arthur", "letmein", "Arthur Names", "arthur@habuma.com", false);
    }

}
