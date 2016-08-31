//联级菜单
//var two=[
//    ["中共黄石港区统战部","江北管理区","花湖街道办事处","黄石港片区管理委员会","环磁湖片区管理委员会","胜阳港片区管理委员会"],
//    ["江北管理区","江北社区"],
//    ["花湖街道办事处","天方社区","天虹社区","大码头社区","老虎头社区","锁前社区","花湖社区"],
//    ["黄石港片区管理委员会","青山湖社区","延安岭社区","黄石港社区","黄印村社区","大桥社区","新闸社区","纺织社区"],
//    ["环磁湖片区管理委员会","覆盆山社区","桂花湾社区","楠竹林社区","凤凰山社区","师院社区","沈家营社区","南岳社区","海观山社区","亚光社区","市建村社区","红旗桥社区","王家里社区"],
//    ["胜阳港片区管理委员会","钟楼社区","文化宫社区","南京路社区","胜阳港社区","天桥社区","湖滨路社区"]
//];
//function getTwo() {
//    var sltOne = document.getElementById("one");
//    var sltTwo = document.getElementById("two");
//    var oneTwo = two[sltOne.selectedIndex - 1];
//    for (var i = 0; i < oneTwo.length; i++) {
//        sltTwo[i + 1] = new Option(oneTwo[i], oneTwo[i]);
//    }
//}
/**
 * 动态删除select中的所有options：
 * 
 * document.getElementById("ddlResourceType").options.length=0;
 * 
 * 动态删除select中的某一项option：
 * 
 * document.getElementById("ddlResourceType").options.remove(indx);
 * 
 * 动态添加select中的项option:
 * 
 * document.getElementById("ddlResourceType").options.add(new
 * Option(text,value));
 * 
 * 其实用标准的DOM操作也可以，就是document.createElement，appendChild，removeChild之类的。
 * 
 */
/*------------------------------------Ajax代码实现联级菜单------------------------------------*/
function getTwo() {
	var value = document.getElementById("one").value;
	if (value != "中共黄石港区委统战部") {
		document.getElementById("two").options.length = 0; // 删除所有option
		document.getElementById("two").options.add(new Option("----请选择登录名----",
				"")); // 添加提示option
		// 获取xmlhttpRequest对象
		var xhr = createXmlHttpRequest();
		// 注册状态变化的回调函数
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200 || xhr.status == 304) {
					var data = xhr.responseText; // 得到的是json字符串
					// alert(data);
					var provinceJson = eval("(" + data + ")");
					// alert(provinceJson[1]);
					for ( var i = 0; i < provinceJson.length; i++) {
						document.getElementById("two")[i + 1] = new Option(
								provinceJson[i], provinceJson[i]);
					}
				}
			}
		}
		// 初始化xmlhttpRequest对象
		xhr.open("POST", "/Manser/servlet/AjaxServlet?time="
				+ new Date().getTime());
		// 设置请求消息头，告知服务器，发送的正文数据的类型。
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		// 发送数据

		xhr.send("ward=" + value);
	} else {
		document.getElementById("two").options.length = 0; // 删除所有option
		document.getElementById("two").options.add(new Option("中共黄石港区委统战部",
				"中共黄石港区委统战部")); // 添加提示option
	}
}

function createXmlHttpRequest() {
	var xmlHttp;
	try { // Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try { // Internet Explorer
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	return xmlHttp;
}
