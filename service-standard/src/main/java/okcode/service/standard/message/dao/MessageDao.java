package okcode.service.standard.message.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import okcode.service.standard.model.Message;


@Repository
public interface MessageDao extends JpaRepository<Message, Long>{
	
}
