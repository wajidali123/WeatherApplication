/**
 * 
 */
package org.forcast.app.repository;

import org.forcast.app.entity.UserEntity;
import org.forcast.app.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	@Query(value = "SELECT * FROM users u WHERE u.name = :name", nativeQuery = true)
    public UserEntity finUserByName(@Param("name") String name);
}
