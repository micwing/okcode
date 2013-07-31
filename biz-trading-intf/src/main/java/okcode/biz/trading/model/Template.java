//package okcode.biz.trading.model;
//
//import java.io.Serializable;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//
//import okcode.biz.trading.enums.Module;
//import okcode.biz.trading.enums.TemplateLevel;
//import okcode.biz.trading.util.GlobalConstants;
//import okcode.service.standard.model.User;
//
//
//@Entity
//@Table(name = GlobalConstants.TABLE_PREFIX_NAMING + "trading_template")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//public class Template implements Serializable {
//
//	private static final long serialVersionUID = 8217067386398303531L;
//	
//	@Id
//	@Column(name = "id", unique = true, nullable = false)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	@NotNull
//	@Enumerated
//	@Column(name = "module_id", nullable = false)
//	private Module module;
//	
//	@NotNull
//	@Column(name = "alias", nullable = false)
//	private String alias;
//	
//	@NotNull
//	@Column(name = "name", nullable = false)
//	private String name;
//	
//	@Column(name = "description", length = 3000)
//	private String description;
//	
//	@Column(name = "rank")
//	private Long rank;
//	
//	@NotNull
//	@Enumerated
//	@Column(name = "template_level", nullable = false)
//	private TemplateLevel templateLevel;
//	
//	@ManyToMany(mappedBy = "templates", fetch = FetchType.LAZY)
//	private Set<User> users;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Module getModule() {
//		return module;
//	}
//
//	public void setModule(Module module) {
//		this.module = module;
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
//	public TemplateLevel getTemplateLevel() {
//		return templateLevel;
//	}
//
//	public void setTemplateLevel(TemplateLevel templateLevel) {
//		this.templateLevel = templateLevel;
//	}
//
//	public Long getRank() {
//		return rank;
//	}
//
//	public void setRank(Long rank) {
//		this.rank = rank;
//	}
//
//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
//
//}
