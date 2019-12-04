package base;

import java.io.Serializable; 
import java.sql.SQLException; 
import java.util.List; 
import org.hibernate.Criteria; 
import org.hibernate.HibernateException; 
import org.hibernate.Query; 
import org.hibernate.Session; 
import org.hibernate.criterion.Criterion;  

import org.springframework.orm.hibernate4.HibernateCallback; 
import org.springframework.orm.hibernate4.support.HibernateDaoSupport; 


public class GenericHibernateDao<T extends Serializable, ID extends Serializable>
		extends HibernateDaoSupport implements GenericDao<T, ID> {
	// 持久化类
	private Class<T> persistentClass;

	// 使用构造子注入
	public GenericHibernateDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	// 批量更新
	public void bulkUpdate(String hql, Object[] params) {
		this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	// 增加
	public T create(T entity) {
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	// 删除
	public void delete(ID id) {
		this.getHibernateTemplate().delete(findById(id));
	}

	// 查找所有记录
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.getHibernateTemplate().loadAll(this.getPersistentClass());
	}

	// 按HQL查询
	@SuppressWarnings("unchecked")
	public List findByHQL(String hql, Object[] params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	// 按主键查询
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) this.getHibernateTemplate().load(persistentClass, id);
	}

	// 分页查询
	@SuppressWarnings("unchecked")
	public PageBean findByPage(final String hql, final int pagecode,
			final int pagesize, final Object[] params) {
		return (PageBean) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						PageBean pb = new PageBean();
						// 数据
						Query q = session.createQuery(hql);
						for (int i = 0; i < params.length; i++)
							q.setParameter(i, params[i]);
						q.setMaxResults(pagesize);
						q.setFirstResult((pagecode - 1) * pagesize);
						pb.setData(q.list());
						// 总记录数
						q = session.createQuery("select count(*) "
								+ hql.substring(hql.toLowerCase().indexOf(
										"from")));
						for (int i = 0; i < params.length; i++)
							q.setParameter(i, params[i]);
						pb.setAllcount((Integer.valueOf(q.uniqueResult().toString())));
						pb.setPagecode(pagecode);
						pb.setPagesize(pagesize);
						return pb;
					}
				});
	}

	// 修改
	public T update(T entity) {
		this.getHibernateTemplate().update(entity);
		return entity;
	}

	// 内部使用条件查询方法
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final List<Criterion> criterion) {
		return (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria crit = session
								.createCriteria(getPersistentClass());
						for (Criterion c : criterion) {
							crit.add(c);
						}
						return crit.list();
					}
				});
	}

}