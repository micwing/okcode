package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okcode.biz.trading.model.Article;
import okcode.biz.trading.model.Catalog;


public class FrontHomeConfigDto implements CommonConfigDto {
	
	public FrontHomeConfigDto setMap(Map<String, String> map) {
		this.articleCatalogId = map.get("articleCatalogId");
		this.articleNum = map.get("articleNum");
		this.productCatalogId = map.get("productCatalogId");
		this.productNum = map.get("productNum");
		this.imageCatalogId = map.get("imageCatalogId");
		this.imageNum = map.get("imageNum");
		this.downloadCatalogId = map.get("downloadCatalogId");
		this.downloadNum = map.get("downloadNum");
		this.jobCatalogId = map.get("jobCatalogId");
		this.jobNum = map.get("jobNum");
		this.exlinkShow = map.get("exlinkShow");
		this.frontContent = map.get("frontContent");
		this.specialContent = map.get("specialContent");
		return this;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("articleCatalogId", getArticleCatalogId());
		map.put("articleNum", getArticleNum());
		map.put("productCatalogId", getProductCatalogId());
		map.put("productNum", getProductNum());
		map.put("imageCatalogId", getImageCatalogId());
		map.put("imageNum", getImageNum());
		map.put("downloadCatalogId", getDownloadCatalogId());
		map.put("downloadNum", getDownloadNum());
		map.put("jobCatalogId", getJobCatalogId());
		map.put("jobNum", getJobNum());
		map.put("exlinkShow", getExlinkShow());
		map.put("frontContent", getFrontContent());
		map.put("specialContent", getSpecialContent());
		return map;
	}
	
	public Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("articleCatalogId");
		set.add("articleNum");
		set.add("productCatalogId");
		set.add("productNum");
		set.add("imageCatalogId");
		set.add("imageNum");
		set.add("downloadCatalogId");
		set.add("downloadNum");
		set.add("jobCatalogId");
		set.add("jobNum");
		set.add("exlinkShow");
		set.add("frontContent");
		set.add("specialContent");
		return set;
	}
	
	private Long userId;
	
	private String articleCatalogId;
	
	private String articleNum;
	
	private String productCatalogId;
	
	private String productNum;
	
	private String imageCatalogId;
	
	private String imageNum;
	
	private String downloadCatalogId;
	
	private String downloadNum;
	
	private String jobCatalogId;
	
	private String jobNum;
	
	private String exlinkShow;
	
	private String frontContent;
	
	private String specialContent;
	
	
	private Catalog articleCatalog;
	
	private List<Article> articles;
	
	private Catalog productCatalog;
	
	private List<Article> products;
	
	private Catalog imageCatalog;
	
	private List<Article> images;
	
	private Catalog downloadCatalog;
	
	private List<Article> downloads;
	
	private Catalog jobCatalog;
	
	private List<Article> jobs;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getArticleCatalogId() {
		return articleCatalogId;
	}

	public void setArticleCatalogId(String articleCatalogId) {
		this.articleCatalogId = articleCatalogId;
	}

	public String getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(String articleNum) {
		this.articleNum = articleNum;
	}

	public String getProductCatalogId() {
		return productCatalogId;
	}

	public void setProductCatalogId(String productCatalogId) {
		this.productCatalogId = productCatalogId;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getImageCatalogId() {
		return imageCatalogId;
	}

	public void setImageCatalogId(String imageCatalogId) {
		this.imageCatalogId = imageCatalogId;
	}

	public String getImageNum() {
		return imageNum;
	}

	public void setImageNum(String imageNum) {
		this.imageNum = imageNum;
	}

	public String getDownloadCatalogId() {
		return downloadCatalogId;
	}

	public void setDownloadCatalogId(String downloadCatalogId) {
		this.downloadCatalogId = downloadCatalogId;
	}

	public String getDownloadNum() {
		return downloadNum;
	}

	public void setDownloadNum(String downloadNum) {
		this.downloadNum = downloadNum;
	}

	public String getJobCatalogId() {
		return jobCatalogId;
	}

	public void setJobCatalogId(String jobCatalogId) {
		this.jobCatalogId = jobCatalogId;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public String getExlinkShow() {
		return exlinkShow;
	}

	public void setExlinkShow(String exlinkShow) {
		this.exlinkShow = exlinkShow;
	}

	public String getFrontContent() {
		return frontContent;
	}

	public void setFrontContent(String frontContent) {
		this.frontContent = frontContent;
	}

	public String getSpecialContent() {
		return specialContent;
	}

	public void setSpecialContent(String specialContent) {
		this.specialContent = specialContent;
	}

	public Catalog getArticleCatalog() {
		return articleCatalog;
	}

	public void setArticleCatalog(Catalog articleCatalog) {
		this.articleCatalog = articleCatalog;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Catalog getProductCatalog() {
		return productCatalog;
	}

	public void setProductCatalog(Catalog productCatalog) {
		this.productCatalog = productCatalog;
	}

	public List<Article> getProducts() {
		return products;
	}

	public void setProducts(List<Article> products) {
		this.products = products;
	}

	public Catalog getImageCatalog() {
		return imageCatalog;
	}

	public void setImageCatalog(Catalog imageCatalog) {
		this.imageCatalog = imageCatalog;
	}

	public List<Article> getImages() {
		return images;
	}

	public void setImages(List<Article> images) {
		this.images = images;
	}

	public Catalog getDownloadCatalog() {
		return downloadCatalog;
	}

	public void setDownloadCatalog(Catalog downloadCatalog) {
		this.downloadCatalog = downloadCatalog;
	}

	public List<Article> getDownloads() {
		return downloads;
	}

	public void setDownloads(List<Article> downloads) {
		this.downloads = downloads;
	}

	public Catalog getJobCatalog() {
		return jobCatalog;
	}

	public void setJobCatalog(Catalog jobCatalog) {
		this.jobCatalog = jobCatalog;
	}

	public List<Article> getJobs() {
		return jobs;
	}

	public void setJobs(List<Article> jobs) {
		this.jobs = jobs;
	}
	
}
