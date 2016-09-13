/**
 * mostrarValidaciones: Permite desplegar los errores reportados por el servicio de procesar data en la vista
 */
function mostrarValidaciones()
{
	var validaciones = CAF.model('#{activePageBean.clientIds["idErrores"]}');	
	  
	if (validaciones.getValue().length > 0)
	{
		var ids = (validaciones.id).split(':');
		var idGeneral =ids[0]+":"+ids[1];
			
		//console.log("validaciones.getValue(): "+ validaciones.getValue());
	    var registros = validaciones.getValue().split('_$$_');
		var mensaje = "";
		var ids = new Array();
		//console.log("registros: "+ registros.length);
			
		// Extraer y parsear valores
		for(var i = 0; i < registros.length-1; i++)
		{
			var columnas = registros[i].split('_$_');
			//console.log("columnas: "+ columnas.length);
			mensaje += columnas[0] + '<br>';
			ids[i] = idGeneral+":"+columnas[1];
//			console.log("columnas[0]: "+ columnas[0]);
//			console.log("columnas[1]: "+ columnas[1]);
//			console.log("columnas[2]: "+ columnas[2]);
		}
		
		CAF.Dialog.show({
			title : 'VALIDACIONES',
			//"styleClass" : clase,
			content : mensaje,
			buttons : {
				OK : {
					label : "Aceptar",
					//"class" : "button6",
					fn : function(form) {					
						 validaciones.setValue("");
						 for (i = 0; i < ids.length; i++) {
							if (document.getElementById(ids[i])){
								 document.getElementById(ids[i]).style.borderColor = "RED";
						 	}
						 }
						 document.getElementById(ids[0]).focus();						 
					},
				},
			}
		});
	}
}
