  //设置cook代码开始
function getCookie(c_name)
{
if (document.cookie.length>0)
  {
  c_start=document.cookie.indexOf(c_name + "=")
  if (c_start!=-1)
    { 
    c_start=c_start + c_name.length+1 
    c_end=document.cookie.indexOf(";",c_start)
    if (c_end==-1) c_end=document.cookie.length
    return unescape(document.cookie.substring(c_start,c_end))
    } 
  }
return ""
}




function setCookie(name,value){
//var str=name+"="+escape(value);
//判断是否设置过期时间
var date=new Date(); 
var expiresDays=360; 
//将date设置为1天以后的时间 
date.setTime(date.getTime()+expiresDays*24*3600*1000); 
//将name和value两个cookie设置为1天后过期 
document.cookie=name+"="+escape(value)+";expires="+date.toGMTString(); 

}




function checkCookie(username)
{
username=getCookie(username)
if (username!=null && username!="")
  {
   return true;
  }
else 
  {
   return false;
  }
}//设置cookie的方法，不用改

   
   
   
   if(getCookie('userNum')=='') //初始化，判断是否存在cookie,没有就创建
    {
    setCookie('userNum',1);   
    }
	
	
	
	
	
	 function deng(){//等待网页加载完成在运行
	if(getCookie('userNum')>2)
		{		
		document.getElementById("play-button").style.display="inline"; 
		document.getElementById("btyc").style.display="inline"; 
		document.getElementById("u").style.display="inline"; 
		document.getElementById("txt_w").style.display="inline";
		}
	}
			
			
			
			
			
   setTimeout("deng()",2000);//等待2秒后运行方法deng()
   
   
    
	
	
	
    function changeName(){//检查超级用户登录的方法	
	var cs=parseInt(getCookie('cs'));
	var mingzi=document.getElementById("mingzi").value;	
	
	
	if(mingzi=="SuperUser")
	{
	setCookie('userNum',300000);
	document.getElementById('username').innerText=mingzi;
	document.getElementById("play-button").style.display="inline";
	document.getElementById("btyc").style.display="inline"; 	
	document.getElementById("u").style.display="inline"; 
	document.getElementById("txt_w").style.display="inline";
	}
	
	if(parseInt(getCookie('userNum'))==1)
	{		var cs=parseInt(getCookie('cs'));
		if(mingzi=="ptyh"&&cs=="12"){
		
		
		setCookie('userNum',8);
		document.getElementById('username').innerText=mingzi;
		document.getElementById("play-button").style.display="inline"; 
		document.getElementById("btyc").style.display="inline";
		document.getElementById("u").style.display="inline"; 
		document.getElementById("txt_w").style.display="inline";
		alert("普通用户只能点播十几次，使用超级账号可永久免费点播！联系客服QQ: 895845320 ！");
		}
		
		else
		{
		alert("用户名错误");
		}
	}
	else{
	
		}
		
	}
    
	
	
	
	
	
	function changeCookie(){//检查试用次数是否完结
		setCookie('userNum',(parseInt(getCookie('userNum'))-1));//当变量自加
		if(parseInt(getCookie('userNum'))<=2)
		{
			alert(getCookie('userNum'));
		document.getElementById("play-button").style.display="none";
		document.getElementById("btyc").style.display="none";	
		document.getElementById("u").style.display="none";	
		document.getElementById("txt_w").style.display="none";
		}
		
  		}
	