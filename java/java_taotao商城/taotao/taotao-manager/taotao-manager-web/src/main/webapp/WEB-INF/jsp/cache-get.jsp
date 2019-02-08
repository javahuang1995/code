<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缓存获取测试</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
rest部件测试:开启redis服务器，数据库
</br>
<a href="http://www.taotao.com:8081/rest/content/list/89">测试大广告缓存</a></br>
<a href="http://www.taotao.com:8081/rest/itemcat/list">测试商品分类缓存</a></br>
<a href="http://www.taotao.com:8081/rest/item/info/536563">获取商品id为536563的商品信息</a></br>
<a href="http://www.taotao.com:8081/rest/item/desc/536563">获取商品id为536563的商品描述</a></br>
<a href="http://www.taotao.com:8081/rest/item/param/536563">获取商品id为536563的商品参数</a></br>
</body>
</html>