package cn.itcast.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/*
@Document(indexName="索引库" , type = "表")
 */
@Document(indexName = "blog3" , type = "article")
public class Article {

    @Id
    private Long id;

    @Field(index = true , store = true , analyzer = "ik_smart" , type = FieldType.Text)
    private String content;

    @Field(index = true , store = true , analyzer = "ik_smart" , type = FieldType.Text)
    private String title;


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
