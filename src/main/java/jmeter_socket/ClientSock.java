package jmeter_socket;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import com.google.gson.Gson;

public class ClientSock implements Const {

	public short DEFAULT_K_TYPE = 4;
	public short DEFAULT_K_MULNUM = 0;
	public short DEFALUT_K_STARTXH = 0;
	private static byte REQ_DEFAULT_VERSION = 12;
	private static byte REQ_DEFALUT_VALUE = 0;
	private String DEFAULT_CODESTR = "000001";
	private short DEFAULT_CODE = 0;
	private String host = "120.26.66.242";
	private int port = 9999;
	private static DataOutputStream dos;
	private static DataInputStream dis;

	private byte[] datacache;
	private Socket mSocket = null;
	private static boolean flag = false;
	private String code;
	private short req;

	public void setReq(short req) {

		this.req = req;
	}

	public short getReq() {

		return this.req;
	}

	public String getCode() {

		return this.code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	public byte[] getReqPack(int mainID, int assID, byte[] reqBody) {

		ReqHeader head_req = new ReqHeader();
		short len = (short) reqBody.length;
		head_req.setRawLen(len);
		head_req.setPacketLen(len);
		head_req.setVersion(REQ_DEFAULT_VERSION);
		head_req.setCompressed(REQ_DEFALUT_VALUE);
		head_req.setEncrypted(REQ_DEFALUT_VALUE);
		head_req.setReserved(REQ_DEFALUT_VALUE);
		head_req.setMainID(mainID);
		head_req.setAssisID(assID);
		head_req.setPriority(REQ_DEFALUT_VALUE);
		byte[] head = head_req.getTagReqHeader();
		byte[] packet = new byte[head.length + reqBody.length];
		System.arraycopy(head, 0, packet, 0, head.length);
		System.arraycopy(reqBody, 0, packet, head.length, reqBody.length);
		return packet;
	}

	public boolean connect() {

		try {
			closeServer();
			mSocket = new Socket();
			mSocket.setReuseAddress(true);
			mSocket.setTcpNoDelay(true);
			mSocket.setSoTimeout(5000);
			mSocket.setSoLinger(true, 0);
			mSocket.setPerformancePreferences(3, 2, 1);

			InetSocketAddress isa = new InetSocketAddress(host, port);
			mSocket.connect(isa, 5000);
			dos = SocketIO.getOutput(mSocket);
			dis = SocketIO.getInput(mSocket);

		} catch (Exception e) {
			flag = true;
			return false;
		} finally {
		}
		return true;
	}

	private void closeServer() {

		try {
			dos.close();
			dis.close();
			mSocket.close();
		} catch (Exception ex) {
		}
	}

	public HQResultData buildRequest(byte[] lpBuf) {

		HQResultData hqRD = new HQResultData();
		datacache = lpBuf;

		if (mSocket != null && (!mSocket.isClosed()) && mSocket.isConnected()) {
			try {
				while (mSocket.isConnected()) {
					dos.write(lpBuf);
					dos.flush();
					byte[] head_b = new byte[37];
					dis.read(head_b, 0, 37);

					ResponseHeader head_ans = new ResponseHeader().Parse(head_b);
					int length = head_ans.getPacketLen();
					int recLen = head_ans.getRawLen();
					int m_compressFlag = head_ans.getCompressed();
					hqRD.setMainID(head_ans.getMainID());
					hqRD.setAssID(head_ans.getAssisID());
					byte[] tempByte = new byte[Const.ANSBUFFER_LEN];
					int i = 0;
					int pos = 0;
					while ((i = dis.read(tempByte, pos, length - pos)) != -1) {
						pos += i;
						if (pos == length)
							break;
					}
					if (m_compressFlag == 0) {
						hqRD.setAnsBuf(new byte[recLen]);
						System.arraycopy(tempByte, 0, hqRD.getAnsBuf(), 0, recLen);

					} else if (m_compressFlag == 1) {
						byte[] m_AnsBuffer = new byte[Const.ANSBUFFER_LEN];
						ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
						Inflater decompresser = new Inflater();
						decompresser.setInput(tempByte);
						int resultLength = 0;

						while (!decompresser.finished()) {
							try {
								resultLength = decompresser.inflate(m_AnsBuffer);
								bos.write(m_AnsBuffer, 0, resultLength);
							} catch (DataFormatException e) {
								e.printStackTrace();
							}
						}
						decompresser.end();
						hqRD.setAnsBuf(new byte[resultLength]);
						System.arraycopy(m_AnsBuffer, 0, hqRD.getAnsBuf(), 0, resultLength);
					}
					break;
				}
			} catch (SocketTimeoutException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return hqRD;
	}

	private HQResultData buildJSONREQ(int mainID, int assID, short req, String jsonstr) {

		// if (mSocket.isClosed() || !mSocket.isConnected() || mSocket.isInputShutdown() || mSocket.isOutputShutdown())
		// {
		connect();
		// }
		byte[] jsonbuf = FormatTransfer.stringToBytes(jsonstr);
		byte[] buf = new byte[jsonbuf.length + Short_LEN];
		int pos = 0;
		System.arraycopy(FormatTransfer.toLH(req), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(jsonbuf, 0, buf, pos, jsonbuf.length);
		byte[] result = getReqPack(mainID, assID, buf);
		return buildRequest(result);
	}

	public HQResultData reqAreaJSON(int mainID, int assID, short req, String code2) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", code2);

		return buildJSONREQ(mainID, assID, req, gson.toJson(map));
	}

	public HQResultData reqCombJSON(int mainID, int assID, String codehead, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", wantnum);
		map.put("2", codehead);
		return buildJSONREQ(mainID, assID, EMB_COMBHQ_NREQ, gson.toJson(map));
	}

	public HQResultData reqComb(int mainID, int assID, String codehead, short wantnum) {

		CombReq request = new CombReq();
		byte[] buf = new byte[request.size()];
		request.setReq(Const.EMB_COMBHQ_NREQ);
		request.setCodehead(codehead);
		request.setWantnum(wantnum);
		int pos = 0;
		System.arraycopy(FormatTransfer.toLH(request.getReq()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getWantnum()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		writeCodeHead(buf, pos, request.getCodehead());
		pos += CODE_HEAD_LEN;
		byte[] result = getReqPack(mainID, assID, buf);
		return buildRequest(result);
	}

	public void writeCodeHead(byte[] bye, int pos, String code) {

		int length = code.getBytes().length;
		if (length > CODE_HEAD_LEN)
			length = CODE_HEAD_LEN;
		if (length > 0)
			System.arraycopy(code.getBytes(), 0, bye, pos, length);
		for (int i = length; i < CODE_HEAD_LEN; i++)
			bye[pos + i] = 0;
	}

	public HQResultData reqMultiJSON(int mainID, int assID, MultiReq request) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_MULTIHQ_NREQ);
		map.put("2", request.getSetdomain());
		map.put("3", request.getColtype());
		map.put("4", request.getStartxh());
		map.put("5", request.getWantnum());
		map.put("6", request.getSorttype());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ, gson.toJson(map));
	}

	public HQResultData reqMultiSimpleJSON(int mainID, int assID, MultiReq request) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_MULTIHQ_NREQ_SIMPLE);
		map.put("2", request.getSetdomain());
		map.put("3", request.getColtype());
		map.put("4", request.getStartxh());
		map.put("5", request.getWantnum());
		map.put("6", request.getSorttype());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ_SIMPLE, gson.toJson(map));
	}

	public HQResultData reqLChartJSON(int mainID, int assID, String codestr, String setcodestr) {

		LineChartReq request = new LineChartReq();
		request.setReq(EMB_ZST_NREQ);
		request.setSetcode(!"".equals(setcodestr) ? Short.parseShort(setcodestr) : 0);
		request.setCode(!"".equals(codestr) ? codestr : DEFAULT_CODESTR);
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", request.getSetcode());
		map.put("2", request.getCode());
		return buildJSONREQ(mainID, assID, EMB_ZST_NREQ, gson.toJson(map));
	}

	public HQResultData reqKChartJSON(int mainID, int assID, String codestr, String setcodestr, short ktype, short startxh,
			short reqnum, boolean btg) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_FXT_NREQ);
		map.put("2", !"".equals(setcodestr) ? Short.parseShort(setcodestr) : DEFAULT_CODE);
		map.put("3", !"".equals(codestr) ? codestr : DEFAULT_CODESTR);
		map.put("4", ktype > -1 ? ktype : DEFAULT_K_TYPE);
		map.put("5", DEFAULT_K_MULNUM);
		map.put("6", startxh > 0 ? startxh : DEFALUT_K_STARTXH);
		map.put("7", reqnum);
		map.put("8", btg);
		return buildJSONREQ(mainID, assID, EMB_FXT_NREQ, gson.toJson(map));
	}

	public HQResultData reqKChart(int mainID, int assID, String codestr, String setcodestr, short ktype, short startxh,
			short reqnum) {

		KLineReq request = new KLineReq();
		byte[] buf = new byte[request.size()];
		request.setReq(EMB_FXT_NREQ);
		request.setSetcode(!"".equals(setcodestr) ? Short.parseShort(setcodestr) : DEFAULT_CODE);
		request.setCode(!"".equals(codestr) ? codestr : DEFAULT_CODESTR);
		request.setLinetype(ktype > -1 ? ktype : DEFAULT_K_TYPE);
		request.setMulnum(DEFAULT_K_MULNUM);
		request.setStartxh(startxh > 0 ? startxh : DEFALUT_K_STARTXH);
		request.setWantnum(reqnum);
		int pos = 0;
		System.arraycopy(FormatTransfer.toLH(request.getReq()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getSetcode()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		writeSTKCode(buf, pos, request.getCode());
		pos += SH_CODE_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getLinetype()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getMulnum()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getStartxh()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getWantnum()), 0, buf, pos, Short_LEN);
		byte[] result = getReqPack(mainID, assID, buf);
		return buildRequest(result);
	}

	public void writeSTKCode(byte[] bye, int pos, String code) {

		int length = code.getBytes().length;
		if (length > SH_CODE_LEN)
			length = SH_CODE_LEN;
		if (length > 0)
			System.arraycopy(code.getBytes(), 0, bye, pos, length);
		for (int i = length; i < SH_CODE_LEN; i++)
			bye[pos + i] = 0;
	}

	public HQResultData reqTickJSON(int mainID, int assID, short setcode, String code, short startxh, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", setcode);
		map.put("2", code);
		map.put("3", startxh);
		map.put("4", wantnum);
		return buildJSONREQ(mainID, assID, EMB_TICK_NREQ, gson.toJson(map));
	}

	public HQResultData reqCombSimpleJSON(int mainID, int assID, String codehead, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", wantnum);
		map.put("2", codehead);
		return buildJSONREQ(mainID, assID, EMB_COMBHQ_NREQ_SIMPLE, gson.toJson(map));
	}

	public HQResultData reqSearchJSON(int mainID, int assID, String keyStr) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_SEARCH_REQ);
		map.put("2", keyStr);
		map.put("3", 20);
		return buildJSONREQ(mainID, assID, EMB_SEARCH_REQ, gson.toJson(map));
	}

	public HQResultData reqFlowsJSON(int mainID, int assID, FlowsReq req) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_FLOWS_REQ);
		map.put("2", req.getPeriod());
		map.put("3", req.getSetcode());
		map.put("4", req.getCode());
		map.put("5", req.getOffset());
		map.put("6", req.getNum());
		map.put("7", req.getResrv());
		return buildJSONREQ(mainID, assID, EMB_FLOWS_REQ, gson.toJson(map));
	}

	public HQResultData reqDicJSON(int mainID, int assID, FlowsReq req) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_DICTIONARY);
		map.put("2", req.getOffset());
		map.put("3", req.getNum());
		return buildJSONREQ(mainID, assID, EMB_DICTIONARY, gson.toJson(map));
	}

	public HQResultData reqFundFlowJSON(int mainID, int assID, FlowsReq req, int flag) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("2", req.getSetcode());
		map.put("3", req.getNum());
		map.put("4", req.getStartxh());
		map.put("5", req.getSorttype());
		map.put("6", req.getColtype());
		short reqFlag = FUND_FLOW;
		if (flag == 0) {
			map.put("1", FUND_FLOW);
			map.put("7", req.getDaytype());
			reqFlag = FUND_FLOW;
		} else {
			map.put("1", DDE);
			reqFlag = DDE;
		}
		return buildJSONREQ(mainID, assID, reqFlag, gson.toJson(map));
	}

	public HQResultData reqMultiDdeJSON(int mainID, int assID, String codehead, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", MULTI_DDE);
		map.put("2", wantnum);
		map.put("3", codehead);
		return buildJSONREQ(mainID, assID, MULTI_DDE, gson.toJson(map));
	}

}
