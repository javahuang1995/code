<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>我的云点播</title>
<meta name="keywords" content="云播,云点播,云播放"/>
<meta name="description" content="我的云点播是BT种子、视频下载链接在线快速播放的服务，支持多浏览器和安卓系统等移动设备。"/>
<link href="./yb/css/style.css" rel="stylesheet" type="text/css">
<script src="http://s0.qhimg.com/lib/jquery/190.js" type="text/javascript"></script>
<script src="http://s0.qhimg.com/v.360.cn/;scripts;js;swfobject/94d0b14f.js" type="text/javascript"></script>
<script src="http://vod.static.chunqi.net/static/js/function.js?v80609" type="text/javascript"></script>
<script src="./yb/function.js" type="text/javascript"></script>
<script type="text/javascript">
//下面两行是可以修改的部分
var right_str = '<a href="./">我的首页</a>';
var left_str = '我的云点播是BT种子、视频下载链接在线快速播放的服务，支持多浏览器和安卓系统等移动设备，谢谢这么久以来的支持。';
</script>
</head>
<?php
error_reporting(E_ALL & ~E_NOTICE );
$thispage = end(explode('/', $_SERVER['PHP_SELF']));
$u = trim(htmlspecialchars($_REQUEST['u']));
$isHash = preg_match('/^[0-9A-F]{40}$/i', strtoupper($u));
if($isHash){
	$u = 'magnet:?xt=urn:btih:'.strtoupper($u);
}
$u = !trim($u) || $u == '在此输入视频链接（thunder、ftp、http、ed2k、magnet、bt://）或上传BT种子' ? null : $u;
$iframeurl	= $u ? "http://www.dayunbo.com/play.php#!u=".$u : './yb/yundianbo.htm';
$ustr = $u ? $u : '在此输入视频链接（thunder、ftp、http、ed2k、magnet、bt://）或上传BT种子';
?>
<body>


<div style=" position:absolute;z-index:1000; top:0px; width:1440px; height:150px;  background-color:#95D6F1;"></div>







<div class="main">
	<div style="height:5px;" class="cls"></div>
	<div class="wrap">
		<div id="player" style="position:relative;z-index: 100;">
			<iframe scrolling="no" frameborder="0" align="center" name="apiwind" id="apiwind" rel="nofollow" border="0" style="background:#000; word-wrap: break-word; width: 960px; height: 680px" src="<?php echo $iframeurl;?>"></iframe>
		</div>
	</div>
	<div class="input_wrap">
		<form id="frompost" method="post" autocomplete="off" name="" action="./">
			<div class="txt_wrap"<?php if($u){?> style="width:640px;"<?php }?>>
				<input id="u" name="u" value="<?php echo $ustr;?>" type="text">
			</div>
			<a class="btn_bt" href="#" onclick="return false;" id="btupload">BT上传</a>
			<a class="btn_url" href="#" onclick="return false;" id="playnow" name="playnow">播放</a>
			<input type="submit" id="playfrm" name="playfrm" value="playfrm" style="cursor: pointer; display:none;"/>
		</form>
	</div>	
	<div style="height:10px;" class="cls"></div>
	
</div>
</body>
</html>