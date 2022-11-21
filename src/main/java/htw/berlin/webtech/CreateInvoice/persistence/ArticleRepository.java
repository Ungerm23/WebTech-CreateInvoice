package htw.berlin.webtech.CreateInvoice.persistence;

import htw.berlin.webtech.CreateInvoice.web.api.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findAllByArticleName(String articleName);

}
