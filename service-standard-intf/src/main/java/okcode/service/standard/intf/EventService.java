package okcode.service.standard.intf;


public interface EventService {
	
	void createCatalogSuccessEvent(Long userId, Long owner, String title);
	void updateCatalogSuccessEvent(Long userId, Long owner, String title);
	
	void sendResetPasswordEmailEvent(Long userId, String userAddress,String passwordUrl);
	void updatePasswordSuccessEvent(Long userId);
}
