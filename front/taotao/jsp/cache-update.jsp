<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缓存更新</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>

这里是缓存刷新:</br>
<button id="button1">刷新缓存</button>

<script type="text/javascript">
$(function(){
    $('#button1').on('click', function(){
        $.ajax({
            cache: false,
            type: "GET",
            url:"/cache/sync",
            async: true,
            success: function(data) {
                if(data.status == 200 ){
    				$.messager.alert('提示','刷新缓存成功!');
                }else if(data.status == 'fail'){
    				$.messager.alert('提示','刷新缓存失败!');
                }
            },
        });
    });
})

</script>
</body>
</html>