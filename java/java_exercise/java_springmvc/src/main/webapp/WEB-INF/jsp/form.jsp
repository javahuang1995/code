<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
普通表单提交<br>
<form action="/send" method="post">
    name:<input type="text" name="name"><br>
    password:<input type="password" name="password"><br>
    submit:<input type="submit" value="提交">
</form>

<br>
ajax提交表单
<form  id="id_form" method="post">
    name:<input type="text" name="name"><br>
    password:<input type="password" name="password"><br>
    submit:<input type="button" value="提交" onclick="submit();">
    reset:<input type="reset" value="重置"></p>
</form>

  <script type="text/javascript">
        function submit() {
        	alert('kkk');
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/sendAjax" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
    </script>
</body>
</html>
