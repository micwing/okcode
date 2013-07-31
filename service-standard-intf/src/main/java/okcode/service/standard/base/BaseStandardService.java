package okcode.service.standard.base;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import okcode.service.standard.enums.Status;

public interface BaseStandardService<T> {
	
	T create(@NotNull @Valid T e);
	
	T update(@NotNull @Valid T e);
	
	T updateStatus(@NotNull @Min(1) Long id, @NotNull Status status);
	
	T delete(@NotNull @Min(1) Long id);
	
	
	T findById(@NotNull @Min(1) Long id);
	
	List<T> findByIds(@NotEmpty Collection<Long> ids);
	
	List<T> findByStatus(@NotEmpty Collection<Status> status);
	
	List<T> findAll();
	
	
	List<T> findByBizOwners(@NotNull @Min(1) Long bizId, @NotEmpty Collection<Long> owners, @NotEmpty Collection<Status> status);
	
	List<T> findByBizsOwner(@NotEmpty Collection<Long> bizIds, @NotNull @Min(1) Long owner, @NotEmpty Collection<Status> status);
	
	
	List<T> findByUser(@NotNull @Min(1) Long userId, @NotEmpty Collection<Status> status);
	
	void checkUser(@NotEmpty Collection<Long> ids, @NotNull @Min(1) Long userId);
	
	
	void exchangeRank(@NotNull @Min(1) Long id, @NotNull @Min(1) Long id2);
	
	long findMaxRank();
	
	long findMinRank();
}
