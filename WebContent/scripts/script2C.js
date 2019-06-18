var xhr = new XMLHttpRequest();
window.onload=function()
{
	document.getElementById("btnCrearC").addEventListener("click",miSubmit);
}
function miSubmit()
{
	alert("sss");
	//abro conexion
	var idcliente = document.getElementById("txtCliente").value;
	var nombre = document.getElementById("txtNombre").value;
	var domicilio = document.getElementById("txtDomicilio").value;
	var telefono = document.getElementById("txtTelefono").value;
	
	//xhr.open("post","CreateServlet");
	xhr.open("POST","CreateCServlet?txtCliente="+idcliente+"&txtNombre="+nombre+"&txtDomicilio="+domicilio+"&txtTelefono="+telefono);
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