package jmeter_socket;

public class KLineReq {

	private short req;
	private short setcode;
	private String code;// 6�?
	private static short linetype;// 0 5分钟 1 15分钟 2 30分钟 3 60分钟 4 日线 5 周线 6 月线
	private short mulnum;
	private short startxh; // 第一次请求的个数
	private short wantnum;// k线个�?

	public short getReq() {

		return req;
	}

	public void setReq(short req) {

		this.req = req;
	}

	public short getSetcode() {

		return setcode;
	}

	public void setSetcode(short setcode) {

		this.setcode = setcode;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	public static short getLinetype() {

		return linetype;
	}

	public void setLinetype(short linetype) {

		this.linetype = linetype;
	}

	public short getMulnum() {

		return mulnum;
	}

	public void setMulnum(short mulnum) {

		this.mulnum = mulnum;
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

	public final int size() {

		final int size = 18; // 请求长度
		return size;
	}
}
