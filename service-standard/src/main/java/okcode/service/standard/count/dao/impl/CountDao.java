package okcode.service.standard.count.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import okcode.service.standard.enums.Status;
import okcode.service.standard.model.Count;


/**
 * 文件储存服务持久层访问接口
 * 
 * @author MICHAEL
 *
 */
@Repository
public interface CountDao extends JpaRepository<Count, Long>,JpaSpecificationExecutor<Count> {

	List<Count> findByIdInAndStatusInOrderByUpdateAtDesc(Collection<Long> ids, Status[] status);
	
	@Query("from Count where biz.bizKey =?1 and owner in (?2) and status in (?3) order by updateAt desc")
	List<Count> findByBizOwnerAndStatusInOrderByUpdateAtDesc(String bizKey, Collection<String> owner, Collection<Status> status);
	
	@Query("from Count where status in (?1) order by updateAt desc")
	List<Count> findByStatusOrderByUpdateAtDesc(Status[] status);
	
}
