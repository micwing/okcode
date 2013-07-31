package okcode.biz.trading.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import okcode.biz.trading.enums.CatalogClickDisplay;
import okcode.biz.trading.enums.CatalogLevel;
import okcode.biz.trading.enums.CatalogNavDisplay;
import okcode.biz.trading.enums.Module;
import okcode.service.standard.util.StandardConstants;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = StandardConstants.TABLE_PREFIX_NAMING + "trading_catalog")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Catalog implements Serializable {

	private static final long serialVersionUID = -441280225512165188L;
	
	public static final String ATTR_KEY_OUTLINK_URL = "outlinkUrl";
	
	@Transient
	private String pname;
	
	@Transient
	private String outlinkUrl;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Enumerated
	@Column(name = "module", nullable = false)
	private Module module;
	
	@Enumerated
	@Column(name = "level", nullable = false)
	private CatalogLevel level;
	
	@Column(name = "pid")
	private Long pid;
	
	@NotNull
	@Column(name = "alias", length = 255, nullable = false)
	private String alias;
	
	@NotNull
	@Column(name = "title", length = 255, nullable = false)
	private String title;

	@Column(name = "sub_title", length = 255)
	private String subTitle;
	
	@Column(name = "rank", nullable = false)
	private Long rank;
	
	@NotNull
	@Enumerated
	@Column(name = "nav_display", nullable = false)
	private CatalogNavDisplay navDisplay;
	
	@Column(name = "new_window_open", nullable = false)
	private Boolean newWindowOpen;
	
	@Enumerated
	@Column(name = "click_display")
	private CatalogClickDisplay clickDisplay;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", nullable = false)
	private Date createAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at", nullable = false)
	private Date updateAt;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = StandardConstants.TABLE_PREFIX_NAMING + "trading_catalog_attr", joinColumns = @JoinColumn(name = "catalog_id"))
	@MapKeyColumn(length = 255, name = "attr_key")
	@Column(name = "attr_value", length = 3000)
	private Map<String, String> attributes;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public CatalogLevel getLevel() {
		return level;
	}

	public void setLevel(CatalogLevel level) {
		this.level = level;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public CatalogNavDisplay getNavDisplay() {
		return navDisplay;
	}

	public void setNavDisplay(CatalogNavDisplay navDisplay) {
		this.navDisplay = navDisplay;
	}

	public Boolean getNewWindowOpen() {
		return newWindowOpen;
	}

	public void setNewWindowOpen(Boolean newWindowOpen) {
		this.newWindowOpen = newWindowOpen;
	}

	public CatalogClickDisplay getClickDisplay() {
		return clickDisplay;
	}

	public void setClickDisplay(CatalogClickDisplay clickDisplay) {
		this.clickDisplay = clickDisplay;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
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

	public String getOutlinkUrl() {
		return outlinkUrl;
	}

	public void setOutlinkUrl(String outlinkUrl) {
		this.outlinkUrl = outlinkUrl;
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
		Catalog other = (Catalog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
