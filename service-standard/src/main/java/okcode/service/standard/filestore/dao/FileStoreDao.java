//package okcode.service.standard.filestore.dao;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import okcode.service.standard.model.FileStore;
//
//
///**
// * 文件储存服务持久层访问接口
// * 
// * @author MICHAEL
// *
// */
//@Repository
//public interface FileStoreDao extends JpaRepository<FileStore, Long>,JpaSpecificationExecutor<FileStore> {
//
//	@Query("from FileStore where id in (?1)")
//	List<FileStore> findByIds(Collection<Long> ids);
//	
//	@Query("from FileStore where userId  = ?1")
//	List<FileStore> findByUser(Long userId);
//	
//	@Query("from FileStore where bizId = ?1 and owner in (?2) order by updateAt desc")
//	List<FileStore> findByBizOwner(Long bizId, Collection<Long> owners);
//}
