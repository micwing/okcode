package okcode.service.standard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import okcode.service.standard.enums.AreaLevel;
import okcode.service.standard.util.StandardConstants;


@Entity
@Table(name = StandardConstants.TABLE_PREFIX_NAMING + "standard_area")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Area implements Serializable {

	private static final long serialVersionUID = 8217067386398303531L;
	
	@Id
	@Column(name = "code", unique = true, nullable = false)
	private Long code;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Enumerated
	@Column(name = "level", nullable = false)
	private AreaLevel level;
	
	@Column(name = "pcode")
	private Long pcode;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AreaLevel getLevel() {
		return level;
	}

	public void setLevel(AreaLevel level) {
		this.level = level;
	}

	public Long getPcode() {
		return pcode;
	}

	public void setPcode(Long pcode) {
		this.pcode = pcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Area other = (Area) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
