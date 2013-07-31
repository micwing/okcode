package okcode.service.standard.util;

import java.util.HashSet;
import java.util.Set;

import okcode.framework.property.Constants;
import okcode.service.standard.enums.Status;


public class StandardConstants extends Constants {
	public interface Cache {
		final String COMMON_AREA = "_COMMON_AREA_";
		final String COMMON_AREA_GROUP = "_COMMON_AREA_GROUP_";
		final String PRODUCT_CATALOG = "_PRODUCT_CATALOG_";
	}
	
	public static final Set<Status> ENABLE_STATUS = new HashSet<Status>();
	static {
		ENABLE_STATUS.add(Status.NORMAL);
		ENABLE_STATUS.add(Status.PAUSED);
	}
	
	public static final String TABLE_PREFIX_NAMING = "m_";
	public final static String FILESTORE_BASEPATH = "D://develop//filestore";

}
