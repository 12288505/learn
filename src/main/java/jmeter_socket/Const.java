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

	public static final short shSetcode = 1; // �Ϻ�
	public static final short szSetcode = 0; // ����
	public static final short hkSetcode = 2;// �۹�
	public static final short sfSetcode = 3;// ��ָ�ڻ�
	public static final short scSetcode = 4;// �Ϻ���Ʒ�ڻ�
	public static final short dcSetcode = 5;// ������Ʒ�ڻ�
	public static final short zcSetcode = 6;// ֣����Ʒ�ڻ�
	public static final short bhSetcode = 7;// ������Ʒ
	public static final short sjSetcode = 8;// �Ϻ���
	public static final short ldjSetcode = 9;// �׶ؽ�
	public static final short tjSetcode = 10;// �������
	public static final short dySetcode = 11;// ��Բ��̩
	public static final short gdSetcode = 12;// �㶫�����

	// v3.4���� ������
	// setcode
	public final int SETCODE_NASDAQ = 13;// ��˹���
	public final int SETCODE_NYSE = 14;// Ŧ����
	public final int SETCODE_AMEX = 15;// ������
	public final int SETCODE_HIS = 16;// �۹�ָ��
	public final int SETCODE_USI = 17;// ����ָ��

	// setdomain
	public final short REG_NEW_TTSLIST_COL_NREQ = 5021;//
	public final short SETDOMAIN_US = 50;// ����
	public final short SETDOMAIN_NASDAQ = 51;// ��˹���
	public final short SETDOMAIN_NYSE = 52;// Ŧ����
	public final short SETDOMAIN_AMEX = 53;// ������
	public final short SETDOMAIN_US_ZS = 54;// ����ָ��
	public final short SETDOMAIN_HK_ZS = 49;// �۹�ָ��

	public final short REG_NEW_MTTSLIST_COL_NREQ = 5028;//
	public final short SETDOMAIN_HK = 36;// �۹�
	public final short SETDOMAIN_HK_ZB = 37;// �������
	public final short SETDOMAIN_HK_CYB = 38;// ��ҵ��
	public final short SETDOMAIN_HK_ZQ = 39;// ծȯ
	public final short SETDOMAIN_HK_QZ = 41;// Ȩ֤
	public final short SETDOMAIN_HK_NXZ = 42;// ţ��֤
	public final short SETDOMAIN_HK_JJ = 43;// ����

	public final short REG_NEW_MBTSLIST_COL_NREQ = 5029;//
	public final String BLOCKID_SH_HK = "5004230002";// �۹�ͨ
	public final String BLOCKID_A_H = "5004210004";// A+H��
	public final String BLOCKID_RED_CHIPS = "5004210001";// ����
	public final String BLOCKID_SOE = "5004210003";// �����
	public final String BLOCKID_TAKES_STOCK = "5004310001";// �иŹ�
	public final String BLOCKID_DOW_JONES = "2060008303";// ����˹
	public final String BLOCKID_S_P500 = "5004210001";// ����500

	// // ʱ������ʾ���ַ���
	// public final static String[][] TIMES_DEFALUT = { { "2015-01-01 09:30", "2015-01-01 11:30" }, {
	// "2015-01-01 13:00", "2015-01-01 15:00" } };// ����
	// public final static String[][] TIMES_DEFALUT2 = { { "2015-01-01 09:30", "2015-01-01 11:30" }, {
	// "2015-01-01 13:00", "2015-01-01 15:10" } };// ������5
	// public final static String[][] TIMES_FUTURES_CN = { { "2015-01-01 09:15", "2015-01-01 11:30" }, {
	// "2015-01-01 13:00", "2015-01-01 15:15" } };// �й������ڻ�������
	// public final static String[][] TIMES_FUTURES_DL = { { "2015-01-01 09:00", "2015-01-01 10:15" }, {
	// "2015-01-01 10:30", "2015-01-01 11:30" }, { "2015-01-01 13:00", "2015-01-01 15:00" } };// �����ڻ�
	// // public final static String[][] TIMES_FUTURES_SH = { { "2015-01-01 09:00",
	// // "2015-01-01 10:15" }, { "2015-01-01 10:30", "2015-01-01 11:30" }, {
	// // "2015-01-01 13:00", "2015-01-01 15:00" } };// �Ϻ��ڻ�������
	// public final static String[][] TIMES_FUTURES_SH2 = { { "2015-01-01 21:00", "2015-01-02 02:30" }, {
	// "2015-01-02 09:00", "2015-01-02 10:15" }, { "2015-01-02 10:30", "2015-01-02 11:30" },
	// { "2015-01-02 13:00", "2015-01-02 15:00" } };// �Ϻ��ڻ���������ҹ��
	// public final static String[][] TIMES_FUTURES_ZZ = { { "2015-01-01 09:00", "2015-01-01 10:15" }, {
	// "2015-01-01 10:30", "2015-01-01 11:30" }, { "2015-01-01 13:00", "2015-01-01 15:00" } };// ֣���ڻ�������
	// public final static String[][] TIMES_METAL_SH = { { "2015-01-01 20:00", "2015-01-02 02:30" }, {
	// "2015-01-02 09:00", "2015-01-02 11:30" }, { "2015-01-02 13:30", "2015-01-02 15:30" } };// �Ϻ��ƽ�������
	// public final static String[][] TIMES_BOHAI = { { "2015-01-01 09:00", "2015-01-01 11:30" }, { "2015-01-01 13:30",
	// "2015-01-01 16:00" } };// ����
	// // ��1
	// public final static String[][] TIMES_BOHAI2 = { { "2015-01-01 19:00", "2015-01-02 03:00" }, { "2015-01-02 09:00",
	// "2015-01-02 11:30" }, { "2015-01-02 13:30", "2015-01-02 16:00" } };// ����
	// // ��2.3.4.5.6
	// public final static String[][] TIMES_METAL_TJ = { { "2015-01-01 06:00", "2015-01-02 04:00" } };// �������������
	// public final static String[][] TIMES_METAL_TJ2 = { { "2015-01-01 06:00", "2015-01-02 04:00" } };// �������������2
	// public final static String[][] TIMES_METAL_GJ = { { "2015-01-01 06:00", "2015-01-02 06:00" } };// ���ʹ����
	//
	// // ������ v3.4����
	// public final static String[][] TIMES_HK = { { "2015-01-01 09:30", "2015-01-01 12:00" }, { "2015-01-01 13:00",
	// "2015-01-01 16:00" } };// �۹�
	// public final static String[][] TIMES_US = { { "2015-01-01 21:30", "2015-01-02 04:00" } };// ����
	//
	// ����
	public static final short EMB_ZST_NREQ = 4205; // ����ͼ����
	public static final short EMB_FXT_NREQ = 4206; // ����ͼ����
	public static final short EMB_TICK_NREQ = 4207; // Tick����
	public static final short EMB_COMBHQ_NREQ_SIMPLE = 4212; // �������(��)
	public static final short EMB_MULTIHQ_NREQ = 4203; // ������,��������Ϣ����ĳ�г�ĳ����Ķ��Ʊ����
	public static final short EMB_MULTIHQ_NREQ_SIMPLE = 4213; // ���
	public static final short EMB_COMBHQ_NREQ = 4202; // �������,ͬʱ���󼸸���Ʊ����ʱʹ��
	public static final short EMB_SEARCH_REQ = 4200;// ����
	public static final short EMB_FLOWS_REQ = 1802;// ��ֻ��Ʊ�ʽ���
	public static final short BREAK_HART = 4;// ����
	public static final short EMB_HOTAREA_NREQ = 4201;// ���Ű��
	public static final short EMB_DICTIONARY = 4220;// ���
	public static final short FUND_FLOW = 4225;// �ʽ�����
	public static final short DDE = 4226;// DDE����
	public static final short MULTI_DDE = 4223;// ����ʽ���
	public static final short HISTORY_DDE = 4224;// ������ʷ�ʽ���
	// v3.4����Э��
	public static final short EMB_MULTIHQ_NREQ_NEW = 4400; // ������
	public static final short EMB_MULTIHQ_NREQ_NEW_SIMPLE = 4410; // ������(��)
	public static final short OPTIONAL_DDE = 4401; // ��ѡDDE
	public static final short OPTIONAL_FUND = 4408; // ��ѡ�ʽ�
	public static final short TRACTOR_LIST = 4402;// �������������б�
	public static final short TRACTOR_DETAIL = 4403;// ��������������ϸ
	public static final short TOP_BILL_LIST = 4404;// �����ҵ������б�
	public static final short TOP_BILL_DETAIL = 4405;// ���ɶ����ҵ���ϸ
	public static final short CANCEL_BILL_LIST = 4406;// �������������б�
	public static final short CANCEL_BILL_DETAIL = 4407;// ��������������ϸ
	public static final short EMB_MULTIHQ_NREQ_AH = 4409;// ��������������ϸ
	public static final short EMB_MULTIHQ_NREQ_EXPAND = 4411;// ����չ����������
	public static final short TIME_NREQ = 4412;// �����г�����ʱ���б�
	//
	public final short ZS_CLIENT_VALIDATE = 5003;// �ͻ�У��
	public final short ZS_CHANGE_TRADE_PWD = 5005;// �޸Ľ�������
	public final short ZS_CHANGE_ZJ_PWD = 5007;// �޸��ʽ�����
	public final short ZS_GET_DATA = 5001;// ���������ֵ�
	public final short ZS_TRANS_FUND = 5091;// ��֤ת��
	public final short ZS_MONEYQUERY_M_NREQ = 5063;// �ʽ��ѯ
	public final short ZS_HOLDINGQUERY_M_NREQ = 5065;// �ɷݲ�ѯ
	public final short ZS_STOCK_BUYSELL = 5033;// ��Ʊί��
	public final short ZS_TRADEMAXNM_M_NREQ = 5031;// ȡ���������
	public final short ZS_CANCELLATION_M_NREQ = 5077;// �ɳ�����ѯ
	public final short ZS_HISORDERQUERY_M_NREQ = 5069;// ��ʷί�в�ѯ
	public final short ZS_HISTRADEQUERY_M_NREQ = 5073;// ��ʷ�ɽ���ѯ
	public final short ZS_BANKTRANSFEQUERY_M_NREQ = 5095;// ��֤ת�˲�ѯ
	public final short ZS_BILLINGINQUIRIESQUERY_M_NREQ = 5079;// ���˵���ѯ
	public final short ZS_ACCOUNT_BALANCE = 5093;// �����˻�����ѯ
	public final short ZS_STOCK_BUYSELL_CANCEL = 5035;// ί�г���
	public final short ZS_DAY_ORDER_QUERY = 5067;// ����ί�в�ѯ
	public final short ZS_DAY_TRADE_QUERY = 5071;// ���ճɽ���ѯ
	public final short ZS_SHAREHOLDER_QUERY = 5061;// �ɶ���ѯ
	public final short ZS_BANK_ACCOUNT_QUERY = 5097;// �����˻���ѯ
	public final short ZJ_DOWNLOAD_CERT = 704;// ����֤��
	public final short ZJ_ALIVE = 3002;// ����Э��
	public final short ZJ_DELIVERY_ORDER_QUERY = 5075;// �����ѯ
	public final short ZS_APPLY_INFO_QUERY = 5103;// �¹��깺��Ϣ��ѯ
	public final short ZS_APPLY_LIMIT_QUERY = 5099;// �¹��깺�����Ϣ��ѯ
	public final short ZS_ASSIGN_NO_QUERY = 5101;// ��ʷ�����Ϣ��ѯ

	// ֤ȯ����
	public static int CODE_SZAG = 0; // A��
	public static int CODE_SZQZ = 1; // Ȩ֤
	public static int CODE_SZGZ = 2; // ��ծ
	public static int CODE_SZZQ = 3; // ��ծ
	public static int CODE_SZKZHZQ = 4; // תծ
	public static int CODE_SZGZHG = 5; // �ع�
	public static int CODE_SZJJ = 6; // ����
	public static int CODE_SZBG = 7; // B��
	public static int CODE_SZCY = 8; // ��С��ҵ
	public static int CODE_SZOTHER = 9; // ����

	public static int CODE_SHAG = 10; // A��
	public static int CODE_SHQZ = 11; // Ȩ֤
	public static int CODE_SHGZ = 12; // ��ծ
	public static int CODE_SHZQ = 13; // ��ծ
	public static int CODE_SHKZHZQ = 14; // תծ
	public static int CODE_SHGZHG = 15; // �ع�
	public static int CODE_SHJJ = 16; // ����
	public static int CODE_SHBG = 17; // B��
	public static int CODE_SHOTHER = 18; // ����

	public static int CODE_KFJJ = 19;// ����ʽ����
	public static int CODE_SB = 20; // ����

	public static int CODE_SZSPEC = 22;
	public static int CODE_SHSPEC = 23;

	public static int CODE_SZ300CY = 24;// 300 ��ͷ�Ĵ�ҵ��

	public static int CODE_HK = 25;
	public static int CODE_SF = 26;
	public static int CODE_SC = 27;
	public static int CODE_DC = 28;
	public static int CODE_ZC = 29;
	public static int CODE_BH = 30;
	public String CLTP = "CLTP";// �ͻ������ 1������WIN-PC�ͻ��� 2��WIN-PC�ͻ��� 3���ֻ��ͻ���
								// 4����ҳί�� 5����ؿͻ���
	public String MAC = "MAC";// Mac��ַ
	public String DISK = "DISK";// Ӳ����Ϣ
	public String YYB = "YYB";// Ӫҵ������
	public String KHH = "KHH";// �ͻ���
	public String JYMM = "JYMM";// ��������
	public String ZHLB = "ZHLB";// �˺����
	public String CVER = "CVER";// �ͻ��˰汾
	public String GVER = "GVER";// ҵ���ܰ汾��
	public String SEID = "SEID";// �����û�У����
	public String NEWM = "NEWM";// �½�������/���ʽ�����
	public String ZJMM = "ZJMM";// �ʽ�����
	public String BZ = "BZ";// ��������
	public String ZZFX = "ZZFX";// ת�˷���
	public String YHDM = "YHDM";// ���д���
	public String YHMM = "YHMM";// ��������
	public String ZZJE = "ZZJE";// ת�˽��
	public String BEGD = "BEGD";// ��ʼ����
	public String ENDD = "ENDD";// ��ֹ����
	public String BEGN = "BEGN";// ��ʼ���
	public String QLEN = "QLEN";// �����¼��
	public String GDDM = "GDDM";// �ɶ�����
	public String JYSM = "JYSM";// ����������
	public String ZQDM = "ZQDM";// ֤ȯ����
	public String WTJG = "WTJG";// ί�м۸�
	public String BSFG = "BSFG";// ������־
	public String JYDW = "JYDW";// ���׵�λ
	public String WTSL = "WTSL";// ί������
	public String WTBH = "WTBH";// ί�б��
	public String KHMC = "KHMC";// �ͻ�����
	public String KHQX = "KHQX";// �ͻ�Ȩ��
	public String LDA = "LDA";// �ϴε�¼����
	public String LIP = "LIP";// �ϴε�¼IP
	public String LMAC = "LMAC";// �ϴε�½��MAC
	public String LTI = "LTI";// �ϴε�¼ʱ��
	public String ZXSJ = "ZXSJ";// ����ʱ��
	public String KQJE = "KQJE";// ��ȡ���
	public String KYZJ = "KYZJ";// �����ʽ�
	public String KQXJ = "KQXJ";// ��ȡ�ֽ�
	public String ZCZZ = "ZCZZ";// �ʲ���ֵ
	public String ZSZ = "ZSZ";// ����ֵ
	public String SECK = "SECK";// ��Կ��
	public String ERMS = "ERMS";// �������
	public String ERMT = "ERMT";// ������Ϣ
	public String CZBZ = "CZBZ";// ����ȷ�ϣ�0����ѯ������ˮ 1����ѯ��֤ͨ�ʽ� CHAR 6
	public String CZQR = "CZQR";// ����ȷ�ϣ�1����ֻ��ѯ���Գ�����ί�У�0�����������ѯȫ��ί��
	public String HDEX = "HDEX";// ��չ�ֶ�
	public String ZJZH = "ZJZH";// �ʽ��ʺ�
	public String MPS = "MPS";// ��λ��
	public String YHZH = "YHZH";// �����ʻ�
	public String LSH = "LSH";// ��ˮ��

}
