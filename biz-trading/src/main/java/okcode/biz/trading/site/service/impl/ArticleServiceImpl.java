package okcode.biz.trading.site.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okcode.biz.trading.dto.ArticleDto;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.ArticleService;
import okcode.biz.trading.model.Article;
import okcode.biz.trading.model.Catalog;
import okcode.biz.trading.site.dao.ArticleDao;
import okcode.biz.trading.site.dao.CatalogDao;
import okcode.biz.trading.site.dao.SpecificDao;
import okcode.biz.trading.util.BizKeyValue;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.framework.utils.StringUtil;
import okcode.service.standard.intf.CountService;
import okcode.service.standard.model.Count;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ckfinder.connector.configuration.ConfigurationFactory;



@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private CatalogDao catalogDao;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private SpecificDao specificDao;
	@Autowired
	private CountService countService;
	
	@Override
	public Article saveArticle(ArticleDto article) {
		Article entity = null;
		if (article.getId() == null || article.getId() == 0) {
			entity = new Article();
			entity.setCreateAt(new Date());
		} else {
			entity = articleDao.findOne(article.getId());
			if (entity == null)
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "更新的对象未找到");
		}
		
		Catalog catalog = catalogDao.findOne(article.getCatalogId());
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "对应的栏目不存在！");
		article.setCatalog(catalog);
		
		//基本数据处理
		entity.setTopFlag(article.getTopFlag() == null ? false : article.getTopFlag());
		entity.setAuthor(article.getAuthor());
		entity.setContent(article.getContent());
		entity.setSubTitle(article.getSubTitle());
		entity.setTitle(article.getTitle());
		entity.setUpdateAt(article.getUpdateAt() == null ? new Date() : article.getUpdateAt());
		entity.setCatalog(article.getCatalog());
		
		//根据模块分别处理
		Module module = catalog.getModule();
		if (module.ordinal() == Module.article.ordinal())
			handleSaveArticle(article, entity);
		else if (module.ordinal() == Module.product.ordinal())
			handleSaveProduct(article, entity);
		else if (module.ordinal() == Module.image.ordinal())
			handleSaveImage(article, entity);
		else if (module.ordinal() == Module.download.ordinal())
			handleSaveDownload(article, entity);
		else if (module.ordinal() == Module.exlink.ordinal())
			handleSaveExlink(article, entity);
		else if (module.ordinal() == Module.job.ordinal())
			handleSaveJob(article, entity);
		else if (module.ordinal() == Module.message.ordinal())
			handleSaveMessage(article, entity);
		
		//save
		articleDao.save(entity);
		long clicks = article.getClicks() == null ? 0 
				: (article.getClicks() <= 0 ? 0 : article.getClicks() );
		countService.saveCount(BizKeyValue.COUNT_SERVICE_ARTICLE_CLICKS.toString(), entity.getId()+"", clicks);
		
		return entity;
	}
	
	private void handleSaveArticle(ArticleDto article, Article entity) {
	}
	
	private void handleSaveProduct(ArticleDto product, Article entity) {
		Map<String, String> attr = entity.getAttr() != null ? entity.getAttr() : new HashMap<String, String>();
		if (!StringUtil.isEmpty(product.getPrice()))
			attr.put(Article.ATTR_PRICE, product.getPrice());
		else
			attr.remove(Article.ATTR_PRICE);
		
		if (!StringUtils.isEmpty(product.getImageUrl1())) {
			attr.put(Article.ATTR_IMAGE_URL_1, product.getImageUrl1());
			attr.put(Article.ATTR_IMAGE_URL_1_THUMB, generateThumb(product.getImageUrl1()));
		}
		else 
			attr.remove(Article.ATTR_IMAGE_URL_1);
		
		if (!StringUtils.isEmpty(product.getImageUrl2()))
			attr.put(Article.ATTR_IMAGE_URL_2, product.getImageUrl2());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_2);
		
		if (!StringUtils.isEmpty(product.getImageUrl3()))
			attr.put(Article.ATTR_IMAGE_URL_3, product.getImageUrl3());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_3);
		
		if (!StringUtils.isEmpty(product.getImageUrl4()))
			attr.put(Article.ATTR_IMAGE_URL_4, product.getImageUrl4());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_4);
		
		if (!StringUtils.isEmpty(product.getImageUrl5()))
			attr.put(Article.ATTR_IMAGE_URL_5, product.getImageUrl5());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_5);
		
		if (!StringUtils.isEmpty(product.getImageUrl6()))
			attr.put(Article.ATTR_IMAGE_URL_6, product.getImageUrl6());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_6);
		
		if (!StringUtils.isEmpty(product.getImageUrl7()))
			attr.put(Article.ATTR_IMAGE_URL_7, product.getImageUrl7());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_7);
		
		if (!StringUtils.isEmpty(product.getImageUrl8()))
			attr.put(Article.ATTR_IMAGE_URL_8, product.getImageUrl8());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_8);
		
		if (!StringUtils.isEmpty(product.getImageUrl9()))
			attr.put(Article.ATTR_IMAGE_URL_9, product.getImageUrl9());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_9);
		
		if (!StringUtils.isEmpty(product.getImageUrl10()))
			attr.put(Article.ATTR_IMAGE_URL_10, product.getImageUrl10());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_10);
		
		entity.setAttr(attr);
	}
	
	private void handleSaveImage(ArticleDto image, Article entity) {
		Map<String, String> attr = entity.getAttr() != null ? entity.getAttr() : new HashMap<String, String>();
		
		if (!StringUtils.isEmpty(image.getImageUrl1())) {
			attr.put(Article.ATTR_IMAGE_URL_1, image.getImageUrl1());
			attr.put(Article.ATTR_IMAGE_URL_1_THUMB, generateThumb(image.getImageUrl1()));
		} else 
			attr.remove(Article.ATTR_IMAGE_URL_1);
		
		if (!StringUtils.isEmpty(image.getImageUrl2()))
			attr.put(Article.ATTR_IMAGE_URL_2, image.getImageUrl2());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_2);
		
		if (!StringUtils.isEmpty(image.getImageUrl3()))
			attr.put(Article.ATTR_IMAGE_URL_3, image.getImageUrl3());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_3);
		
		if (!StringUtils.isEmpty(image.getImageUrl4()))
			attr.put(Article.ATTR_IMAGE_URL_4, image.getImageUrl4());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_4);
		
		if (!StringUtils.isEmpty(image.getImageUrl5()))
			attr.put(Article.ATTR_IMAGE_URL_5, image.getImageUrl5());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_5);
		
		if (!StringUtils.isEmpty(image.getImageUrl6()))
			attr.put(Article.ATTR_IMAGE_URL_6, image.getImageUrl6());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_6);
		
		if (!StringUtils.isEmpty(image.getImageUrl7()))
			attr.put(Article.ATTR_IMAGE_URL_7, image.getImageUrl7());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_7);
		
		if (!StringUtils.isEmpty(image.getImageUrl8()))
			attr.put(Article.ATTR_IMAGE_URL_8, image.getImageUrl8());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_8);
		
		if (!StringUtils.isEmpty(image.getImageUrl9()))
			attr.put(Article.ATTR_IMAGE_URL_9, image.getImageUrl9());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_9);
		
		if (!StringUtils.isEmpty(image.getImageUrl10()))
			attr.put(Article.ATTR_IMAGE_URL_10, image.getImageUrl10());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_10);
		
		entity.setAttr(attr);
	}
	
	private void handleSaveDownload(ArticleDto download, Article entity) {
		Map<String, String> attr = entity.getAttr() != null ? entity.getAttr() : new HashMap<String, String>();
		
		if (!StringUtil.isEmpty(download.getAttrFile())) {
			attr.put(Article.ATTR_ATTR_FILE, download.getAttrFile());
			attr.put(Article.ATTR_IMAGE_URL_1_THUMB, generateThumb(download.getImageUrl1()));			
		} else
			attr.remove(Article.ATTR_ATTR_FILE);
		
		if (!StringUtils.isEmpty(download.getImageUrl1()))
			attr.put(Article.ATTR_IMAGE_URL_1, download.getImageUrl1());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_1);
		
		if (!StringUtils.isEmpty(download.getImageUrl2()))
			attr.put(Article.ATTR_IMAGE_URL_2, download.getImageUrl2());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_2);
		
		if (!StringUtils.isEmpty(download.getImageUrl3()))
			attr.put(Article.ATTR_IMAGE_URL_3, download.getImageUrl3());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_3);
		
		if (!StringUtils.isEmpty(download.getImageUrl4()))
			attr.put(Article.ATTR_IMAGE_URL_4, download.getImageUrl4());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_4);
		
		if (!StringUtils.isEmpty(download.getImageUrl5()))
			attr.put(Article.ATTR_IMAGE_URL_5, download.getImageUrl5());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_5);
		
		if (!StringUtils.isEmpty(download.getImageUrl6()))
			attr.put(Article.ATTR_IMAGE_URL_6, download.getImageUrl6());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_6);
		
		if (!StringUtils.isEmpty(download.getImageUrl7()))
			attr.put(Article.ATTR_IMAGE_URL_7, download.getImageUrl7());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_7);
		
		if (!StringUtils.isEmpty(download.getImageUrl8()))
			attr.put(Article.ATTR_IMAGE_URL_8, download.getImageUrl8());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_8);
		
		if (!StringUtils.isEmpty(download.getImageUrl9()))
			attr.put(Article.ATTR_IMAGE_URL_9, download.getImageUrl9());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_9);
		
		if (!StringUtils.isEmpty(download.getImageUrl10()))
			attr.put(Article.ATTR_IMAGE_URL_10, download.getImageUrl10());
		else 
			attr.remove(Article.ATTR_IMAGE_URL_10);
		
		entity.setAttr(attr);
	}
	
	private void handleSaveJob(ArticleDto job, Article entity) {
		Map<String, String> attr = entity.getAttr() != null ? entity.getAttr() : new HashMap<String, String>();
		if (!StringUtil.isEmpty(job.getPlace()))
			attr.put(Article.ATTR_PLACE, job.getPlace());
		else
			attr.remove(Article.ATTR_PLACE);
		
		if (!StringUtil.isEmpty(job.getCount()))
			attr.put(Article.ATTR_COUNT, job.getCount());
		else
			attr.remove(Article.ATTR_COUNT);
		
		if (!StringUtil.isEmpty(job.getDeal()))
			attr.put(Article.ATTR_DEAL, job.getDeal());
		else
			attr.remove(Article.ATTR_DEAL);
		
		if (!StringUtil.isEmpty(job.getEnableDays()))
			attr.put(Article.ATTR_ENABLEDAYS, job.getEnableDays());
		else
			attr.remove(Article.ATTR_ENABLEDAYS);
		
		entity.setAttr(attr);
	}
	
	private void handleSaveExlink(ArticleDto exlink, Article entity) {
	}
	
	private void handleSaveMessage(ArticleDto message, Article entity) {
	}
	
	private String generateThumb(String imageUrl) {
		String basePath = "";
		try {
			basePath = ConfigurationFactory.getInstace().getConfiguration().getBaseURL();
		} catch (Exception e1) {
			throw new AppException(ErrorCode.SERVER_ERROR);
		}
		String file = imageUrl.substring(imageUrl.lastIndexOf("/"), imageUrl.length());
		return basePath+"_thumbs/Image"+file;
	}
	
	

	@Override
	public Article deleteArticle(Long articleId) {
		Article article = articleDao.findOne(articleId);
		if (article == null)
			return null;
		articleDao.delete(article);
		return article;
	}
	
	/*
	 * 查询点击次数
	 */
	private void setClicks(List<Article> list) {
		if (!CollectionUtils.isEmpty(list)) {			
			List<String> ids = new ArrayList<String>();
			for (Article article : list)
				ids.add(article.getId()+"");
			Map<String, Count> counts = countService.findCounts(BizKeyValue.COUNT_SERVICE_ARTICLE_CLICKS.toString(), ids);
			for (Article article : list)
				article.setClicks(counts.get(article.getId()+"").getNum());
		}
	}
	
	/*
	 * 查询点击次数
	 */
	private void setClicks(Article article) {
		if (article == null)
			return;
		Count count = countService.findCount(BizKeyValue.COUNT_SERVICE_ARTICLE_CLICKS.toString(), article.getId()+"");
		if (count != null)
			article.setClicks(count.getNum());
	}
	
	@Override
	public Article findById(Long id) {
		Article article = articleDao.findOne(id);
		setClicks(article);
		return article;
	}

	@Override
	public List<Article> findByIds(Collection<Long> ids) {
		List<Article> articles = articleDao.findByIdInOrderByUpdateAtDesc(ids);
		return articles;
	}
	
	@Override
	public List<Article> findByCatalogId(Collection<Long> catalogIds) {
		List<Article> articles = articleDao.findByCatalogIdInOrderByUpdateAtDesc(catalogIds);
		setClicks(articles);
		return articles;
	}

	@Override
	public Page<Article> list(Module module, Collection<Long> catalogIds,String key,Pageable pageable) {
		List<Article> articles = specificDao.listArticle(module, catalogIds, key, 
				(pageable == null ? -1:pageable.getOffset()), 
				(pageable == null ? -1:pageable.getPageSize()) );
		setClicks(articles);
		long total = specificDao.countArticle(module, catalogIds, key);
		Page<Article> page = new PageImpl<Article>(articles, pageable, total);
		return page;
	}
	
	

}
