package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class BottomInfoDto implements CommonConfigDto {
	
	public BottomInfoDto setMap(Map<String, String> map) {
		this.addressInfo = map.get("addressInfo");
		this.contectInfo = map.get("contectInfo");
		this.faxInfo = map.get("faxInfo");
		this.copyrightInfo = map.get("copyrightInfo");
		this.moreCode = map.get("moreCode");
		this.otherInfo = map.get("otherInfo");
		return this;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("addressInfo", getAddressInfo());
		map.put("faxInfo", getFaxInfo());
		map.put("copyrightInfo", getCopyrightInfo());
		map.put("contectInfo", getContectInfo());
		map.put("moreCode", getMoreCode());
		map.put("otherInfo", getOtherInfo());
		return map;
	}
	
	public Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("addressInfo");
		set.add("faxInfo");
		set.add("copyrightInfo");
		set.add("contectInfo");
		set.add("moreCode");
		set.add("otherInfo");
		return set;
	}
	
	private Long userId;
	
	private String addressInfo;
	
	private String contectInfo;
	
	private String faxInfo;
	
	private String copyrightInfo;
	
	private String moreCode;
	
	private String otherInfo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	public String getContectInfo() {
		return contectInfo;
	}

	public void setContectInfo(String contectInfo) {
		this.contectInfo = contectInfo;
	}

	public String getFaxInfo() {
		return faxInfo;
	}

	public void setFaxInfo(String faxInfo) {
		this.faxInfo = faxInfo;
	}

	public String getCopyrightInfo() {
		return copyrightInfo;
	}

	public void setCopyrightInfo(String copyrightInfo) {
		this.copyrightInfo = copyrightInfo;
	}

	public String getMoreCode() {
		return moreCode;
	}

	public void setMoreCode(String moreCode) {
		this.moreCode = moreCode;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}
