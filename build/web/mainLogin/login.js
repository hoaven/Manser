//�����˵�
//var two=[
//    ["�й���ʯ����ͳս��","����������","�����ֵ����´�","��ʯ��Ƭ������ίԱ��","���ź�Ƭ������ίԱ��","ʤ����Ƭ������ίԱ��"],
//    ["����������","��������"],
//    ["�����ֵ����´�","�췽����","�������","����ͷ����","�ϻ�ͷ����","��ǰ����","��������"],
//    ["��ʯ��Ƭ������ίԱ��","��ɽ������","�Ӱ�������","��ʯ������","��ӡ������","��������","��բ����","��֯����"],
//    ["���ź�Ƭ������ίԱ��","����ɽ����","��������","���������","���ɽ����","ʦԺ����","���Ӫ����","��������","����ɽ����","�ǹ�����","�н�������","����������","����������"],
//    ["ʤ����Ƭ������ίԱ��","��¥����","�Ļ�������","�Ͼ�·����","ʤ��������","��������","����·����"]
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
 * ��̬ɾ��select�е�����options��
 * 
 * document.getElementById("ddlResourceType").options.length=0;
 * 
 * ��̬ɾ��select�е�ĳһ��option��
 * 
 * document.getElementById("ddlResourceType").options.remove(indx);
 * 
 * ��̬���select�е���option:
 * 
 * document.getElementById("ddlResourceType").options.add(new
 * Option(text,value));
 * 
 * ��ʵ�ñ�׼��DOM����Ҳ���ԣ�����document.createElement��appendChild��removeChild֮��ġ�
 * 
 */
/*------------------------------------Ajax����ʵ�������˵�------------------------------------*/
function getTwo() {
	var value = document.getElementById("one").value;
	if (value != "�й���ʯ����ίͳս��") {
		document.getElementById("two").options.length = 0; // ɾ������option
		document.getElementById("two").options.add(new Option("----��ѡ���¼��----",
				"")); // �����ʾoption
		// ��ȡxmlhttpRequest����
		var xhr = createXmlHttpRequest();
		// ע��״̬�仯�Ļص�����
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200 || xhr.status == 304) {
					var data = xhr.responseText; // �õ�����json�ַ���
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
		// ��ʼ��xmlhttpRequest����
		xhr.open("POST", "/Manser/servlet/AjaxServlet?time="
				+ new Date().getTime());
		// ����������Ϣͷ����֪�����������͵��������ݵ����͡�
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		// ��������

		xhr.send("ward=" + value);
	} else {
		document.getElementById("two").options.length = 0; // ɾ������option
		document.getElementById("two").options.add(new Option("�й���ʯ����ίͳս��",
				"�й���ʯ����ίͳս��")); // �����ʾoption
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
