package okcode.service.standard.biz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import okcode.service.standard.model.Biz;

@Repository
public interface BizDao extends JpaRepository<Biz, Long> {

	Biz findByBizKey(String bizKey);
}
