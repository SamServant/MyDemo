package cn.itcast.service;

import cn.itcast.doa.ArticleDao;
import cn.itcast.domain.Article;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public List<Article> findAll() {
        // 简单的查询全部，展示在页面上，也需要排序
        Iterable<Article> articleIterable = articleDao.findAll(Sort.by(Sort.Order.asc("id")));
        return Lists.newArrayList(articleIterable);
    }

    @Override
    public Article findOne(Long id) {
        return articleDao.findById(id).get();
    }

    /*
    分页查询全部
        在实际使用中： controller 并不会给Pageable 这种参数，而只是 pageNumber pageSiZe 这样的参数
            那么，就需要自己构建 Pageable
     */
    @Override
    public List<Article> findPage(Pageable pageable) {
        // 真实情况下，分页：
        //Pageable page = PageRequest.of(pageNumber , pagesize , Sort.by(Sort.Order.asc("id")));

        Page<Article> articlePage = articleDao.findAll(pageable);
        return articlePage.getContent();
    }

    @Override
    public void deleteOne(Long id) {
        articleDao.deleteById(id);
    }


    /*
    自定义方法，查询title 域（字段）的内容，并且分页
     */
    @Override
    public List<Article> findByTitle(String title, Pageable pageable) {
        return articleDao.findByTitle(title , pageable);
    }
}
