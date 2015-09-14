package jmeter_socket;

public class Main extends ClientSock {

	private String body; // 记录要解析的String，里面存储的是JSON格式

	public String m_strCode; // 代码
	short m_sReq; // 协议号

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

	// 监控4201协议 热门板块
	public String Protocol4201() {

		String strCode = "882098";
		String resultStr = "";
		HQResultData resultData = reqAreaJSON(ClientSock.mainID, ClientSock.assID, strCode);
		byte[] temp = resultData.getAnsBuf();
		resultStr = FormatTransfer.bytesToString(temp);
		body = resultStr;
		return resultStr;
	}

	// 请求字段
	// Wantnum 最多200
	// Codehead 7位 市场代码1位+6位股票代码
	// 监控组合行情 4202组合行情
	public String Protocol4202() {

		HQResultData resultData = reqCombJSON(2, 4, "0002626", (short) 100);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// 请求字段
	// Wantnum 最多200
	// Codehead 7位 市场代码1位+6位股票代码
	public String Protocol4203() {

		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.shSetcode); // 市场分类
		request.setColtype((short) Const.CODE_SZAG); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 1);
		HQResultData resultData = reqMultiJSON(2, 4, request);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// 测试4205协议 （走势图）
	public String Protocol4205() {

		String codestr = "600586"; // 股票代码
		String setcodestr = "1"; // 市场类型
		HQResultData resultData = reqLChartJSON(2, 3, codestr, setcodestr);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// 监控4206协议 分析数据
	public String Protocol4206() {

		String codestr = "600586";
		String setcodestr = "1";
		short ktype = 4;
		short startxh = 0;
		short reqnum = 200;
		boolean btg = false; // 这个值含义不明

		HQResultData resultData = reqKChartJSON(2, 3, codestr, setcodestr, ktype, startxh, reqnum, btg);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// 监控4207协议 (Tick)
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

	// 监控4212协议 (组合行情)
	public String Protocol4212() {

		HQResultData resultData = reqCombJSON(2, 4, "0002626", (short) 100);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		return body;
	}

	// 监控4213 分类行情2
	public String Protocol4213() {

		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.shSetcode); // 市场分类
		request.setColtype((short) Const.CODE_SZAG); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 2);
		HQResultData resultData = reqMultiSimpleJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		return body;
	}

	// 监控4200协议 键盘精灵
	public String Protocol4200() {

		String keyStr = "zghd"; // 查询中国核电
		HQResultData resultData = reqSearchJSON(2, 3, keyStr);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控1802协议 单只股票资金流
	public String Protocol1802() {

		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		HQResultData resultData = reqFlowsJSON(2, 3, flowsReq);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4220协议 (码表)
	public String Protocol4220() {

		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		HQResultData resultData = reqDicJSON(2, 3, flowsReq);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		return body;
	}

	// 监控4223 （多股资金流）
	public String Protocol4223() {

		short wantnum = 100;
		String codehead = "600586";
		HQResultData resultData = reqMultiDdeJSON(2, 3, codehead, wantnum);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4225 (资金)
	public String Protocol4225() {

		int flag = 0;
		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		flowsReq.setDaytype(1); // 1 当日 3三日 5五日 10十日
		HQResultData resultData = reqFundFlowJSON(2, 3, flowsReq, flag);

		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4226 (DDE)
	public String Protocol4226() {

		int flag = 1;
		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		flowsReq.setDaytype(10); // 1 当日 3三日 5五日 10十日
		HQResultData resultData = reqFundFlowJSON(2, 3, flowsReq, flag);

		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	public String Protolcol4400() {

		short gpId = 530;
		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.hkSetcode); // 市场分类
		request.setColtype(Const.SETDOMAIN_HK); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 2);
		request.setBlockid(Const.BLOCKID_SH_HK);

		HQResultData resultData = reqNewMultiJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4400协议
	public String Protolcol4410() {

		short gpId = 530;
		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.hkSetcode); // 市场分类
		request.setColtype(Const.SETDOMAIN_HK); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
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

	// 监控4401协议 （多股DDE查询）
	public String Protolcol4401() {

		FlowsReq req = new FlowsReq();
		String codehead = " 1603169";
		req.setCodehead(codehead);
		req.setNum(100);
		HQResultData resultData = reqOptionalDDEJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4408多股主力资金流查询
	public String Protolcol4408() {

		FlowsReq req = new FlowsReq();
		String codehead = "002492";
		req.setCodehead(codehead);
		req.setNum(100);
		HQResultData resultData = reqOptionalFundJSON(2, 3, req);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4402协议： 拖拉机单个股列表
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

	// 监控4403协议： 个股拖拉机单明细
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

	// 监控4404 顶级挂单个股列表
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

	// 监控4405 个股顶级挂单明细
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

	// 监控4406 主力撤单个股列表
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

	// 监控4407 个股主力撤单明细
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

	// 监控4409 （A+H比价）
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
