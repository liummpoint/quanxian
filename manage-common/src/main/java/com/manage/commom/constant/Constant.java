package com.manage.commom.constant;

/**
 * Created by Administrator on 2017/3/6 0006.
 */
public class Constant {
    public static final int REDIS_START = 0;
    public static final int REDIS_END = 1;
    public static final int REDIS_LREM_COUNT = 1;
	//返回状态
	public static final int RETURN_STATUS_SUCCESS=0;




    // 订单状态
    public static final int ORDER_STATUS_SUCCESS = 0;
    public static final int ORDER_STATUS_INIT = 1;
    public static final int ORDER_STATUS_HANDING = 2;
    public static final int ORDER_STATUS_FAIL = 3;

    // 结果CODEsuccess码
    public static final String CODE_SUCCESS = "000000";


    //渠道，0:宝付1:连连2：闪信 3:掌上汇通',
    public static final int BAOFOO = 0;
    public static final int LIANLIAN = 1;
    public static final int SHANXIN = 2;
    public static final int PAYPALM = 3;

    // 闪信notify result
    public static final String SHANXIN_SUCCESS = "SUCCESS";
    public static final String SHANXIN_FAIL = "FAIL";
    public static final String ID_NAME_ERROR = "9999";
    
    public static final String	BLUE_0	=	"0"	; //	提交成功
    public static final String	BLUE_101	=	"101"	; //	无此用户
    public static final String	BLUE_102	=	"102"	; //	密码错
    public static final String	BLUE_103	=	"103"	; //	提交过快（提交速度超过流速限制）
    public static final String	BLUE_104	=	"104"	; //	系统忙（因平台侧原因，暂时无法处理提交的短信）
    public static final String	BLUE_105	=	"105"	; //	敏感短信（短信内容包含敏感词）
    public static final String	BLUE_106	=	"106"	; //	消息长度错（>536或<=0）
    public static final String	BLUE_107	=	"107"	; //	包含错误的手机号码
    public static final String	BLUE_108	=	"108"	; //	手机号码个数错（群发>50000或<=0）
    public static final String	BLUE_109	=	"109"	; //	无发送额度（该用户可用短信数已使用完）
    public static final String	BLUE_110	=	"110"	; //	不在发送时间内
    public static final String	BLUE_113	=	"113"	; //	扩展码格式错（非数字或者长度不对）
    public static final String	BLUE_114	=	"114"	; //	可用参数组个数错误（小于最小设定值或者大于1000）;变量参数组大于20个
    public static final String	BLUE_116	=	"116"	; //	签名不合法或未带签名（用户必须带签名的前提下）
    public static final String	BLUE_117	=	"117"	; //	IP地址认证错,请求调用的IP地址不是系统登记的IP地址
    public static final String	BLUE_118	=	"118"	; //	用户没有相应的发送权限（账号被禁止发送）
    public static final String	BLUE_119	=	"119"	; //	用户已过期
    public static final String	BLUE_120	=	"120"	; //	违反防盗用策略(日发送限制)
    public static final String	BLUE_123	=	"123"	; //	发送类型错误
    public static final String	BLUE_124	=	"124"	; //	白模板匹配错误
    public static final String	BLUE_125	=	"125"	; //	匹配驳回模板，提交失败
    public static final String	BLUE_127	=	"127"	; //	定时发送时间格式错误
    public static final String	BLUE_128	=	"128"	; //	内容编码失败
    public static final String	BLUE_129	=	"129"	; //	JSON格式错误
    public static final String	BLUE_130	=	"130"	; //	请求参数错误（缺少必填参数）
    
}
