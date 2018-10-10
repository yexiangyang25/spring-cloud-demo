package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.repository.BaseRepository;
import org.moy.spring.test.example.service.BaseService;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * <p> 基础服务实现类
 * Created on 2018/10/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    public static final String ENTITY_SUFFIX = "Entity";
    public static final String REPOSITORY_SUFFIX = "Repository";
    public static final String BASE_REPOSITORY_NAME = "baseRepository";

    protected BaseRepository<T, PK> baseRepository;

    /**
     * <p>Description:[借助spring初始化bean执行方法]</p>
     * Created on 2018/10/10
     * @author 叶向阳
     */
    @PostConstruct
    private void initBind() throws NoSuchFieldException, IllegalAccessException {
        // 获取继承该类的类名 即子类
        Class<? extends BaseServiceImpl> subClass = this.getClass();
        ParameterizedType type = (ParameterizedType) subClass.getGenericSuperclass();
        // 获取子类第一个泛型参数 即数据库实体类
        Class<T> entityClazz = (Class<T>) type.getActualTypeArguments()[0];

        String simpleName = entityClazz.getSimpleName();
        String entityName = getEntityName(simpleName);
        // 获取在子类中 数据库操作实体的字段名
        String entityRepositoryName = getEntityRepositoryName(entityName);

        Field subRepositoryField = subClass.getDeclaredField(entityRepositoryName);
        subRepositoryField.setAccessible(true);
        Field baseField = subClass.getSuperclass().getDeclaredField(BASE_REPOSITORY_NAME);
        baseField.setAccessible(true);
        baseField.set(this, subRepositoryField.get(this));
    }

    private String getEntityRepositoryName(String entityName) {
        StringBuilder builder = new StringBuilder();
        builder.append(entityName.substring(0, 1).toLowerCase());
        builder.append(entityName.substring(1));
        builder.append(REPOSITORY_SUFFIX);
        return builder.toString();
    }

    private String getEntityName(String simpleName) {
        String entityName;
        int lastIndex = simpleName.lastIndexOf(ENTITY_SUFFIX);
        if (lastIndex > 0) {
            entityName = simpleName.substring(0, lastIndex);
        } else {
            entityName = simpleName;
        }
        return entityName;
    }

    @Override
    public Integer insert(T entity) {
        return baseRepository.insert(entity);
    }

    @Override
    public Integer addAll(List<T> entity) {
        return baseRepository.addAll(entity);
    }

    @Override
    public Integer delete(PK id) {
        return baseRepository.delete(id);
    }

    @Override
    public Integer delete(T entity) {
        return baseRepository.delete(entity);
    }

    @Override
    public Integer deleteAll(List<PK> ids) {
        return baseRepository.deleteAll(ids);
    }

    @Override
    public Integer deleteAll(PK[] ids) {
        return baseRepository.deleteAll(ids);
    }

    @Override
    public Integer update(T entity) {
        return baseRepository.update(entity);
    }

    @Override
    public Integer updateAll(List<T> entity) {
        return baseRepository.updateAll(entity);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> query(T entity) {
        return baseRepository.query(entity);
    }

    @Override
    public T get(T entity) {
        return baseRepository.get(entity);
    }

    @Override
    public T get(PK id) {
        return baseRepository.get(id);
    }

    @Override
    public List<T> find(PK[] ids) {
        return baseRepository.find(ids);
    }

    @Override
    public Long count() {
        return baseRepository.count();
    }

    @Override
    public Long count(T entity) {
        return baseRepository.count(entity);
    }
}
