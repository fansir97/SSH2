package base;

import java.io.Serializable; 
import java.util.List; 


public interface GenericDao<T extends Serializable, ID extends Serializable> {
	// 增
	public T create(T entity);

	// 删
	public void delete(ID id);

	// 改
	public T update(T entity);

	// 查找所有的记录
	public List<T> findAll();

	// 按 ID 查找
	public T findById(ID id);

	// 查找对象
	public List findByHQL(String hql, Object[] params);

	// 分页显示
	public PageBean findByPage(String hql, int pagecode, int pagesize,
			Object[] params);

	// 批量更新
	public void bulkUpdate(String hql, Object[] params);
}