//package okcode.service.standard.standard.dao;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import okcode.mall.core.enums.AreaLevel;
//import okcode.mall.core.model.Area;
//
//
///**
// * 区域持久层访问接口
// * 
// * @author MICHAEL
// *
// */
//@Repository
//public interface AreaDao extends JpaRepository<Area, Long>,JpaSpecificationExecutor<Area> {
//
//	List<Area> findByLevel(AreaLevel level);
//	
//	@Query("from Area where code in (?1)")
//	List<Area> findByCodes(Collection<Long> codes);
//	
//	@Query("from Area where parent.code = ?1")
//	List<Area> findSubList(Long pcode);
//	
//	@Query("from Area where name like ?1")
//	List<Area> findByName(String name);
//}
