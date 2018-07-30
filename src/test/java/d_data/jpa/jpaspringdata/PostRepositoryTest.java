package d_data.jpa.jpaspringdata;

/**
 * Created by akulgeiko on 7/20/2018.
 */
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Blogger;
import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Post;
import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Transactional
    public void count() {
        assertEquals(15, postRepository.count());
    }

    @Test
    @Transactional
    public void findRecent() {
        // default case
        {
            List<Post> recent = postRepository.findRecent();
            assertRecent(recent, 10);
        }

        // specific count case
        {
            List<Post> recent = postRepository.findRecent(5);
            assertRecent(recent, 5);
        }
    }

    @Test
    @Transactional
    public void findOne() {
        Post thirteen = postRepository.findOne(13L);
        assertEquals(13, thirteen.getId().longValue());
        assertEquals("Bonjour from Art!", thirteen.getMessage());
        assertEquals(1332682500000L, thirteen.getPostedTime().getTime());
        assertEquals(4, thirteen.getBlogger().getId().longValue());
        assertEquals("artnames", thirteen.getBlogger().getUsername());
        assertEquals("password", thirteen.getBlogger().getPassword());
        assertEquals("Art Names", thirteen.getBlogger().getFullName());
        assertEquals("art@habuma.com", thirteen.getBlogger().getEmail());
        assertTrue(thirteen.getBlogger().isUpdateByEmail());
    }

    @Test
    @Transactional
    public void findBySpitter() {
        List<Post> spittles = postRepository.findByBloggerId(4L);
        assertEquals(11, spittles.size());
        for (int i = 0; i < 11; i++) {
            assertEquals(i+5, spittles.get(i).getId().longValue());
        }
    }

    @Test
    @Transactional
    public void save() {
        assertEquals(15, postRepository.count());
        Blogger spitter = postRepository.findOne(13L).getBlogger();
        Post spittle = new Post(null, spitter, "Un Nuevo Post from Art", new Date());
        Post saved = postRepository.save(spittle);
        assertEquals(16, postRepository.count());
        assertNewSpittle(saved);
        assertNewSpittle(postRepository.findOne(16L));
    }

    @Test
    @Transactional
    public void delete() {
        assertEquals(15, postRepository.count());
        assertNotNull(postRepository.findOne(13L));
        postRepository.delete(13L);
        assertEquals(14, postRepository.count());
        assertNull(postRepository.findOne(13L));
    }

    private void assertRecent(List<Post> recent, int count) {
        long[] recentIds = new long[] {3,2,1,15,14,13,12,11,10,9};
        assertEquals(count, recent.size());
        for (int i = 0; i < count; i++) {
            assertEquals(recentIds[i], recent.get(i).getId().longValue());
        }
    }

    private void assertNewSpittle(Post spittle) {
        assertEquals(16, spittle.getId().longValue());
    }

}
