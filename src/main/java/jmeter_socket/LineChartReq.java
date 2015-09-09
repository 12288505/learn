package jmeter_socket;

public class LineChartReq {

	private short req;
	private short setcode;
	private String code = ""; // 6�?

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

	public final int size() {

		final int size = 10; // 请求长度
		return size;
	}
}
