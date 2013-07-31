//package okcode.service.standard.filestore.service.impl;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.shiro.util.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.utils.Md5Coder;
//import okcode.service.standard.enums.FileType;
//import okcode.service.standard.enums.Status;
//import okcode.service.standard.filestore.dao.FileStoreDao;
//import okcode.service.standard.intf.FileStoreService;
//import okcode.service.standard.model.FileStore;
//import okcode.service.standard.util.StandardConstants;
//
//@Service
//public class FileStoreServiceImpl implements FileStoreService {
//
//	@Autowired
//	private FileStoreDao fileStoreDao;
//	
//	@Override
//	public FileStore save(FileStore fileStore, MultipartFile fileUpload) {
//		if (fileUpload.isEmpty())
//			throw new AppException(ErrorCode.MISS_PARAM, "文件不能空");
//
//		FileType fileType = checkFileType(fileUpload, Collections.singleton(fileStore.getType()));
//		String originalFilename = fileUpload.getOriginalFilename();
//		String[] suffixs = originalFilename.split("\\.");
//		String suffixName = suffixs[suffixs.length - 1];
//		
//		int fileSize = checkFileSize(fileUpload);
//
//		// get file store path.
//		String fileStoreName = "";
//		try {
//			fileStoreName = Md5Coder.EncoderByMd5(new Date().getTime()
//					+ ((int) (Math.random() * 1000) + ""));
//		} catch (Exception e) {
//			throw new AppException(ErrorCode.SERVER_ERROR);
//		}
//
//		// store file info.
//		Date now = new Date();
//		fileStore.setType(fileType);
//		fileStore.setId(null);
//		fileStore.setStoreName(fileStoreName);
//		fileStore.setCreateAt(now);
//		fileStore.setOriginalName(originalFilename);
//		fileStore.setSuffixName(suffixName);
//		fileStore.setSize(new Long(fileSize));
//		if (fileStore.getStatus() == null)
//			fileStore.setStatus(Status.NORMAL);
//		fileStore.setUpdateAt(now);
//		fileStoreDao.save(fileStore);
//
//		// store file.
//		storeFile(fileUpload,
//				StandardConstants.FILESTORE_BASEPATH
//						+ File.separator
//						+ fileStore.getUserId()
//						+ File.separator + fileStoreName);
//		return fileStore;
//	}
//
//	private void storeFile(MultipartFile fileUpload, String fileStorePath) {
//		if (fileUpload.isEmpty())
//			throw new AppException(ErrorCode.MISS_PARAM, "文件不能空");
//
//		try {
//			File filePath = new File(fileStorePath);
//			if (!filePath.getParentFile().exists()) {
//				filePath.getParentFile().mkdirs();
//			}
//			FileCopyUtils.copy(fileUpload.getBytes(), filePath);
//		} catch (IOException e) {
//			throw new AppException(ErrorCode.SERVER_ERROR, "保存文件出错");
//		}
//	}
//	
//	@Override
//	public int checkFileSize(MultipartFile fileUpload) {
//		// check file size,B.
//		int fileSize = (int) fileUpload.getSize();
////		long m = StandardConstants.FILESTORE_FILE_MAXSIZE;
////		if (fileSize > m * 1024 * 1024)
////			throw new AppException(ErrorCode.ILLEGAL_PARAM,
////					"上传的文件太大，文件大小不能超过"+m+"M");
//		return fileSize;
//	}
//
//	@Override
//	public FileType checkFileType(MultipartFile fileUpload,Set<FileType> allowFileTypes) {
//		// check file type.
//		String originalFilename = fileUpload.getOriginalFilename();
//		String[] suffixs = originalFilename.split("\\.");
//		String suffix = "." + suffixs[suffixs.length - 1];
//		
//		FileType type = null;
//		if (".zip.rar".indexOf(suffix.toLowerCase()) > -1)
//			type = FileType.PACKAGE;
//		else if (".jpg.gif.png.ico.bmp".indexOf(suffix.toLowerCase()) > -1)
//			type = FileType.IMAGE;
//		else if (".avi.wmv.rmvb.rm.flash.mp4.mid.3gp".indexOf(suffix.toLowerCase()) > -1)
//			type = FileType.VIDEO;
//		else if (".txt.doc.docx.xls.xlsx.pdf".indexOf(suffix.toLowerCase()) > -1)
//			type = FileType.DOC;
//		else if (".mp3.wma.mid".indexOf(suffix.toLowerCase()) > -1)
//			type = FileType.AUDIO;
//		else 
//			type = FileType.OTHER;
//		
//		if (!allowFileTypes.contains(type))
//			throw new AppException(ErrorCode.RANGE_ERROR, "文件类型不合要求");
//		
//		return type;
//	}
//
//	@Override
//	public void delete(Set<Long> ids) {
//		List<FileStore> list = fileStoreDao.findByIds(ids);
//		if (!CollectionUtils.isEmpty(list)) {
//			for (FileStore fs : list) {
//				fileStoreDao.delete(fs);
//			}
//		}
//	}
//
//	@Override
//	public List<FileStore> findByUser(Long userId) {
//		return fileStoreDao.findByUser(userId);
//	}
//
//	@Override
//	public List<FileStore> findByBizOwner(Long bizId, Set<Long> owners) {
//		return fileStoreDao.findByBizOwner(bizId, owners);
//	}
//
//}
