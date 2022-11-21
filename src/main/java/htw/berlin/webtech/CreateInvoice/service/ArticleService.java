package htw.berlin.webtech.CreateInvoice.service;

import htw.berlin.webtech.CreateInvoice.persistence.ArticleEntity;
import htw.berlin.webtech.CreateInvoice.persistence.ArticleRepository;
import htw.berlin.webtech.CreateInvoice.persistence.CustomerEntity;
import htw.berlin.webtech.CreateInvoice.persistence.CustomerRepository;
import htw.berlin.webtech.CreateInvoice.web.api.Article;
import htw.berlin.webtech.CreateInvoice.web.api.Customer;
import htw.berlin.webtech.CreateInvoice.web.api.CustomerManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAll(){
        List<ArticleEntity> article = articleRepository.findAll();
        return article.stream()
                .map(articleEntity -> transformEntity(articleEntity))
                .collect(Collectors.toList());
    }

    public Article findById(Long id) {
        //hier optional Entity, da bei Suche nach id sonst auch NullPointerExc auftreten kann
        //somit erst geschaut, ob Entity null, falls nicht, dann wird transformiert
        var articleEntity = articleRepository.findById(id);
        return articleEntity.isPresent()? transformEntity(articleEntity.get()) :null;
    }

    private Article transformEntity (ArticleEntity articleEntity) {
        return new Article(
                articleEntity.getId(),
                articleEntity.getArticleName(),
                articleEntity.getPrice()
        );
    }
}
