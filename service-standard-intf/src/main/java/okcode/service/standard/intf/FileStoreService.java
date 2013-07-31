//package okcode.service.standard.intf;
//
//import java.util.List;
//import java.util.Set;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.multipart.MultipartFile;
//
//import okcode.service.standard.enums.FileType;
//import okcode.service.standard.model.FileStore;
//
//
///**
// * 文件储存服务接口
// * 
// * @author MICHAEL
// * 
// */
//@Validated
//public interface FileStoreService {
//	
//	FileStore save(@NotNull @Valid FileStore fileStore, @NotNull MultipartFile fileUpload);
//	
//	int checkFileSize(MultipartFile fileUpload);
//	
//	FileType checkFileType(@NotNull MultipartFile fileUpload, Set<FileType> allowFileTypes);
//	
//	List<FileStore> findByUser(Long userId);
//	
//	List<FileStore> findByBizOwner(Long bizId, Set<Long> owners);
//	
//	void delete(@NotEmpty Set<Long> id);
//	
//}
