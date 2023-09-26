package com.hypeboy.hypeBoard.service;

import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import com.hypeboy.hypeBoard.page.Page;
import com.hypeboy.hypeBoard.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class PostService {
    @Autowired
    private PostRepository postRepository;

    int contentCount = 5;

    @Transactional
    public Post postRegister(PostDto postDto, String id, String nickname) throws SQLException {
        Post post = postToEntity(postDto, id, nickname);
        postRepository.save(post);
        return post;
    }
    public Post postToEntity(PostDto postDto, String id, String nickname){
        postDto.setNickname(nickname);
        postDto.setUserId(id);
        Post post = new Post(postDto);
        return post;
    }
    public Page<PostDto> createPageByPostDto(List<PostDto> postDtoList, int currentPage){
        int totalPosts = postDtoList.size();
        int totalPages = (int) Math.ceil((double) totalPosts/contentCount);
        int start = (currentPage-1)*contentCount;
        int end = start + contentCount;
        List<PostDto> currentPagePosts = postDtoList.subList(start,end);
        Page<PostDto> page = new Page<>(currentPagePosts, currentPage, totalPages ,contentCount);
        return page;
    }
    public Page<PostDto> createPageByNickName(String nickname, int currentPage){
        List<PostDto> postDtoList = postRepository.findByNickname(nickname, contentCount);
        return createPageByPostDto(postDtoList, currentPage);
    }
    public Page<PostDto> createPageById(String id, int currentPage){
        List<PostDto> postDtoList = postRepository.findById(id, contentCount);
        return createPageByPostDto(postDtoList, currentPage);
    }

    public void updatePost(PostDto postDto, String id, int postId) {
        postRepository.updatePost(postDto, id, postId);
    }

    public void delete(String id, int postId) throws SQLException {
        postRepository.deletePost(id,postId);
    }
}
