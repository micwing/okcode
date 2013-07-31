/**
 * @Project: main-core
 * @File: AuthService.java
 * @package okcode.mall.api.service.identity
 * @Description:
 * @author micwing
 * @date 2013-4-7 下午1:05:49
 * @version V1.0
 *
 * Copyright (c) 2013 OneKr Soft Studio. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package okcode.service.standard.intf;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import okcode.service.standard.enums.UserGroup;
import okcode.service.standard.model.UserAuth;

@Validated
public interface UserAuthService {
	
	UserAuth findUserAuthByName(@NotBlank String credentialName);
	boolean isExistCredentialName(@NotBlank String credentialName);
	UserAuth createByName(@NotBlank String credentialName, @NotBlank String password, @NotNull UserGroup userGroup);
	
	UserAuth findUserAuthByEmail(@NotBlank String credentialEmail);
	boolean isExistCredentialEmail(@NotBlank String credentialEmail);
	UserAuth createByEmail(@NotBlank String credentialEmail, @NotBlank String password, @NotNull UserGroup userGroup);
	
	void updatePasswordByEmail(@NotBlank String credentialEmail, @NotBlank String newPassword);
	
}
