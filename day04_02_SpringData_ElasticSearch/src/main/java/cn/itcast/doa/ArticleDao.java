package cn.itcast.doa;

import cn.itcast.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/*
dao 层需要继承 ElasticsearchRepository< 实体类 , 实体类中[id]的类型>
 */
public interface ArticleDao extends ElasticsearchRepository<Article , Long> {


    // 如果在实际使用中，springData 提供的方法不能完美得到想要的结果，可以自定义方法
    public List<Article> findByTitle(String title , Pageable pageable);
}
