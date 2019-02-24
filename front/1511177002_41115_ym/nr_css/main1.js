function getQueryStringArgs(){
    var qs = (location.search.length > 0 ? location.search.substring(1) : "");
    var args = {};
    var items = qs.split("&");
    var item = null,
        name = null,
        value = null;

    for (var i=0; i < items.length; i++){
        item = items[i].split("=");
        name = decodeURIComponent(item[0]);
        value = decodeURIComponent(item[1]);
        args[name] = value;
    }
    return args;
}

function checkkey(data) {
    var plays = new Array("thunder", "ed2k", "magnet", "bt", "http", "ftp");
    var str = data.split(':');
    if (contains(plays, str[0])) {
        return true;
    }

    return false;
}

function handleFileSelect(evt) {
    var files = evt.target.files; // FileList object
    // files is a FileList of File objects. List some properties.
    if (files.length) {
        var f = files[0];
        var reader = new FileReader();
        reader.onload = (function(theFile) {
            var rawData = reader.result;
            try {
                var dic = bdecode(rawData);
            } catch (e) {
                alert("error!")
                return;
            }
            var url = "magnet:?xt=urn:btih:" + CryptoJS.SHA1(CryptoJS.enc.Latin1.parse(bencode(dic["info"])));
            playUrl(url);
        });
        reader.readAsBinaryString(f);
    }
}

var playtrue=false;
var fulltrue=false;
function gshow(){
    if(!playtrue && !fulltrue){
	$("#gdiv").show();
    }
    else{
	$("#gdiv").hide();
    }
}

function ckplayer_status(str){
    switch(str){
        case '102':
            playtrue=true;
            gshow();
            break;
        case '103':
            playtrue=false;
            gshow();
            break;  
        case '104':
            fulltrue=false;
            gshow();
            break;  
        case '105':
            fulltrue=true;
            gshow();
            break;  
        default:
            break;
    }
}

if(window!=parent) parent.navigate(window.location.href);
function playUrl(a){return $("#u").val(a),$("#play-button").click();}
$(document).ready(function () {
    $("#u").keydown(function(event){
        event.keyCode==13 && $("#play-button").click();
    })
    $(function(){ 
        $(":input").focus(function(){ 
              $(this).addClass("focus"); 
              if($(this).val() ==this.defaultValue){   
                  $(this).val("");            
              }  
        }).blur(function(){ 
             $(this).removeClass("focus"); 
             if ($(this).val() == '') { 
                $(this).val(this.defaultValue); 
             } 
        }); 
    })
    $('#play-button').click(function () {

		$.ajax({ type: "GET",
				dataType: "jsonp",         
				data:{'url':encodeURIComponent($.trim($("#u").val()))},
				url: "http://vod.dychao.com/i/geturl",
				success: function (data) {
					if (data.msg != '') {
						var client = new ZeroClipboard( document.getElementById("copy") );
						client.on( "ready", function( readyEvent ) {
						    client.on( "aftercopy", function( event ) {
						        //event.target.style.display = "none";
						    });
						});
						$("#urltext").html($.trim($("#u").val()));
        					$("#urltext").hide();
						$("#url").attr("href", $.trim($("#u").val()));
						$("#mdialog").show();
            			$("#mdialog").alert();
						return;
					}

					/*
					for (key in data) {
						val = data[key];
						//$('.x-copyright').append(key+':'+val);
					}
					*/
					var flashvars={
					f:data.url,
					c:0,
					p:1,
					b:1
				};
				var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always'};
				CKobject.embedSWF('https://dychao.github.io/blog/ckplayer.swf','player','ckplayer_a1','970','540',flashvars, params);

				
				$("#mdialoghead").hide();
        		$("#urltext").hide();
        		$("#gbtn").hide();
				$("#mdialog").show();
            	$("#mdialog").alert();

				InterValObj = window.setInterval(SetRemainTime, 1000);
				var count = 0;
				function SetRemainTime() { 
					if (count > 10){
						$("#mdialog").hide();
						window.clearInterval(InterValObj);
					}
					count += 1;
				}
				
			}
			});
		
    });
	var query = getQueryStringArgs();
	if(query.url){
		playUrl(decodeURIComponent(query.url));
	}
    document.getElementById('files').addEventListener('change', handleFileSelect, false);
   ckplayer_status(str);

});
