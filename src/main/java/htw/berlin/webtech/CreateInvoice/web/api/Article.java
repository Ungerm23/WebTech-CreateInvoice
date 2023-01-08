package htw.berlin.webtech.CreateInvoice.web.api;

import java.math.BigDecimal;

public class Article {

    private long id;
    private String articleName;
    private BigDecimal price;

    public Article(long id, String articleName, BigDecimal price) {
        this.id = id;
        this.articleName = articleName;
        this.price = price;
    }

    public Article() {}

    public long getId() {
        return id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
