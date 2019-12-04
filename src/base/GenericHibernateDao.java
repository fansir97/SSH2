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
	// �־û���
	private Class<T> persistentClass;

	// ʹ�ù�����ע��
	public GenericHibernateDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	// ��������
	public void bulkUpdate(String hql, Object[] params) {
		this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	// ����
	public T create(T entity) {
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	// ɾ��
	public void delete(ID id) {
		this.getHibernateTemplate().delete(findById(id));
	}

	// �������м�¼
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.getHibernateTemplate().loadAll(this.getPersistentClass());
	}

	// ��HQL��ѯ
	@SuppressWarnings("unchecked")
	public List findByHQL(String hql, Object[] params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	// ��������ѯ
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) this.getHibernateTemplate().load(persistentClass, id);
	}

	// ��ҳ��ѯ
	@SuppressWarnings("unchecked")
	public PageBean findByPage(final String hql, final int pagecode,
			final int pagesize, final Object[] params) {
		return (PageBean) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						PageBean pb = new PageBean();
						// ����
						Query q = session.createQuery(hql);
						for (int i = 0; i < params.length; i++)
							q.setParameter(i, params[i]);
						q.setMaxResults(pagesize);
						q.setFirstResult((pagecode - 1) * pagesize);
						pb.setData(q.list());
						// �ܼ�¼��
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

	// �޸�
	public T update(T entity) {
		this.getHibernateTemplate().update(entity);
		return entity;
	}

	// �ڲ�ʹ��������ѯ����
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