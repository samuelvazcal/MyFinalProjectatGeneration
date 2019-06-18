var xhr = new XMLHttpRequest();
window.onload=function()
{
	document.getElementById("btnCrear").addEventListener("click",miSubmit);
}
function miSubmit()
{
	alert("sss");
	//abro conexion
	var codigo = document.getElementById("txtIdProducto").value;
	var nombre = document.getElementById("txtNombre").value;
	var mtscaja = document.getElementById("txtMtsxCaja").value;
	var pzscaja = document.getElementById("txtPzsxCaja").value;
	var pesocaja = document.getElementById("txtPesoxCaja").value;
	var cajaspallet = document.getElementById("txtCajasxPallet").value;
	var preciometro = document.getElementById("txtPrecioxMetro").value;
	
	//xhr.open("post","CreateServlet");
	xhr.open("POST","CreateServlet?txtIdProducto="+codigo+"&txtNombre="+nombre+"&txtMtsxCaja="+mtscaja+"&txtPzsxCaja="+pzscaja+"&txtPesoxCaja="+pesocaja+"&txtCajasxPallet="+cajaspallet+"&txtPrecioxMetro="+preciometro);
	xhr.onload=callBack;
	xhr.send(null);
}
function callBack()
{
	if(xhr.status==200)
		{
			document.getElementById("divResultado").innerHTML=xhr.responseText;
		}
}