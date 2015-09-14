package jmeter_socket;

public class Main extends ClientSock {

	private String body; // ��¼Ҫ������String������洢����JSON��ʽ

	public String m_strCode; // ����
	short m_sReq; // Э���

	public String getSocketBody(int protocol) {

		// String resBody = "";
		String resBody = "";
		switch (protocol) {

		case 1802:
			resBody = Protocol1802();
			break;

		case 4200:
			resBody = Protocol4200();
			break;

		case 4201:
			resBody = Protocol4201();
			break;
		case 4202:
			resBody = Protocol4202();
			break;
		case 4203:
			resBody = Protocol4203();
			break;
		case 4205:
			resBody = Protocol4205();
			break;
		case 4206:
			resBody = Protocol4206();
			break;
		case 4207:
			resBody = Protocol4207();
			break;
		case 4212:
			resBody = Protocol4212();
			break;
		case 4213:
			resBody = Protocol4213();
			break;
		case 4220:
			resBody = Protocol4220();
			break;
		case 4223:
			resBody = Protocol4223();
			break;
		case 4225:
			resBody = Protocol4225();
			break;
		case 4226:
			resBody = Protocol4226();
			break;
		case 4400:
			resBody = Protolcol4400();
			break;
		case 4410:
			resBody = Protolcol4410();
			break;
		case 4411:
			resBody = Protolcol4411();
			break;
		case 4401:
			resBody = Protolcol4401();
			break;
		case 4402:
			resBody = Protolcol4402();
			break;
		case 4403:
			resBody = Protolcol4403();
			break;
		case 4404:
			resBody = Protolcol4404();
			break;
		case 4405:
			resBody = Protolcol4405();
			break;
		case 4406:
			resBody = Protolcol4406();
			break;
		case 4407:
			resBody = Protolcol4407();
			break;
		case 4408:
			resBody = Protolcol4408();
			break;
		case 4409:
			resBody = Protolcol4409();
			break;
		}

		System.out.println(resBody);
		return resBody;
	}

	// ���4201Э�� ���Ű��
	public String Protocol4201() {

		String strCode = "882098";
		String resultStr = "";
		HQResultData resultData = reqAreaJSON(ClientSock.mainID, ClientSock.assID, strCode);
		byte[] temp = resultData.getAnsBuf();
		resultStr = FormatTransfer.bytesToString(temp);
		body = resultStr;
		return resultStr;
	}

	// �����ֶ�
	// Wantnum ���200
	// Codehead 7λ �г�����1λ+6λ��Ʊ����
	// ���������� 4202�������
	public String Protocol4202() {

		HQResultData resultData = reqCombJSON(2, 4, "0002626", (short) 100);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// �����ֶ�
	// Wantnum ���200
	// Codehead 7λ �г�����1λ+6λ��Ʊ����
	public String Protocol4203() {

		// ���� ������������
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.shSetcode); // �г�����
		request.setColtype((short) Const.CODE_SZAG); // ��Ʊ��Ŀ����
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // ���200
		request.setSorttype((short) 1);
		HQResultData resultData = reqMultiJSON(2, 4, request);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// ����4205Э�� ������ͼ��
	public String Protocol4205() {

		String codestr = "600586"; // ��Ʊ����
		String setcodestr = "1"; // �г�����
		HQResultData resultData = reqLChartJSON(2, 3, codestr, setcodestr);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// ���4206Э�� ��������
	public String Protocol4206() {

		String codestr = "600586";
		String setcodestr = "1";
		short ktype = 4;
		short startxh = 0;
		short reqnum = 200;
		boolean btg = false; // ���ֵ���岻��

		HQResultData resultData = reqKChartJSON(2, 3, codestr, setcodestr, ktype, startxh, reqnum, btg);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// ���4207Э�� (Tick)
	public String Protocol4207() {

		short setcode = 1;
		String code = "600586";
		short startxh = 0;
		short wantnum = 200;
		HQResultData resultData = reqTickJSON(2, 3, setcode, code, startxh, wantnum);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// ���4212Э�� (�������)
	public String Protocol4212() {

		HQResultData resultData = reqCombJSON(2, 4, "0002626", (short) 100);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// ���4213 ��������2
	public String Protocol4213() {

		// ���� ������������
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.shSetcode); // �г�����
		request.setColtype((short) Const.CODE_SZAG); // ��Ʊ��Ŀ����
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // ���200
		request.setSorttype((short) 2);
		HQResultData resultData = reqMultiSimpleJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		return body;
	}

	// ���4200Э�� ���̾���
	public String Protocol4200() {

		String keyStr = "zghd"; // ��ѯ�й��˵�
		HQResultData resultData = reqSearchJSON(2, 3, keyStr);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���1802Э�� ��ֻ��Ʊ�ʽ���
	public String Protocol1802() {

		FlowsReq flowsReq = new FlowsReq();
		// ���ṹ��flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // �г�����
		flowsReq.setCode("600586"); // �г�+��Ʊ���룿����
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		HQResultData resultData = reqFlowsJSON(2, 3, flowsReq);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4220Э�� (���)
	public String Protocol4220() {

		FlowsReq flowsReq = new FlowsReq();
		// ���ṹ��flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // �г�����
		flowsReq.setCode("600586"); // �г�+��Ʊ���룿����
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		HQResultData resultData = reqDicJSON(2, 3, flowsReq);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		return body;
	}

	// ���4223 ������ʽ�����
	public String Protocol4223() {

		short wantnum = 100;
		String codehead = "600586";
		HQResultData resultData = reqMultiDdeJSON(2, 3, codehead, wantnum);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4225 (�ʽ�)
	public String Protocol4225() {

		int flag = 0;
		FlowsReq flowsReq = new FlowsReq();
		// ���ṹ��flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // �г�����
		flowsReq.setCode("600586"); // �г�+��Ʊ���룿����
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		flowsReq.setDaytype(1); // 1 ���� 3���� 5���� 10ʮ��
		HQResultData resultData = reqFundFlowJSON(2, 3, flowsReq, flag);

		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4226 (DDE)
	public String Protocol4226() {

		int flag = 1;
		FlowsReq flowsReq = new FlowsReq();
		// ���ṹ��flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // �г�����
		flowsReq.setCode("600586"); // �г�+��Ʊ���룿����
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		flowsReq.setDaytype(10); // 1 ���� 3���� 5���� 10ʮ��
		HQResultData resultData = reqFundFlowJSON(2, 3, flowsReq, flag);

		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	public String Protolcol4400() {

		short gpId = 530;
		// ���� ������������
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.hkSetcode); // �г�����
		request.setColtype(Const.SETDOMAIN_HK); // ��Ʊ��Ŀ����
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // ���200
		request.setSorttype((short) 2);
		request.setBlockid(Const.BLOCKID_SH_HK);

		HQResultData resultData = reqNewMultiJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4400Э��
	public String Protolcol4410() {

		short gpId = 530;
		// ���� ������������
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.hkSetcode); // �г�����
		request.setColtype(Const.SETDOMAIN_HK); // ��Ʊ��Ŀ����
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // ���200
		request.setSorttype((short) 2);
		request.setBlockid(Const.BLOCKID_SH_HK);

		HQResultData resultData = reqNewMultiJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	public String Protolcol4411() {

		// TODO Auto-generated method stub

		short wantnum = 100;
		String codehead = " 1603169";
		HQResultData resultData = reqCombExpandJSON(2, 3, codehead, wantnum);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4401Э�� �����DDE��ѯ��
	public String Protolcol4401() {

		FlowsReq req = new FlowsReq();
		String codehead = " 1603169";
		req.setCodehead(codehead);
		req.setNum(100);
		HQResultData resultData = reqOptionalDDEJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4408��������ʽ�����ѯ
	public String Protolcol4408() {

		FlowsReq req = new FlowsReq();
		String codehead = "002492";
		req.setCodehead(codehead);
		req.setNum(100);
		HQResultData resultData = reqOptionalFundJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4402Э�飺 �������������б�
	public String Protolcol4402() {

		MultiReq req = new MultiReq();
		req.setWantnum((short) 100);
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);

		HQResultData resultData = reqTractorListJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4403Э�飺 ��������������ϸ
	public String Protolcol4403() {

		MultiReq req = new MultiReq();
		String code = "601991";
		req.setSetCode(Const.shSetcode);
		req.setCode(code);
		req.setWantnum((short) (100));
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);
		HQResultData resultData = reqTractorDetailJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		return body;
	}

	// ���4404 �����ҵ������б�
	public String Protolcol4404() {

		MultiReq req = new MultiReq();
		req.setWantnum((short) (100));
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);
		HQResultData resultData = reqTopBillListJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4405 ���ɶ����ҵ���ϸ
	public String Protolcol4405() {

		MultiReq req = new MultiReq();
		String code = "603001";
		req.setSetCode(Const.shSetcode);
		req.setCode(code);
		req.setWantnum((short) (100));
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);
		HQResultData resultData = reqTopBillDetailJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		return body;
	}

	// ���4406 �������������б�
	public String Protolcol4406() {

		MultiReq req = new MultiReq();
		req.setWantnum((short) 100);
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);
		HQResultData resultData = reqCancelBillListJSON(2, 4, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4407 ��������������ϸ
	public String Protolcol4407() {

		MultiReq req = new MultiReq();
		String code = "600757";
		req.setSetCode(Const.shSetcode);
		req.setCode(code);
		req.setWantnum((short) (100));
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);
		HQResultData resultData = reqCancelBillDetailJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// ���4409 ��A+H�ȼۣ�
	public String Protolcol4409() {

		MultiReq req = new MultiReq();
		int mainID = 2;
		int assID = 3;
		req.setWantnum((short) (100));
		req.setStartxh((short) 0);
		req.setSortcol((short) 1);
		req.setSorttype((short) 1);
		HQResultData resultData = reqAHMultiJSON(mainID, assID, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

}
