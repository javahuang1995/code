<?php 
header("Content-type: text/html; charset=utf-8"); 
include_once("contion.php");





 
$dopost=!empty($_POST['dopost'])?$_POST['dopost']:''; 
 
if($dopost=='addsave') 
{ 
 
    $sqlid="select max(id) as maxid from banner "; 
    $rs=mysql_query($sqlid) or die(mysql_error()); 
    $maxs=mysql_fetch_array($rs); 
    $names=$maxs['maxid']+1; 
    //查询当前最大的图片对应的id并且再它之上加1 为了让图片命名更加清晰 
         
    //判断是否有图片上传 并且进行处理 
    if(is_uploaded_file($_FILES['newimg']['tmp_name'])) 
    { 
	
	
	 
        if($_FILES['newimg']['size']>500000) 
        { 
            echo '图片大小不能大于500kb,<a href="javascript:history.go(-1);">返回</a>'; 
            exit();          
        } 
         		
        //设定图片名称 
        $pic_name='banner'.$names; 
       	
	
$path="uploadfile/"; //上传路径 

//echo $_FILES["filename"]["type"]; 

if(!file_exists($path)) 
{ 
//检查是否有该文件夹，如果没有就创建，并给予最高权限 
mkdir("$path", 0700); 
}//END IF 
//允许上传的文件格式 
$tp = array("image/gif","image/pjpeg","image/jpeg","image/png"); 
//检查上传文件是否在允许上传的类型 
if(!in_array($_FILES["newimg"]["type"],$tp)) 
{ 
echo "File Type is incorrect"; 
exit; 
}//END IF 
if($_FILES["newimg"]["name"]) 
{ 
$file1=$_FILES["newimg"]["name"]; 
//$file2 = $path.time().$file1; 
//文件名称 取原文件名
$wei=substr($file1,-4);


$file2 = $path.$pic_name.$wei; 
$flag=1; 
}//END IF 
if($flag) $result=move_uploaded_file($_FILES["newimg"]["tmp_name"],$file2); 
//特别注意这里传递给move_uploaded_file的第一个参数为上传到服务器上的临时文件 
         
        //记录图片的相对地址为了存储在数据库中以备调用 
        $banner=$file2; 
    } 
    else 
    { 
        echo '请选择图片，<a href="javascript:history.go(-1);">返回</a>'; 
        exit(); 
    } 
 
    //接收参数 
	$mvid=$_GET["mvid"];
	$dads=$_POST['ads_des'];
    $banners=addslashes($banner); 
	$ads_zhuyan=$_POST['ads_zhuyan'];
    $redu=$_POST['redu']; 
    $sort=$_POST['sort']; 
    $ads_url=addslashes($_POST['ads_url']); 
    $title=addslashes($_POST['ads_title']); 
    $dads_des=substr($dads,0,600); 
    $add_time=date("Y-m-d H:i:s"); 
    //存入数据库 
	
	$sql="UPDATE `banner` set ads_title='$title',ads_zhuyan='$ads_zhuyan',ads_des='$dads_des',ads_pic='$banners',add_time='$add_time' ,sort='$sort',states='$redu',ads_url='ads_url' where id = ".$mvid;
		$rs = mysql_query($sql);
		if($rs){echo "<script>alert('编辑成功');window.close();</script>";}
	else{echo "<script>alert('出错！');window.close();</script>";}
	
	
} 
else 
{ 
    include("ed_banner.php"); 
	
	
	
} 





?>