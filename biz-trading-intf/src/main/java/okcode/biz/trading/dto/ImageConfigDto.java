package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ImageConfigDto {
	
	public ImageConfigDto() {
	}
	
	public ImageConfigDto(Map<String, String> map) {
		this.productImageHeight = map.get("productImageHeight");
		this.productImageWidth = map.get("productImageWidth");
		this.imageImageHeight = map.get("imageImageHeight");
		this.imageImageWidth = map.get("imageImageWidth");
		this.downloadImageWidth = map.get("downloadImageWidth");
		this.downloadImageHeight = map.get("downloadImageHeight");
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("productImageHeight", getProductImageHeight());
		map.put("productImageWidth", getProductImageWidth());
		map.put("imageImageHeight", getImageImageHeight());
		map.put("imageImageWidth", getImageImageWidth());
		map.put("downloadImageWidth", getDownloadImageWidth());
		map.put("downloadImageHeight", getDownloadImageHeight());
		return map;
	}
	
	public static Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("productImageHeight");
		set.add("productImageWidth");
		set.add("imageImageHeight");
		set.add("imageImageWidth");
		set.add("downloadImageWidth");
		set.add("downloadImageHeight");
		return set;
	}
	
	private Long userId;
	
	private String productImageHeight;
	
	private String productImageWidth;
	
	private String imageImageHeight;
	
	private String imageImageWidth;
	
	private String downloadImageWidth;
	
	private String downloadImageHeight;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProductImageHeight() {
		return productImageHeight;
	}

	public void setProductImageHeight(String productImageHeight) {
		this.productImageHeight = productImageHeight;
	}

	public String getProductImageWidth() {
		return productImageWidth;
	}

	public void setProductImageWidth(String productImageWidth) {
		this.productImageWidth = productImageWidth;
	}

	public String getImageImageHeight() {
		return imageImageHeight;
	}

	public void setImageImageHeight(String imageImageHeight) {
		this.imageImageHeight = imageImageHeight;
	}

	public String getImageImageWidth() {
		return imageImageWidth;
	}

	public void setImageImageWidth(String imageImageWidth) {
		this.imageImageWidth = imageImageWidth;
	}

	public String getDownloadImageWidth() {
		return downloadImageWidth;
	}

	public void setDownloadImageWidth(String downloadImageWidth) {
		this.downloadImageWidth = downloadImageWidth;
	}

	public String getDownloadImageHeight() {
		return downloadImageHeight;
	}

	public void setDownloadImageHeight(String downloadImageHeight) {
		this.downloadImageHeight = downloadImageHeight;
	}

}
