package ToyProject.JpaAws.service.posts;

import ToyProject.JpaAws.domain.posts.Posts;
import ToyProject.JpaAws.domain.posts.PostsRepository;
import ToyProject.JpaAws.web.dto.PostsSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
    @Autowired
    private PostsRepository postsRepository;
    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }
    @Test
    public void save() {

        PostsSaveRequestDto postDto = PostsSaveRequestDto.builder().title("hello")
                .content("hihi")
                .author("kim").build();


        Posts savedPosts = postsRepository.save(postDto.toEntity());

        assertThat(savedPosts.getAuthor()).isEqualTo("kim");

    }


}