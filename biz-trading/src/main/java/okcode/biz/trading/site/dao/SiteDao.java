//package okcode.biz.trading.site.dao;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import okcode.biz.trading.model.Site;
//import okcode.service.standard.model.Catalog;
//
//
//
///**
// * 商品分类持久层访问接口
// * 
// * @author MICHAEL
// */
//@Repository
//public interface SiteDao extends JpaRepository<Site, Long>,JpaSpecificationExecutor<Catalog>{
//	
//	@Query("from Site where id in (?1) order by id")
//	List<Site> findByIds(Collection<Long> ids);
//	
//	@Query("from Site where user.id = ?1 and status != 3")
//	List<Site> findByUser(long userId);
//	
//	@Query("from Site where alias = ?1 and status != 3")
//	Site findByAlias(String alias);
//	
//	@Query("from Site where status != 3")
//	List<Site> findAll();
//}
