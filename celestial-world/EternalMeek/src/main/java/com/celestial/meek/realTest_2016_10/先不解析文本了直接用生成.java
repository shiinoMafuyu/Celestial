package com.celestial.meek.realTest_2016_10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;


public class 先不解析文本了直接用生成 {

	static List<List<Object>> lreq = new ArrayList<List<Object>>();
	static List<List<Object>> lres = new ArrayList<List<Object>>();
	/**
	 * <b>方法说明：</b>
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
			UtilFile.printFile(ls,filePath + qualifiedName.substring(qualifiedName.lastIndexOf(".")+1) + ".java");
			
		}
		for(List<Object> li : lres){
			String qualifiedName = (String)li.get(0);
			List<String> ls = CreateRequestResponseOld.createreResponseClass(qualifiedName, Arrays.asList(((String[][])li.get(1))), Arrays.asList(((String[][])li.get(2))), (List<String>)li.get(3));
			UtilFile.printFile(ls,filePath + qualifiedName.substring(qualifiedName.lastIndexOf(".")+1) + ".java");
		}
		
		
	}

	@SuppressWarnings("unused")
	private static void get_TemplateCancelResponseVO() {
		/**=============================== =========================================*/
		//request添加p1
		
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TemplateCancelResponseVO",//全名3
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						{"N","TemplateNo","String","撤销模板ID"}
						
						},
				new String[][]{//输出查询5
						
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**=============================== =========================================*/

		
	}

	private static void getListRequestResponse_Espot() {
		/**===============================8. 系统信息查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SysInfoRequestVO",//全名1
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SysInfoResponseVO",//全名3
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"D","TradeDate","Date","当前交易日（yyyy-MM-dd）"}
						
						},
				new String[][]{//输出查询5
						
						{"WI","WarehouseId","String","仓库ID"},
						{"WN","WarehouseName","String","仓库名称"},
						
						{"LSP","LowestRiskRate","Double","最低风险金"},
						{"TPT","TradeMarginTime","Integer","默认保证金支付期限(小时)"},
						{"DPT","DeliveryTime","Integer","默认交收准备期限(小时)"},
						
						{"OVT","OrderValidTime","Integer","默认委托有效期限(小时)"},
						{"OTM","OrderTradeMargin","Double","单笔诚信保障金"},
						{"TMM","GuaranteeMagnify","Double","诚信保障金放大率"},
						
						{"FPR","FirstRate","Double","首款比例"},
						{"SPR","SecondRate","Double","第二笔货款比例"},
						{"OFS","OverFlowShort","Double","溢短比例"},
						
						{"TFM","TradeFeeMode","Integer","交易手续费模式： 1：固定值； 2：百分比"},
						{"TFR","TradeFeeRate","Double","交易手续费率"},
						{"DFM","DeliveryFeeMode","Double","交收手续费模式： 1：固定值； 2：百分比"},
						
						{"DFR","DeliveryFeeRate","Double","交收手续费率"},
						{"DMM","DeliveryMarginMode","Integer","交收保证金模式： 1：固定值； 2：百分比"},
						{"DMR","DeliveryMargin","Double","交收保证金率"},
						
						{"PTS","PayTimes","Integer","付款次数，只能为2、3"},
						{"OAB","OrderAuthBuy","Integer","买挂牌是否需要审核： 0：需要； 1：不需要"},
						{"OAS","OrderAuthSell","Integer","卖挂牌是否需要审核： 0：需要； 1：不需要"},
						
						{"PAS","PayBillAuthSell","Integer","卖仓单是否需要审核： 0：需要； 1：不需要"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================8. 系统信息查询 =========================================*/

	}

	public static void getListRequestJIngJia2() {
		/**===============================8 商品详情查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityInfoQueryRequestVO",//全名1
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"C","commodityId","String","商品代码"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityInfoQueryResponseVO",//全名3
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TRD","TotalRecord","Integer","总记录数"}
						
						},
				new String[][]{//输出查询5
						{"I","Code","String","标的码"},
						{"C","CommodityCode","String","商品码"},
						{"SP","StartPrice","Double","起报价"},
						
						{"AP","AlertPrice","Double","报警价"},
						{"AD","AddPrice","Double","加价幅度"},
						{"Q","Qty","Integer","交易总数"},
						
						{"IQ","MinQty","Integer","最小报单数量"},
						{"XQ","MaxQty","Integer","最大报单数量"},
						{"MAR","Margin","Double","交易保证金"},
						
						{"FEE","Fee","Double","手续费"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================8 商品详情查询 =========================================*/

	}

	public static void getListRequestJIngJia() {
		/**===============================9 下单操作 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"I","Code","String","标的号"},
						{"C","CommodityCode","String","商品代码"},
						{"M","Module","Integer","交易板块"},
						{"P","Price","Double","下单价格"},
						{"Q","Qty","Integer","下单数量"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}
						
						},
				new String[][]{//输出查询5

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================9 下单操作 =========================================*/
		
		/**===============================10 交易板块查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TradePlateQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TradePlateQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TRD","TotalRecord","Integer","总记录数"}
						
						},
				new String[][]{//输出查询5
						{"N","TradeModuleName","String","交易版块名称"},
						{"M","TradeMode","Integer","交易模式"},
						{"S","TradeStatus","Integer","交易状态"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================10 交易板块查询 =========================================*/
		
		/**===============================11 自选商品添加/删除 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityOperateRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"I","Code","String","标的号"},
						{"C","CommodityCode","String","商品码"},
						{"M","Module","Integer","交易版块"},
						{"S","Status","Integer","状态"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityOperateResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}

						},
				new String[][]{//输出查询5
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================11 自选商品添加/删除 =========================================*/
		
		/**===============================13 个人信息查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.UserInfoQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"}
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.UserInfoQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}
						
						},
				new String[][]{//输出查询5
						{"BF","BalanceFunds","Double","资金余额"},
						{"UF","UsableFunds","Double","可用资金"},
						{"FF","FrozenFunds","Double","冻结资金"},
						{"OP","Option","Boolean","是否有挂单权限"},
						{"NP","NewOption","Boolean","是否有重新下单权限"},
						{"AD","Address","String","地址"},
						{"PH","Phone","String","电话"},
						{"IF","PersonInfo","String","个人简介"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================13 个人信息查询 =========================================*/
		
		/**===============================14 自选商品查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"M","Module","Integer","交易板块"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SelectedCommodityQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TRD","TotalRecord","Integer","总记录数"},
						{"M","Module","Integer","交易板块"},
						
						
						},
				new String[][]{//输出查询5
						{"I","Code","String","标的号"},
						{"C","CommodityCode","String","商品码"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================14 自选商品查询 =========================================*/
		
		/**===============================15 消息提醒（委托状态变动、撤单、部分撤单） =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.VendueMessageRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"T","LastTime","Date","上次查询时间"}

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.VendueMessageResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},

						{"TRD","TotalRecord","Integer","总记录数"},
						{"TI","timestamp","Date","本次查询时间"}
						
						},
				new String[][]{//输出查询5
						{"I","ModuleId","Integer","交易板块ID"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================15 消息提醒（委托状态变动、撤单、部分撤单） =========================================*/
		
		/**===============================16 挂单功能 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityAddRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						
						{"C","CommdoityId","String","商品代码"},
						{"COD","CommodityCode","String","商品码"},
						{"AA","AuctionAlgr","String","流拍算法"},
						
						{"AQ","AuctionQty","String","流拍量"},
						{"SP","StartPrice","Double","起拍价"},
						{"AP","AlertPrice","Double","报警价"},
						
						{"Q","Qty","Integer","数量"},
						{"UN","TradeUnit","Integer","交易数量单位"},
						{"IA","MinAmount","Integer","最小报单数量"},
						
						{"XA","MaxAmount","Integer","最大报单数量"},
						{"AD","AddPrice","Double","加价幅度"},
						
						{"BPI","BreedPropertyId","String","品种属性代码"},
						{"PID","PropertyId","String","商品属性代码"},
						{"PNM","PropertyName","String","商品属性名称"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityAddResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}
						
						},
				new String[][]{//输出查询5

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================16 挂单功能 =========================================*/
		
		/**===============================17 挂单可选商品查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.AddCommodityQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.AddCommodityQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}
						
						
						},
				new String[][]{//输出查询5
						{"C","CommodityCode","String","商品代码"},
						{"CN","CommodityName","String","商品名称"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================17 挂单可选商品查询 =========================================*/
		
		/**===============================18 挂单商品交收属性查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityPropQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						
						{"C","CommodityCode","String","商品代码"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CommodityPropQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						
						{"AP","AlertPrice","Double","默认报警价"},
						{"AQ","AlertQty","Integer","默认商品数量"},
						{"TU","TradeUnit","Integer","默认交易数量单位"},
						
						{"IA","MinAmount","Integer","默认最小报单数量"},
						{"XA","MaxAmount","Integer","默认最大报单数量"},
						{"TRD","TotalRecord","Integer","总记录数"},

						},
				new String[][]{//输出查询5
						{"BPI","BreedPropertyId","String","品种属性代码"},
						{"BPN","BreedPropertyName","String","品种属性名称"},
						
						{"CPS","CommodityPropertyList","String","品种属性名称"},
						{"CPI","CommodityPropertyId","String","属性代码"},
						{"CPN","CommodityPropertyName","String","属性名称"}
						

						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================18 挂单商品交收属性查询 =========================================*/
		
		/**===============================19 当前委托查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrdersQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"M","Module","Integer","交易板块"},
						{"TI","LastTime","Date","上次查询时间"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrdersQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"NEW","NewOrder","Boolean","是否有新委托"}
						
						},
				new String[][]{//输出查询5
						{"O","OrderId","String","委托号"},
						{"I","CmdCode","String","标的号"},
						{"P","Price","Double","我的报价"},
						
						{"CP","CurPrice","Double","当前报价"},
						{"Q","Qty","Integer","数量"},
						{"ST","SubmitTime","Date","提交时间"},
						
						{"MT","ModifyTime","Date","修改时间"},
						{"UQ","ValidQty","Integer","有效数量"},
						{"FM","FrozenMargin","Double","冻结保证金"},
						
						{"FF","FrozenFee","Double","冻结手续费"},
						{"RM","ReleaseMargin","Double","释放保证金"},
						{"RF","ReleaseFee","Double","释放手续费"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================19 当前委托查询 =========================================*/
		
		/**===============================20 我的挂单查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyCmdQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						
						{"ST","StartTime","Date","开始时间"},
						{"ET","EndTime","Date","结束时间"},
						{"M","Module","Integer","交易板块"},
						{"PN","PageNo","Integer","页面大小"},
						{"PS","PageSzie","Integer","页面大小"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyCmdQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TRD","TotalRecord","Integer","总记录大小"}
						
						
						
						},
				new String[][]{//输出查询5
						{"I","CmdCode","String","标的号"},
						{"C","CommodityCode","String","商品码"},
						{"P","Price","Double","起报价"},
						
						{"Q","Qty","Integer","数量"},
						{"ST","StartQty","Integer","最小报单量"},
						{"MT","MaxQty","Integer","最大报单量"},
						
						{"AP","AlertPrice","Double","报警价"},
						{"TU","TradeUnit","Integer","交易单位数量"},
						{"AD","AddPrice","Double","加价幅度"},
						
						{"AA","AuctionAlgr","String","流拍算法"},
						{"AQ","AuctionQty","Double","流拍量"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================20 我的挂单查询 =========================================*/
		
		/**===============================21 我的成交查询 =========================================*/
		//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyTradeQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"ST","StartTime","Date","开始时间"},
						{"ET","EndTime","Date","结束时间"},
						{"M","Module","Integer","交易板块"},
						
						{"PN","PageNo","Integer","页面大小"},
						{"PS","PageSize","Integer","页面大小"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.MyTradeQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TRD","TotalRecord","Integer","总记录大小"}
						
						},
				new String[][]{//输出查询5
						{"C","ContractNo","String","合同号"},
						{"I","CmdCode","String","标的号"},
						{"P","Price","Double","成交价"},
						
						{"Q","TradeQty","Integer","成交量"},
						{"M","Margin","Double","交易保证金"},
						{"F","Fee","Double","手续费"},
						
						{"T","TradeTime","Date","成交时间"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		/**===============================21 我的成交查询 =========================================*/

		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * E现货的手机协议
	 * </ul>
	 */
	public static void getListRequest() {
//		List<List<Object>> lreq = new ArrayList<List<Object>>();
		//ls2.add(new String[]{"U","UserID","String","用户id"});
		//ls2.add(new String[]{"SI","SessionID","Long","用户会话id"});
		//{"","","",""},
		//String Double Integer Date
		/*List<String> linfo = Arrays.asList(new String[]{"update by wangzg 2016年8月3日14:29:29"});
		
		String qualifiedName19 = "gnnt.MEBS.MobileServer.vo.micro.trade.FirmInfoRequestVO";
		String[][] sArrArrRequest19 = new String[][]{
				{"U","UserID","String","用户id"},
				{"SI","SessionID","Long","用户会话id"},
				};
		List<String[]> ls = Arrays.asList(sArrArrRequest19);*/
		
		
		
		/**===============================19. 交易商信息=========================================*/
		//request添加
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.FirmInfoRequestVO",//全名
				new String[][]{//输入信息
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date
		//response添加
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.FirmInfoResponseVO",//全名
				new String[][]{//输出信息
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						{"TI","TraderID","String","交易员ID"},
						{"UI","UserID","String","用户名"},
						{"TN","TraderName","String","交易员名称"},
						
						{"FI","FirmID","String","交易商ID"},
						{"FN","FirmName","String","交易商名称"},
						{"FT","FirmType","String","交易商类型"},
						
						{"AD","Address","String","交易地址"},
						{"CM","ContactMan","String","联系人"},
						{"PH","Phone","String","联系人电话"}
						},
				new String[][]{//输出查询
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================19. 交易商信息=========================================*/
		
		/**===============================18. 议价委托详情查询=========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderInfoQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						{"CHF","CheckHistoryFlag","String","当前历史查询标志     0：当前记录;  1: 历史记录"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderInfoQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						{"CHF","CheckHistoryFlag","String","当前历史查询标志     0：当前记录;  1: 历史记录"},
						
						{"SOI","AsOrderId","String","议价委托单号"},
						{"STA","Status","String","委托议价状态：0：等待答复 1：委托方接受 2：委托方拒绝 3：议价方撤单 4：系统自动撤单 5: 管理员撤单"},
						
						{"PRI","Price","Double","价格"},
						{"QTY","Qty","Integer","议价数量"},
						{"U","Unit","String","商品单位"},
						
						{"WHI","WarehouseId","String","交收仓库"},
						{"CT","CreateTime","Date","提出时间"},
						
						{"RT","ReplyTime","Date","答复时间"},
						{"RM","ReplyMessage","String","答复信息"},
						{"DMB","BuyerPerformMargin","Double","买方履约保证金"},
						
						{"DMS","SellerPerformMargin","Double","卖方履约保证金"},
						{"DDT","DeliveryDateType","String","交收日类型：0：指定期限；1：指定日期"},
						{"DPH","DeliveryTime","Integer","交货期限（单位：小时）限制条件显示，交收日类型：（0）指定期限"},
						{"DD","DeliveryDate","Date","交货日期限制条件显示，交收日类型：（1）指定日期"},
						
						{"RMK","Remark","String","附加条款"},
						{"SFI","PerformFirmID","String","议价委托交易商ID"},
						{"OFI","OrderFirmID","String","委托交易商ID"},
						
						{"ORI","OrderID","String","委托单号"}
						},
				new String[][]{//输出查询5
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================18. 议价委托详情查询=========================================*/
		
		/**===============================17. 议价委托查询=========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						{"CHF","CheckHistoryFlag","String","当前历史查询标志     0：当前记录;  1: 历史记录"},
						
						{"UT","LastTimestamp","Long","最大更新时间,微妙表示"},
						{"PN","PageNo","Integer","当前页码"},
						{"PS","PageSize","Integer","每页显示条数"},
						{"T","AsOrderType","String","交易商委托议价的类型标志：1：发起的议价 2：接受的议价"},
						
						{"STA","Status","String","委托议价状态：0：等待答复 1：委托方接受 2：委托方拒绝 3：议价方撤单 4：系统自动撤单 5: 管理员撤单"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.SubOrderQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TTLREC","TotalRecord","Integer","总记录数"},
						{"PN","PageNo","Integer","当前页码"},
						{"PS","PageSize","Integer","每页显示条数"}

						},
				new String[][]{//输出查询5
						{"SI","AsOrderId","String","议价委托单号"},
						{"ORT","OrderTitle","String","委托标题"},
						{"PRI","Price","Double","单价"},
						
						{"QTY","Qty","Integer","数量"},
						{"U","Unit","String","商品单位"},
						{"T","Type","String","交收类型:0: 协议交收1：自主交收"},
						
						{"STA","Status","String","委托议价状态：0：等待答复 1：委托方接受 2：委托方拒绝 3：议价方撤单 4：系统自动撤单 5: 管理员撤单"},
						{"SFI","PerformFirmID","String","议价委托交易商ID"},
						{"CT","CreateTime","Date","议价提出时间"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================17. 议价委托查询=========================================*/
		
		/**===============================16. 摘牌=========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.PickOffOrderRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"ORI","OrderID","String","委托单号"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.PickOffOrderResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}
						
						},
				new String[][]{//输出查询5
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================16. 摘牌=========================================*/
		
		/**===============================15. 撤销委托=========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderCancelRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						{"ORI","OrderID","String","委托单号"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderCancelResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"}
						},
				new String[][]{//输出查询5
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================15. 撤销委托=========================================*/
		

		/**===============================33. 仓单详细信息 =========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.BillDetailQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"N","BillNo","String","仓单号"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.BillDetailQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"B","BreedId","String","分类代码"},
						{"C","CommodityId","String","品名代码"},
						{"T","CommodityTitle","String","商品标题"},
						
						{"Q","Qty","Integer","数量"},
						{"P","Price","Double","价格"},
						{"S","StartTradeQty","Integer","起定量"},
						
						{"U","TradeUnit","String","交易单位"},
						{"W","WarehouseId","String","交收仓库代码"},
						
						},
				new String[][]{//输出查询5
						{"PT","PropertyType","String","属性类型 （基本属性 质量指标）"},
						{"PN","PropertyName","String","品种属性名称"},
						{"PV","PropertyValue","String","品名属性值"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================33. 仓单详细信息=========================================*/
		
		/**===============================31. 模板详情查询 =========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TemplateDetailQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"N","TemplateNo","String","模板ID"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.TemplateDetailQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"ORI","OrderID","String","委托单号"},
						{"ORT","OrderTitle","String","委托标题"},
						{"BN","BreedName","String","品种名称"},
						
						{"BCN","BreedCmdName","String","所属分类名称"},
						{"BS","BsFlag","Integer","买卖方向:  1: 买；2：卖"},
						{"T","TemplateType","String","模板类型  1系统模板 2自定义模板 3系统模板+自定义模板"},
						
						{"STA","Status","Integer","委托状态：0：未成交1：部分成交2：全部成交3：已下架11：待管理员审核"},
						{"PRI","Price","Double","单位价格"},
						{"QTY","Qty","Integer","商品数量"},
						
						{"TQ","TradeQty","Integer","已成交数量"},
						{"U","Unit","String","商品单位"},
						{"OT","OrderTime","Date","委托时间"},
						
						{"ET","EffectiveTime","Date","生效时间，为空显示“--”"},
						{"RMK","Remark","String","附加条款"},
						{"VH","ValidateHours","Integer","信息有效期（单位：小时）：-1：长期有效；其他值整数小时"},
						
						{"TF","TradeFlag","Integer","成交方式：1：直接成交；2：可议价成交；3：必须议价成交"},
						{"TPH","MarginDeadLine","String","保证金支付期限(小时)，限制条件显示,品种交易模式：（1）诚信保障金模式"},
						{"TMB","TradeMarginBuyer","String","买方诚信保障金限制条件显示,品种交易模式：（1）诚信保障金模式"},
						
						{"TMS","TradeMarginSeller","String","卖方诚信保障金限制条件显示,品种交易模式：（1）诚信保障金模式"},
						{"IPM","IsPayMargin","String","是否已支付履约保证金：  Y:是；N:否限制条件显示,品种交易模式：（1）诚信保障金模式"},
						//{"PF","PayFlag","Integer",">是否卖仓单：0：否；1：是"},
						
						{"STI","SellBillId","Integer","限制条件显示，是否卖仓单：（1）是"},
						{"OWI","OrderWithdrawId","Integer","撤单人限制条件显示，委托状态：（3）已下架"},
						{"OWT","OrderWithdrawType","Integer","撤单时间限制条件显示，委托状态：（3）已下架"},
						
						{"MTQ","MinTradeQty","Integer","最小交易数量"},
						{"TU","TradeUnit","String","交易单位"},
						{"DET","DeliveryType","String","交收地类型：1：指定仓库；2：指定交收地"},
						
						{"DWI","DeliveryWarehouseId","String","交收仓库号，为空显示“--” 限制条件显示，交收地类型：（1）指定仓库"},
						{"DEA","DeliveryAddress","String","交收地，为空显示“--” 限制条件显示，交收地类型：（2）指定交收地"},
						{"DMB","BuyerPerformMargin","Double","买方履约保证金"},
						
						{"DMS","SellerPerformMargin","Double","卖方履约保证金"},
						{"TY","SettleType","Integer","交收类型: 0: 协议交收； 1：自主交收"},
						{"PT","PayType","Integer","付款类型：0：先款后货；1：先货后款；2：无限制限制条件显示，交收类型：（1）自主交收"},
						
						{"DDT","DeliveryDateType","String","交收日类型：0：指定期限；1：指定日期"},
						{"DPH","DeliveryTime","Date","交货期限（单位：小时）限制条件显示，交收日类型：（0）指定期限"},
						{"DD","DeliveryDate","Date","交货日期限制条件显示，交收日类型：（1）指定日期"},
						
						
						},
				new String[][]{//输出查询5
						{"PT","PropertyType","String","属性类型 （基本属性 质量指标）"},
						{"PN","PropertyName","String","品种属性名称"},
						{"PV","PropertyValue","String","品名属性值"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================31. 模板详情查询 =========================================*/
		
		
		/**===============================14. 发布委托  =========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderSubmitRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"BS","BsFlag","Integer","买卖方向:  1: 买；2：卖"},
						{"PF","PayFlag","Integer",">是否卖仓单：0：否；1：是"},
						{"ORT","OrderTitle","String","委托标题"},
						
						{"CI","CommodityId","String","所属分类ID"},
						{"BI","BreedId","String","品种ID"},
						{"B","BillId","String","关联仓单ID"},
						
						{"T","PropertyType","String","属性类别 (基本属性、质量指标) "},
						{"P","PropertyId","String","品种属性代码"},
						{"N","PropertyName","String","商品属性代码/名称"},
						
						{"PRI","Price","Double","委托价格"},
						{"QTY","Qty","Integer","委托数量"},
						{"MTQ","MinTradeQty","Integer","最小交易数量"},
						
						{"TU","TradeUnit","String","交易单位"},
						{"TF","TradeFlag","Integer","成交方式：1：直接成交；2：可议价成交；3：必须议价成交"},
						{"VH","ValidateHours","Integer","信息有效期（单位：小时）：-1：长期有效；其他值整数小时"},
						
						{"MT","MarginType","Integer","履约保证金支付方式  1支付  2不支付 "},
						{"TY","SettleType","Integer","交收类型: 0: 协议交收； 1：自主交收"},
						{"PT","PropertyType","String","属性类型 （基本属性 质量指标）"},
						
						{"DET","DeliveryType","String","交收地类型：1：指定仓库；2：指定交收地"},
						{"DWI","DeliveryWarehouseId","String","交收仓库号."},
						{"DEA","DeliveryAddress","String","交收地"},
						
						{"DPH","DeliveryTime","Integer","交货期限（单位：小时）限制条件显示，交收日类型."},
						{"DD","DeliveryDate","Date","交货日期限制条件显示，交收日类型."},
						{"DMB","BuyerPerformMargin","Double","买方履约保证金"},
						
						{"DMS","SellerPerformMargin","Double","卖方履约保证金"},
						{"RMK","Remark","String","附加条款"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderSubmitResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						},
				new String[][]{//输出查询5
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================14. 发布委托 =========================================*/
		
		/**===============================13. 个人委托详情查询 =========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderInfoQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"ORI","OrderID","String","委托单号"}
						
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderInfoQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"ORI","OrderID","String","委托单号"},
						{"ORT","OrderTitle","String","委托标题"},//=============
						{"BN","BreedName","String","品种名称"},
						
						{"BCN","BreedCmdName","String","品名名称"},
						{"BS","BsFlag","Integer","买卖方向:  1: 买；2：卖"},
						{"STA","Status","String","委托状态：0：未成交1：部分成交2：全部成交3：已下架11：待管理员审核"},
						
						{"PRI","Price","Double","单位价格"},
						{"QTY","Qty","Integer","商品数量"},
						{"TQ","TradeQty","Integer","已成交数量"},
						
						{"U","Unit","String","商品单位"},
						{"OT","OrderTime","String","委托时间"},//=============
						{"ET","EffectiveTime","Date","生效时间，为空显示“--”"},
						
						{"RMK","Remark","String","附加条款"},
						{"VH","ValidateHours","Integer","信息有效期（单位：小时）：-1：长期有效；其他值整数小时"},
						{"TF","TradeFlag","Integer","成交方式：1：直接成交；2：可议价成交；3：必须议价成交"},
						
						{"TPH","MarginDeadLine","String","保证金支付期限(小时)，"},
						{"TMB","TradeMarginBuyer","String","买方诚信保障金"},
						{"TMS","TradeMarginSeller","String","卖方诚信保障金"},
						
						{"IPM","IsPayMargin","String","是否已支付履约保证金：  Y:是；N:否"},
						{"PF","PayFlag","Integer",">是否卖仓单：0：否；1：是"},
						
						{"STI","SellBillId","Integer","卖仓单号"},
						{"OWI","OrderWithdrawId","Integer","撤单人"},
						{"OWT","OrderWithdrawType","Integer","撤单时间"},
						
						{"MTQ","MinTradeQty","Integer","最小交易数量"},
						{"TU","TradeUnit","String","交易单位"},
						{"DET","DeliveryType","String","交收地类型：1：指定仓库；2：指定交收地"},
						
						{"DWI","DeliveryWarehouseId","String","交收仓库号，为空显示“--”"},
						{"DEA","DeliveryAddress","String","交收地，为空显示“--”"},
						{"DMB","BuyerPerformMargin","Double","买方履约保证金"},
						
						{"DMS","SellerPerformMargin","Double","卖方履约保证金"},
						{"TY","SettleType","Integer","交收类型: 0: 协议交收； 1：自主交收"},
						{"PT","PayType","Integer","付款类型：0：先款后货；1：先货后款；2：无限制限制条件显示，交收类型：（1）自主交收"},
						
						{"DDT","DeliveryDateType","String","交收日类型：0：指定期限；1：指定日期"},
						{"DPH","DeliveryTime","Date","交货期限（单位：小时）"},
						{"DD","DeliveryDate","Date","交货日期限制条件显示，交收日类型：（1）指定日期"}
						
						
						},
				new String[][]{//输出查询5
						{"PT","PropertyType","String","属性类型 （基本属性 质量指标）"},
						{"PN","PropertyName","String","品种属性名称"},
						{"PV","PropertyValue","String","品名属性值"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================13. 个人委托详情查询 =========================================*/

		/**===============================12. 个人委托查询 =========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"B","BreedId","String","品种代码"},
						{"C","CommodityId","String","品名代码"},
						{"X","MaxPrice","Double","最高价"},
						
						{"I","MinPrice","Double","最低价"},
						{"M","TradeMode","Integer","交易模式"},
						{"R","SortType","String","排序方式"},
						
						{"T","CommodityTitle","Integer","商品标题"},
						{"N","NewOrderId","String","最新委托单号"},
						{"S","Size","Integer","查询条数       大于零 查询大于最新委托号的N条数据  	小于零 查询小于最新委托号的N条数据"},
						
						{"BS","BsFlag","Integer","查询买卖委托标志：     1：买委托    2：卖委托	 3：所有委托"},
						{"STA","Status","String","委托状态：0：未成交 1：部分成交2：全部成交3：已下架11：待管理员审核"},
						
						{"BP","BreedProperty","String","品种属性代码"},
						{"CP","CommodityPropValue","String","商品属性值"},
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.OrderQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TTLREC","TotalRecord","Integer","总记录数"}
						},
				new String[][]{//输出查询5
						{"PID","PictureId","String","图片唯一标识"},
						{"ORI","OrderID","String","委托单号"},
						{"ORT","OrderTitle","String","委托标题"},
						
						{"BN","BreedName","String","品名"},
						{"TM","TradeMode","Integer"," 1: 诚信保障金模式； 2：保证金模式"},
						{"BS","BsFlag","Integer","买卖方向:  1: 买；2：卖"},
						
						{"STA","Status","Integer","委托状态：0：未成交    1：部分成交  2：全部成交   3：已下架  11：待管理员审核"},
						{"PRI","Price","Double","单位价格"},
						{"QTY","Qty","Integer","已成交数量"},
						
						{"TQ","TradeQty","Integer","已成交数量"},
						{"U","Unit","String","商品单位"},
						{"OT","OrderTime","Date","委托时间"},
						
						
						{"TY","SettleType","Integer","交收类型: 0: 协议交收； 1：自主交收"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================12. 个人委托查询 =========================================*/
		
		/**===============================11. 商品委托详情查询 =========================================*/
		//request添加p1
		/*lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderInfoQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"ORI","OrderID","String","委托单号"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		//String Double Integer Date Long
		//response添加p2
		/*lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderInfoQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"ORI","OrderID","String","委托单号"},
						{"ORT","OrderTitle","String","委托商品标题"},
						{"BN","BreedName","String","品种名称"},
						
						{"BCN","BreedCmdName","String","品名名称"},
						{"BS","BsFlag","Integer","买卖方向:  1: 买；2：卖"},
						{"PRI","Price","Double","单位价格"},
						
						{"QTY","Qty","Integer","商品数量"},
						{"TQ","TradeQty","Integer","已成交数量"},
						{"U","Unit","String","商品单位"},
						
						
						
						{"OT","OrderTime","Date","委托时间"},
						
						{"ET","EffectiveTime","Date","生效时间，为空显示“--”"},
						{"RMK","Remark","String","附加条款"},
						{"VH","ValidateHours","Integer","信息有效期（单位：小时）：-1：长期有效；其他值整数小时"},
						
						{"TF","TradeFlag","Integer","成交方式：1：直接成交；2：可议价成交；3：必须议价成交"},
						{"TPH","MarginDeadLine","String","保证金支付期限(小时)，"},
						{"TMB","TradeMarginBuyer","String","买方诚信保障金限"},
						
						{"TMS","TradeMarginSeller","String","卖方诚信保障金"},
						{"IPM","IsPayMargin","String","是否已支付履约保证金：  Y:是；N:否"},
						{"PF","PayFlag","Integer",">是否卖仓单：0：否；1：是"},
						
						{"STI","SellBillId","Integer","限制条件显示，是否卖仓单：（1）是"},
						{"OWI","OrderWithdrawId","Integer","撤单人"},
						{"OWT","OrderWithdrawType","Integer","撤单时间"},
						
						{"MTQ","MinTradeQty","Integer","最小交易数量"},
						{"TU","TradeUnit","String","交易单位"},
						{"DET","DeliveryType","String","交收地类型：1：指定仓库；2：指定交收地"},
						
						{"DWI","DeliveryWarehouseId","String","交收仓库号，为空显示“--” 库"},
						{"DEA","DeliveryAddress","String","交收地，为空显示“--” "},
						{"DMB","BuyerPerformMargin","Double","买方履约保证金"},
						
						{"DMS","SellerPerformMargin","Double","卖方履约保证金"},
						{"TY","SettleType","Integer","交收类型: 0: 协议交收； 1：自主交收"},
						{"PT","PayType","Integer","付款类型：0：先款后货；1：先货后款；2：无"},
						
						{"DDT","DeliveryDateType","String","交收日类型：0：指定期限；1：指定日期"},
						{"DPH","DeliveryTime","Date","交货期限（单位：小时）"},
						{"DD","DeliveryDate","Date","交货日期"},
						
						},
				new String[][]{//输出查询5
						{"PT","PropertyType","String","属性类型 （基本属性 质量指标）"},
						{"PN","PropertyName","String","品种属性名称"},
						{"PV","PropertyValue","String","品名属性值"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================11. 商品委托详情查询 =========================================*/

		/**===============================10. 商品委托查询 =========================================*/
		/*//request添加p1
		lreq.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderQueryRequestVO",//  <<--------  全名1  ---------
				new String[][]{//输入信息2
						{"U","UserID","String","用户id"},
						{"SI","SessionID","Long","用户会话id"},
						
						{"B","BreedId","String","品种代码"},
						{"C","CommodityId","String","品名代码"},
						{"X","MaxPrice","Double","最高价"},
						
						{"I","MinPrice","Double","最低价"},
						{"M","TradeMode","Integer","交易模式  1保证金   2诚信保障金   3或为空 所有"},
						{"R","SortType","String","排序方式"},
						
						{"T","CommodityTitle","Integer","商品标题"},
						{"N","NewOrderId","String","最新委托单号"},
						{"S","Size","Integer","查询条数       大于零 查询大于最新委托号的N条数据  	小于零 查询小于最新委托号的N条数据"},
						
						{"BS","BsFlag","Integer","查询买卖委托标志：     1：买委托    2：卖委托	 3：所有委托"},
						
						{"BP","BreedPropertyId","String","品种属性代码"},
						{"CP","CommodityPropertyValue","String","商品属性值"}
						
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));
		//String Double Integer Date Long
		//response添加p2
		lres.add(Arrays.asList(new Object[]{
				"gnnt.MEBS.MobileServer.vo.micro.trade.CmdOrderQueryResponseVO",//  <<--------  全名3  ---------
				new String[][]{//输出信息4
						{"RETCODE","RETCODE","String","返回码  =0成功, 其他为失败，错误描述在MESSAGE 中"},
						{"MESSAGE","MESSAGE","String","返回的提示消息内容"},
						
						{"TTLREC","TotalRecord","Integer","总记录数"},
						{"S","Size","Integer","查询条数"}
						
						},
				new String[][]{//输出查询5
						{"PID","PictureId","String","图片唯一标识"},
						{"ORI","OrderID","String","委托单号"},
						{"ORT","OrderTitle","String","委托标题"},
						
						{"BN","BreedName","String","品名"},
						{"TM","TradeMode","Integer"," 1: 诚信保障金模式； 2：保证金模式"},
						{"BS","BsFlag","Integer","买卖方向:  1: 买；2：卖"},
						
						{"PRI","Price","Double","单位价格"},
						{"QTY","Qty","Integer","商品数量"},
						{"TQ","TradeQty","Integer","已成交数量"},
						{"U","Unit","String","商品单位"},
						
						{"TU","TradeUnit","String","交易单位"},
						{"SQ","StartOrderQty","Integer","起订数量"},
						{"OT","OrderTime","Date","委托时间"},
						{"TY","SettleType","Integer","交收类型: 0: 协议交收； 1：自主交收"},
						
						{"TR","TraderId","String","发布交易商ID"}
						},
				Arrays.asList(new String[]{"update by wangzg "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())})}));*/
		/**===============================10. 商品委托查询 =========================================*/

		
		return ;
	}

}
