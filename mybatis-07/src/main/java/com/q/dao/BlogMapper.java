package com.q.dao;

import com.q.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    /**
     * ��ӵ���
     *
     * @param blog ����
     * @return int
     *///��������
    int addBook(Blog blog);

    /**
     * ��ѯ����
     *
     * @param map ��ͼ
     * @return {@link List<Blog>}
     *///��ѯ����
    List<Blog> QueryBlog(Map<String, Object> map);

    /**
     * ��ѯ����ѡ��
     *
     * @param map ��ͼ
     * @return {@link List<Blog>}
     */
    List<Blog> QueryBlogChoose(Map<Object, Object> map);

    /**
     * ���ڲ���
     *
     * @param map ��ͼ
     * @return int
     */
    int upDateTest(Map<Object, Object> map);

    /**
     * ѡ�񲩿�
     *
     * @param map ��ͼ
     * @return {@link List<Blog>}
     *///    ��ѯid 1 2 3�Ĳ���
    List<Blog> selectBlog(Map<Object, Object> map);

    /**
     * ѡ�񲩿͵�����
     *
     * @param string �ַ���
     * @return {@link List<Blog>}
     */
    List<Blog> selectBlogByName(String string);


}

