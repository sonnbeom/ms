package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements MemoryPostRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void save(Post post) {
//        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        String sql = "INSERT INTO POSTS (USERID, TITLE, NICKNAME, TEXTCONTENT, CATEGORY, REFERENCEDID) VALUES(?, ?, ?, ?, ?, ?)";

        int rowsInserted = jdbcTemplate.update(sql, post.getUserId(), post.getTitle(), post.getNickname(), post.getTextContent(), post.getCategory(), post.getReferencedId());

        if (rowsInserted > 0) {
            System.out.println("User created successfully.");
        } else {
            System.out.println("Failed to create user.");
        }

        /*insert.withTableName("POSTS").usingGeneratedKeyColumns("ID");
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("USERID",post.getUserId());
        parameters.put("TITLE",post.getTitle());
        parameters.put("CATEGORY",post.getCategory());
        parameters.put("TEXTCONTENT",post.getTextContent());
        parameters.put("NICKNAME",post.getNickname());
        parameters.put("REFERENCEDID",post.getReferencedId());
        parameters.put("CREATEDAT", LocalDateTime.now());
        parameters.put("UPDATEDAT",LocalDateTime.now());
        insert.execute(parameters);*/
    }
//    public void save(Post post) {
//        String sql = "INSERT INTO POSTS (USERID, TITLE, NICKNAME, TEXTCONTENT, CATEGORY, REFERENCEDID, CREATEDAT, UPDATEDAT) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.update(sql,
//                post.getUserId(),
//                post.getTitle(),
//                post.getNickname(),
//                post.getTextContent(),
//                post.getCategory(),
//                post.getReferencedId(),
//                (LocalDateTime.now()),
//                (LocalDateTime.now()));
//    }



}
