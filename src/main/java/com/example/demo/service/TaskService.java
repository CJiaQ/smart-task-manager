package com.example.demo.service;

import com.example.demo.entity.PageResult;
import com.example.demo.entity.Task;
import com.example.demo.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TaskService {

    private final TaskMapper taskMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> findAll() {

        String key = "task:list";

        // 1 先查redis
        List<Task> cacheList = (List<Task>) redisTemplate.opsForValue().get(key);

        if (cacheList != null) {
            System.out.println("查询Redis缓存");
            return cacheList;
        }

        // 2 redis没有 查数据库
        System.out.println("查询数据库");

        List<Task> list = taskMapper.findAll();

        // 3 写入redis
        redisTemplate.opsForValue().set(key, list);

        return list;
    }

    public void add(Task task) {

        taskMapper.insert(task);

        redisTemplate.delete("task:list");
    }

    public void delete(Long id) {

        taskMapper.delete(id);

        redisTemplate.delete("task:list");
    }

    public void update(Task task) {

        taskMapper.update(task);

        redisTemplate.delete("task:list");
    }
    public PageResult<Task> findByPage(String keyword, int page, int size) {

        String key = "task:page:" + keyword + ":" + page + ":" + size;

        // 1️⃣ 先查缓存
        Object cache = redisTemplate.opsForValue().get(key);

        if (cache != null) {
            System.out.println("走缓存...");
            return (PageResult<Task>) cache;
        }

        System.out.println("查询数据库...");

        // 2️⃣ 查数据库
        int total = taskMapper.countByKeyword(keyword);
        int offset = (page - 1) * size;

        List<Task> list =
                taskMapper.findByPage(keyword, offset, size);

        PageResult<Task> result = new PageResult<>(total, list);

        // 3️⃣ 写入缓存（10分钟过期）
        redisTemplate.opsForValue()
                .set(key, result, java.time.Duration.ofMinutes(10));

        return result;
    }
}