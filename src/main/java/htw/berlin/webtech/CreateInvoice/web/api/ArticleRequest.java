package htw.berlin.webtech.CreateInvoice.web.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ArticleRequest {

    private String articleName;
    private BigDecimal price;

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

    public ArticleRequest(String articleName, BigDecimal price) {
        this.articleName = articleName;
        this.price = price;
    }
}
