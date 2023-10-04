package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.connectionpool.ConnectionPool;
import com.hypeboy.hypeBoard.dto.PostDto;
import com.hypeboy.hypeBoard.entity.Post;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Log4j2
@Repository
public class PostRepository implements MemoryPostRepository {

    private final ConnectionPool connPool;

    @Autowired
    public PostRepository(ConnectionPool coonPool) {
        this.connPool = coonPool;
    }

    private String readSqlByNickname = "SELECT * FROM posts WHERE nickname = ?";
    private String readSqlById = "SELECT * FROM posts WHERE USERID = ?";
    private String deleteSql = "DELETE FROM POSTS WHERE ID = ? AND USERID = ?";
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void save(Post post) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = connPool.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO posts (userid, title, nickname, textContent, category, referencedId) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, post.getUserId());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getNickname());
            stmt.setString(4, post.getTextContent());
            stmt.setString(5, post.getCategory());
            stmt.setString(6, null);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            connPool.close(conn, stmt);
        }
    }

    @Override
    public void deletePost(String id, int postId) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = connPool.getConnection();
        ;
        try {
            stmt = conn.prepareStatement(deleteSql);
            stmt.setInt(1, postId);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getErrorCode();
        } finally {
            connPool.close(conn, stmt);

        }
    }

    public List<PostDto> readPost(String parameter, String sql) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet result = null;
        List<PostDto> postDtos = new ArrayList<>();
        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, parameter);
            result = stmt.executeQuery();
            while (result.next()) {
                PostDto postDto = new PostDto();
                postDto.setTitle(result.getString("title"));
                postDto.setNickname(result.getString("nickname"));
                postDto.setTextContent(result.getString("textContent"));
                postDto.setCategory(result.getString("category"));
                postDtos.add(postDto);

            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            connPool.redaClose(conn, stmt, result);
        }
        return postDtos;
    }

    public List<PostDto> findByNickname(String nickname, int contentCount) {
        return readPost(nickname, readSqlByNickname);
    }

    @Override
    public List<PostDto> findById(String id, int contentCount) {
        return readPost(id, readSqlById);
    }

    public void updatePost(PostDto postDto, String id, int postId) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = buildUpdateQuery(postDto,id,postId);

        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(sql);
            setStmt(stmt, postDto, id, postId);
            stmt.executeUpdate();

            } catch (SQLException e) {
                e.getErrorCode();
            } finally {
                connPool.close(conn, stmt);
                }
    }
    private String buildUpdateQuery(PostDto postDto, String id, int postId) {
        String sql = "UPDATE posts SET";
        boolean updateOrNot = false;

        if (postDto.getTitle() != null) {
            sql += " title = ?,";
            updateOrNot = true;
        }if (postDto.getCategory() != null) {
            sql += " category = ?,";
            updateOrNot = true;
        }if (postDto.getTextContent() != null) {
            sql += " textcontent = ?,";
            updateOrNot = true;
        }if (updateOrNot) {
            sql = sql.substring(0, sql.length() - 1); // Remove the trailing comma and space.
            sql += " where userid = ? and Id = ?";
        }
        return sql;
    }
    public void setStmt(PreparedStatement stmt, PostDto postDto, String id, int postId) throws SQLException {
        int index = 1;
        if (postDto.getTitle() != null) {
            stmt.setString(index++, postDto.getTitle());
        }
        if (postDto.getCategory() != null) {
            stmt.setString(index++, postDto.getCategory());
        }
        if (postDto.getTextContent() != null) {
            stmt.setString(index++, postDto.getTextContent());
        }
        stmt.setString(index++, id);
        stmt.setInt(index, postId);
    }

    public Integer count () {
        String countQuery = "select count(*) from posts";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conn = null;

        Integer count = null;

        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(countQuery);
            rs = stmt.executeQuery();
            while(rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            log.error("error: >> " + ex.getMessage());
        } finally {
            connPool.safeClose(conn, stmt, rs);
        }

        return count;
    }

    public List<Post> findAll(Integer offset, Integer limit) {
        String findAllQuery = "select * from posts "
                + "order by ID desc "
                + " limit ? "
                + " offset ?";

        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conn = null;

        List<Post> postList = new LinkedList<>();

        try {
            conn = connPool.getConnection();
            stmt = conn.prepareStatement(findAllQuery);
            stmt.setInt(1, limit);
            stmt.setInt(2, offset);

            rs = stmt.executeQuery();

            while(rs.next()) {
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                Post post = new Post(
                        rs.getInt("id"),
                        rs.getString("userId"),
                        rs.getString("title"),
                        rs.getString("nickname"),
                        rs.getString("textContent"),
                        rs.getString("category"),
                        rs.getInt("referencedId"),
                        createdAt,
                        updatedAt
                );

                postList.add(post);
            }

        } catch (Exception ex) {
            log.error("error: >> " + ex.getMessage());
        } finally {
            connPool.safeClose(conn, stmt, rs);
        }

        return postList;
    }
}

