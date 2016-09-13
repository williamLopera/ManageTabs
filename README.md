# ManageTabs -  Autor William Lopera 
@pranical.com Sep 2016

Proyecto de SoftwareAG Webmethod CAF - version. 9.5.
     1.- Manejo de tabs con vistas independientes en un solo portlet.
         * MyPortlet/default.view   => Datos Laborales
         * MyPortlet/page2.view     => Datos Personales
         * MyPortlet/page3.view     => Otros Datos
         * MyPortlet/ready.view     => Resultado del procesamiento
         
     2.- Uso de Preference para tener un solo objeto de negocio que se actualiza a través de las preferencias y 
         distribución de la información en las vistas del tab 
                DatosSolicitud -> DatosLaborales)
                               -> DatosPersonales
                               -> Mensajes de Error
     3.- Uso de Archivo XML, para configurar y validar los campos obligatorios del lado del Servidor. Parar ellos
            * Parsear archivo XML a documento de negocio (dominio)
            * Buscar en documento de negocio (xml) campos obligatorios
            * Evaluar si son difentes de vacio. En caso de vacio general lista de errores y redireccionar a la vista o tab 
              que presenta errores
     4.- En CAF - JS evaluar los errores:
           * Enviar vista modal con errores.
           * Colocar los campos erroneos de la vista actual con borde de color rojo.
           * Seleccionar el primer error (focus) al cerra la modal.
           
      5.- Al enviar a procesar se evalua los campos que fueron modificados y se genera una tabla solo con los campos modificados
           Uso de Aspect de Java 
           
      Notas: El ejercicio parte de datos iniciales y permite modificar los valores de las vistas y al final evalua si los campos
             obligatorios estan vacios y reportar error o exito al final.
             
