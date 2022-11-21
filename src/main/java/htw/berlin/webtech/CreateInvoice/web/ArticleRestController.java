package htw.berlin.webtech.CreateInvoice.web;

import htw.berlin.webtech.CreateInvoice.service.ArticleService;
import htw.berlin.webtech.CreateInvoice.service.CustomerService;
import htw.berlin.webtech.CreateInvoice.web.api.Article;
import htw.berlin.webtech.CreateInvoice.web.api.Customer;
import htw.berlin.webtech.CreateInvoice.web.api.CustomerManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(path = "/api/v1/article")
    public ResponseEntity<List<Article>> fetchArticle() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping(path = "/api/v1/article/{id}")
    public ResponseEntity<Article> fetchCustomerById(@PathVariable Long id) {
        var article = articleService.findById(id);
        //wenn customer nicht null, dann gib customer und ok zurück, falls null gib 404 zurück
        return article != null? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

}
