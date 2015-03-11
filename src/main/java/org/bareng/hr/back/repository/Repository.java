package org.bareng.hr.back.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;

/**
 * Generic repository support for MyBatis.
 * 
 * @author zakyalvan
 *
 * @param <T>
 * @param <I>
 */
public interface Repository<T, I> {
	/**
	 * Save one entity.
	 * 
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * Save collection of entity.
	 * 
	 * @param entities
	 */
	void save(Iterable<T> entities);
	
	/**
	 * Check whether given entity id exists.
	 * 
	 * @param id
	 * @return
	 */
	boolean exists(I id);
	
	/**
	 * Find all registered entity.
	 * 
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * Find paged list of registered entities based on given {@link RowBounds}
	 * object.
	 * 
	 * @param rowBounds
	 * @return
	 */
	List<T> findAll(RowBounds rowBounds);
	
	/**
	 * Find one entity with given id
	 * 
	 * @param id
	 * @return
	 */
	T findOne(I id);
	
	/**
	 * Count all registered entities.
	 * 
	 * @return
	 */
	Long countAll();
}
