//package okcode.biz.trading.intf;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.validation.annotation.Validated;
//
//import okcode.biz.trading.model.Site;
//import okcode.service.standard.enums.Status;
//
//
///**
// * @author MICHAEL
// */
//@Validated
//public interface SiteService {
//	
//	Site findById(@NotNull @Min(1) Long id);
//	
//	List<Site> findByUser(@NotNull @Min(1) Long userId);
//	
//	Site findByAlias(@NotBlank String alias);
//	
//	void deleteByUser(@NotEmpty Set<Long> siteIds,@NotNull @Min(1) Long userId);
//	
//	Site create(@NotNull Site site);
//	
//	Site updateBaseInfo(@NotNull Site site,@NotNull @Min(1) Long userId);
//	
//	Site updateTemplate(@NotNull Site site,@NotNull @Min(1) Long userId);
//	
//	Site updateSeoInfo(@NotNull Site site,@NotNull @Min(1) Long userId);
//	
//	Site updateAttributes(@NotNull @Min(1) Long siteId,@NotNull Map<String, String> attributes);
//	
//	Site changeStatus(Long siteId, Status status, Long userId);
//	
//	Site savePausedNotice(Long siteId, String notice, Long userId);
//	
//	boolean checkUserOwn(Set<Long> siteIds, Long userId);
//}
