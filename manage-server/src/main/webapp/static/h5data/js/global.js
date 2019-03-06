function Hs(){};//定义主函数
Hs.ajaxDataParam={};
Hs.error=function(e){
    $(".container").css({"display":"none"});
    $("html").css({"width":"100%","height":"100%"});
    $("body").css({"width":"100%","height":"100%"});
    $("body").html('<div style="width:100%;height:100%;background:#fff;text-align:center;position:fixed;top:0;left:0"><img style="display:block;width:40%;height:auto;margin:55% auto 0 auto;" src="../images/error/errorImg.png" /><p style="font-size:.9875rem;font-weight:bold;color:#3f3f3f;margin-top:1.2rem;">网络竟然崩溃了</p><p style="font-size:.8125rem;color: #acacac;margin-top:.8rem">别紧张，请重新打开</p></div>');
    console.log(e);
}
var platform="";//手机平台
var u = navigator.userAgent;
if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) {//安卓
  platform = "Android-WebView";
} else if (u.indexOf('iPhone') > -1) {//苹果
  platform = "iOS-WebView";
} 
//获取地址栏参数
function getParam(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
//header中需要传的参数
var appVersion = getParam('appVersion');
var header = {
  'userId':getParam('userId'),
  'token':getParam('token'),
  'appVersion':appVersion,
  'platform':platform
}
// alert(JSON.stringify(header))
/*
*
*ajax 封装方法
* 
 */
 var hsUrl = '';//本地模拟http://39.106.19.96:8080
// var hsUrl ='http://test.imhuasheng.com';//前端测试服务器http://60.205.94.36:48080
//var hsUrl = location.origin;//获取域名
Hs.getAjaxWithAsync = function (url, successMethod, data,dataType, methodType,beforeSendMethod) {
  var datatypesend = data;
  if (methodType=="post"|methodType=="POST"){
      datatypesend =JSON.stringify(data);
  };
    $.ajax({
        url: hsUrl+url,
        cache: false,
        dataType: dataType,
        type: methodType,
        headers:header,
        async: false,
        data: datatypesend,
        contentType: "application/json;charset=utf-8",
        timeout: 600000,
        beforeSend:function(){
          //loading.png
          beforeSendMethod();
        },
        success: function(data) {
          if(data.message.error_code=='200'){
              successMethod(data.data);
          }else if(data.message.error_code == "-10201" || data.message.error_code == "-10202" || data.message.error_code == "-10205"){

            alert(data.message.error_msg);
            if(appVersion=="2.0"||appVersion=="2.1"||appVersion=="2.1.1"||appVersion=="3.0"||appVersion=="3.1"||appVersion=="3.2"||appVersion=="3.3"){
              window.location="hs://1003";
            }
            
          }else{
            alert(data.message.error_msg);
          }
            
        },
        error:function(e){
            Hs.error(e);
        } 
    });
};

/*货币转换函数*/
function formatMoney(number, places, symbol, thousand, decimal) {
        number = number || 0;
        places = !isNaN(places = Math.abs(places)) ? places : 2;
        symbol = symbol !== undefined ? symbol : "";
        thousand = thousand || ",";
        decimal = decimal || ".";
        var negative = number < 0 ? "-" : "",
            i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
            j = (j = i.length) > 3 ? j % 3 : 0;
        return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
    }
function setValue(param){
	var paramTime;
	if(param ==""||param==null||param=="undefined"){
		paramTime = "暂无时间";
		return paramTime;
	}else{
		return param;
	}
}
/*调用方法
formatMoney(54321); // $54,321
formatMoney(12345, 0, "£ "); // £ 12,345
formatMoney(12345, 2, "£ "); // £ 12,345.00
formatMoney(12345.232, 2, "£ "); // £ 12,345.23
*/


//文档高度
function getDocumentTop() {
    var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
    if (document.body) {
        bodyScrollTop = document.body.scrollTop;
    }
    if (document.documentElement) {
        documentScrollTop = document.documentElement.scrollTop;
    }
    scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;    return scrollTop;
}
//可视窗口高度
function getWindowHeight() {
    var windowHeight = 0;    if (document.compatMode == "CSS1Compat") {
        windowHeight = document.documentElement.clientHeight;
    } else {
        windowHeight = document.body.clientHeight;
    }
    return windowHeight;
}
//滚动条滚动高度
function getScrollHeight() {
    var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
    if (document.body) {
        bodyScrollHeight = document.body.scrollHeight;
    }
    if (document.documentElement) {
        documentScrollHeight = document.documentElement.scrollHeight;
    }
    scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;    return scrollHeight;
}