package okcode.biz.trading.dto;

import java.util.Date;

import okcode.biz.trading.model.Catalog;


public class ArticleDto {
	private Long id;
	private Catalog catalog;
	private String title;
	private String subTitle;
	private Boolean topFlag;
	private String author;
	private Date createAt;
	private Date updateAt;
	private String content;
	
	private Long catalogId;
	private String catalogTitle;
	private Long clicks;
	
	private String price;
	private String imageUrl1;
	private String imageUrl2;
	private String imageUrl3;
	private String imageUrl4;
	private String imageUrl5;
	private String imageUrl6;
	private String imageUrl7;
	private String imageUrl8;
	private String imageUrl9;
	private String imageUrl10;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Boolean getTopFlag() {
		return topFlag;
	}
	public void setTopFlag(Boolean topFlag) {
		this.topFlag = topFlag;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogTitle() {
		return catalogTitle;
	}
	public void setCatalogTitle(String catalogTitle) {
		this.catalogTitle = catalogTitle;
	}
	public Long getClicks() {
		return clicks;
	}
	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImageUrl1() {
		return imageUrl1;
	}
	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}
	public String getImageUrl2() {
		return imageUrl2;
	}
	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}
	public String getImageUrl3() {
		return imageUrl3;
	}
	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}
	public String getImageUrl4() {
		return imageUrl4;
	}
	public void setImageUrl4(String imageUrl4) {
		this.imageUrl4 = imageUrl4;
	}
	public String getImageUrl5() {
		return imageUrl5;
	}
	public void setImageUrl5(String imageUrl5) {
		this.imageUrl5 = imageUrl5;
	}
	public String getImageUrl6() {
		return imageUrl6;
	}
	public void setImageUrl6(String imageUrl6) {
		this.imageUrl6 = imageUrl6;
	}
	public String getImageUrl7() {
		return imageUrl7;
	}
	public void setImageUrl7(String imageUrl7) {
		this.imageUrl7 = imageUrl7;
	}
	public String getImageUrl8() {
		return imageUrl8;
	}
	public void setImageUrl8(String imageUrl8) {
		this.imageUrl8 = imageUrl8;
	}
	public String getImageUrl9() {
		return imageUrl9;
	}
	public void setImageUrl9(String imageUrl9) {
		this.imageUrl9 = imageUrl9;
	}
	public String getImageUrl10() {
		return imageUrl10;
	}
	public void setImageUrl10(String imageUrl10) {
		this.imageUrl10 = imageUrl10;
	}
	
}
