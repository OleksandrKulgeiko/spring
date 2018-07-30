package d_data.jpa.jpahibernate;

import static org.junit.Assert.*;

import java.util.List;

import com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.db.BloggerRepository;
import com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.domain.Blogger;
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
        assertSpitter(0, spitters.get(0));
        assertSpitter(1, spitters.get(1));
        assertSpitter(2, spitters.get(2));
        assertSpitter(3, spitters.get(3));
    }

    @Test
    @Transactional
    public void findByUsername() {
        assertSpitter(0, bloggerRepository.findByUsername("habuma"));
        assertSpitter(1, bloggerRepository.findByUsername("mwalls"));
        assertSpitter(2, bloggerRepository.findByUsername("chuck"));
        assertSpitter(3, bloggerRepository.findByUsername("artnames"));
    }

    @Test
    @Transactional
    public void findOne() {
        assertSpitter(0, bloggerRepository.findOne(1L));
        assertSpitter(1, bloggerRepository.findOne(2L));
        assertSpitter(2, bloggerRepository.findOne(3L));
        assertSpitter(3, bloggerRepository.findOne(4L));
    }

    @Test
    @Transactional
    @Ignore
    public void save_newSpitter() {
        assertEquals(4, bloggerRepository.count());
        Blogger spitter = new Blogger(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        Blogger saved = bloggerRepository.save(spitter);
        assertEquals(5, bloggerRepository.count());
        assertSpitter(4, saved);
        assertSpitter(4, bloggerRepository.findOne(5L));
    }

    @Test
    @Transactional
    @Ignore
    public void save_existingSpitter() {
        assertEquals(4, bloggerRepository.count());
        Blogger spitter = new Blogger(4L, "arthur", "letmein", "Arthur Names", "arthur@habuma.com", false);
        Blogger saved = bloggerRepository.save(spitter);
        assertSpitter(5, saved);
        assertEquals(4, bloggerRepository.count());
        Blogger updated = bloggerRepository.findOne(4L);
        assertSpitter(5, updated);
    }

    private static void assertSpitter(int expectedSpitterIndex, Blogger actual) {
        assertSpitter(expectedSpitterIndex, actual, "Newbie");
    }

    private static void assertSpitter(int expectedSpitterIndex, Blogger actual, String expectedStatus) {
        Blogger expected = SPITTERS[expectedSpitterIndex];
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getFullName(), actual.getFullName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
    }

    private static Blogger[] SPITTERS = new Blogger[6];

    @BeforeClass
    public static void before() {
        SPITTERS[0] = new Blogger(1L, "habuma", "password", "Craig Walls", "craig@habuma.com", false);
        SPITTERS[1] = new Blogger(2L, "mwalls", "password", "Michael Walls", "mwalls@habuma.com", true);
        SPITTERS[2] = new Blogger(3L, "chuck", "password", "Chuck Wagon", "chuck@habuma.com", false);
        SPITTERS[3] = new Blogger(4L, "artnames", "password", "Art Names", "art@habuma.com", true);
        SPITTERS[4] = new Blogger(5L, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        SPITTERS[5] = new Blogger(4L, "arthur", "letmein", "Arthur Names", "arthur@habuma.com", false);
    }

}
