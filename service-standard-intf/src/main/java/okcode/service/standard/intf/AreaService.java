package okcode.service.standard.intf;
//package okcode.mall.api.service.standard;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.validation.annotation.Validated;
//
//import okcode.framework.exception.AppException;
//import okcode.mall.api.service.standard.dto.AreaDto;
//import okcode.mall.core.enums.AreaLevel;
//import okcode.mall.core.model.Area;
//
//
///**
// * 地区标准数据接口
// * 提供区域Area对象的多维度查询
// * 
// * @author MICHAEL
// * 
// */
//@Validated
//public interface AreaService {
//	/**
//	 * 添加区域
//	 * @param areaDto
//	 * @return
//	 * @throws AppException
//	 */
//	long saveArea(@NotNull @Valid AreaDto areaDto) throws AppException;
//	/**
//	 * 删除区域
//	 * @param ids
//	 * @throws AppException
//	 */
//	void deleteArea(@NotEmpty List<Long> ids) throws AppException;
//	/**
//	 * 删除区域
//	 * @param id
//	 * @throws AppException
//	 */
//	void deleteArea(@NotNull Long id) throws AppException;
//	/**
//	 * 查询一个区域
//	 * 
//	 * @param areaId
//	 * @return
//	 */
//	Area findArea(@NotNull @Min(0) Long areaCode) throws AppException;
//
//	/**
//	 * 查询多个区域
//	 * 
//	 * @param codes
//	 * @return
//	 */
//	Set<Area> findArea(@NotEmpty Set<Long> codes) throws AppException;
//
//	/**
//	 * 查询多个区域
//	 * 
//	 * @param codes
//	 * @return
//	 */
//	Map<Long, Area> findAreaMap(@NotEmpty Set<Long> codes) throws AppException;
//
//	/**
//	 * 查询所有区域
//	 * 
//	 * @param level
//	 * @return
//	 */
//	List<Area> findArea(@NotNull AreaLevel level) throws AppException;
//
//	/**
//	 * 查询所有区域
//	 * 
//	 * @param level
//	 * @return
//	 */
//	List<Area> findAreaByName(@NotBlank String name) throws AppException;
//	
//	/**
//	 * 查询属于指定区域的所有区域
//	 * 
//	 * @param pcode
//	 * @return
//	 */
//	List<Area> findAreaListByParent(@NotNull @Min(0) Long pcode) throws AppException;
//
//	/**
//	 * 查询属于指定区域的所有区域
//	 * 
//	 * @param pcode
//	 * @return
//	 */
//	Map<Long, Area> findAreaMapByParent(@NotNull @Min(0) Long pcode) throws AppException;
//
//	/**
//	 * 查询上级区域
//	 * 
//	 * @param code
//	 * @return
//	 */
//	Area findParentArea(@NotNull @Min(0) Long code) throws AppException;
//
//	/**
//	 * 根据条件查询区域列表
//	 * @param pageable
//	 * @param areaDto
//	 * @return
//	 * @throws AppException
//	 */
//	Page<Area> listArea(Pageable pageable, AreaDto areaDto) throws AppException;
//	
//	/**
//	 * 查询全部
//	 * @return
//	 * @throws AppException
//	 */
//	List<Area> findAll() throws AppException;
//	
//	/**
//	 * 查询父子区域map
//	 * @return
//	 */
//	List<AreaDto> getTwoLevelArea();
//	
//}
