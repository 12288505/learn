package jmeter_socket;

public class ReqHeader {

	// short 2
	private int dwcrc; // å å¯ï¼ï¼ï¼?

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
	 * è¿åè¦åéçæ°æ®åå¤´çå­èæ°ç»?
	 */
	public byte[] getTagReqHeader() {

		// æå¥bufæ°ç»çä½ç½?
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

		temp = FormatTransfer.toLH(MainID); // è½¬æ¢ä¸ºä½å­èå¨åï¼é«å­èå¨åçbyteæ°ç»
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
