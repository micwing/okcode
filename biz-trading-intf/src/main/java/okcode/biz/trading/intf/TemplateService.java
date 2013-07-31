//package okcode.biz.trading.intf;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.validation.annotation.Validated;
//
//import okcode.biz.trading.enums.Module;
//import okcode.biz.trading.model.Template;
//import okcode.framework.exception.AppException;
//
//
///**
// * @author MICHAEL
// */
//@Validated
//public interface TemplateService {
//	
//	Template findById(@Min(1) long id);
//	
//	Map<Long, Template> findByIds(@NotEmpty Set<Long> ids);
//	
//	List<Template> findAll();
//	
//	long save(@NotNull @Valid Template e);
//	
//	List<Template> getUserTemplates(@NotNull Module module, @Min(1) long userId) throws AppException;
//	
//	void userAddTemplate(@Min(1) long templateId, @Min(1) long userId) throws AppException;
//	
//	List<Template> getTemplateByModule(Module module);
//}
