var xhr = new XMLHttpRequest();
window.onload=function()
{
	document.getElementById("btnABNB").addEventListener("click",miSubmit);
	document.getElementById("btnAgregarFila").addEventListener("click",agregarFila);
	document.getElementById("btnLimpiar").addEventListener("click",limpiar);
}
function miSubmit(){
	alert("00000");
	
	var codigo=document.getElementById("nuevo_codigo").value;
	var nombre=document.getElementById("nuevo_nombre").value;
	var mtsxcajas=document.getElementById("nuevo_mtsxcajas").value;
	var pzsxcajas=document.getElementById("nuevo_pzsxcajas").value;
	var pesocaja=document.getElementById("nuevo_pesoxcaja").value;
	var cajasxpallet=document.getElementById("nuevo_cajasxpallet").value;
	var precioxm=document.getElementById("nuevo_precioxm").value;

	//--
	xhr.open("get","MiServlet?txtCodigo="+codigo);
	//xhr.open("get","Practica3Servlet?txtNombrecillo="+nombre+"&" + "txtApellidilloP="+apellidoP+"&txtApellidilloM="+apellidoM+"&txtEdadcilla="+edad+"&txtPesillo="+peso+"&txtAlturilla="+altura);
	xhr.onload=callBack;
	xhr.send(null);
}
var zero=0;
var acum=parseInt(zero);
var acum2=parseInt(zero);
function callBack()
{
	if(xhr.status==200)
		{
		
		var s = xhr.responseText;
		console.log(s);
		var s1=JSON.parse(s);
		alert(s1.codigo);
		document.getElementById("nuevo_nombre").value=s1.nombre;
		var boxNumber = parseInt(document.getElementById("nuevo_pzsxcajas").value);
		console.log("Este es el valor de boxNumber: "+boxNumber);
		document.getElementById("nuevo_mtsxcajas").value=(parseFloat(s1.mtsxcajas)*boxNumber).toFixed(2);
		document.getElementById("nuevo_pesoxcaja").value=(parseFloat(s1.pesocaja)*boxNumber).toFixed(2);
		document.getElementById("nuevo_cajasxpallet").value=parseInt(s1.cajasxpallet)*boxNumber;
		document.getElementById("nuevo_precioxm").value=(parseFloat(s1.precioxm)*boxNumber).toFixed(2);
		var res=parseFloat((nuevo_pesoxcaja).value);
		sumaPesos(res);
		//document.getElementById("miDiv").innerHTML=xhr.responseText;
		sumaPrecio();
		//----->
		}
}
function sumaPesos(res){
	console.log("estas en sumaPesos");
	console.log(res);
	document.getElementById("xxx").value=res;
	acum=acum+res;
	document.getElementById("xxx").value=acum;
	return acum;
}
function sumaPrecio(){
	var res2=parseFloat((nuevo_precioxm).value);
	
	console.log("estas en sumaPrecio");
	console.log(res2);
	document.getElementById("yyy").value=res2;
	acum2=acum2+res2;
	document.getElementById("yyy").value=acum2;
	return acum2;			
}
function borrar(no)
{
	var resBorrar=document.getElementById("pesoxcaja_row"+no+"").innerText;
	var resBorrar2=document.getElementById("precioxm_row"+no+"").innerText;
	restaPeso(resBorrar);
	//>document.getElementById("row"+no+"").outerHTML="";
	restaPrecio(resBorrar2);
	//document.getElementById("row"+no+"").outerHTML="";
	document.getElementById("row"+no+"").outerHTML="";
	
}
function restaPeso(resBorrar){
	
	console.log("AAA: "+resBorrar);
	console.log("BBB: "+acum);
	acum=acum-resBorrar;
	document.getElementById("xxx").value=acum;
	return acum;
}
function restaPrecio(resBorrar2){
	//var resBorrar2=document.getElementById("precioxm_row"+no+"").innerText;
	acum2=acum2-resBorrar2;
	document.getElementById("yyy").value=acum2;
	return acum2;
}

var cont=0;
function agregarFila()
{
 
 cont++;
 var nuevo_id=document.getElementById("nuevo_id").value;
 var nuevo_codigo=document.getElementById("nuevo_codigo").value;
 var nuevo_nombre=document.getElementById("nuevo_nombre").value;
 var nuevo_mtsxcajas=document.getElementById("nuevo_mtsxcajas").value;
 var nuevo_pzsxcajas=document.getElementById("nuevo_pzsxcajas").value;
 var nuevo_pesoxcaja=document.getElementById("nuevo_pesoxcaja").value;
 var nuevo_cajasxpallet=document.getElementById("nuevo_cajasxpallet").value;
 var nuevo_precioxm=document.getElementById("nuevo_precioxm").value;
	
 var table=document.getElementById("tablaC");
 var table_len=(table.rows.length)-1;
 var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td>"+cont+"</td><td id='codigo_row"+table_len+"'>"+nuevo_codigo+"</td><td id='nombre_row"+table_len+"'>"+nuevo_nombre+"</td><td id='mtsxcajas_row"+table_len+"'>"+nuevo_mtsxcajas+"</td><td id='pzsxcajas_row"+table_len+"'>"+nuevo_pzsxcajas+"</td><td id='pesoxcaja_row"+table_len+"'>"+nuevo_pesoxcaja+"</td><td id='cajasxpallet_row"+table_len+"'>"+nuevo_cajasxpallet+"</td><td id='precioxm_row"+table_len+"'>"+nuevo_precioxm+"</td><td><input type='button' value='Borrar Fila' class='delete' onclick='borrar("+table_len+")'></td></tr>";
 
 document.getElementById("nuevo_id").value="";
 document.getElementById("nuevo_codigo").value="";
 document.getElementById("nuevo_nombre").value="";
 document.getElementById("nuevo_mtsxcajas").value="";
 document.getElementById("nuevo_pzsxcajas").value="";
 document.getElementById("nuevo_pesoxcaja").value="";
 document.getElementById("nuevo_cajasxpallet").value="";
 document.getElementById("nuevo_precioxm").value="";
}

function limpiar(){
	document.getElementById("nuevo_id").innerHTML="";
	document.getElementById("nuevo_codigo").innerHTML="";
	document.getElementById("nuevo_nombre").innerHTML="";
	document.getElementById("nuevo_nocajas").innerHTML="";
	document.getElementById("nuevo_cajaxtarima").innerHTML="";
	document.getElementById("nuevo_peso").innerHTML="";
}
