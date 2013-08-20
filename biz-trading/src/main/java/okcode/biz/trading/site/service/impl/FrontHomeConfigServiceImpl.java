package okcode.biz.trading.site.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okcode.biz.trading.dto.FrontHomeConfigDto;
import okcode.biz.trading.intf.ArticleService;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.intf.FrontHomeConfigService;
import okcode.biz.trading.model.Article;
import okcode.biz.trading.model.Catalog;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class FrontHomeConfigServiceImpl implements FrontHomeConfigService {
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ArticleService articleService;
	
	@Override
	public FrontHomeConfigDto getFrontHomeInfos(FrontHomeConfigDto dto) {
		String articleCatalogId = dto.getArticleCatalogId();
		if (!StringUtils.isEmpty(articleCatalogId)
				&& !StringUtils.isEmpty(dto.getArticleNum()) ) {
			Catalog catalog = catalogService.findById(Long.parseLong(articleCatalogId));
			dto.setArticleCatalog(catalog);
			
			List<Catalog> allCatalogs = new ArrayList<Catalog>();
			allCatalogs.add(catalog);
			allCatalogs.addAll(catalogService.findAllByParent(catalog.getId()));
			
			Set<Long> ids = new HashSet<Long>();
			for (Catalog c : allCatalogs)
				ids.add(c.getId());
			Page<Article> page = articleService.list(catalog.getModule(), ids,
					null, new PageRequest(0, Integer.parseInt(dto.getArticleNum())));
			dto.setArticles(page.getContent());
		}
		
		String productCatalogId = dto.getProductCatalogId();
		if (!StringUtils.isEmpty(productCatalogId)
				&& !StringUtils.isEmpty(dto.getProductNum()) ) {
			Catalog catalog = catalogService.findById(Long.parseLong(productCatalogId));
			dto.setProductCatalog(catalog);
			
			List<Catalog> allCatalogs = new ArrayList<Catalog>();
			allCatalogs.add(catalog);
			allCatalogs.addAll(catalogService.findAllByParent(catalog.getId()));
			
			Set<Long> ids = new HashSet<Long>();
			for (Catalog c : allCatalogs)
				ids.add(c.getId());
			Page<Article> page = articleService.list(catalog.getModule(), ids,
					null, new PageRequest(0, Integer.parseInt(dto.getProductNum())));
			dto.setProducts(page.getContent());
		}
		
		String imageCatalogId = dto.getImageCatalogId();
		if (!StringUtils.isEmpty(imageCatalogId)
				&& !StringUtils.isEmpty(dto.getImageNum()) ) {
			Catalog catalog = catalogService.findById(Long.parseLong(imageCatalogId));
			dto.setImageCatalog(catalog);
			
			List<Catalog> allCatalogs = new ArrayList<Catalog>();
			allCatalogs.add(catalog);
			allCatalogs.addAll(catalogService.findAllByParent(catalog.getId()));
			
			Set<Long> ids = new HashSet<Long>();
			for (Catalog c : allCatalogs)
				ids.add(c.getId());
			Page<Article> page = articleService.list(catalog.getModule(), ids,
					null, new PageRequest(0, Integer.parseInt(dto.getImageNum())));
			dto.setImages(page.getContent());
		}
		
		String downloadCatalogId = dto.getDownloadCatalogId();
		if (!StringUtils.isEmpty(downloadCatalogId)
				&& !StringUtils.isEmpty(dto.getDownloadNum()) ) {
			Catalog catalog = catalogService.findById(Long.parseLong(downloadCatalogId));
			dto.setDownloadCatalog(catalog);
			
			List<Catalog> allCatalogs = new ArrayList<Catalog>();
			allCatalogs.add(catalog);
			allCatalogs.addAll(catalogService.findAllByParent(catalog.getId()));
			
			Set<Long> ids = new HashSet<Long>();
			for (Catalog c : allCatalogs)
				ids.add(c.getId());
			Page<Article> page = articleService.list(catalog.getModule(), ids,
					null, new PageRequest(0, Integer.parseInt(dto.getDownloadNum())));
			dto.setDownloads(page.getContent());
		}
		
		String jobCatalogId = dto.getJobCatalogId();
		if (!StringUtils.isEmpty(jobCatalogId)
				&& !StringUtils.isEmpty(dto.getJobNum()) ) {
			Catalog catalog = catalogService.findById(Long.parseLong(jobCatalogId));
			dto.setJobCatalog(catalog);
			
			List<Catalog> allCatalogs = new ArrayList<Catalog>();
			allCatalogs.add(catalog);
			allCatalogs.addAll(catalogService.findAllByParent(catalog.getId()));
			
			Set<Long> ids = new HashSet<Long>();
			for (Catalog c : allCatalogs)
				ids.add(c.getId());
			Page<Article> page = articleService.list(catalog.getModule(), ids,
					null, new PageRequest(0, Integer.parseInt(dto.getJobNum())));
			dto.setJobs(page.getContent());
		}
		return dto;
	}

}
