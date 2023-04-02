/**
 * javascript for itemlist
 */

/**
* 品物一覧画面の処理はここに書く
*/
$(function(){

	//品物一覧表示
	$.itemlist = function(){
		$('#datafield').empty();
    document.getElementById("ebase6_submenu").innerHTML="品物一覧";


		$('#dataTable').remove();
		$('#ebase6_pamview').remove();

		var field = document.getElementById("datafield");

		var pamView = document.createElement("div");
		field.appendChild(pamView);
		pamView.className = "ebase6_pamview";
		pamView.id = "ebase6_pamview";
		pamView.style.cssText = 'position:absolute;top:150px;';

		var table = document.createElement("table");
		field.appendChild(table);
		table.className = "tablesorter";
		table.id = "dataTable";
		table.style.cssText = 'position:absolute;top:165px;';

		//submit処理開始
		//$.ajaxSetup({ async: false }); //同期
		$.postJSON("DQube",{actionID:'GoodsList'}, function(jres){

			//pamView.innerHTML="SQL [ " + jres.pams["sql"] + " ]";

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

			//$.ajaxSetup({ async: true }); //同期の解除
			return false;
		});

    var field = document.getElementById("datafield");

	//チェックボックス作成

	for(j=0;j<1;j++){
           var check = document.createElement("input");  //チェックボックス追加(データ行数に合わせる)
           var rcheck = "chbox"
               field.appendChild(check);
           check.setAttribute('type',"checkbox");
           check.setAttribute('id',rcheck);
           check.setAttribute('class', "recheck")
           check.setAttribute('checkd',"checked");
           check.style.cssText = 'position:relative;top:210px;left:15px;'
           //$(rcheck).off("check");
    }

	/*var check = document.createElement("input");
	field.appendChild(check);
		check.setAttribute('type',"checkbox");
		check.setAttribute('checkd',"checked");
		check.setAttribute('id',"chbox");
		check.style.cssText = 'position:absolute;top:150px;'*/

	//新規登録ボタン作成
	 var btn = document.createElement("input");
     field.appendChild(btn);
		btn.setAttribute('type',"button");
		btn.setAttribute('value',"新規登録");
		btn.setAttribute('id',"new_sample");
		btn.style.cssText = 'font-size:1.4em;padding: 10px 30px;background-color: #FFCCFF;position:absolute;top:80px;'
		$('#new_sample').off("click");
		$('#new_sample').on("click" , newgoods );


	/* 新規登録ボタン押下処理 */
	 function newgoods() {
		$('#dataTable').remove();
		 $('#view1_sample').remove();
	        $('#view2_sample').remove();
	        $('#view3_sample').remove();
	        $('#view4_sample').remove();
	        $('#view5_sample').remove();
	        //$('#view6_sample').remove();
	        $('#input1_sample').remove();
	        $('#input2_sample').remove();
	        $('#input3_sample').remove();
	        $('#input4_sample').remove();
	        $('#input5_sample').remove();
	        //$('#input6_sample').remove();
	        $('#button_sample').remove();


	        var field = document.getElementById("datafield");

			var x =  document.getElementById("chbox").checked;
			//var y = document.getElementById("chbox").checked;
			//var x = $('#chbox').prop('checked');

			if (x == true){
				document.getElementById("ebase6_submenu").innerHTML="OK";
			} else {

	        var view1 = document.createElement("div");
	        field.appendChild(view1);
	        view1.innerHTML = "品名";
	        view1.style.cssText = 'position:absolute;top:150px;';
	        view1.id = "view1_sample";

	        var view2 = document.createElement("div");
	        field.appendChild(view2);
	        view2.innerHTML = "単位";
	        view2.style.cssText = 'position:absolute;top:150px;left:160px;';
	        view2.id = "view2_sample";

	        var view3 = document.createElement("div");
	        field.appendChild(view3);
	        view3.innerHTML = "原価";
	        view3.style.cssText = 'position:absolute;top:150px;left:320px;';
	        view3.id = "view3_sample";

	        var view4 = document.createElement("div");
	        field.appendChild(view4);
	        view4.innerHTML = "賞味期限";
	        view4.style.cssText = 'position:absolute;top:150px;left:480px;';
	        view4.id = "view4_sample";

	        var view5 = document.createElement("div");
	        field.appendChild(view5);
	        view5.innerHTML = "発注の際の注意点";
	        view5.style.cssText = 'position:absolute;top:150px;left:640px;';
	        view5.id = "view5_sample";

	        var btn = document.createElement("input");
	        field.appendChild(btn);
			btn.setAttribute('type',"button");
			btn.setAttribute('value',messages['BTNSUBMIT']);
			btn.setAttribute('id',"button_sample");
			btn.style.cssText = 'position:absolute;top:170px;right:250px';
			$('#button_sample').off("click");
			$('#button_sample').on("click" , insertdata );

			var input1 = document.createElement("input");
	        field.appendChild(input1);
	        input1.setAttribute("type", "text");
	        input1.style.cssText = 'position:absolute;top:170px;width:150px;height:25px';
	        input1.setAttribute("id" ,"input1_sample");

	        var input2 = document.createElement("input");
	        field.appendChild(input2);
	        input2.setAttribute("type", "text");
	        input2.style.cssText = 'position:absolute;top:170px;left:160px;width:150px;height:25px';
	        input2.setAttribute("id" ,"input2_sample");

	        var input3 = document.createElement("input");
	        field.appendChild(input3);
	        input3.setAttribute("type", "text");
	        input3.style.cssText = 'position:absolute;top:170px;left:320px;height:25px;width:150px';
	        input3.setAttribute("id" ,"input3_sample");

	        var input4 = document.createElement("input");
	        field.appendChild(input4);
	        input4.setAttribute("type", "text");
	        input4.style.cssText = 'position:absolute;top:170px;left:480px;height:25px;width:150px';
	        input4.setAttribute("id" ,"input4_sample");

	        var input5 = document.createElement("input");
	        field.appendChild(input5);
	        input5.setAttribute("type", "text");
	        input5.style.cssText = 'position:absolute;top:170px;left:640px;height:25px;width:300px';
	        input5.setAttribute("id" ,"input5_sample");

	        field.update();

	        $('#ebase6_shadow').css('display', 'block');

		}
	 }


	 //品物データの登録処理
	function insertdata() {
		//var sql = prompt("input sql","");

		var name = $('#input1_sample').val();
		var unit = $('#input2_sample').val();
		var cost = $('#input3_sample').val();
		var expdays = $('#input4_sample').val();
		var caution = $('#input5_sample').val();
		//var caution = $('#input6_sample').val();

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
		$.postJSON("DQube",{actionID:'InsertData', name:name, unit:unit, cost:cost, expDays:expdays, caution:caution}, function(jres){

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


			$('#new_sample').remove();
			$('#view1_sample').remove();
	        $('#view2_sample').remove();
	        $('#view3_sample').remove();
	        $('#view4_sample').remove();
	        $('#view5_sample').remove();
	        //$('#view6_sample').remove();
	        $('#input1_sample').remove();
	        $('#input2_sample').remove();
	        $('#input3_sample').remove();
	        $('#input4_sample').remove();
	        $('#input5_sample').remove();
	        //$('#input6_sample').remove();
	        $('#button_sample').remove();

			//$.ajaxSetup({ async: true }); //同期の解除
			return false;
		});
	 }


	}
});
