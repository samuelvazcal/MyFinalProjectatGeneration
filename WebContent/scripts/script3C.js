var xhr = new XMLHttpRequest();
window.onload=function()
{
	document.getElementById("btnActualizarC").addEventListener("click",miSubmit);
}
function miSubmit()
{
	alert("aaa");
	//abro conexion
	var idcliente = document.getElementById("txtCliente").value;
	var nombre = document.getElementById("txtNombre").value;
	var domicilio = document.getElementById("txtDomicilio").value;
	var telefono = document.getElementById("txtTelefono").value;
	
	//xhr.open("post","CreateServlet");
	//xhr.open("POST","UpdateServlet?txtIdProducto="+codigo+"&txtNombre="+nombre+"&txtMtsxCaja="+mtscaja+"&txtPzsxCaja="+pzscaja+"&txtPesoxCaja="+pesocaja+"&txtCajasxPallet="+cajaspallet+"&txtPrecioxMetro="+preciometro);
	xhr.open("POST","UpdateCServlet?txtCliente="+idcliente+"&txtNombre="+nombre+"&txtDomicilio="+domicilio+"&txtTelefono="+telefono);
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