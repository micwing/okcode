package okcode.web.console.contentmgr;

import java.util.Collections;
import java.util.Date;

import okcode.biz.trading.dto.ArticleDto;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.ArticleService;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.model.Article;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.framework.result.Result;
import okcode.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 门户商品请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/contentManage")
public class ConsoleContentManageController extends BaseController {
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:/console/contentManage/list?module=article";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Module module, Long cid, Pageable page) {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/main-list");
		Page<Article> articlePage = articleService.list(module, cid==null?null:Collections.singleton(cid), null, page);
		mav.addObject("catalogs", catalogService.findByModule(module));
		mav.addObject("cid", cid);
		mav.addObject("module", module);
		mav.addObject("articleList", articlePage.getContent());
		mav.addObject("page", articlePage);
		return mav;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(Module module, Long cid, Long id) {
		Article article = null;
		if (id == null || id == 0) {			
			article = new Article();
			article.setUpdateAt(new Date());
		} else {
			article = articleService.findById(id);
			if (article == null)
				throw new AppException(ErrorCode.MISS_PARAM);
		}
			
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/main-detail");
		mav.addObject("catalogs", catalogService.findByModule(module));
		mav.addObject("cid", cid);
		mav.addObject("module", module);
		mav.addObject("article", article);
		return mav;
	}
	
	@RequestMapping(value = "/doSave", method = RequestMethod.POST)
	@ResponseBody
	public Result doSave(ArticleDto article) {
		Result result = new Result();
//		for (int i = 0; i < 85; i++) {
//			article.setId(null);
//			article = articleService.saveArticle(article);
//		}
		if (article.getId() == null) {
			result.setMessage("添加成功！");
		} else {
			result.setMessage("修改成功！");
		}
		Article entity = articleService.saveArticle(article);
		result.setValue(entity.getId());
		return result;
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Result doDelete(Long aid) {
		Article article = articleService.deleteArticle(aid);
		Result result = new Result("删除成功");
		result.setValue(article.getId());
		return result;
	}
	
}
