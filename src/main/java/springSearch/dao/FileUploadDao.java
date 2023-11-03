package springSearch.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import springSearch.model.UserFiles;

@Repository
public interface FileUploadDao extends JpaRepository<UserFiles, Long> { 
	
	
}
