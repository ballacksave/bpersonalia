package org.bareng.hr.back.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * <p>Generic repository support for MyBatis. Please note, this just a contract for
 * your repository, you must write MyBatis map of every required method, no magic
 * happen here. Write maps only for required methods first, remember YAGNI.</p>
 * 
 * <b>NOTE</p>
 * <p>Not all method scenarios proven can be handled using MyBatis, need to explore</p>
 * 
 * @author zakyalvan
 *
 * @param <T>
 * @param <I>
 */
public interface Repository<T, I> {
    /**
     * <p>Save one entity. Id of entity must be assigned manually on MyBatis
     * mapper.</p>
     * 
     * @param entity
     * @return flag whether persist success or not.
     */
    boolean insert(T entity);

    /**
     * <p>Save collection of entities.</p>
     * 
     * <b>NOTE</b>
     * <p>Current issues, we cant get the id of inserted entities when using this method.
     * So, if you want (and your collection reasonable), just iterate, save them one-by-one
     * 
     * https://code.google.com/p/mybatis/issues/detail?id=33</p>
     * 
     * @param entities
     * @return number of persisted entity.
     */
    int insertAll(List<T> entities);

    /**
     * <p>Update single entity.</p>
     * 
     * @param entity
     * @return
     */
    boolean update(T entity);
    
    /**
     * <p>Update collection of entities.</p>
     * 
     * @param entities
     * @return
     */
    int updateAll(Iterable<T> entities);
    
    /**
     * <p>Check whether given entity id exists.</p>
     * 
     * @param id
     * @return
     */
    boolean exists(I id);

    /**
     * <p>Find all registered entity.</p>
     * 
     * @return
     */
    List<T> findAll();

    /**
     * <p>Find paged list of registered entities based on given {@link RowBounds}
     * object.</p>
     * 
     * @param rowBounds
     * @return
     */
    List<T> findAll(RowBounds rowBounds);

    /**
     * <p>Find paged list of registered entities based on given {@link RowBounds}
     * object and sorts parameter to hint order of returned result.</p>
     * 
     * @param rowBounds
     * @param sort
     * @return
     */
    List<T> findAll(RowBounds rowBounds, String... sorts);
    
    /**
     * <p>Find one entity with given id</p>
     * 
     * @param id
     * @return
     */
    T findOne(I id);

    /**
     * <p>Count all registered entities.</p>
     * 
     * @return
     */
    Long countAll();
    
    /**
     * <p>Delete entity by id.</p>
     * 
     * @param id
     * @return
     */
    boolean delete(I id);
    
    /**
     * 
     * @param ids
     * @return
     */
    int deleteAll(Iterable<I> ids);
}
