package jmeter_socket;

public class FlowsReq {

	private int wbussinessid;
	private int period;
	private int setcode;
	private String code;
	private int offset;
	private int num;// �������
	private int resrv;

	// �ʽ�����
	private int req;
	private int startxh;// ��ʼ���
	private int sorttype;// ��������
	private int coltype;// ������У��������Ϊ40����������
	private int daytype;

	// 3.4��ѡDDE
	private String codehead;

	public String getCodehead() {

		return codehead;
	}

	public void setCodehead(String codehead) {

		this.codehead = codehead;
	}

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
