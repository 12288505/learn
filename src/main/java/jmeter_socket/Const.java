package jmeter_socket;

public interface Const {

	public static final int SH_CODE_LEN = 6;
	public static final int CODE_HEAD_LEN = 7;
	public static final int NAME_LEN = 8;
	public static final int Long_LEN = 8;
	public static final int Int_LEN = 4;
	public static final int Float_LEN = 4;
	public static final int Short_LEN = 2;
	public static final int Char_LEN = 2;
	public static final int Byte_LEN = 1;
	public static final int REQBUFFER_LEN = 4 * 1024; // 4K
	public static final int ANSBUFFER_LEN = 30 * 8196; //
	public static final int ONEKB_SIZE = 1024;

	public static final short shSetcode = 1; // 上海
	public static final short szSetcode = 0; // 深圳
	public static final short sfSetcode = 3;// 股指期货
	public static final short scSetcode = 4;// 上海商品期货
	public static final short dcSetcode = 5;// 大连商品期货
	public static final short zcSetcode = 6;// 郑州商品期货
	public static final short bhSetcode = 7;// 渤海商品
	public static final short sjSetcode = 8;// 上海�?
	public static final short ldjSetcode = 9;// 伦敦�?
	public static final short tjSetcode = 10;// 天津贵金�?
	public static final short dySetcode = 11;// 大圆银泰
	public static final short gdSetcode = 12;// 广东贵金�?
	// 时间轴显示的字符�?
	public final static String[][] TIMES_DEFALUT = { { "2015-01-01 09:30", "2015-01-01 11:30" },
			{ "2015-01-01 13:00", "2015-01-01 15:00" } };// 沪深
	public final static String[][] TIMES_DEFALUT2 = { { "2015-01-01 09:30", "2015-01-01 11:30" },
			{ "2015-01-01 13:00", "2015-01-01 15:10" } };// 沪深�?5
	public final static String[][] TIMES_FUTURES_CN = { { "2015-01-01 09:15", "2015-01-01 11:30" },
			{ "2015-01-01 13:00", "2015-01-01 15:15" } };// 中国金融期货交易�?
	public final static String[][] TIMES_FUTURES_DL = { { "2015-01-01 09:00", "2015-01-01 10:15" },
			{ "2015-01-01 10:30", "2015-01-01 11:30" }, { "2015-01-01 13:00", "2015-01-01 15:00" } };// 大连期货
	// public final static String[][] TIMES_FUTURES_SH = { { "2015-01-01 09:00",
	// "2015-01-01 10:15" }, { "2015-01-01 10:30", "2015-01-01 11:30" }, {
	// "2015-01-01 13:00", "2015-01-01 15:00" } };// 上海期货交易�?
	public final static String[][] TIMES_FUTURES_SH2 = { { "2015-01-01 21:00", "2015-01-02 02:30" },
			{ "2015-01-02 09:00", "2015-01-02 10:15" }, { "2015-01-02 10:30", "2015-01-02 11:30" },
			{ "2015-01-02 13:00", "2015-01-02 15:00" } };// 上海期货交易�?（夜�?
	public final static String[][] TIMES_FUTURES_ZZ = { { "2015-01-01 09:00", "2015-01-01 10:15" },
			{ "2015-01-01 10:30", "2015-01-01 11:30" }, { "2015-01-01 13:00", "2015-01-01 15:00" } };// 郑州期货交易�?
	public final static String[][] TIMES_METAL_SH = { { "2015-01-01 20:00", "2015-01-02 02:30" },
			{ "2015-01-02 09:00", "2015-01-02 11:30" }, { "2015-01-02 13:30", "2015-01-02 15:30" } };// 上海黄金交易�?�?
	public final static String[][] TIMES_BOHAI = { { "2015-01-01 09:00", "2015-01-01 11:30" },
			{ "2015-01-01 13:30", "2015-01-01 16:00" } };// 渤海
	// �?1
	public final static String[][] TIMES_BOHAI2 = { { "2015-01-01 19:00", "2015-01-02 03:00" },
			{ "2015-01-02 09:00", "2015-01-02 11:30" }, { "2015-01-02 13:30", "2015-01-02 16:00" } };// 渤海
	// �?2.3.4.5.6
	public final static String[][] TIMES_METAL_TJ = { { "2015-01-01 06:00", "2015-01-02 04:00" } };// 天津贵金属交易所
	public final static String[][] TIMES_METAL_TJ2 = { { "2015-01-01 06:00", "2015-01-02 04:00" } };// 天津贵金属交易所2
	public final static String[][] TIMES_METAL_GJ = { { "2015-01-01 06:00", "2015-01-02 06:00" } };// 国际贵金�?
	// 行情
	public static final short EMB_ZST_NREQ = 4205; // 走势图数�?
	public static final short EMB_FXT_NREQ = 4206; // 分析图数�?
	public static final short EMB_TICK_NREQ = 4207; // Tick数据
	public static final short EMB_COMBHQ_NREQ_SIMPLE = 4212; // 组合行情(�?)
	public static final short EMB_MULTIHQ_NREQ = 4203; // 多行�?,按分类信息请求某市场某排序的多股票行�?
	public static final short EMB_MULTIHQ_NREQ_SIMPLE = 4213; // �?�?
	public static final short EMB_COMBHQ_NREQ = 4202; // 组合行情,同时请求几个股票行情时使�?
	public static final short EMB_SEARCH_REQ = 4200;// 搜索
	public static final short EMB_FLOWS_REQ = 1802;// 单只股票资金�?
	public static final short BREAK_HART = 4;// 心跳
	public static final short EMB_HOTAREA_NREQ = 4201;// 热门板块
	public static final short EMB_DICTIONARY = 4220;// 码表
	public static final short FUND_FLOW = 4225;// 资金流向
	public static final short DDE = 4226;// DDE决策
	public static final short MULTI_DDE = 4223;// 多股资金�?
	public static final short HISTORY_DDE = 4224;// 个股历史资金�?
	//
	public final short ZS_CLIENT_VALIDATE = 5003;// 客户校验
	public final short ZS_CHANGE_TRADE_PWD = 5005;// 修改交易密码
	public final short ZS_CHANGE_ZJ_PWD = 5007;// 修改资金密码
	public final short ZS_GET_DATA = 5001;// 返回数据字典
	public final short ZS_TRANS_FUND = 5091;// 银证转账
	public final short ZS_MONEYQUERY_M_NREQ = 5063;// 资金查询
	public final short ZS_HOLDINGQUERY_M_NREQ = 5065;// 股份查询
	public final short ZS_STOCK_BUYSELL = 5033;// 股票委托
	public final short ZS_TRADEMAXNM_M_NREQ = 5031;// 取最大交易数�?
	public final short ZS_CANCELLATION_M_NREQ = 5077;// 可撤单查�?
	public final short ZS_HISORDERQUERY_M_NREQ = 5069;// 历史委托查询
	public final short ZS_HISTRADEQUERY_M_NREQ = 5073;// 历史成交查询
	public final short ZS_BANKTRANSFEQUERY_M_NREQ = 5095;// 银证转账查询
	public final short ZS_BILLINGINQUIRIESQUERY_M_NREQ = 5079;// 对账单查�?
	public final short ZS_ACCOUNT_BALANCE = 5093;// 银行账户余额查询
	public final short ZS_STOCK_BUYSELL_CANCEL = 5035;// 委托撤单
	public final short ZS_DAY_ORDER_QUERY = 5067;// 当日委托查询
	public final short ZS_DAY_TRADE_QUERY = 5071;// 当日成交查询
	public final short ZS_SHAREHOLDER_QUERY = 5061;// 股东查询
	public final short ZS_BANK_ACCOUNT_QUERY = 5097;// 银行账户查询
	public final short ZJ_DOWNLOAD_CERT = 704;// 下载证书
	public final short ZJ_ALIVE = 3002;// 心跳协议
	public final short ZJ_DELIVERY_ORDER_QUERY = 5075;// 交割单查�?
	public final short ZS_APPLY_INFO_QUERY = 5103;// 新股申购信息查询
	public final short ZS_APPLY_LIMIT_QUERY = 5099;// 新股申购额度信息查询
	public final short ZS_ASSIGN_NO_QUERY = 5101;// 历史配号信息查询

	// 证券类型
	public static int CODE_SZAG = 0; // A�?
	public static int CODE_SZQZ = 1; // 权证
	public static int CODE_SZGZ = 2; // 国�??
	public static int CODE_SZZQ = 3; // 企�??
	public static int CODE_SZKZHZQ = 4; // 转�??
	public static int CODE_SZGZHG = 5; // 回购
	public static int CODE_SZJJ = 6; // 基金
	public static int CODE_SZBG = 7; // B�?
	public static int CODE_SZCY = 8; // 中小企业
	public static int CODE_SZOTHER = 9; // 其它

	public static int CODE_SHAG = 10; // A�?
	public static int CODE_SHQZ = 11; // 权证
	public static int CODE_SHGZ = 12; // 国�??
	public static int CODE_SHZQ = 13; // 企�??
	public static int CODE_SHKZHZQ = 14; // 转�??
	public static int CODE_SHGZHG = 15; // 回购
	public static int CODE_SHJJ = 16; // 基金
	public static int CODE_SHBG = 17; // B�?
	public static int CODE_SHOTHER = 18; // 其它

	public static int CODE_KFJJ = 19;// �?放式基金
	public static int CODE_SB = 20; // 三板

	public static int CODE_SZSPEC = 22;
	public static int CODE_SHSPEC = 23;

	public static int CODE_SZ300CY = 24;// 300 �?头的创业�?

	public static int CODE_HK = 25;
	public static int CODE_SF = 26;
	public static int CODE_SC = 27;
	public static int CODE_DC = 28;
	public static int CODE_ZC = 29;
	public static int CODE_BH = 30;
	public String CLTP = "CLTP";// 客户端类�? 1、场内WIN-PC客户�? 2、WIN-PC客户�? 3、手机客户端
								// 4、网页委�? 5、监控客户端
	public String MAC = "MAC";// Mac地址
	public String DISK = "DISK";// 硬件信息
	public String YYB = "YYB";// 营业部代�?
	public String KHH = "KHH";// 客户�?
	public String JYMM = "JYMM";// 交易密码
	public String ZHLB = "ZHLB";// 账号类别
	public String CVER = "CVER";// 客户端版�?
	public String GVER = "GVER";// 业务功能版本�?
	public String SEID = "SEID";// 交易用户校验编号
	public String NEWM = "NEWM";// 新交易密�?/新资金密�?
	public String ZJMM = "ZJMM";// 资金密码
	public String BZ = "BZ";// 币种类型
	public String ZZFX = "ZZFX";// 转账方向
	public String YHDM = "YHDM";// 银行代码
	public String YHMM = "YHMM";// 银行密码
	public String ZZJE = "ZZJE";// 转账金额
	public String BEGD = "BEGD";// 起始日期
	public String ENDD = "ENDD";// 终止日期
	public String BEGN = "BEGN";// 起始序号
	public String QLEN = "QLEN";// 请求记录�?
	public String GDDM = "GDDM";// 股东代码
	public String JYSM = "JYSM";// 交易�?代码
	public String ZQDM = "ZQDM";// 证券代码
	public String WTJG = "WTJG";// 委托价格
	public String BSFG = "BSFG";// 买卖标志
	public String JYDW = "JYDW";// 交易单位
	public String WTSL = "WTSL";// 委托数量
	public String WTBH = "WTBH";// 委托编号
	public String KHMC = "KHMC";// 客户名称
	public String KHQX = "KHQX";// 客户权限
	public String LDA = "LDA";// 上次登录日期
	public String LIP = "LIP";// 上次登录IP
	public String LMAC = "LMAC";// 上次登陆的MAC
	public String LTI = "LTI";// 上次登录时间
	public String ZXSJ = "ZXSJ";// 在线时间
	public String KQJE = "KQJE";// 可取金额
	public String KYZJ = "KYZJ";// 可用资金
	public String KQXJ = "KQXJ";// 可取现金
	public String ZCZZ = "ZCZZ";// 资产总�??
	public String ZSZ = "ZSZ";// 总市�?
	public String SECK = "SECK";// 密钥�?
	public String ERMS = "ERMS";// 错误代码
	public String ERMT = "ERMT";// 错误信息
	public String CZBZ = "CZBZ";// 操作确认�?0：查询银行流�? 1：查询银证�?�资�? CHAR 6
	public String CZQR = "CZQR";// 操作确认�?1，则只查询可以撤单的委托�?0及其他，则查询全部委�?
}
