package okcode.biz.trading.site.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import okcode.biz.trading.enums.CatalogLevel;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.model.Catalog;


/**
 * 栏目
 * 
 * @author MICHAEL
 *
 */
@Repository
public interface CatalogDao extends JpaRepository<Catalog, Long> {

	List<Catalog> findByIdInOrderByRankAsc(Collection<Long> ids);
	
	List<Catalog> findByPidInOrderByRankAsc(Collection<Long> pids);
	
	List<Catalog> findByLevelInOrderByRankAsc(Collection<CatalogLevel> levels);
	
	List<Catalog> findByModuleAndAliasOrderByRankAsc(Module module, String alias);
	
	List<Catalog> findByModuleOrderByRankAsc(Module module);
	
	@Query("from Catalog order by rank asc")
	List<Catalog> findAllOrderByRankAsc();
	
}
