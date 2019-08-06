package cn.itcast;

import cn.itcast.domain.Article;
import cn.itcast.service.ArticleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTestDemo {

    @Autowired
    private ArticleServiceImpl articleService;


    @Test   // 测试新增，和修改
    public void testSave() {
        for (int i = 0; i < 50 ; i++) {
            Article article = new Article();
            article.setId((long)i);
            article.setTitle( i + "测试springData + title");
            article.setContent(i + "测试springData + Content");
            articleService.save(article);
        }
    }


    @Test   // 测试查询全部，没有分页
    public void testFindAll() {
        // service 层做排序的配置
        List<Article> articleList = articleService.findAll();
        for (Article article : articleList) {
            System.out.println(article);
        }
    }


    @Test   // 测试 单独查找
    public void testFindOne() {
        System.out.println(articleService.findOne(1L));
    }


    @Test   // 测试 删除指定数据
    public void testDeleteOne() {
        articleService.deleteOne(0L);
    }


    @Test   // 测试 修改指定数据
    public void testUpdate() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("测试springData + title + 修改数据1111");
        article.setContent("测试springData + Content + 修改数据1111");
        articleService.save(article);
    }




    /* ============【重点】============= */

    @Test   // 测试 分页查找
    public void testFindAllPage() {
        int pageNumber = 1;
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber - 1 , pageSize, Sort.by(Sort.Order.asc("id")));
        List<Article> page = articleService.findPage(pageable);
        for (Article article : page) {
            System.out.println(article);
        }
    }


    @Test   // 测试 自定义方法
    public void testUserDefinedDemo1() {
        String title = "测试";
        int pageNumber = 2;
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber - 1 , pageSize , Sort.by(Sort.Order.asc("id")));

        List<Article> articleByTitle = articleService.findByTitle(title, pageable);
        for (Article article : articleByTitle) {
            System.out.println(article);
        }
    }

}
