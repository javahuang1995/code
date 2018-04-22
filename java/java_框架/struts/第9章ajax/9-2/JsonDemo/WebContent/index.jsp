<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*定义xmlhttprequest变量*/
var XHR= false;
function CreateXHR(){
	 try{
		 	/*检查能否用activexobject*/
			XHR = new ActiveXObject("msxml2.XMLHTTP");
		}catch(e1){
			try{
				/*检查能否用activexobject*/
				XHR = new ActiveXObject("microsoft.XMLHTTP");
			}catch(e2){
				try{
					/*检查能否用本地javascript对象*/
					XHR = new XMLHttpRequest();
				}catch(e3){
					//创建失败
					XHR = false;
				}
			}
		}
    }   
function sendRequest(){
 //创建xmlhttprequest对象
  CreateXHR();
  if(XHR){
		 //创建成功
		//访问open
	     XHR.open("GET",uri,true); 
		//设置事件触发器
	     XHR.onreadystatechange = resultHander; 
		//发送请求
	     XHR.send(null); 
  } 
} 
 function resultHander(){
   if (XHR.readyState == 4 && XHR.status == 200){ 
	   //得到json对象
	   var userObj = JSON.parse(XHR.responseText);
		var userStr = "<table border=0>";
       userStr += ('<tr><td><b>Name</b></td><td>' + userObj.USER.name + '</td></tr>');
       userStr += ('<tr><td><b>Age</b></td><td>' + userObj.USER.age + '</td></tr>');
       userStr += "</table>";
       //插入对象值
       document.getElementById('jsonDiv').innerHTML = userStr;
    }
 }
</script> 

</head>
<body>
<center>
<div id="jsonDiv"></div>
<input type="button" value="OK" onclick="sendRequest();"/>
</center>
</body>
</html>
