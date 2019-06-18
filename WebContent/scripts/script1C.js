var xhr = new XMLHttpRequest();

window.onload=function()
{
	document.getElementById("btnCBuscar_I").addEventListener("click",miSubmit);
	document.getElementById("btnCBuscar_A").addEventListener("click",miSubmit2);
}

function miSubmit(){
	alert("xD");
	var idcliente=document.getElementById("txtIdCliente").value;
	xhr.open("post","ReadServletC_I?txtcustomer="+idcliente);
	xhr.onload=callBack;
	xhr.send(null);
}

function miSubmit2(){
	alert("xDxD");
	xhr.open("post","ReadCServlet_A");
	xhr.onload=callBack;
	xhr.send(null);
}

function callBack(){
	if(xhr.status==200){
		//--->
		if(xhr.readyState==4&&xhr.status==200){
			document.getElementById("divResultado").innerHTML=xhr.responseText;
		}
	}
}