package com.q.dao;

import com.q.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    /**
     * 添加的书
     *
     * @param blog 博客
     * @return int
     *///插入数据
    int addBook(Blog blog);

    /**
     * 查询博客
     *
     * @param map 地图
     * @return {@link List<Blog>}
     *///查询博客
    List<Blog> QueryBlog(Map<String, Object> map);

    /**
     * 查询博客选择
     *
     * @param map 地图
     * @return {@link List<Blog>}
     */
    List<Blog> QueryBlogChoose(Map<Object, Object> map);

    /**
     * 日期测试
     *
     * @param map 地图
     * @return int
     */
    int upDateTest(Map<Object, Object> map);

    /**
     * 选择博客
     *
     * @param map 地图
     * @return {@link List<Blog>}
     *///    查询id 1 2 3的博客
    List<Blog> selectBlog(Map<Object, Object> map);

    /**
     * 选择博客的名字
     *
     * @param string 字符串
     * @return {@link List<Blog>}
     */
    List<Blog> selectBlogByName(String string);


}

