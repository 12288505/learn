package jmeter_socket;

public class ReqHeader {

	// short 2
	private int dwcrc; // 加密？？�?

	private byte Version;
	private byte Compressed;
	private byte Encrypted;
	private byte Reserved;

	private int cookie;
	private int MainID;
	public int AssisID;
	private int PacketLen;
	public int RawLen;
	private byte Priority;

	private static final int SIZE = 29;

	private byte[] requestHead = new byte[SIZE];

	public int getDwcrc() {

		return dwcrc;
	}

	public void setDwcrc(int dwcrc) {

		this.dwcrc = dwcrc;
	}

	public byte getVersion() {

		return Version;
	}

	public void setVersion(byte version) {

		Version = version;
	}

	public byte getCompressed() {

		return Compressed;
	}

	public void setCompressed(byte compressed) {

		Compressed = compressed;
	}

	public byte getEncrypted() {

		return Encrypted;
	}

	public void setEncrypted(byte encrypted) {

		Encrypted = encrypted;
	}

	public byte getReserved() {

		return Reserved;
	}

	public void setReserved(byte reserved) {

		Reserved = reserved;
	}

	public int getCookie() {

		return cookie;
	}

	public void setCookie(int cookie) {

		this.cookie = cookie;
	}

	public int getMainID() {

		return MainID;
	}

	public void setMainID(int mainID) {

		MainID = mainID;
	}

	public int getAssisID() {

		return AssisID;
	}

	public void setAssisID(int assisID) {

		AssisID = assisID;
	}

	public int getPacketLen() {

		return PacketLen;
	}

	public void setPacketLen(int packetLen) {

		PacketLen = packetLen;
	}

	public int getRawLen() {

		return RawLen;
	}

	public void setRawLen(int rawLen) {

		RawLen = rawLen;
	}

	public byte getPriority() {

		return Priority;
	}

	public void setPriority(byte priority) {

		Priority = priority;
	}

	/**
	 * 返回要发送的数据包头的字节数�?
	 */
	public byte[] getTagReqHeader() {

		// 插入buf数组的位�?
		int pos = 0;
		byte[] temp = FormatTransfer.toLH(dwcrc);
		System.arraycopy(temp, 0, requestHead, pos, 4);
		pos += 4;

		requestHead[pos] = Version;
		pos += 1;

		requestHead[pos] = Compressed;
		pos += 1;

		requestHead[pos] = Encrypted;
		pos += 1;

		requestHead[pos] = Reserved;
		pos += 1;

		temp = FormatTransfer.toLH(cookie);
		System.arraycopy(temp, 0, requestHead, pos, 4);
		pos += 4;

		temp = FormatTransfer.toLH(MainID); // 转换为低字节在前，高字节在后的byte数组
		System.arraycopy(temp, 0, requestHead, pos, 4);
		pos += 4;

		temp = FormatTransfer.toLH(AssisID);
		System.arraycopy(temp, 0, requestHead, pos, 4);
		pos += 4;

		temp = FormatTransfer.toLH(PacketLen);
		System.arraycopy(temp, 0, requestHead, pos, 4);
		pos += 4;

		temp = FormatTransfer.toLH(RawLen);
		System.arraycopy(temp, 0, requestHead, pos, 4);
		pos += 4;
		requestHead[pos] = Priority;
		return requestHead;
	}
}
