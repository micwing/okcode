package okcode.service.standard.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import okcode.service.standard.model.OperateLog;


/**
 * 文件储存服务持久层访问接口
 * 
 * @author MICHAEL
 *
 */
@Repository
public interface OperateLogDao extends JpaRepository<OperateLog, Long>,JpaSpecificationExecutor<OperateLog> {

}
