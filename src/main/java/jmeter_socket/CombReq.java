package jmeter_socket;

/**
 * 组合行情同时请求几个股票行情时使�?
 * 
 * @author Administrator
 *
 */
public class CombReq {

	private short req;
	private short wantnum; // �?�?200
	private String codehead;// 7�? 市场代码1�?+6位股票代�?

	public final int size() {

		final int size = 11; // 请求长度
		return size;
	}

	public short getReq() {

		return req;
	}

	public void setReq(short req) {

		this.req = req;
	}

	public short getWantnum() {

		return wantnum;
	}

	public void setWantnum(short wantnum) {

		this.wantnum = wantnum;
	}

	public String getCodehead() {

		return codehead;
	}

	public void setCodehead(String codehead) {

		this.codehead = codehead;
	}

}
