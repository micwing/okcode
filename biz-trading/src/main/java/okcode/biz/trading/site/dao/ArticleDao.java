package okcode.biz.trading.site.dao;

import java.util.Collection;
import java.util.List;

import okcode.biz.trading.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 文章
 * 
 * @author MICHAEL
 *
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

	List<Article> findByIdInOrderByUpdateAtDesc(Collection<Long> ids);
	
	@Query("from Article where catalog.id in (?1) order by updateAt desc")
	List<Article> findByCatalogIdInOrderByUpdateAtDesc(Collection<Long> catalogIds);
	
}
