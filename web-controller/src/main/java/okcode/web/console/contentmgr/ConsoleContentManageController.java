package okcode.web.console.contentmgr;

import java.util.Collections;
import java.util.Date;

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
		return "redirect:/console/contentManage/articleList?module=article";
	}
	
	@RequestMapping(value = "/articleList", method = RequestMethod.GET)
	public ModelAndView articleList(Module module, Long cid, Pageable page) {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/article-list");
		Page<Article> articlePage = articleService.list(module, cid==null?null:Collections.singleton(cid), null, page);
		mav.addObject("catalogs", catalogService.findByModule(module));
		mav.addObject("cid", cid);
		mav.addObject("module", module);
		mav.addObject("articleList", articlePage.getContent());
		mav.addObject("page", articlePage);
		return mav;
	}
	
	@RequestMapping(value = "/articleDetail", method = RequestMethod.GET)
	public ModelAndView articleDetail(Module module, Long cid, Long id) {
		Article article = null;
		if (id == null || id == 0) {			
			article = new Article();
			article.setUpdateAt(new Date());
		} else {
			article = articleService.findById(id);
			if (article == null)
				throw new AppException(ErrorCode.MISS_PARAM);
		}
			
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/article-detail");
		mav.addObject("catalogs", catalogService.findByModule(module));
		mav.addObject("cid", cid);
		mav.addObject("module", module);
		mav.addObject("article", article);
		return mav;
	}
	
	@RequestMapping(value = "/doSaveArticle", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveArticle(Article article) {
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
		article = articleService.saveArticle(article);
		result.setValue(article.getId());
		return result;
	}
	
	@RequestMapping(value = "/doDeleteArticle", method = RequestMethod.POST)
	@ResponseBody
	public Result doDeleteArticle(Long aid) {
		Article article = articleService.deleteArticle(aid);
		Result result = new Result("删除成功");
		result.setValue(article.getId());
		return result;
	}
	
	@RequestMapping(value = "/productModule", method = RequestMethod.GET)
	public ModelAndView productModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/productModule");
		return mav;
	}
	
	@RequestMapping(value = "/downloadModule", method = RequestMethod.GET)
	public ModelAndView downloadModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/downloadModule");
		return mav;
	}
	
	@RequestMapping(value = "/imageModule", method = RequestMethod.GET)
	public ModelAndView imageModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/imageModule");
		return mav;
	}
	
	@RequestMapping(value = "/messageModule", method = RequestMethod.GET)
	public ModelAndView messageModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/messageModule");
		return mav;
	}
	
	@RequestMapping(value = "/jobModule", method = RequestMethod.GET)
	public ModelAndView jobModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/jobModule");
		return mav;
	}
	
	@RequestMapping(value = "/exlinkModule", method = RequestMethod.GET)
	public ModelAndView exlinkModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "contentManage/exlinkModule");
		return mav;
	}
}
