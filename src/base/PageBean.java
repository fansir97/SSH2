package base;

import java.util.ArrayList; 
import java.util.List; 


public class PageBean {
	private int allcount; // �ܼ�¼��
	private int allpage;// ��ҳ��
	private int pagecode; // ҳ��
	private int pagesize; // ÿҳ��¼��
	private List data = new ArrayList(); // ��ǰҳ����

	public int getAllcount() {
		return allcount;
	}

	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}

	public int getAllpage() {
		return allcount % pagesize == 0 ? allcount / pagesize : allcount
				/ pagesize + 1;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}
