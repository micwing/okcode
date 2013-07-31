package okcode.service.standard.intf;

import java.util.Date;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import okcode.service.standard.model.OperateLog;

@Validated
public interface OperateLogService {
	
	List<OperateLog> list(Query query, Sort sort);
	
	class Query {
		private Long bizId;
		private Long owner;
		private Long userId;
		private String keyword;
		private Date startAt;
		private Date endAt;
		public Long getBizId() {
			return bizId;
		}
		public void setBizId(Long bizId) {
			this.bizId = bizId;
		}
		public Long getOwner() {
			return owner;
		}
		public void setOwner(Long owner) {
			this.owner = owner;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public Date getStartAt() {
			return startAt;
		}
		public void setStartAt(Date startAt) {
			this.startAt = startAt;
		}
		public Date getEndAt() {
			return endAt;
		}
		public void setEndAt(Date endAt) {
			this.endAt = endAt;
		}
	}
	class Sort {
		private Boolean ascBizId;
		private Boolean ascOwner;
		private Boolean ascUserId;
		private Boolean ascCreateAt;
		public Boolean getAscBizId() {
			return ascBizId;
		}
		public void setAscBizId(Boolean ascBizId) {
			this.ascBizId = ascBizId;
		}
		public Boolean getAscOwner() {
			return ascOwner;
		}
		public void setAscOwner(Boolean ascOwner) {
			this.ascOwner = ascOwner;
		}
		public Boolean getAscUserId() {
			return ascUserId;
		}
		public void setAscUserId(Boolean ascUserId) {
			this.ascUserId = ascUserId;
		}
		public Boolean getAscCreateAt() {
			return ascCreateAt;
		}
		public void setAscCreateAt(Boolean ascCreateAt) {
			this.ascCreateAt = ascCreateAt;
		}
	}
}

