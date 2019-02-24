
<?php

include_once("contion.php");
$mvid=$_GET["mvid"];
	
	$sql='SELECT * FROM  `banner` where id = '.$mvid;
	$rs2 = mysql_query($sql);
	






 
?>







<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传图片</title> 
</head> 
<body> 
<form method="post" action="" enctype="multipart/form-data"> 
  <input name="dopost" type="hidden" value="addsave" /> 
  
  
  <?php 

while($row = mysql_fetch_array($rs2)){
?>
  
<table width="98%" border="0" cellpadding="1" cellspacing="1" align="center" class="tbtitle" style="    background:#dbe4cd;"> 
    <tr> 
        <td height="30" colspan="9" bgcolor="#EDF9D5">上传图片</td> 
    </tr> 
    <tr bgcolor="#FDFEE9" height="26"> 
        <td colspan="7" align="left"> 
 
                <table width="100%" border="0" cellpadding="1" cellspacing="1">                
                    <tr>
                      <td height="31" align="right" bgcolor="#F7FFFF">&nbsp;</td>
                      <td height="31" colspan="2" bgcolor="#F7FFFF">&nbsp;</td>
                    </tr>
                    <tr> 
                        <td width="129" height="31" align="right" bgcolor="#F7FFFF">标题</td> 
                        <input type="hidden" value="<?php echo ($row["id"])?>" />
                        <td width="882" height="31" colspan="2" bgcolor="#F7FFFF"><input name="ads_title" value="<?php echo ($row["ads_title"])?>" type="text" id="ads_title" class="company_manage_form_label" style="width:250px;height:16px;margin-top:5px;margin-left:10px;" /></td> 
                    </tr> 
                           
                    <tr>
                       <td width="129" height="31" align="right" bgcolor="#F7FFFF">主演</td> 
                     <td width="882" height="31" colspan="2" bgcolor="#F7FFFF"><input name="ads_zhuyan" value="<?php echo ($row["ads_zhuyan"])?>" type="text" id="ads_zhuyan" class="company_manage_form_label" style="width:250px;height:16px;margin-top:5px;margin-left:10px;" /></td> 
                    </tr>
                    <tr> 
                        <td width="129" height="31" align="right" bgcolor="#F9FCEF">简介</td> 
                        <td height="31" colspan="2" bgcolor="#F9FCEF"><textarea id="ads_des" name="ads_des"  class="company_manage_form_label" style="margin-top:5px;margin-left:10px;height:70px;width:255px;" ><?php echo ($row["ads_des"])?></textarea></td> 
                    </tr> 
                    <tr> 
                        <td width="129" height="31" align="right" bgcolor="#F7FFFF">图片</td> 
                        <td width="882" height="31" colspan="2" bgcolor="#F7FFFF"><input name="newimg" value="<?php echo ($row["ads_pic"])?>" type="file" class="company_manage_form_label" style="width:350px;height:20px;margin-top:5px;margin-left:10px;" /></td> 
                    </tr>  
                     <tr> 
                        <td width="129" height="31" align="right" bgcolor="#F9FCEF">视频地址</td> 
                       <td height="31" colspan="2" bgcolor="#F9FCEF"><input type="text" name="ads_url" value="<?php echo ($row["ads_url"])?>" class="company_manage_form_label" style="margin-top:5px;margin-left:10px;height:16px;width:255px;" />如（http://lipichang.com）</td> 
                    </tr>                                     
                    <tr> 
                        <td width="129" height="31" align="right" bgcolor="#F7FFFF">热度</td> 
                        <td width="882" height="31" colspan="2" bgcolor="#F7FFFF"> &nbsp;
                          <label>
                          <input type="text" name="redu" value="<?php echo ($row["states"])?>" id="redu" value="956" />
                        </label>
                        </td>  
                    </tr> 
                      <tr> 
                        <td width="129" height="31" align="right" bgcolor="#F7FFFF">排序</td> 
                        <td width="882" height="31" colspan="2" bgcolor="#F7FFFF"><input name="sort" type="text" id="sort" value="<?php echo ($row["sort"])?>" class="company_manage_form_label" style="width:250px;height:16px;margin-top:5px;margin-left:10px;" /></td> 
                    </tr> 
                     
                     
                    <tr> 
                        <td height="28" align="right" valign="top" bgcolor="#F9FCEF">&nbsp;</td> 
                        <td height="30" colspan="2" bgcolor="#F9FCEF"><input type="submit" value="提交" class="button01" /> <input type="button" onclick="history.go(-1)" value="返回" class="button01" /></td> 
                    </tr> 
                </table> 
      </td> 
    </tr> 
</table> <?php 
  }
  ?>
  
    <?php 
mysql_close();
?>
</form> 


</body> 
</html> 