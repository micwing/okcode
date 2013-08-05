package okcode.biz.trading.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import okcode.service.standard.util.StandardConstants;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = StandardConstants.TABLE_PREFIX_NAMING + "trading_article")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Article implements Serializable {

	private static final long serialVersionUID = -441280225512165188L;
	
	public static final String ATTR_PRICE = "price";
	public static final String ATTR_IMAGE_URL_1 = "imageUrl1";
	public static final String ATTR_IMAGE_URL_2 = "imageUrl2";
	public static final String ATTR_IMAGE_URL_3 = "imageUrl3";
	public static final String ATTR_IMAGE_URL_4 = "imageUrl4";
	public static final String ATTR_IMAGE_URL_5 = "imageUrl5";
	public static final String ATTR_IMAGE_URL_6 = "imageUrl6";
	public static final String ATTR_IMAGE_URL_7 = "imageUrl7";
	public static final String ATTR_IMAGE_URL_8 = "imageUrl8";
	public static final String ATTR_IMAGE_URL_9 = "imageUrl9";
	public static final String ATTR_IMAGE_URL_10 = "imageUrl10";
	
	public static final String ATTR_ATTR_FILE = "attrFile";
	
	public static final String ATTR_PLACE = "place";
	public static final String ATTR_DEAL = "deal";
	public static final String ATTR_COUNT = "count";
	public static final String ATTR_ENABLEDAYS = "enableDays";
	
	@Transient
	private Long catalogId;
	@Transient
	private String catalogTitle;
	@Transient
	private Long clicks;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "catalog_id", nullable = false)
	private Catalog catalog;
	
	@Column(name = "title", length = 255)
	private String title;

	@Column(name = "sub_title", length = 255)
	private String subTitle;
	
	@Column(name = "top_flag")
	private Boolean topFlag;
	
	@Column(name = "author")
	private String author;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", nullable = false)
	private Date createAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", nullable = false)
	private Date updateAt;
	
	@Lob
	@Column(name = "content")
	private String content;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = StandardConstants.TABLE_PREFIX_NAMING + "trading_article_attr", joinColumns = @JoinColumn(name = "article_id"))
	@MapKeyColumn(length = 255, name = "attr_key")
	@Column(name = "attr_value", length = 3000)
	private Map<String, String> attr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Map<String, String> getAttr() {
		return attr;
	}

	public void setAttr(Map<String, String> attr) {
		this.attr = attr;
	}

	public Long getClicks() {
		return clicks;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
