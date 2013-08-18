package okcode.biz.trading.intf;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import okcode.biz.trading.dto.CatalogItem;
import okcode.biz.trading.enums.CatalogLevel;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.model.Catalog;

@Validated
public interface CatalogService {
	
	Catalog saveCatalog(@NotNull @Valid Catalog catalog);
	
	Catalog deleteCatalog(@NotNull @Min(1) Long catalogId);
	
	
	Catalog findById(@NotNull @Min(1) Long id);
	
	List<Catalog> findByIds(@NotEmpty Collection<Long> ids);
	
	List<Catalog> findByLevel(@NotNull CatalogLevel level);
	
	List<Catalog> findByParent(@NotNull @Min(1) Long catalogId);
	
	List<Catalog> findAllByParent(@NotNull @Min(1) Long catalogId);
	
	List<Catalog> findByModule(@NotNull Module module);
	
	List<Catalog> findAll();
	
	List<CatalogItem> listCatalogItems();
	
	List<CatalogItem> listNavCatalogItems();
	
	Catalog findNavCatalog(Catalog catalog);
	
	List<Catalog> findNavBreadCatalogs(Catalog catalog);
	
	
	Catalog findByAlias(Module module, String alias);
}
