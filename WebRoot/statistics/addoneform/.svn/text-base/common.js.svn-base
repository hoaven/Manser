/**
 * 引入js后乱码原因：jsp和js编码方式不同 解决方法：右键属性--统一编码utf-8最宜
 */

function getGrid() {
	var ward = document.getElementById("ward").value;
	var community = document.getElementById("community").value;
	var grid = document.getElementById("grid").value;

	if (ward != "") {
		if (community != "" && grid == "") {
			getThere();
		}
		if (community == "") {
			getTwo();
		}
	}
}
// 得到社区
function getTwo() {
	document.getElementById("community").options.length = 0; // 删除所有option
	document.getElementById("grid").options.length = 0; // 删除所有option

	document.getElementById("community").options.add(new Option(
			"----请选择社区----", "")); // 添加提示option
	document.getElementById("grid").options
			.add(new Option("----请选择社区----", "")); // 添加提示option
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
					document.getElementById("community")[i + 1] = new Option(
							provinceJson[i], provinceJson[i]);
				}
			}
		}
	}
	// 初始化xmlhttpRequest对象
	xhr
			.open("POST", "/Manser/servlet/AjaxServlet?time="
					+ new Date().getTime());
	// 设置请求消息头，告知服务器，发送的正文数据的类型。
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// 发送数据
	var value = document.getElementById("ward").value;
	// alert("片区：" + value);
	xhr.send("ward=" + value);
}

// 得到网格
function getThere() {
	document.getElementById("grid").options.length = 0; // 删除所有option
	document.getElementById("grid").options
			.add(new Option("----请选择网格----", "")); // 添加提示option
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
					document.getElementById("grid")[i + 1] = new Option(
							provinceJson[i], provinceJson[i]);
				}
			}
		}
	}
	// 初始化xmlhttpRequest对象
	xhr
			.open("POST", "/Manser/servlet/AjaxServlet?time="
					+ new Date().getTime());
	// 设置请求消息头，告知服务器，发送的正文数据的类型。
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// 发送数据
	var value = document.getElementById("community").value;
	var pq = document.getElementById("ward").value;
	xhr.send("ward=" + value + "&pq=" + pq);
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
