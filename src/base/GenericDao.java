package base;

import java.io.Serializable; 
import java.util.List; 


public interface GenericDao<T extends Serializable, ID extends Serializable> {
	// ��
	public T create(T entity);

	// ɾ
	public void delete(ID id);

	// ��
	public T update(T entity);

	// �������еļ�¼
	public List<T> findAll();

	// �� ID ����
	public T findById(ID id);

	// ���Ҷ���
	public List findByHQL(String hql, Object[] params);

	// ��ҳ��ʾ
	public PageBean findByPage(String hql, int pagecode, int pagesize,
			Object[] params);

	// ��������
	public void bulkUpdate(String hql, Object[] params);
}