package cn.itcast.service;

import cn.itcast.domain.Article;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    public void save(Article article);

    //查询全部
    List<Article> findAll();

    //查询单个
    Article findOne(Long id);

    //分页查询
    List<Article> findPage(Pageable pageable);

    //删除
    void deleteOne(Long id);


    // 自定义方法
    public List<Article> findByTitle(String title , Pageable pageable);
}
