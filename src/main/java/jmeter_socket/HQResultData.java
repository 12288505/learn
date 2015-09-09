package jmeter_socket;

public class HQResultData {

	private int MainID;
	private int AssID;
	private byte[] ansBuf;

	public int getMainID() {

		return MainID;
	}

	public void setMainID(int mainID) {

		MainID = mainID;
	}

	public int getAssID() {

		return AssID;
	}

	public void setAssID(int assID) {

		AssID = assID;
	}

	public byte[] getAnsBuf() {

		return ansBuf;
	}

	public void setAnsBuf(byte[] ansBuf) {

		this.ansBuf = ansBuf;
	}
}
