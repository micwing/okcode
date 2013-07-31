//package okcode.biz.trading.template.dao;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import okcode.biz.trading.enums.Module;
//import okcode.biz.trading.enums.TemplateLevel;
//import okcode.biz.trading.model.Template;
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
//public interface TemplateDao extends JpaRepository<Template, Long>,JpaSpecificationExecutor<Catalog>{
//	
//	@Query("from Template where id in (?1) order by rank")
//	List<Template> findByIds(Collection<Long> ids);
//	
//	@Query("from Template where module = ?1 and templateLevel = ?2 order by rank")
//	List<Template> findByModule(Module module, TemplateLevel level);
//	
//	@Query("from Template where module = ?1")
//	List<Template> findByModule(Module module);
//	
//	@Query("from Template order by rank desc")
//	List<Template> findAll();
//}
