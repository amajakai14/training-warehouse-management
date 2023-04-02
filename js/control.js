/**
 * javascript for ebase6
 */
$(function(){

	messages = {}; //メッセージ配列
	msgidlist = [ 'TOPDBEXE','BTNSUBMIT','BTNSUBMIT','BTNSUBMIT','LBXMLKEY','LBXMLSELCT','ADDWORK','InsertData' ];

	//POST処理作成
	$.postJSON = function(url, data, callback) {
		$.post(url, data, callback, "json");
	};

	//初回稼働時
	$(document).ready(function(){
		//ラングコードを取得
		var lang = navigator.language || navigator.userLanguage;
		if(lang != "ja") lang="en";
		//メッセージ配列の生成
		$.postJSON("DQube",{actionID:'MSGGET01' ,ids:msgidlist , lang:lang}, function(jres){
			for(j=0;j<msgidlist.length;j++){
				id = msgidlist[j];
				messages[id] = jres.message[id];
			}
		});
	});

	//ALL menu close
	function menuClose() {
		$('#ebase6_shadow').css('display', 'none');
		$('#ebase6_menulist').css('display', 'none');
		$('#ebase6_popup').css('display', 'none');
	};

	//初期処理
	$('a[id=initialsetup]').click(function(){
		$.postJSON("DQube",{actionID:'INITILIZ'}, function(jres){
			alert(jres.result["result"]);
			return false;
		});
	});

	//メンテナンスボタンをクリック
	$('#ebase6_conmenu_mente').click(function(){
		if($('#ebase6_menulist').css('display') == "block"){
			menuClose();
		}else{
			$('#ebase6_menulist').css('display', 'block');
		}
	});

	//ポップアップクローズ
	$('#ebase6_popup_close').click(function(){
		$('#ebase6_popup').css('display', 'none');
		$('#ebase6_shadow').css('display', 'none');
	});

	/* NAVIGATION FRAME */
	var navPX = $("#ebase6_nav").offset().left + window.pageXOffset;
	var navPY = $("#ebase6_nav").offset().top + window.pageYOffset;
	var winTop = $("#ebase6_body").scrollTop();
	$("#ebase6_nav").css('position','absolute');
	$("#ebase6_nav").animate({top: winTop + "px"}, "slow");

	//スクロールをするたびに実行
	$("#ebase6_body").scroll(function () {
		winTop = $("#ebase6_body").scrollTop();
		$("#ebase6_nav").stop(); //これがないと連続して実行されたときに変な動きになります。
		$("#ebase6_nav").css('position','absolute');
		$("#ebase6_nav").animate({top: winTop + "px"}, "slow");

	});


	//}

	/*function time() {

	var field = document.getElementById("datafield");

	var hiduke=new Date();
    var jikan= new Date();

	//年・月・日・曜日を取得する
	var year = hiduke.getFullYear();
	var month = hiduke.getMonth()+1;
	var week = hiduke.getDay();
	var day = hiduke.getDate();

	//時・分・秒を取得する
 	var hour = jikan.getHours();
 	var minute = jikan.getMinutes();
  	var second = jikan.getSeconds();

	var yobi= new Array("日","月","火","水","木","金","土");

	var timeView = document.write(year+"/"+month+"/"+day+"/ "+"("+yobi[week]+")"+hour+":"+minute);
	timeView.style.cssText = 'position:fixed;top:20px;right:20px;left:100px';
	}*/


});
