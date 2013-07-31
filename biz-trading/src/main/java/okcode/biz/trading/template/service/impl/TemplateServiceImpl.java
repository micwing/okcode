//package okcode.biz.trading.template.service.impl;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.shiro.util.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import okcode.biz.trading.enums.Module;
//import okcode.biz.trading.enums.TemplateLevel;
//import okcode.biz.trading.intf.TemplateService;
//import okcode.biz.trading.model.Template;
//import okcode.biz.trading.template.dao.TemplateDao;
//import okcode.biz.trading.template.utils.TemplateComparator;
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.service.standard.intf.UserService;
//import okcode.service.standard.model.User;
//
//
//@Service
//public class TemplateServiceImpl implements TemplateService {
//	@Autowired
//	private TemplateDao templateDao;
//	@Autowired
//	private UserService userService;
//
//	@Override
//	public Template findById(long id) {
//		return templateDao.findOne(id);
//	}
//
//	@Override
//	public Map<Long, Template> findByIds(Set<Long> ids) {
//		List<Template> list = templateDao.findByIds(ids);
//		if (CollectionUtils.isEmpty(list)) {
//			return Collections.emptyMap();
//		}
//		Map<Long, Template> map = new HashMap<Long, Template>();
//		for (Template template : list) {
//			map.put(template.getId(), template);
//		}
//		return map;
//	}
//
//	@Override
//	public List<Template> findAll() {
//		return templateDao.findAll();
//	}
//
//	@Override
//	public long save(Template e) {
//		templateDao.save(e);
//		return e.getId();
//	}
//	
//	@Override
//	public List<Template> getUserTemplates(Module module, long userId) throws AppException{
////		User user = userService.findUser(userId);
////		if (user == null)
////			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "用户未找到");
////		Set<Template> userTemplates = user.getTemplates();
////		List<Template> templates = templateDao.findByModule(module, TemplateLevel.NORMAL);
////		templates.addAll(userTemplates);
////		Collections.sort(templates, new TemplateComparator());
////		return templates;
//		return null;
//	}
//
//	@Override
//	public void userAddTemplate(long templateId, long userId) throws AppException {
////		Template template = templateDao.findOne(templateId);
////		if (template == null)
////			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "模板"+templateId+"不存在");
////		if (template.getTemplateLevel() != TemplateLevel.ADVANCED)
////			throw new AppException(ErrorCode.ILLEGAL_STATE, "非高级模板不支持该操作");
////		User user = userService.findUser(userId);
////		Set<Template> userTemplates = user.getTemplates();
////		if (userTemplates.contains(template))
////			throw new AppException(ErrorCode.ENTITY_ALREADY_EXIST, "用户已经拥有该模板，不需要要再添加");
////		userTemplates.add(template);
//	}
//
//	@Override
//	public List<Template> getTemplateByModule(Module module) {
//		return templateDao.findByModule(module);
//	}
//
//}
