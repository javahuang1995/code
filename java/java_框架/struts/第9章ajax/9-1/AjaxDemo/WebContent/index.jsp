<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sx:head/>
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
	 //得到name的值
	 var name=document.getElementById("name").value;
	 //得到password的值
	 var password=document.getElementById("password").value;
	 //要访问的uri
	 var uri="http://localhost:8080/AjaxDemo/login.action?name="+name+"&password="+password;
	//var uri="http://localhost:8080/AjaxDemo/login.action?name=1&password=1";
	//访问open
     XHR.open("GET",uri,true); 
	//设置事件触发器
     XHR.onreadystatechange = resultHander; 
	//发送请求
     XHR.send(null); 
  } 
}
 function resultHander(){
	 //检查状态
   if (XHR.readyState == 4 && XHR.status == 200){ 
	  //显示提示框
      alert(XHR.responseText);
    }
 } 
</script> 
</head>
<body>
	<center>
		Name: <input type="text" id="name" /><br />
		password: <input type="password" id="password" /><br /> 
		<!-- 单击触发ajax -->
		<input type="button" value="ok" onclick="sendRequest();" />
	
	</center>
</body>
</html>
