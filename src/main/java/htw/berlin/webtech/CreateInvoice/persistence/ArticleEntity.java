package htw.berlin.webtech.CreateInvoice.persistence;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "article")
public class ArticleEntity {

    @Id
    //sorgt dafür, dass nummerischer Wert erzeugt wird, der um 1 hochzählt, sobald neuer Datensatz hinzugefügt wird
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "article_name", nullable = false)
    private String articleName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public ArticleEntity(String articleName, BigDecimal price) {
        this.articleName = articleName;
        this.price = price;
    }

    //public wäre hier auch möglich, aber nicht notwendig, daher geringste Sichtbarkeit wählen --> protected
    protected ArticleEntity() {}

    public Long getId() {
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
