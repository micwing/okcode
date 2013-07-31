package okcode.service.standard.intf;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import okcode.service.standard.model.Biz;

@Validated
public interface BizService {
	
	Biz create(Biz biz);
	
	Biz update(Biz biz);
	
	void delete(Long id);
	
	List<Biz> listAll();
	
	Biz findById(Long id);
	
	Biz findByBizKey(String bizKey);
}
