package jmeter_socket;

public class FlowsReq {

	private int wbussinessid;
	private int period;
	private int setcode;
	private String code;
	private int offset;
	private int num;// 请求个数
	private int resrv;

	// 资金流向
	private int req;
	private int startxh;// 起始序号
	private int sorttype;// 排序类型
	private int coltype;// 排序的列，代码的列为40，依次类�?
	private int daytype;// 1 当日 3三日 5五日 10十日

	public int getReq() {

		return req;
	}

	public void setReq(int req) {

		this.req = req;
	}

	public int getStartxh() {

		return startxh;
	}

	public void setStartxh(int startxh) {

		this.startxh = startxh;
	}

	public int getSorttype() {

		return sorttype;
	}

	public void setSorttype(int sorttype) {

		this.sorttype = sorttype;
	}

	public int getColtype() {

		return coltype;
	}

	public void setColtype(int coltype) {

		this.coltype = coltype;
	}

	public int getWbussinessid() {

		return wbussinessid;
	}

	public void setWbussinessid(int wbussinessid) {

		this.wbussinessid = wbussinessid;
	}

	public int getPeriod() {

		return period;
	}

	public void setPeriod(int period) {

		this.period = period;
	}

	public int getSetcode() {

		return setcode;
	}

	public void setSetcode(int setcode) {

		this.setcode = setcode;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	public int getOffset() {

		return offset;
	}

	public void setOffset(int offset) {

		this.offset = offset;
	}

	public int getNum() {

		return num;
	}

	public void setNum(int num) {

		this.num = num;
	}

	public int getResrv() {

		return resrv;
	}

	public void setResrv(int resrv) {

		this.resrv = resrv;
	}

	public int getDaytype() {

		return daytype;
	}

	public void setDaytype(int daytype) {

		this.daytype = daytype;
	}
}
