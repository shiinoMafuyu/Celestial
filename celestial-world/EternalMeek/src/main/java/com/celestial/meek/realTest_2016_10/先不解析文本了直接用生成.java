package com.celestial.meek.realTest_2016_10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_File;


public class �Ȳ������ı���ֱ�������� {

	static List<List<Object>> lreq = new ArrayList<List<Object>>();
	static List<List<Object>> lres = new ArrayList<List<Object>>();
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
//		List<List<Object>> l = new ArrayList<List<Object>>();
		String filePath ="C:/Users/Administrator/Desktop/te";
//		getListRequest();
//		getListRequestJIngJia2();
		getListRequestResponse_Espot();
//		get_TemplateCancelResponseVO();
		//qualifiedName, varsList, linfo
		for(List<Object> li : lreq){
			String qualifiedName = (String)li.get(0);
			List<String> ls = CreateRequestResponseOld.createRequestClass(qualifiedName, Arrays.asList(((String[][])li.get(1))), (List<String>)li.get(2));
			Util_File.printFile(ls,filePath + qualifiedName.substring(qualifiedName.lastIndexOf(".")+1) + ".java");
			
		}
		for(List<Object> li : lres){
			String qualifiedName = (String)li.get(0);
			List<String> ls = CreateRequestResponseOld.createreResponseClass(qualifiedName, Arrays.asList(((String[][])li.get(1))), Arrays.asList(((String[][])li.get(2))), (List<String>)li.get(3));
			Util_File.printFile(ls,filePath + qualifiedName.substring(qualifiedName.lastIndexOf(".")+1) + ".java");
		}
		
		
	}

	private static void get_TemplateCancelResponseVO() {
		/**=============================== =========================================*/
		//request���p1
		
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TemplateCancelResponseVO",//ȫ��3
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						{"N","TemplateNo","String","����ģ��ID"}
						
						},
				new String[][]{//�����ѯ5
						
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**=============================== =========================================*/

		
	}

	private static void getListRequestResponse_Espot() {
		/**===============================8. ϵͳ��Ϣ��ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SysInfoRequestVO",//ȫ��1
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SysInfoResponseVO",//ȫ��3
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"D","TradeDate","Date","��ǰ�����գ�yyyy-MM-dd��"}
						
						},
				new String[][]{//�����ѯ5
						
						{"WI","WarehouseId","String","�ֿ�ID"},
						{"WN","WarehouseName","String","�ֿ�����"},
						
						{"LSP","LowestRiskRate","Double","��ͷ��ս�"},
						{"TPT","TradeMarginTime","Integer","Ĭ�ϱ�֤��֧������(Сʱ)"},
						{"DPT","DeliveryTime","Integer","Ĭ�Ͻ���׼������(Сʱ)"},
						
						{"OVT","OrderValidTime","Integer","Ĭ��ί����Ч����(Сʱ)"},
						{"OTM","OrderTradeMargin","Double","���ʳ��ű��Ͻ�"},
						{"TMM","GuaranteeMagnify","Double","���ű��Ͻ�Ŵ���"},
						
						{"FPR","FirstRate","Double","�׿����"},
						{"SPR","SecondRate","Double","�ڶ��ʻ������"},
						{"OFS","OverFlowShort","Double","��̱���"},
						
						{"TFM","TradeFeeMode","Integer","����������ģʽ�� 1���̶�ֵ�� 2���ٷֱ�"},
						{"TFR","TradeFeeRate","Double","������������"},
						{"DFM","DeliveryFeeMode","Double","����������ģʽ�� 1���̶�ֵ�� 2���ٷֱ�"},
						
						{"DFR","DeliveryFeeRate","Double","������������"},
						{"DMM","DeliveryMarginMode","Integer","���ձ�֤��ģʽ�� 1���̶�ֵ�� 2���ٷֱ�"},
						{"DMR","DeliveryMargin","Double","���ձ�֤����"},
						
						{"PTS","PayTimes","Integer","���������ֻ��Ϊ2��3"},
						{"OAB","OrderAuthBuy","Integer","������Ƿ���Ҫ��ˣ� 0����Ҫ�� 1������Ҫ"},
						{"OAS","OrderAuthSell","Integer","�������Ƿ���Ҫ��ˣ� 0����Ҫ�� 1������Ҫ"},
						
						{"PAS","PayBillAuthSell","Integer","���ֵ��Ƿ���Ҫ��ˣ� 0����Ҫ�� 1������Ҫ"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================8. ϵͳ��Ϣ��ѯ =========================================*/

	}

	public static void getListRequestJIngJia2() {
		/**===============================8 ��Ʒ�����ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityInfoQueryRequestVO",//ȫ��1
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"C","commodityId","String","��Ʒ����"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityInfoQueryResponseVO",//ȫ��3
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TRD","TotalRecord","Integer","�ܼ�¼��"}
						
						},
				new String[][]{//�����ѯ5
						{"I","Code","String","�����"},
						{"C","CommodityCode","String","��Ʒ��"},
						{"SP","StartPrice","Double","�𱨼�"},
						
						{"AP","AlertPrice","Double","������"},
						{"AD","AddPrice","Double","�Ӽ۷���"},
						{"Q","Qty","Integer","��������"},
						
						{"IQ","MinQty","Integer","��С��������"},
						{"XQ","MaxQty","Integer","��󱨵�����"},
						{"MAR","Margin","Double","���ױ�֤��"},
						
						{"FEE","Fee","Double","������"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================8 ��Ʒ�����ѯ =========================================*/

	}

	public static void getListRequestJIngJia() {
		/**===============================9 �µ����� =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"I","Code","String","��ĺ�"},
						{"C","CommodityCode","String","��Ʒ����"},
						{"M","Module","Integer","���װ��"},
						{"P","Price","Double","�µ��۸�"},
						{"Q","Qty","Integer","�µ�����"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}
						
						},
				new String[][]{//�����ѯ5

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================9 �µ����� =========================================*/
		
		/**===============================10 ���װ���ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TradePlateQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TradePlateQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TRD","TotalRecord","Integer","�ܼ�¼��"}
						
						},
				new String[][]{//�����ѯ5
						{"N","TradeModuleName","String","���װ������"},
						{"M","TradeMode","Integer","����ģʽ"},
						{"S","TradeStatus","Integer","����״̬"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================10 ���װ���ѯ =========================================*/
		
		/**===============================11 ��ѡ��Ʒ���/ɾ�� =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityOperateRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"I","Code","String","��ĺ�"},
						{"C","CommodityCode","String","��Ʒ��"},
						{"M","Module","Integer","���װ��"},
						{"S","Status","Integer","״̬"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityOperateResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}

						},
				new String[][]{//�����ѯ5
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================11 ��ѡ��Ʒ���/ɾ�� =========================================*/
		
		/**===============================13 ������Ϣ��ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.UserInfoQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"}
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.UserInfoQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}
						
						},
				new String[][]{//�����ѯ5
						{"BF","BalanceFunds","Double","�ʽ����"},
						{"UF","UsableFunds","Double","�����ʽ�"},
						{"FF","FrozenFunds","Double","�����ʽ�"},
						{"OP","Option","Boolean","�Ƿ��йҵ�Ȩ��"},
						{"NP","NewOption","Boolean","�Ƿ��������µ�Ȩ��"},
						{"AD","Address","String","��ַ"},
						{"PH","Phone","String","�绰"},
						{"IF","PersonInfo","String","���˼��"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================13 ������Ϣ��ѯ =========================================*/
		
		/**===============================14 ��ѡ��Ʒ��ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"M","Module","Integer","���װ��"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TRD","TotalRecord","Integer","�ܼ�¼��"},
						{"M","Module","Integer","���װ��"},
						
						
						},
				new String[][]{//�����ѯ5
						{"I","Code","String","��ĺ�"},
						{"C","CommodityCode","String","��Ʒ��"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================14 ��ѡ��Ʒ��ѯ =========================================*/
		
		/**===============================15 ��Ϣ���ѣ�ί��״̬�䶯�����������ֳ����� =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.VendueMessageRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"T","LastTime","Date","�ϴβ�ѯʱ��"}

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.VendueMessageResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},

						{"TRD","TotalRecord","Integer","�ܼ�¼��"},
						{"TI","timestamp","Date","���β�ѯʱ��"}
						
						},
				new String[][]{//�����ѯ5
						{"I","ModuleId","Integer","���װ��ID"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================15 ��Ϣ���ѣ�ί��״̬�䶯�����������ֳ����� =========================================*/
		
		/**===============================16 �ҵ����� =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityAddRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						
						{"C","CommdoityId","String","��Ʒ����"},
						{"COD","CommodityCode","String","��Ʒ��"},
						{"AA","AuctionAlgr","String","�����㷨"},
						
						{"AQ","AuctionQty","String","������"},
						{"SP","StartPrice","Double","���ļ�"},
						{"AP","AlertPrice","Double","������"},
						
						{"Q","Qty","Integer","����"},
						{"UN","TradeUnit","Integer","����������λ"},
						{"IA","MinAmount","Integer","��С��������"},
						
						{"XA","MaxAmount","Integer","��󱨵�����"},
						{"AD","AddPrice","Double","�Ӽ۷���"},
						
						{"BPI","BreedPropertyId","String","Ʒ�����Դ���"},
						{"PID","PropertyId","String","��Ʒ���Դ���"},
						{"PNM","PropertyName","String","��Ʒ��������"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityAddResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}
						
						},
				new String[][]{//�����ѯ5

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================16 �ҵ����� =========================================*/
		
		/**===============================17 �ҵ���ѡ��Ʒ��ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.AddCommodityQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.AddCommodityQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}
						
						
						},
				new String[][]{//�����ѯ5
						{"C","CommodityCode","String","��Ʒ����"},
						{"CN","CommodityName","String","��Ʒ����"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================17 �ҵ���ѡ��Ʒ��ѯ =========================================*/
		
		/**===============================18 �ҵ���Ʒ�������Բ�ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityPropQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						
						{"C","CommodityCode","String","��Ʒ����"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityPropQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						
						{"AP","AlertPrice","Double","Ĭ�ϱ�����"},
						{"AQ","AlertQty","Integer","Ĭ����Ʒ����"},
						{"TU","TradeUnit","Integer","Ĭ�Ͻ���������λ"},
						
						{"IA","MinAmount","Integer","Ĭ����С��������"},
						{"XA","MaxAmount","Integer","Ĭ����󱨵�����"},
						{"TRD","TotalRecord","Integer","�ܼ�¼��"},

						},
				new String[][]{//�����ѯ5
						{"BPI","BreedPropertyId","String","Ʒ�����Դ���"},
						{"BPN","BreedPropertyName","String","Ʒ����������"},
						
						{"CPS","CommodityPropertyList","String","Ʒ����������"},
						{"CPI","CommodityPropertyId","String","���Դ���"},
						{"CPN","CommodityPropertyName","String","��������"}
						

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================18 �ҵ���Ʒ�������Բ�ѯ =========================================*/
		
		/**===============================19 ��ǰί�в�ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrdersQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"M","Module","Integer","���װ��"},
						{"TI","LastTime","Date","�ϴβ�ѯʱ��"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrdersQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"NEW","NewOrder","Boolean","�Ƿ�����ί��"}
						
						},
				new String[][]{//�����ѯ5
						{"O","OrderId","String","ί�к�"},
						{"I","CmdCode","String","��ĺ�"},
						{"P","Price","Double","�ҵı���"},
						
						{"CP","CurPrice","Double","��ǰ����"},
						{"Q","Qty","Integer","����"},
						{"ST","SubmitTime","Date","�ύʱ��"},
						
						{"MT","ModifyTime","Date","�޸�ʱ��"},
						{"UQ","ValidQty","Integer","��Ч����"},
						{"FM","FrozenMargin","Double","���ᱣ֤��"},
						
						{"FF","FrozenFee","Double","����������"},
						{"RM","ReleaseMargin","Double","�ͷű�֤��"},
						{"RF","ReleaseFee","Double","�ͷ�������"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================19 ��ǰί�в�ѯ =========================================*/
		
		/**===============================20 �ҵĹҵ���ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyCmdQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						
						{"ST","StartTime","Date","��ʼʱ��"},
						{"ET","EndTime","Date","����ʱ��"},
						{"M","Module","Integer","���װ��"},
						{"PN","PageNo","Integer","ҳ���С"},
						{"PS","PageSzie","Integer","ҳ���С"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyCmdQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TRD","TotalRecord","Integer","�ܼ�¼��С"}
						
						
						
						},
				new String[][]{//�����ѯ5
						{"I","CmdCode","String","��ĺ�"},
						{"C","CommodityCode","String","��Ʒ��"},
						{"P","Price","Double","�𱨼�"},
						
						{"Q","Qty","Integer","����"},
						{"ST","StartQty","Integer","��С������"},
						{"MT","MaxQty","Integer","��󱨵���"},
						
						{"AP","AlertPrice","Double","������"},
						{"TU","TradeUnit","Integer","���׵�λ����"},
						{"AD","AddPrice","Double","�Ӽ۷���"},
						
						{"AA","AuctionAlgr","String","�����㷨"},
						{"AQ","AuctionQty","Double","������"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================20 �ҵĹҵ���ѯ =========================================*/
		
		/**===============================21 �ҵĳɽ���ѯ =========================================*/
		//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyTradeQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"ST","StartTime","Date","��ʼʱ��"},
						{"ET","EndTime","Date","����ʱ��"},
						{"M","Module","Integer","���װ��"},
						
						{"PN","PageNo","Integer","ҳ���С"},
						{"PS","PageSize","Integer","ҳ���С"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyTradeQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TRD","TotalRecord","Integer","�ܼ�¼��С"}
						
						},
				new String[][]{//�����ѯ5
						{"C","ContractNo","String","��ͬ��"},
						{"I","CmdCode","String","��ĺ�"},
						{"P","Price","Double","�ɽ���"},
						
						{"Q","TradeQty","Integer","�ɽ���"},
						{"M","Margin","Double","���ױ�֤��"},
						{"F","Fee","Double","������"},
						
						{"T","TradeTime","Date","�ɽ�ʱ��"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================21 �ҵĳɽ���ѯ =========================================*/

		
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * E�ֻ����ֻ�Э��
	 * </ul>
	 */
	public static void getListRequest() {
//		List<List<Object>> lreq = new ArrayList<List<Object>>();
		//ls2.add(new String[]{"U","UserID","String","�û�id"});
		//ls2.add(new String[]{"SI","SessionID","Long","�û��Ựid"});
		//{"","","",""},
		//String Double Integer Date
		/*List<String> linfo = Arrays.asList(new String[]{"update by wangzg 2016��8��3��14:29:29"});
		
		String qualifiedName19 = "gnnt.MEBS.MobileServer.vo.micro.trade.FirmInfoRequestVO";
		String[][] sArrArrRequest19 = new String[][]{
				{"U","UserID","String","�û�id"},
				{"SI","SessionID","Long","�û��Ựid"},
				};
		List<String[]> ls = Arrays.asList(sArrArrRequest19);*/
		
		
		
		/**===============================19. ��������Ϣ=========================================*/
		//request���
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.FirmInfoRequestVO",//ȫ��
				new String[][]{//������Ϣ
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date
		//response���
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.FirmInfoResponseVO",//ȫ��
				new String[][]{//�����Ϣ
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						{"TI","TraderID","String","����ԱID"},
						{"UI","UserID","String","�û���"},
						{"TN","TraderName","String","����Ա����"},
						
						{"FI","FirmID","String","������ID"},
						{"FN","FirmName","String","����������"},
						{"FT","FirmType","String","����������"},
						
						{"AD","Address","String","���׵�ַ"},
						{"CM","ContactMan","String","��ϵ��"},
						{"PH","Phone","String","��ϵ�˵绰"}
						},
				new String[][]{//�����ѯ
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================19. ��������Ϣ=========================================*/
		
		/**===============================18. ���ί�������ѯ=========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderInfoQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						{"CHF","CheckHistoryFlag","String","��ǰ��ʷ��ѯ��־     0����ǰ��¼;  1: ��ʷ��¼"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderInfoQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						{"CHF","CheckHistoryFlag","String","��ǰ��ʷ��ѯ��־     0����ǰ��¼;  1: ��ʷ��¼"},
						
						{"SOI","AsOrderId","String","���ί�е���"},
						{"STA","Status","String","ί�����״̬��0���ȴ��� 1��ί�з����� 2��ί�з��ܾ� 3����۷����� 4��ϵͳ�Զ����� 5: ����Ա����"},
						
						{"PRI","Price","Double","�۸�"},
						{"QTY","Qty","Integer","�������"},
						{"U","Unit","String","��Ʒ��λ"},
						
						{"WHI","WarehouseId","String","���ղֿ�"},
						{"CT","CreateTime","Date","���ʱ��"},
						
						{"RT","ReplyTime","Date","��ʱ��"},
						{"RM","ReplyMessage","String","����Ϣ"},
						{"DMB","BuyerPerformMargin","Double","����Լ��֤��"},
						
						{"DMS","SellerPerformMargin","Double","������Լ��֤��"},
						{"DDT","DeliveryDateType","String","���������ͣ�0��ָ�����ޣ�1��ָ������"},
						{"DPH","DeliveryTime","Integer","�������ޣ���λ��Сʱ������������ʾ�����������ͣ���0��ָ������"},
						{"DD","DeliveryDate","Date","������������������ʾ�����������ͣ���1��ָ������"},
						
						{"RMK","Remark","String","��������"},
						{"SFI","PerformFirmID","String","���ί�н�����ID"},
						{"OFI","OrderFirmID","String","ί�н�����ID"},
						
						{"ORI","OrderID","String","ί�е���"}
						},
				new String[][]{//�����ѯ5
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================18. ���ί�������ѯ=========================================*/
		
		/**===============================17. ���ί�в�ѯ=========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						{"CHF","CheckHistoryFlag","String","��ǰ��ʷ��ѯ��־     0����ǰ��¼;  1: ��ʷ��¼"},
						
						{"UT","LastTimestamp","Long","������ʱ��,΢���ʾ"},
						{"PN","PageNo","Integer","��ǰҳ��"},
						{"PS","PageSize","Integer","ÿҳ��ʾ����"},
						{"T","AsOrderType","String","������ί����۵����ͱ�־��1���������� 2�����ܵ����"},
						
						{"STA","Status","String","ί�����״̬��0���ȴ��� 1��ί�з����� 2��ί�з��ܾ� 3����۷����� 4��ϵͳ�Զ����� 5: ����Ա����"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TTLREC","TotalRecord","Integer","�ܼ�¼��"},
						{"PN","PageNo","Integer","��ǰҳ��"},
						{"PS","PageSize","Integer","ÿҳ��ʾ����"}

						},
				new String[][]{//�����ѯ5
						{"SI","AsOrderId","String","���ί�е���"},
						{"ORT","OrderTitle","String","ί�б���"},
						{"PRI","Price","Double","����"},
						
						{"QTY","Qty","Integer","����"},
						{"U","Unit","String","��Ʒ��λ"},
						{"T","Type","String","��������:0: Э�齻��1����������"},
						
						{"STA","Status","String","ί�����״̬��0���ȴ��� 1��ί�з����� 2��ί�з��ܾ� 3����۷����� 4��ϵͳ�Զ����� 5: ����Ա����"},
						{"SFI","PerformFirmID","String","���ί�н�����ID"},
						{"CT","CreateTime","Date","������ʱ��"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================17. ���ί�в�ѯ=========================================*/
		
		/**===============================16. ժ��=========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.PickOffOrderRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"ORI","OrderID","String","ί�е���"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.PickOffOrderResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}
						
						},
				new String[][]{//�����ѯ5
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================16. ժ��=========================================*/
		
		/**===============================15. ����ί��=========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderCancelRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						{"ORI","OrderID","String","ί�е���"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderCancelResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"}
						},
				new String[][]{//�����ѯ5
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================15. ����ί��=========================================*/
		

		/**===============================33. �ֵ���ϸ��Ϣ =========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.BillDetailQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"N","BillNo","String","�ֵ���"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.BillDetailQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"B","BreedId","String","�������"},
						{"C","CommodityId","String","Ʒ������"},
						{"T","CommodityTitle","String","��Ʒ����"},
						
						{"Q","Qty","Integer","����"},
						{"P","Price","Double","�۸�"},
						{"S","StartTradeQty","Integer","����"},
						
						{"U","TradeUnit","String","���׵�λ"},
						{"W","WarehouseId","String","���ղֿ����"},
						
						},
				new String[][]{//�����ѯ5
						{"PT","PropertyType","String","�������� ���������� ����ָ�꣩"},
						{"PN","PropertyName","String","Ʒ����������"},
						{"PV","PropertyValue","String","Ʒ������ֵ"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================33. �ֵ���ϸ��Ϣ=========================================*/
		
		/**===============================31. ģ�������ѯ =========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TemplateDetailQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"N","TemplateNo","String","ģ��ID"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TemplateDetailQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"ORI","OrderID","String","ί�е���"},
						{"ORT","OrderTitle","String","ί�б���"},
						{"BN","BreedName","String","Ʒ������"},
						
						{"BCN","BreedCmdName","String","������������"},
						{"BS","BsFlag","Integer","��������:  1: ��2����"},
						{"T","TemplateType","String","ģ������  1ϵͳģ�� 2�Զ���ģ�� 3ϵͳģ��+�Զ���ģ��"},
						
						{"STA","Status","Integer","ί��״̬��0��δ�ɽ�1�����ֳɽ�2��ȫ���ɽ�3�����¼�11��������Ա���"},
						{"PRI","Price","Double","��λ�۸�"},
						{"QTY","Qty","Integer","��Ʒ����"},
						
						{"TQ","TradeQty","Integer","�ѳɽ�����"},
						{"U","Unit","String","��Ʒ��λ"},
						{"OT","OrderTime","Date","ί��ʱ��"},
						
						{"ET","EffectiveTime","Date","��Чʱ�䣬Ϊ����ʾ��--��"},
						{"RMK","Remark","String","��������"},
						{"VH","ValidateHours","Integer","��Ϣ��Ч�ڣ���λ��Сʱ����-1��������Ч������ֵ����Сʱ"},
						
						{"TF","TradeFlag","Integer","�ɽ���ʽ��1��ֱ�ӳɽ���2������۳ɽ���3��������۳ɽ�"},
						{"TPH","MarginDeadLine","String","��֤��֧������(Сʱ)������������ʾ,Ʒ�ֽ���ģʽ����1�����ű��Ͻ�ģʽ"},
						{"TMB","TradeMarginBuyer","String","�򷽳��ű��Ͻ�����������ʾ,Ʒ�ֽ���ģʽ����1�����ű��Ͻ�ģʽ"},
						
						{"TMS","TradeMarginSeller","String","�������ű��Ͻ�����������ʾ,Ʒ�ֽ���ģʽ����1�����ű��Ͻ�ģʽ"},
						{"IPM","IsPayMargin","String","�Ƿ���֧����Լ��֤��  Y:�ǣ�N:������������ʾ,Ʒ�ֽ���ģʽ����1�����ű��Ͻ�ģʽ"},
						//{"PF","PayFlag","Integer",">�Ƿ����ֵ���0����1����"},
						
						{"STI","SellBillId","Integer","����������ʾ���Ƿ����ֵ�����1����"},
						{"OWI","OrderWithdrawId","Integer","����������������ʾ��ί��״̬����3�����¼�"},
						{"OWT","OrderWithdrawType","Integer","����ʱ������������ʾ��ί��״̬����3�����¼�"},
						
						{"MTQ","MinTradeQty","Integer","��С��������"},
						{"TU","TradeUnit","String","���׵�λ"},
						{"DET","DeliveryType","String","���յ����ͣ�1��ָ���ֿ⣻2��ָ�����յ�"},
						
						{"DWI","DeliveryWarehouseId","String","���ղֿ�ţ�Ϊ����ʾ��--�� ����������ʾ�����յ����ͣ���1��ָ���ֿ�"},
						{"DEA","DeliveryAddress","String","���յأ�Ϊ����ʾ��--�� ����������ʾ�����յ����ͣ���2��ָ�����յ�"},
						{"DMB","BuyerPerformMargin","Double","����Լ��֤��"},
						
						{"DMS","SellerPerformMargin","Double","������Լ��֤��"},
						{"TY","SettleType","Integer","��������: 0: Э�齻�գ� 1����������"},
						{"PT","PayType","Integer","�������ͣ�0���ȿ�����1���Ȼ���2������������������ʾ���������ͣ���1����������"},
						
						{"DDT","DeliveryDateType","String","���������ͣ�0��ָ�����ޣ�1��ָ������"},
						{"DPH","DeliveryTime","Date","�������ޣ���λ��Сʱ������������ʾ�����������ͣ���0��ָ������"},
						{"DD","DeliveryDate","Date","������������������ʾ�����������ͣ���1��ָ������"},
						
						
						},
				new String[][]{//�����ѯ5
						{"PT","PropertyType","String","�������� ���������� ����ָ�꣩"},
						{"PN","PropertyName","String","Ʒ����������"},
						{"PV","PropertyValue","String","Ʒ������ֵ"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================31. ģ�������ѯ =========================================*/
		
		
		/**===============================14. ����ί��  =========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderSubmitRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"BS","BsFlag","Integer","��������:  1: ��2����"},
						{"PF","PayFlag","Integer",">�Ƿ����ֵ���0����1����"},
						{"ORT","OrderTitle","String","ί�б���"},
						
						{"CI","CommodityId","String","��������ID"},
						{"BI","BreedId","String","Ʒ��ID"},
						{"B","BillId","String","�����ֵ�ID"},
						
						{"T","PropertyType","String","������� (�������ԡ�����ָ��) "},
						{"P","PropertyId","String","Ʒ�����Դ���"},
						{"N","PropertyName","String","��Ʒ���Դ���/����"},
						
						{"PRI","Price","Double","ί�м۸�"},
						{"QTY","Qty","Integer","ί������"},
						{"MTQ","MinTradeQty","Integer","��С��������"},
						
						{"TU","TradeUnit","String","���׵�λ"},
						{"TF","TradeFlag","Integer","�ɽ���ʽ��1��ֱ�ӳɽ���2������۳ɽ���3��������۳ɽ�"},
						{"VH","ValidateHours","Integer","��Ϣ��Ч�ڣ���λ��Сʱ����-1��������Ч������ֵ����Сʱ"},
						
						{"MT","MarginType","Integer","��Լ��֤��֧����ʽ  1֧��  2��֧�� "},
						{"TY","SettleType","Integer","��������: 0: Э�齻�գ� 1����������"},
						{"PT","PropertyType","String","�������� ���������� ����ָ�꣩"},
						
						{"DET","DeliveryType","String","���յ����ͣ�1��ָ���ֿ⣻2��ָ�����յ�"},
						{"DWI","DeliveryWarehouseId","String","���ղֿ��."},
						{"DEA","DeliveryAddress","String","���յ�"},
						
						{"DPH","DeliveryTime","Integer","�������ޣ���λ��Сʱ������������ʾ������������."},
						{"DD","DeliveryDate","Date","������������������ʾ������������."},
						{"DMB","BuyerPerformMargin","Double","����Լ��֤��"},
						
						{"DMS","SellerPerformMargin","Double","������Լ��֤��"},
						{"RMK","Remark","String","��������"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderSubmitResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						},
				new String[][]{//�����ѯ5
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================14. ����ί�� =========================================*/
		
		/**===============================13. ����ί�������ѯ =========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderInfoQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"ORI","OrderID","String","ί�е���"}
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderInfoQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"ORI","OrderID","String","ί�е���"},
						{"ORT","OrderTitle","String","ί�б���"},//=============
						{"BN","BreedName","String","Ʒ������"},
						
						{"BCN","BreedCmdName","String","Ʒ������"},
						{"BS","BsFlag","Integer","��������:  1: ��2����"},
						{"STA","Status","String","ί��״̬��0��δ�ɽ�1�����ֳɽ�2��ȫ���ɽ�3�����¼�11��������Ա���"},
						
						{"PRI","Price","Double","��λ�۸�"},
						{"QTY","Qty","Integer","��Ʒ����"},
						{"TQ","TradeQty","Integer","�ѳɽ�����"},
						
						{"U","Unit","String","��Ʒ��λ"},
						{"OT","OrderTime","String","ί��ʱ��"},//=============
						{"ET","EffectiveTime","Date","��Чʱ�䣬Ϊ����ʾ��--��"},
						
						{"RMK","Remark","String","��������"},
						{"VH","ValidateHours","Integer","��Ϣ��Ч�ڣ���λ��Сʱ����-1��������Ч������ֵ����Сʱ"},
						{"TF","TradeFlag","Integer","�ɽ���ʽ��1��ֱ�ӳɽ���2������۳ɽ���3��������۳ɽ�"},
						
						{"TPH","MarginDeadLine","String","��֤��֧������(Сʱ)��"},
						{"TMB","TradeMarginBuyer","String","�򷽳��ű��Ͻ�"},
						{"TMS","TradeMarginSeller","String","�������ű��Ͻ�"},
						
						{"IPM","IsPayMargin","String","�Ƿ���֧����Լ��֤��  Y:�ǣ�N:��"},
						{"PF","PayFlag","Integer",">�Ƿ����ֵ���0����1����"},
						
						{"STI","SellBillId","Integer","���ֵ���"},
						{"OWI","OrderWithdrawId","Integer","������"},
						{"OWT","OrderWithdrawType","Integer","����ʱ��"},
						
						{"MTQ","MinTradeQty","Integer","��С��������"},
						{"TU","TradeUnit","String","���׵�λ"},
						{"DET","DeliveryType","String","���յ����ͣ�1��ָ���ֿ⣻2��ָ�����յ�"},
						
						{"DWI","DeliveryWarehouseId","String","���ղֿ�ţ�Ϊ����ʾ��--��"},
						{"DEA","DeliveryAddress","String","���յأ�Ϊ����ʾ��--��"},
						{"DMB","BuyerPerformMargin","Double","����Լ��֤��"},
						
						{"DMS","SellerPerformMargin","Double","������Լ��֤��"},
						{"TY","SettleType","Integer","��������: 0: Э�齻�գ� 1����������"},
						{"PT","PayType","Integer","�������ͣ�0���ȿ�����1���Ȼ���2������������������ʾ���������ͣ���1����������"},
						
						{"DDT","DeliveryDateType","String","���������ͣ�0��ָ�����ޣ�1��ָ������"},
						{"DPH","DeliveryTime","Date","�������ޣ���λ��Сʱ��"},
						{"DD","DeliveryDate","Date","������������������ʾ�����������ͣ���1��ָ������"}
						
						
						},
				new String[][]{//�����ѯ5
						{"PT","PropertyType","String","�������� ���������� ����ָ�꣩"},
						{"PN","PropertyName","String","Ʒ����������"},
						{"PV","PropertyValue","String","Ʒ������ֵ"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================13. ����ί�������ѯ =========================================*/

		/**===============================12. ����ί�в�ѯ =========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"B","BreedId","String","Ʒ�ִ���"},
						{"C","CommodityId","String","Ʒ������"},
						{"X","MaxPrice","Double","��߼�"},
						
						{"I","MinPrice","Double","��ͼ�"},
						{"M","TradeMode","Integer","����ģʽ"},
						{"R","SortType","String","����ʽ"},
						
						{"T","CommodityTitle","Integer","��Ʒ����"},
						{"N","NewOrderId","String","����ί�е���"},
						{"S","Size","Integer","��ѯ����       ������ ��ѯ��������ί�кŵ�N������  	С���� ��ѯС������ί�кŵ�N������"},
						
						{"BS","BsFlag","Integer","��ѯ����ί�б�־��     1����ί��    2����ί��	 3������ί��"},
						{"STA","Status","String","ί��״̬��0��δ�ɽ� 1�����ֳɽ�2��ȫ���ɽ�3�����¼�11��������Ա���"},
						
						{"BP","BreedProperty","String","Ʒ�����Դ���"},
						{"CP","CommodityPropValue","String","��Ʒ����ֵ"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TTLREC","TotalRecord","Integer","�ܼ�¼��"}
						},
				new String[][]{//�����ѯ5
						{"PID","PictureId","String","ͼƬΨһ��ʶ"},
						{"ORI","OrderID","String","ί�е���"},
						{"ORT","OrderTitle","String","ί�б���"},
						
						{"BN","BreedName","String","Ʒ��"},
						{"TM","TradeMode","Integer"," 1: ���ű��Ͻ�ģʽ�� 2����֤��ģʽ"},
						{"BS","BsFlag","Integer","��������:  1: ��2����"},
						
						{"STA","Status","Integer","ί��״̬��0��δ�ɽ�    1�����ֳɽ�  2��ȫ���ɽ�   3�����¼�  11��������Ա���"},
						{"PRI","Price","Double","��λ�۸�"},
						{"QTY","Qty","Integer","�ѳɽ�����"},
						
						{"TQ","TradeQty","Integer","�ѳɽ�����"},
						{"U","Unit","String","��Ʒ��λ"},
						{"OT","OrderTime","Date","ί��ʱ��"},
						
						
						{"TY","SettleType","Integer","��������: 0: Э�齻�գ� 1����������"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================12. ����ί�в�ѯ =========================================*/
		
		/**===============================11. ��Ʒί�������ѯ =========================================*/
		//request���p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderInfoQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"ORI","OrderID","String","ί�е���"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		//String Double Integer Date Long
		//response���p2
		/*lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderInfoQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"ORI","OrderID","String","ί�е���"},
						{"ORT","OrderTitle","String","ί����Ʒ����"},
						{"BN","BreedName","String","Ʒ������"},
						
						{"BCN","BreedCmdName","String","Ʒ������"},
						{"BS","BsFlag","Integer","��������:  1: ��2����"},
						{"PRI","Price","Double","��λ�۸�"},
						
						{"QTY","Qty","Integer","��Ʒ����"},
						{"TQ","TradeQty","Integer","�ѳɽ�����"},
						{"U","Unit","String","��Ʒ��λ"},
						
						
						
						{"OT","OrderTime","Date","ί��ʱ��"},
						
						{"ET","EffectiveTime","Date","��Чʱ�䣬Ϊ����ʾ��--��"},
						{"RMK","Remark","String","��������"},
						{"VH","ValidateHours","Integer","��Ϣ��Ч�ڣ���λ��Сʱ����-1��������Ч������ֵ����Сʱ"},
						
						{"TF","TradeFlag","Integer","�ɽ���ʽ��1��ֱ�ӳɽ���2������۳ɽ���3��������۳ɽ�"},
						{"TPH","MarginDeadLine","String","��֤��֧������(Сʱ)��"},
						{"TMB","TradeMarginBuyer","String","�򷽳��ű��Ͻ���"},
						
						{"TMS","TradeMarginSeller","String","�������ű��Ͻ�"},
						{"IPM","IsPayMargin","String","�Ƿ���֧����Լ��֤��  Y:�ǣ�N:��"},
						{"PF","PayFlag","Integer",">�Ƿ����ֵ���0����1����"},
						
						{"STI","SellBillId","Integer","����������ʾ���Ƿ����ֵ�����1����"},
						{"OWI","OrderWithdrawId","Integer","������"},
						{"OWT","OrderWithdrawType","Integer","����ʱ��"},
						
						{"MTQ","MinTradeQty","Integer","��С��������"},
						{"TU","TradeUnit","String","���׵�λ"},
						{"DET","DeliveryType","String","���յ����ͣ�1��ָ���ֿ⣻2��ָ�����յ�"},
						
						{"DWI","DeliveryWarehouseId","String","���ղֿ�ţ�Ϊ����ʾ��--�� ��"},
						{"DEA","DeliveryAddress","String","���յأ�Ϊ����ʾ��--�� "},
						{"DMB","BuyerPerformMargin","Double","����Լ��֤��"},
						
						{"DMS","SellerPerformMargin","Double","������Լ��֤��"},
						{"TY","SettleType","Integer","��������: 0: Э�齻�գ� 1����������"},
						{"PT","PayType","Integer","�������ͣ�0���ȿ�����1���Ȼ���2����"},
						
						{"DDT","DeliveryDateType","String","���������ͣ�0��ָ�����ޣ�1��ָ������"},
						{"DPH","DeliveryTime","Date","�������ޣ���λ��Сʱ��"},
						{"DD","DeliveryDate","Date","��������"},
						
						},
				new String[][]{//�����ѯ5
						{"PT","PropertyType","String","�������� ���������� ����ָ�꣩"},
						{"PN","PropertyName","String","Ʒ����������"},
						{"PV","PropertyValue","String","Ʒ������ֵ"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================11. ��Ʒί�������ѯ =========================================*/

		/**===============================10. ��Ʒί�в�ѯ =========================================*/
		/*//request���p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderQueryRequestVO",//  <<--------  ȫ��1  ---------
				new String[][]{//������Ϣ2
						{"U","UserID","String","�û�id"},
						{"SI","SessionID","Long","�û��Ựid"},
						
						{"B","BreedId","String","Ʒ�ִ���"},
						{"C","CommodityId","String","Ʒ������"},
						{"X","MaxPrice","Double","��߼�"},
						
						{"I","MinPrice","Double","��ͼ�"},
						{"M","TradeMode","Integer","����ģʽ  1��֤��   2���ű��Ͻ�   3��Ϊ�� ����"},
						{"R","SortType","String","����ʽ"},
						
						{"T","CommodityTitle","Integer","��Ʒ����"},
						{"N","NewOrderId","String","����ί�е���"},
						{"S","Size","Integer","��ѯ����       ������ ��ѯ��������ί�кŵ�N������  	С���� ��ѯС������ί�кŵ�N������"},
						
						{"BS","BsFlag","Integer","��ѯ����ί�б�־��     1����ί��    2����ί��	 3������ί��"},
						
						{"BP","BreedPropertyId","String","Ʒ�����Դ���"},
						{"CP","CommodityPropertyValue","String","��Ʒ����ֵ"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response���p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderQueryResponseVO",//  <<--------  ȫ��3  ---------
				new String[][]{//�����Ϣ4
						{"RETCODE","RETCODE","String","������  =0�ɹ�, ����Ϊʧ�ܣ�����������MESSAGE ��"},
						{"MESSAGE","MESSAGE","String","���ص���ʾ��Ϣ����"},
						
						{"TTLREC","TotalRecord","Integer","�ܼ�¼��"},
						{"S","Size","Integer","��ѯ����"}
						
						},
				new String[][]{//�����ѯ5
						{"PID","PictureId","String","ͼƬΨһ��ʶ"},
						{"ORI","OrderID","String","ί�е���"},
						{"ORT","OrderTitle","String","ί�б���"},
						
						{"BN","BreedName","String","Ʒ��"},
						{"TM","TradeMode","Integer"," 1: ���ű��Ͻ�ģʽ�� 2����֤��ģʽ"},
						{"BS","BsFlag","Integer","��������:  1: ��2����"},
						
						{"PRI","Price","Double","��λ�۸�"},
						{"QTY","Qty","Integer","��Ʒ����"},
						{"TQ","TradeQty","Integer","�ѳɽ�����"},
						{"U","Unit","String","��Ʒ��λ"},
						
						{"TU","TradeUnit","String","���׵�λ"},
						{"SQ","StartOrderQty","Integer","������"},
						{"OT","OrderTime","Date","ί��ʱ��"},
						{"TY","SettleType","Integer","��������: 0: Э�齻�գ� 1����������"},
						
						{"TR","TraderId","String","����������ID"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================10. ��Ʒί�в�ѯ =========================================*/

		
		return ;
	}

}
