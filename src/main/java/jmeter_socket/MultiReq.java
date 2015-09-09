package jmeter_socket;

public class MultiReq {

	private short req;
	private short setdomain; // 市场分类
	private short coltype; // 股票栏目代码
	private short startxh;
	private short wantnum;// �?�?200
	private short sorttype;// 升降�?

	public final int size() {

		final int size = 12; // 请求长度
		return size;
	}

	public short getReq() {

		return req;
	}

	public void setReq(short req) {

		this.req = req;
	}

	public short getSetdomain() {

		return setdomain;
	}

	public void setSetdomain(short setdomain) {

		this.setdomain = setdomain;
	}

	public short getColtype() {

		return coltype;
	}

	public void setColtype(short coltype) {

		this.coltype = coltype;
	}

	public short getStartxh() {

		return startxh;
	}

	public void setStartxh(short startxh) {

		this.startxh = startxh;
	}

	public short getWantnum() {

		return wantnum;
	}

	public void setWantnum(short wantnum) {

		this.wantnum = wantnum;
	}

	public short getSorttype() {

		return sorttype;
	}

	public void setSorttype(short sorttype) {

		this.sorttype = sorttype;
	}
}
