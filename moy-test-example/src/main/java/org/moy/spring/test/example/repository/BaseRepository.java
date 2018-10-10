package org.moy.spring.test.example.repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p> 基础数据库操作类
 * Created on 2018/10/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public interface BaseRepository<T, PK extends Serializable> {

    Integer insert(T entity);

    Integer addAll(List<T> entity);

    Integer delete(PK id);

    Integer delete(T entity);

    Integer deleteAll(List<PK> ids);

    Integer deleteAll(PK[] ids);

    Integer update(T entity);

    Integer updateAll(List<T> entity);

    List<T> query(T entity);

    List<T> findAll();

    T get(T entity);

    T get(PK id);

    List<T> find(PK[] ids);

    Long count();

    Long count(T entity);
}
