///**
// * @Project: main-core
// * @File: Supplier.java
// * @package okcode.mall.core.model
// * @Description:
// * @author micwing
// * @date 2013-3-28 下午2:36:22
// * @version V1.0
// *
// * Copyright (c) 2013 BGoal Soft Studio. All Rights Reserved.
// *
// * Copying of this document or code and giving it to others and the
// * use or communication of the contents thereof, are forbidden without
// * expressed authority. Offenders are liable to the payment of damages.
// * All rights reserved in the event of the grant of a invention patent or the
// * registration of a utility model, design or code.
// */
//package okcode.biz.trading.model;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapKeyColumn;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Transient;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotEmpty;
//
//import okcode.biz.trading.util.GlobalConstants;
//import okcode.service.standard.enums.Status;
//import okcode.service.standard.model.Article;
//import okcode.service.standard.model.User;
//import okcode.service.standard.util.CatalogItem;
//
///**
// * @ClassName: Site
// * @Description:
// * @author micwing
// * @date 2013-3-28 下午2:36:22
// */
//@Entity
//@Table(name = GlobalConstants.TABLE_PREFIX_NAMING + "trading_site")
//public class Site implements Serializable {
//	private static final long serialVersionUID = -1693136269120955938L;
//	@Transient
//	private Long moduleId;
//	@Transient
//	private Long templateId;
//	@Transient
//	private List<CatalogItem> catalogItems;
//	@Transient
//	private Map<Long, List<Article>> articleMap;
//	
//	public static final String ATTR_PAUSED_NOTICE = "pausedNotice";
//	
//	
//	@Id
//	@Column(name = "id", unique = true, nullable = false)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	@NotEmpty
//	@Column(name = "alias", nullable = false)
//	private String alias;
//	
//	@NotEmpty
//	@Column(name = "name")
//	private String name;
//	
//	@Column(name = "description", length = 3000)
//	private String description;
//	
//	@Column(name = "seo_title")
//	private String seoTitle;
//	
//	@Column(name = "seo_keyword")
//	private String seoKeywords;
//	
//	@Column(name = "seo_description")
//	private String seoDescription;
//	
//	@Enumerated
//	@Column(name = "status", nullable = false)
//	private Status status;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "template_id", nullable = false)
//	private Template template;
//	
//	@NotNull
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "create_at", nullable = false)
//	private Date createAt;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "update_at", nullable = false)
//	private Date updateAt;
//	
//	@ElementCollection(fetch = FetchType.LAZY)
//	@JoinTable(name = GlobalConstants.TABLE_PREFIX_NAMING + "trading_site_attr", joinColumns = @JoinColumn(name = "site_id"))
//	@MapKeyColumn(length = 255, name = "attr_key")
//	@Column(name = "attr_value", length = 3000)
//	private Map<String, String> attributes;
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getAlias() {
//		return alias;
//	}
//
//	public void setAlias(String alias) {
//		this.alias = alias;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Status getStatus() {
//		return status;
//	}
//
//	public void setStatus(Status status) {
//		this.status = status;
//	}
//
//	public Template getTemplate() {
//		return template;
//	}
//
//	public void setTemplate(Template template) {
//		this.template = template;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Map<String, String> getAttributes() {
//		return attributes;
//	}
//
//	public void setAttributes(Map<String, String> attributes) {
//		this.attributes = attributes;
//	}
//
//	public Long getModuleId() {
//		return moduleId;
//	}
//
//	public void setModuleId(Long moduleId) {
//		this.moduleId = moduleId;
//	}
//
//	public Long getTemplateId() {
//		return templateId;
//	}
//
//	public void setTemplateId(Long templateId) {
//		this.templateId = templateId;
//	}
//
//	public Date getCreateAt() {
//		return createAt;
//	}
//
//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}
//
//	public Date getUpdateAt() {
//		return updateAt;
//	}
//
//	public void setUpdateAt(Date updateAt) {
//		this.updateAt = updateAt;
//	}
//
//	public List<CatalogItem> getCatalogItems() {
//		return catalogItems;
//	}
//
//	public void setCatalogItems(List<CatalogItem> catalogItems) {
//		this.catalogItems = catalogItems;
//	}
//
//	public Map<Long, List<Article>> getArticleMap() {
//		return articleMap;
//	}
//
//	public void setArticleMap(Map<Long, List<Article>> articleMap) {
//		this.articleMap = articleMap;
//	}
//
//	public String getSeoTitle() {
//		return seoTitle;
//	}
//
//	public void setSeoTitle(String seoTitle) {
//		this.seoTitle = seoTitle;
//	}
//
//	public String getSeoKeywords() {
//		return seoKeywords;
//	}
//
//	public void setSeoKeywords(String seoKeywords) {
//		this.seoKeywords = seoKeywords;
//	}
//
//	public String getSeoDescription() {
//		return seoDescription;
//	}
//
//	public void setSeoDescription(String seoDescription) {
//		this.seoDescription = seoDescription;
//	}
//
//}
