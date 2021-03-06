package okcode.biz.trading.dto;

import java.util.List;

import okcode.biz.trading.model.Catalog;

public class CatalogItem {
	
	private Catalog catalog;
	
	private boolean activeFlag;
	
	private List<CatalogItem> subCatalog;

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<CatalogItem> getSubCatalog() {
		return subCatalog;
	}

	public void setSubCatalog(List<CatalogItem> subCatalog) {
		this.subCatalog = subCatalog;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
