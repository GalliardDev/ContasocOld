# **Contasoc - Control de asociaciones**
⚠️ Esta versión está personalizada para la asociación **Huertos la Salud Bellavista** (Sevilla)

## **INFORMACIÓN**

[![Github All Releases](https://img.shields.io/github/downloads/yoshibv/Contasoc/total.svg)]()<br>
La aplicación está desarrollada en Java completamente, usando Swing para el apartado gráfico.

Si es requerido por la asociación, se puede automáticamente enviar un mail cuando salga una nueva versión de la app. (El correo se enviará automáticamente desde mi correo personal, porque no me puedo permitir un servidor de correo :P)

*Próximamente intentaré que Contasoc sea personalizable al 100%, es decir que sea una aplicación válida para cualquier asociación que quiera usarla y siempre será bajo la licencia [GNU GPL 3.0](https://www.gnu.org/licenses/gpl-3.0.txt) (código abierto, es decir, gratis)* .-YoshiBv

## **DESCARGA**

En en link de descarga en las [Releases](https://github.com/yoshibv/Contasoc/releases) o desde mi [página web](https://yoshibv.es), descargas el Setup para instalar Contasoc. El setup instala el programa en `C:/Archivos de Programa (x86)/Contasoc` por defecto pudiéndolo cambiar a elección del usuario. También permite elegir si crear o no un acceso directo en `Escritorio` o en `C:/ProgramData/Microsoft/Windows/Start Menu/Programs`. 

Luego de la instalación, crea en `C:/Users/TU_USUARIO/Documentos` una carpeta (Contasoc) para almacenar las bases de datos desde las cuales se leerán y almacenarán datos.

Contasoc también lleva integrada una versión de [Java](https://www.oracle.com/java/technologies/downloads/) para que no sea necesario instalarla por tu cuenta.

Por último, en la carpeta `Programs` mencionada anteriormente, hay un ejecutable que se crea en el proceso de instalación llamado `unins000.exe` el cual desinstalará Contasoc de tu equipo pero **no eliminará las bases de datos** por si hiciese falta actualizar el programa o exportar los datos.

## **INTERFAZ**

Los botones de la barra de la barra de herramientas (Toolbar) son, respectivamente, limpiar todos los campos, minimizar y cerrar. También se puede apreciar el logo de la asociación en la parte de arriba a la izquierda y la versión actual justo abajo en el menú lateral.

Este es el apartado de socios de la aplicación. Se puede añadir, buscar, modificar o eliminar socios desde aquí.
![Socios](https://i.imgur.com/gPW1UH0.png)

Este es el apartado de ingresos de la aplicación. Ingresos se refiere a los ingresos que realizan los socios para obtener un huerto o entrar en lista de espera.Se pueden añadir, buscar, modificar o eliminar ingresos desde aquí.
![Ingresos](https://i.imgur.com/8rlgyDh.png)

Este es el apartado de pagos de la aplicación. Pagos se refiere a los pagos que realiza la asociación a sus proveedores.Se pueden añadir, buscar, modificar o eliminar pagos desde aquí.
![Pagos](https://i.imgur.com/rOhGVFQ.png)

Este es el apartado de informe. Sirve para generar un informe de lo que se ha gastado calculando con el saldo incial de banco y caja introducidos y la suma total de ingresos (por caja y banco) y pagos (también por caja y banco) el total de dinero que queda.
![Informe](https://i.imgur.com/u2lbdKr.png)

Una lista de socios filtrada por los que están en lista de espera y mostrados en una tabla. Se puede actualizar si se modifica un socio y se le quita el estado de lista de espera.
![Lista de espera](https://i.imgur.com/LOyzx1h.png)

En este apartado se puede mostar un listado completo de socios, pagos, ingresos y lista de espera para luego imprimirlo en un PDF, por si hiciera falta una copia física.
![Impresión](https://i.imgur.com/SchAdoc.png)
