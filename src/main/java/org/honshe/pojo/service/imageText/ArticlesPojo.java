package org.honshe.pojo.service.imageText;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class ArticlesPojo {
    private List<ServiceImageTextContentPojo> articles;

    @Override
    public String toString() {
        return "ArticlesPojo{" +
                "articles=" + articles +
                '}';
    }

    public List<ServiceImageTextContentPojo> getArticles() {
        return articles;
    }

    public void setArticles(List<ServiceImageTextContentPojo> articles) {
        this.articles = articles;
    }
}
