package okcode.biz.trading.intf;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import okcode.biz.trading.enums.Module;
import okcode.biz.trading.model.Article;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ArticleService {
	
	Article saveArticle(@NotNull @Valid Article article);
	
	Article deleteArticle(@NotNull @Min(1) Long articleId);
	
	
	Article findById(@NotNull @Min(1) Long id);
	
	List<Article> findByIds(@NotEmpty Collection<Long> ids);
	
	List<Article> findByCatalogId(Collection<Long> catalogIds);
	
	Page<Article> list(Module module, Collection<Long> catalogId, String key, Pageable pageable);
	
}
