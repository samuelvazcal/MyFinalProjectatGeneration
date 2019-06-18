window.onload = function()
{
    document.getElementById("btnAgregarFila").addEventListener("click", erase);

    document.getElementById("nuevo_id").addEventListener("click", changeRedAlert);

    function changeRedAlert(){
        var nuevo_id = document.getElementById("nuevo_id");
        alert("Campo no modificabe or el ususario");
    }
}

function erase() {
    document.getElementById("nuevo_codigo").value = "";
}