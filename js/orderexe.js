/**
 * javascript for orderexe
 */

/**
* 発注作業画面の処理はここに書く
*/
$(function(){

	//ALL menu close
	function menuClose() {
		$('#ebase6_shadow').css('display', 'none');
		$('#ebase6_menulist').css('display', 'none');
		$('#ebase6_popup').css('display', 'none');
	};

	//発注作業画面表示
	$.orderexe = function(){
		$('#datafield').empty();

		document.getElementById("ebase6_submenu").innerHTML="発注作業";
		$('#ebase6_popup').css('width', '300');
		$('#ebase6_popup').css('height', '200');
		$('#ebase6_popup').css('margin', '-150px 0 0 -100px');
		$('#ebase6_shadow').css('display', 'block'); //他入力欄をシャドウ化
		$('#ebase6_popup').css('display', 'block'); //ポップアップ表示
		$('#ebase6_popup_title').html(messages['TOPDBEXE']); //ポップアップにメッセージ表示
		$('#ebase6_popup_body').empty(); //ボディ初期化
		$('#ebase6_popup_foot').empty(); //フッター初期化
		//実行ボタン作成
		var btn = document.createElement("input");
		btn.setAttribute('type',"button");
		btn.setAttribute('value',messages['BTNSUBMIT']);
		btn.setAttribute('id',"ebase6_popup_submit");
		$('#ebase6_popup_foot').append(btn);
		$('#ebase6_popup_submit').off("click"); //実行ボタンの処理を初期化
		$('#ebase6_popup_submit').on("click" , orderingWork ); //実行ボタンの処理変更
		$('#ebase6_popup_submit').on("click" , menuClose );//ポップアップを閉じる
		//入力欄作成
		var inp = document.createElement("textarea");
		inp.setAttribute('id',"ebase6_popup_order");
		inp.style.cssText = 'position:absolute;left:0;width:295px;height:128px;';
		$('#ebase6_popup_body').append(inp);

		var field = document.getElementById("datafield");

        var btn = document.createElement("input");
        field.appendChild(btn);
		btn.setAttribute('type',"button");
		btn.setAttribute('value', "確定");
		btn.setAttribute('id',"button_sample");
		btn.style.cssText = 'font-size:2.0em;padding: 5px 10px;font-weight: bold;background-color: #3399CC;position:absolute;top:80px;left:100px'
		$('#button_sample').off("click");
		$('#button_sample').on("click" , supplydata );


        field.update();

	}

	//発注商品の選択
	function orderingWork(){
		//var sql = prompt("input sql","");
		var order = $('#ebase6_popup_order').val();

		$('#dataTable').remove();
		$('#ebase6_pamview').remove();

		var field = document.getElementById("datafield");

		/*var pamView = document.createElement("div");
		field.appendChild(pamView);
		pamView.className = "ebase6_pamview";
		pamView.id = "ebase6_pamview";
		pamView.style.cssText = 'position:absolute;top:80px;'*/

		var select = document.createElement("select");
		field.appendChild(select);
		select.id = "dataSelect";
		select.style.cssText = 'position:absolute;top:170px;width:150px;height:30px';
		select.onchange = function(){
			$('#ebase6_popup').css('width', '300');
			$('#ebase6_popup').css('height', '200');
			$('#ebase6_popup').css('margin', '-150px 0 0 -100px');
			$('#ebase6_shadow').css('display', 'block'); //他入力欄をシャドウ化
			$('#ebase6_popup').css('display', 'block'); //ポップアップ表示
			$('#ebase6_popup_title').html(messages['TOPDBEXE']); //ポップアップにメッセージ表示
			$('#ebase6_popup_body').empty(); //ボディ初期化
			$('#ebase6_popup_foot').empty(); //フッター初期化
			//実行ボタン作成
			var btn = document.createElement("input");
			btn.setAttribute('type',"button");
			btn.setAttribute('value',messages['BTNSUBMIT']);
			btn.setAttribute('id',"ebase6_popup_submit");
			$('#ebase6_popup_foot').append(btn);
			$('#ebase6_popup_submit').off("click"); //実行ボタンの処理を初期化
			$('#ebase6_popup_submit').on("click" , selectChange ); //実行ボタンの処理変更
			$('#ebase6_popup_submit').on("click" , menuClose ); //ポップアップを閉じる
			//入力欄作成
			var inp = document.createElement("textarea");
			inp.setAttribute('id',"ebase6_popup_item");
			inp.style.cssText = 'position:absolute;left:0;width:295px;height:128px;';
			$('#ebase6_popup_body').append(inp);

			var view1 = document.createElement("div");
	        field.appendChild(view1);
	        view1.innerHTML = "発注数";
	        view1.style.cssText = 'position:absolute;top:150px;;left:670px;';
	        view1.id = "view1_sample";

	        var view2 = document.createElement("div");
	        field.appendChild(view2);
	        view2.innerHTML = "仕入れ予定日";
	        view2.style.cssText = 'position:absolute;top:150px;right:350px;';
	        view2.id = "view2_sample";

	        var input1 = document.createElement("input");
	        field.appendChild(input1);
	        input1.setAttribute("type", "text");
	        input1.style.cssText = 'position:absolute;top:170px;left:670px;width:150px;height:25px';
	        input1.setAttribute("id" ,"supply1_sample");

	        var input2 = document.createElement("input");
	        field.appendChild(input2);
	        input2.setAttribute("type", "text");
	        input2.style.cssText = 'position:absolute;top:170px;right:300px;width:150px;height:25px';
	        input2.setAttribute("id" ,"supply2_sample");
		};

		//SQL文：単位、原価、前日発注数、在庫数表示
		//select UNIT,COST,ORDER_NUM,STOCK from ITEM_MST i inner join SUPPLY_HISTORY su on i.id = su.id inner join STOCK_HISTORY so on i.id = so.id where i.id = 2 and su.SUPPLY_DAY = ADDDATE(CURRENT_DATE(), -1);


		//submit処理開始
		//$.ajaxSetup({ async: false }); //同期
		$.postJSON("DQube",{actionID:'OrderWork', order:order}, function(jres){

			//pamView.innerHTML="SQL [ " + jres.pams["sql"] + " ]";

			var option1 = document.createElement("option");
			option1.innerHTML = "選択してください"
			select.appendChild(option1);

			for(i=0;i<jres.tblData.length;i++){
                var option2 = document.createElement("option");
                option2.value = jres.tblData[i]["id"];
                option2.innerHTML = jres.tblData[i]["ITEM_NAME"];
                option2.setAttribute('id',"option_data");
                select.appendChild(option2);
            }

			$("#dataSelect").trigger("update");

			//$.ajaxSetup({ async: true }); //同期の解除
			return false;
		});
	}

	//発注データの登録
	function supplydata() {

		var id = $('#dataSelect').val();
		var ord = $('#supply1_sample').val();
		var scheduled = $('#supply2_sample').val();

		$('#dataTable').remove();
		$('#ebase6_pamview').remove();

		var field = document.getElementById("datafield");

		var pamView = document.createElement("div");
		field.appendChild(pamView);
		pamView.className = "ebase6_pamview";
		pamView.id = "ebase6_pamview";
		pamView.style.cssText = 'position:absolute;top:70px';

		var table = document.createElement("table");
		field.appendChild(table);
		table.className = "tablesorter";
		table.id = "dataTable";
		table.style.cssText = 'position:absolute;top:80px';

		//submit処理開始
		//$.ajaxSetup({ async: false }); //同期
		$.postJSON("DQube",{actionID:'SupplyData',id:id, ord:ord, scheduled:scheduled }, function(jres){

			pamView.innerHTML="SQL [ " + jres.pams["sql"] + " ]";

			//DOM型で要素をAppendしていく
			var theadElem = document.createElement("thead");
			var trElem = document.createElement("tr");
			table.appendChild(theadElem);
			theadElem.appendChild(trElem);

			var ssSearch = document.getElementById("ss_select");

			for(i=0;i<jres.keys.length;i++){
				//テーブルにカラム名を表示
				var col = jres.keys[i];
				var thElem = document.createElement("th");
				trElem.appendChild(thElem);
				thElem.className = jres.tblColData[col]["classname"];
				thElem.innerHTML=jres.tblColData[col]["name"];
			}

			//データ行を作成
			var tbodyElem = document.createElement("tbody");
			table.appendChild(tbodyElem);

			//データのヒットがない場合、空行を作成
			if(jres.tblData.length==0){
				var trElem = document.createElement("tr");
				tbodyElem.appendChild(trElem);
				for(i=0;i<jres.keys.length;i++){
					var tdElem = document.createElement("td");
					trElem.appendChild(tdElem);
				}
			}

			for(j=0;j<jres.tblData.length;j++){ //データの書きだし
				var trElem = document.createElement("tr");
				tbodyElem.appendChild(trElem);
				for(i=0;i<jres.keys.length;i++){
					var tdElem = document.createElement("td");
					trElem.appendChild(tdElem);
					tdElem.style.background = "#fff";
					var col = jres.keys[i];
					tdElem.innerHTML = jres.tblData[j][col];
				}
			}


			$("#dataTable").tablesorter({
				widgets: ['zebra'],
				sortList: [[0, 1]]
			});
			$("#dataTable").trigger("update");

			$('#button_sample').remove();
			$('#dataSelect').remove();
			$('#view1_sample').remove();
			$('#view2_sample').remove();
			$('#supply1_sample').remove();
			$('#supply2_sample').remove();

			//$.ajaxSetup({ async: true }); //同期の解除
			return false;
		});
	}


	//セレクトボックス変更による処理
	function selectChange() {
		//var sql = prompt("input sql","");
		var list = $('#ebase6_popup_item').val();

		$('#dataTable').remove();
		$('#ebase6_pamview').remove();

		var field = document.getElementById("datafield");

		var table = document.createElement("table");
		field.appendChild(table);
		table.className = "tablesorter";
		table.id = "dataTable";
		table.style.cssText = 'position:absolute;top:160px;width:500px;height:25px;left:160px;';

		//submit処理開始
		//$.ajaxSetup({ async: false }); //同期
		$.postJSON("DQube",{actionID:'GoodsList',list:list }, function(jres){

			//DOM型で要素をAppendしていく
			var theadElem = document.createElement("thead");
			var trElem = document.createElement("tr");
			table.appendChild(theadElem);
			theadElem.appendChild(trElem);

			var ssSearch = document.getElementById("ss_select");

			/*for(i=0;i<jres.keys.length;i++){
				//テーブルにカラム名を表示
				var col = jres.keys[i];
				var thElem = document.createElement("th");
				trElem.appendChild(thElem);
				thElem.innerHTML=jres.tblColData[col]["name"];
			}*/

			//データ行を作成
			var tbodyElem = document.createElement("tbody");
			table.appendChild(tbodyElem);

			//データのヒットがない場合、空行を作成
			/*if(jres.tblData.length==0){
				var trElem = document.createElement("tr");
				tbodyElem.appendChild(trElem);
				for(i=0;i<jres.keys.length;i++){
					var tdElem = document.createElement("td");
					trElem.appendChild(tdElem);
				}
			}*/

			for(j=0;j<jres.tblData.length;j++){ //データの書きだし
				var trElem = document.createElement("tr");
				tbodyElem.appendChild(trElem);
				for(i=0;i<jres.keys.length;i++){
					var tdElem = document.createElement("td");
					trElem.appendChild(tdElem);
					tdElem.style.background = "#fff";
					var col = jres.keys[i];
					tdElem.innerHTML = jres.tblData[j][col];
				}
			}


			$("#dataTable").tablesorter({
				widgets: ['zebra'],
				sortList: [[0, 1]]
			});
			$("#dataTable").trigger("update");

			//$.ajaxSetup({ async: true }); //同期の解除
			return false;
		});
	}


});
