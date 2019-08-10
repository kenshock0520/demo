function lineAdd() {

	var inputCount = document.getElementsByClassName("form-group").length;
	var input = document.createElement("input");
	input.setAttribute("type", "text");
	input.setAttribute("id", "lineFormList" + inputCount + ".id");
	input.setAttribute("class", "form-control");
	input.setAttribute("name", "lineFormList[" + inputCount + "].id")
	input.setAttribute("value", "");
	
	var name = document.createElement("input");
	name.setAttribute("type", "text");
	name.setAttribute("id", "lineFormList" + inputCount + ".name");
	name.setAttribute("class", "form-control");
	name.setAttribute("name", "lineFormList[" + inputCount + "].name")
	name.setAttribute("value", "");
	
	var value = document.createElement("input");
	value.setAttribute("type", "text");
	value.setAttribute("id", "lineFormList" + inputCount + ".value");
	value.setAttribute("class", "form-control");
	value.setAttribute("name", "lineFormList[" + inputCount + "].value")
	value.setAttribute("value", "");
	
	var flg = document.createElement("input");
	flg.setAttribute("type", "text");
	flg.setAttribute("id", "lineFormList" + inputCount + ".flg");
	flg.setAttribute("class", "form-control");
	flg.setAttribute("name", "lineFormList[" + inputCount + "].flg")
	flg.setAttribute("value", "");
	
	var ele = document.createElement("div");
	ele.className = 'form-group';
//	ele.appendChild(document.createTextNode("id:"));
	ele.appendChild(input);
	ele.appendChild(name);
	ele.appendChild(value);
	ele.appendChild(flg);

	// 生成したdiv要素を追加する
	document.getElementById('formArea').appendChild(ele);
	
}