var xhr = new XMLHttpRequest();

window.onload=function()
{
	document.getElementById("btnBuscar_I").addEventListener("click",miSubmit);
	document.getElementById("btnBuscar_A").addEventListener("click",miSubmit2);
}

function miSubmit(){
	alert("xD");
	var codigo=document.getElementById("txtIdProducto").value;
	xhr.open("post","ReadServlet_I?txtIdProducto="+codigo);
	//xhr.open("get","Practica3Servlet?txtNombrecillo="+nombre+"&" + "txtApellidilloP="+apellidoP+"&txtApellidilloM="+apellidoM+"&txtEdadcilla="+edad+"&txtPesillo="+peso+"&txtAlturilla="+altura);
	xhr.onload=callBack;
	xhr.send(null);
}

function miSubmit2(){
	alert("xDxD");
	//var codigo=document.getElementById("txtIdProducto").value;
	xhr.open("post","ReadServlet_G");
	//xhr.open("get","Practica3Servlet?txtNombrecillo="+nombre+"&" + "txtApellidilloP="+apellidoP+"&txtApellidilloM="+apellidoM+"&txtEdadcilla="+edad+"&txtPesillo="+peso+"&txtAlturilla="+altura);
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