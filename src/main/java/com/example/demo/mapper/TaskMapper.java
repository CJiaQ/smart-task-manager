package com.example.demo.mapper;

import com.example.demo.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT * FROM task")
    List<Task> findAll();
    @Select("""
        SELECT * FROM task
        WHERE title LIKE CONCAT('%', #{keyword}, '%')
        LIMIT #{offset}, #{size}
        """)
    List<Task> findByPage(String keyword, int offset, int size);
    @Insert("INSERT INTO task(title, done) VALUES(#{title}, #{done})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Task task);

    @Delete("DELETE FROM task WHERE id = #{id}")
    void delete(Long id);

    @Update("UPDATE task SET title=#{title}, done=#{done} WHERE id=#{id}")
    void update(Task task);

    @Select("""
        SELECT COUNT(*) FROM task
        WHERE title LIKE CONCAT('%', #{keyword}, '%')
        """)
    int countByKeyword(String keyword);
}