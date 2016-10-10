package org.honshe.pojo.service.imageText;

import org.honshe.pojo.service.ServiceBasePojo;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class ServiceImageTextPojo extends ServiceBasePojo{
    private ArticlesPojo news;

    @Override
    public String toString() {
        return "ServiceImageTextPojo{" +
                "news=" + news +
                '}';
    }

    public ArticlesPojo getNews() {
        return news;
    }

    public void setNews(ArticlesPojo news) {
        this.news = news;
    }
}
