package ToyProject.JpaAws.service.posts;


import ToyProject.JpaAws.domain.posts.Posts;
import ToyProject.JpaAws.domain.posts.PostsRepository;
import ToyProject.JpaAws.web.dto.PostsResponseDto;
import ToyProject.JpaAws.web.dto.PostsSaveRequestDto;
import ToyProject.JpaAws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void saveVoid(PostsSaveRequestDto requestDto) {
        postsRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(posts);
    }
}
