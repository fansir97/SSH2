package base;

import java.util.ArrayList; 
import java.util.List; 


public class PageBean {
	private int allcount; // 总记录数
	private int allpage;// 总页数
	private int pagecode; // 页码
	private int pagesize; // 每页记录数
	private List data = new ArrayList(); // 当前页数据

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
