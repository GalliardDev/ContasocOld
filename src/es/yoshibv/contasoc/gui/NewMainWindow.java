/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.yoshibv.contasoc.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import es.yoshibv.contasoc.ContasocDAO;
import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.TipoHortelano;
import es.yoshibv.contasoc.common.TipoRetribucion;
import es.yoshibv.contasoc.ingreso.Ingreso;
import es.yoshibv.contasoc.pago.Pago;
import es.yoshibv.contasoc.persona.hortelano.Hortelano;
import es.yoshibv.contasoc.util.DNIValidator;
import es.yoshibv.contasoc.util.ErrorHandler;
import es.yoshibv.contasoc.util.PDFPrinter;
import es.yoshibv.contasoc.util.Parsers;
import es.yoshibv.contasoc.util.StretchIcon;
import es.yoshibv.contasoc.util.UpperCaseFilter;

/**
 *
 * @author jomaa
 */
@SuppressWarnings("serial")
public class NewMainWindow extends javax.swing.JFrame {
	public static String valor = null;
    private boolean isResizable = false;

    public NewMainWindow() {
        initComponents();
        finalizeInit();
        
    }
    
    public boolean getResizable() {
        return this.isResizable;
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/newlogo.png"));
        return retValue;
    }
    
    private void setFilters() {
    	List<JTextField> lista = List.of(
    			sociosNHuertoField,
    			sociosNombreField,
    			ingresosConceptoField,
    			gastosProveedorField,
    			gastosConceptoField
    			);
    	for(JTextField jtp:lista) {
    		AbstractDocument doc = (AbstractDocument) jtp.getDocument();
	        doc.setDocumentFilter( new UpperCaseFilter());
    	}
    }
        
    private void showFirstPanel() {
        Component[] components = this.getContentPane().getComponents();
                
        components[1].setVisible(true);
        components[0].setVisible(false);
    }
    
    private void showPanel(Container container, String name){
        Component[] components = container.getComponents();
        
        for(Component component:components){
            if(component.getName() != null && component.getName().equals(name)){
                    component.setVisible(true);
                } else {
                    component.setVisible(false);
            }
        }
    }
    
    private void finalizeInit() {
        setLocationRelativeTo(null);
        setBg();
        setNoResIfInicio();
        ContasocDAO.inicializarBaseDeDatos();
        actualizar();
        setFilters();
        showFirstPanel();
        setTableSorter();
    }
    
    private void setNoResIfInicio() {
        if(inicioPanel.isVisible()) {
            this.setResizable(false);
        } else if(appPanel.isVisible()) {
            this.setResizable(true);
        }
    }
    
    private void setBg() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(NewMainWindow.class.getResourceAsStream("/imagenes/bg.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        StretchIcon imagenIcono = new StretchIcon(img,false);
        jLabel1.setIcon(imagenIcono);
    }
    
    private List<JTextField> sociosGetTextFields(){
    	List<JTextField> aux = new ArrayList<>();
    	aux.add(sociosNHuertoField);
    	aux.add(sociosNSocioField);
    	aux.add(sociosNombreField);
    	aux.add(sociosDniField);
    	aux.add(sociosTelefonoField);
    	aux.add(sociosCorreoField);
    	aux.add(sociosFechaAltaField);
    	aux.add(sociosFechaEntregaField);
    	aux.add(sociosFechaBajaField);
    	aux.add(sociosNotasField);
    	aux.add(sociosEstadoField);
    	return aux;
    }
       
    private boolean sociosInputChecker() {
    	if(sociosNSocioField.getText().equals("") ||
    			sociosNombreField.getText().equals("") ||
    			sociosDniField.getText().equals("") ||
    			sociosFechaAltaField.getText().equals("")) {		
			ErrorHandler.camposObligatoriosVacios();
			return false;
		}
    	if(DNIValidator.validarDNI(sociosDniField.getText())==false) {
    		if(DNIValidator.validarNIE(sociosDniField.getText())==false) {
    			ErrorHandler.errorAlLeerDNI();
    			return false;
    		}
    	}

    	String patronCorreo = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern patternCorreo = Pattern.compile(patronCorreo);
        Matcher matcherCorreo = patternCorreo.matcher(sociosCorreoField.getText());
        if(!(sociosCorreoField.getText().equals("")) && !(matcherCorreo.matches())) {
        	ErrorHandler.errorAlLeerCorreo();
        	return false;
        }
        if(sociosFechaAltaField.getText().split("/").length==1) {
			ErrorHandler.errorAlLeerFecha("alta");
			return false;
		}
		if(sociosNHuertoField.getText().equals("") && (!(sociosTipoComboBox.getSelectedItem().toString().equals("LISTA DE ESPERA")))) {
			ErrorHandler.numeroHuertoVacio();
			return false;
		}
		if(!(sociosNHuertoField.getText().equals("")) && sociosTipoComboBox.getSelectedItem().toString().equals("LISTA DE ESPERA")) {
			ErrorHandler.tipoSocioNoAdecuado();
			return false;
		}
		return true;
    }
    
    private void añadirSocio() {    	
		List<JTextField> lista = sociosGetTextFields();
		String huerto = lista.get(0).getText();
		List<Hortelano> aux = ContasocDAO.toHortelano(ContasocDAO.leerTabla("hortelanos"));
		String socio = String.valueOf(aux.get(aux.size()-1).getSocio()+1);
		String nombre = lista.get(2).getText();
		String dni = lista.get(3).getText();
		String telefono = lista.get(4).getText();
		String correo = lista.get(5).getText();
		String alta = lista.get(6).getText();
		String entrega = lista.get(7).getText();
		String baja = "null";
		String notas = lista.get(9).getText();
		String tipo = Parsers.tipoHortelanoParser(sociosTipoComboBox.getSelectedItem().toString());
		String estado = "ACTIVO";
		
		if(!(sociosInputChecker())) {
			
		} else {
			List<String> registroExistente = ContasocDAO.buscarDatosDobleEntrada("hortelanos", "numSocio", socio, "nombre", nombre);

            if (!registroExistente.isEmpty()) {
                // Realiza alguna acción si el registro ya existe en la base de datos
                modificarSocio();
            } else {
                // Agregar el nuevo registro a la tabla "pagos"
                ContasocDAO.agregarDatos("hortelanos", new String[]{huerto,socio,nombre,dni,telefono,
                		correo,alta,entrega,baja,notas,tipo,estado});

                // Restablecer los campos de entrada
                for (JTextField jtf : lista) {
                    jtf.setText("");
                }
            }			
			ErrorHandler.socioAgregado(Integer.valueOf(socio));
			ContasocDAO.eliminarDatos("hortelanos", "numSocio", "0");
		}
	}
    
    /*private void buscarSocio() {
    	List<JTextField> lista = sociosGetTextFields();
    	String socio = lista.get(1).getText();
    	String huerto = lista.get(0).getText();
    	String nombre = lista.get(2).getText();
    	List<String> hortelanosSocio = ContasocDAO.buscarDatos("hortelanos", "numSocio", socio);
    	List<String> hortelanosHuerto = ContasocDAO.buscarDatos("hortelanos", "numHuerto", huerto);
    	List<String> hortelanosNombreComp = ContasocDAO.buscarDatos("hortelanos", "nombre", nombre);
    	if(hortelanosSocio.size()==0&&hortelanosHuerto.size()==0&&hortelanosNombreComp.size()==0) {
    		ErrorHandler.socioNoExiste();
    	} else {
    		if(socio!=""&&huerto==""&&nombre=="") {
    			String[] hArr = hortelanosSocio.get(0).split(";");
        		int i = 0;
            	while(i<11) {
            		lista.get(i).setText(hArr[i].replace("null", ""));
            		i++;
            	}
            	if(hArr[11].equals("LISTA_ESPERA")) {
            		sociosTipoComboBox.setSelectedItem("LISTA DE ESPERA");
            	} else if(hArr[11].equals("HORTELANO")) {
            		sociosTipoComboBox.setSelectedItem("HORTELANO");
            	} else if(hArr[11].equals("HORTELANO_INVERNADERO")) {
            		sociosTipoComboBox.setSelectedItem("HORTELANO+INVERNADERO");
            	} else if(hArr[11].equals("COLABORADOR")) {
            		sociosTipoComboBox.setSelectedItem("COLABORADOR");
            	}
    		} else if(socio==""&&huerto!=""&&nombre=="") {
    			String[] hArr = hortelanosHuerto.get(0).split(";");
        		int i = 0;
            	while(i<11) {
            		lista.get(i).setText(hArr[i].replace("null", ""));
            		i++;
            	}
            	if(hArr[11].equals("LISTA_ESPERA")) {
            		sociosTipoComboBox.setSelectedItem("LISTA DE ESPERA");
            	} else if(hArr[11].equals("HORTELANO")) {
            		sociosTipoComboBox.setSelectedItem("HORTELANO");
            	} else if(hArr[11].equals("HORTELANO_INVERNADERO")) {
            		sociosTipoComboBox.setSelectedItem("HORTELANO+INVERNADERO");
            	} else if(hArr[11].equals("COLABORADOR")) {
            		sociosTipoComboBox.setSelectedItem("COLABORADOR");
            	}
    		} else if(socio==""&&huerto==""&&nombre!="") {
    			String[] hArr = hortelanosNombreComp.get(0).split(";");
        		int i = 0;
            	while(i<11) {
            		lista.get(i).setText(hArr[i].replace("null", ""));
            		i++;
            	}
            	if(hArr[11].equals("LISTA_ESPERA")) {
            		sociosTipoComboBox.setSelectedItem("LISTA DE ESPERA");
            	} else if(hArr[11].equals("HORTELANO")) {
            		sociosTipoComboBox.setSelectedItem("HORTELANO");
            	} else if(hArr[11].equals("HORTELANO_INVERNADERO")) {
            		sociosTipoComboBox.setSelectedItem("HORTELANO+INVERNADERO");
            	} else if(hArr[11].equals("COLABORADOR")) {
            		sociosTipoComboBox.setSelectedItem("COLABORADOR");
            	}
    		}
    	}
    }*/
    
    private void modificarSocio() {
    	List<JTextField> lista = sociosGetTextFields();
		String huerto = lista.get(0).getText();
		String socio = lista.get(1).getText();
		String nombre = lista.get(2).getText();
		String dni = lista.get(3).getText();
		String telefono = lista.get(4).getText();
		String correo = lista.get(5).getText();
		String alta = lista.get(6).getText();
		String entrega = lista.get(7).getText();
		String baja = lista.get(8).getText();
		String notas = lista.get(9).getText();
		String tipo = sociosTipoComboBox.getSelectedItem().toString();
		String estado = "ACTIVO";
		if(baja=="") {
			baja = "null";
			estado = "ACTIVO";
		} else {
			estado = "INACTIVO";
		}
		if(!(sociosInputChecker())) {
			
		} else {
			String[] columnas = new String[] {"nombre","apellidos","dni","direccion","telefono","correo",
					"numSocio","numHuerto","fechaAlta","fechaBaja","estado","tipo"};
			String[] valores = new String[] {huerto,socio,nombre,dni,telefono,correo,alta,entrega,baja,notas,tipo,estado};
			ContasocDAO.modificarDatos("hortelanos", "numSocio", socio, columnas, valores);
			
			for(JTextField tp:lista) {
				tp.setText("");
			}
			actualizarSociosTabla();
			ErrorHandler.socioModificado(Integer.valueOf(socio));
			
		}
			
    }
    
    private void eliminarSocio() {
    	List<JTextField> lista = sociosGetTextFields();
    	String socio = lista.get(1).getText();
    	
    	ContasocDAO.eliminarDatos("hortelanos", "numSocio", String.valueOf(socio));
    	
    	for(JTextField tp:lista) {
    		tp.setText("");
    	}
    	actualizarSociosTabla();
    	ErrorHandler.socioEliminado(Integer.valueOf(socio));
    }
    
    private List<JTextField> ingresosGetTextFields(){
    	List<JTextField> aux = new ArrayList<JTextField>();
    	aux.add(ingresosNSocioField);
    	aux.add(ingresosFechaField);
    	aux.add(ingresosConceptoField);
    	aux.add(ingresosCantidadField);
    	return aux;
    }
    
    private boolean ingresosInputChecker() {
    	if(ingresosNSocioField.getText().equals("") ||
				ingresosFechaField.getText().equals("") ||
				ingresosConceptoField.getText().equals("") ||
				ingresosCantidadField.getText().equals("")) {		
			ErrorHandler.camposObligatoriosVacios();
			return false;
		}
    	if(ingresosFechaField.getText().split("/").length==1) {
			ErrorHandler.errorAlLeerFecha("registro del ingreso");
			return false;
		}
    	if(!(Double.valueOf(ingresosCantidadField.getText()) instanceof Double)) {
    		ErrorHandler.errorAlLeerCantidadNumerica(ingresosCantidadField.getText());
    		return false;
    	}
    	return true;
    }
    
    private void añadirIngreso() {
    	List<JTextField> lista = ingresosGetTextFields();
    	String socio = lista.get(0).getText();
    	String fecha = lista.get(1).getText();
    	String concepto = lista.get(2).getText();
    	String cantidad = Parsers.decimalSymbolParser(lista.get(3).getText());
    	String tipoIngreso = ingresosTipoComboBox.getSelectedItem().toString();
    	    	
    	if(!(ingresosInputChecker())) {
    		
    	} else {
    		ContasocDAO.agregarDatos("ingresos", new String[] {socio,fecha,concepto,cantidad,tipoIngreso});
        	
        	ingresosLista.setText("");
        	for(JTextField tp:lista) {
				tp.setText("");
			}
        	ErrorHandler.ingresoAgregado(Integer.valueOf(socio));
    	}
    }
    
    private void buscarIngreso() {
    	List<JTextField> lista = ingresosGetTextFields();
    	Integer socio = Integer.valueOf(lista.get(0).getText());
    	List<String> ingresosList = ContasocDAO.buscarDatos("ingresos", "numSocio", String.valueOf(socio));
    	String titulo = null;
    	if(!(ingresosList.size()==0)) {
    		List<String> aux = new ArrayList<String>();
        	for(String s:ingresosList) {
        		String[] t = s.split(";");
        		aux.add("Fecha: " + t[1] + "\n" +
        		"Concepto: " + t[2] + "\n" +
                "Cantidad: " + t[3] + "\n" +
        		"Tipo: " + t[4]);
        		titulo = "Ingresos del socio nº " + t[0] +"\n\n";
        	}
        	ingresosLista.setText(titulo);
        	ingresosLista.append(String.join("\n\n", aux));
    	} else if(ingresosList.size()==0) {
    		ingresosLista.setText("");
    	}
    }
    
    private void modificarIngreso() {
    	List<JTextField> lista = ingresosGetTextFields();
    	String socio = lista.get(0).getText();
    	String fecha = lista.get(1).getText();
    	String concepto = lista.get(2).getText();
    	String cantidad = lista.get(3).getText();
    	String tipo = ingresosTipoComboBox.getSelectedItem().toString();
    	
    	if(!(ingresosInputChecker())) {
    		
    	} else {    		
    		ContasocDAO.modificarDatosDobleEntrada("ingresos", "numSocio", socio, "fecha", fecha,
    				new String[] {"fecha","concepto","cantidad","tipo"},
    				new String[] {fecha,concepto,cantidad,tipo});
    		
    		for(JTextField tp:lista) {
    			tp.setText("");
    		}
    		ingresosLista.setText("");
    		ErrorHandler.ingresoModificado(Integer.valueOf(socio));
    	}
    	
    }
    
    private void eliminarIngreso() {
    	List<JTextField> lista = ingresosGetTextFields();
    	Integer socio = Integer.valueOf(lista.get(0).getText());
    	String fecha = lista.get(1).getText();
    
    	ContasocDAO.eliminarDatosDobleEntrada("ingresos", "numSocio", String.valueOf(socio), "fecha", fecha);
    	
    	for(JTextField tp:lista) {
			tp.setText("");
		}
    	ingresosLista.setText("");
    	ErrorHandler.ingresoEliminado(socio);
    }
    
    private List<JTextField> gastosGetTextFields(){
    	List<JTextField> aux = new ArrayList<JTextField>();
    	aux.add(gastosFechaField);
    	aux.add(gastosProveedorField);
    	aux.add(gastosConceptoField);
    	aux.add(gastosCantidadField);
    	aux.add(gastosFacturaField);
    	return aux;
    }
    
    private boolean pagosInputChecker() {
    	if(gastosFechaField.getText().equals("") ||
    			gastosProveedorField.getText().equals("") ||
    			gastosCantidadField.getText().equals("")) {		
			ErrorHandler.camposObligatoriosVacios();
			return false;
		}
    	if(gastosFechaField.getText().split("/").length==1 || gastosFechaField.getText().split("/")[2].length()>4) {
			ErrorHandler.errorAlLeerFecha("registro del pago");
			return false;
		}
    	if(!(Double.valueOf(gastosCantidadField.getText()) instanceof Double)) {
    		ErrorHandler.errorAlLeerCantidadNumerica(gastosCantidadField.getText());
    		return false;
    	}
    	return true;
    }
    
    private void añadirGasto() {
    	List<JTextField> lista = gastosGetTextFields();
    	String fecha = lista.get(0).getText();
    	String proveedor = lista.get(1).getText();
    	String concepto = lista.get(2).getText();
    	String cantidad = lista.get(3).getText();
    	String factura = lista.get(4).getText();
    	String tipo = gastosTipoComboBox.getSelectedItem().toString();
    	
    	if(!(pagosInputChecker())) {
    		
    	} else {
    		
    		ContasocDAO.agregarDatos("gastos", new String[] {fecha,proveedor,concepto,cantidad,factura,tipo});
    		
    		for(JTextField tp:lista) {
				tp.setText("");
			}
    		gastosLista.setText("");
    		ErrorHandler.pagoAgregado(factura);
    	}
    }
    
    private void buscarGasto() {
    	List<JTextField> lista = gastosGetTextFields();
    	String proveedor = lista.get(1).getText();
    	List<Pago> pagoList = ContasocDAO.buscarDatos("gastos", "proveedor", proveedor).stream().map(x->Parsers.pagoParser(x)).toList();
    	List<String> aux = new ArrayList<String>();
    	for(Pago p:pagoList) {
    		String str = String.join(";", List.of(
    				"Fecha: "+Parsers.dateParser(p.getFecha()),
    				"Concepto: "+p.getConcepto(),
    				"Cantidad: "+p.getCantidad().toString()+"€",
    				"Factura: "+p.getFactura(),
    				"Tipo: "+p.getTipo().name()));
    		aux.add(str);
    	}
    	List<String> test = new ArrayList<String>();
    	test.add(proveedor);
    	for(String s:aux) {
    		String[] t = s.split(";");
    		test.add(String.join("\n", t));
    	}
    	gastosLista.setText(test.get(0)+"\n\n"+String.join("\n\n",test.subList(1, test.size())));
    	
    }
    
    private void modificarGasto() {
    	List<JTextField> lista = gastosGetTextFields();
    	   	
    	String fecha = lista.get(0).getText();
    	String proveedor = lista.get(1).getText();
    	String concepto = lista.get(2).getText();
    	String cantidad = Parsers.decimalSymbolParser(lista.get(3).getText());
    	String factura = lista.get(4).getText();
    	String tipo = gastosTipoComboBox.getSelectedItem().toString();
    	    	
    	if(!(pagosInputChecker())) {
    		
    	} else {
    		ContasocDAO.modificarDatosDobleEntrada("gastos", "proveedor", proveedor, "fecha", fecha,
    				new String[] {"fecha","proveedor","concepto","cantidad","numFactura","tipo"},
    				new String[] {fecha,proveedor,concepto,cantidad,factura,tipo});
    		for(JTextField tp:lista) {
    			tp.setText("");
    		}
    		gastosLista.setText("");
    		
    		ErrorHandler.pagoModificado();
    	}
    	
    }
    
    private void eliminarGasto() {
    	List<JTextField> lista = gastosGetTextFields();
    	
    	String proveedor = lista.get(1).getText();
    	String factura = lista.get(4).getText();
    	
    	ContasocDAO.eliminarDatosDobleEntrada("gastos", "proveedor", proveedor, "numFactura", factura);
    	
    	for(JTextField tp:lista) {
			tp.setText("");
		}
		ingresosLista.setText("");
		ErrorHandler.pagoEliminado();
    }
    
    private List<JTextField> informeGetTextFields(){
    	List<JTextField> aux = new ArrayList<JTextField>();
    	aux.add(balanceInicialBancoField);
    	aux.add(balanceInicialCajaField);
    	return aux;
    }
    
    private void calcularBalance() {
    	List<JTextField> lista = informeGetTextFields();
    	Double banco = null;
    	Double caja = null;
    	
    	if(lista.get(0).getText().equals("") && lista.get(1).getText().equals("")) {
    		String[] aux = ContasocDAO.leerTabla("informe").get(0).split(";");
    		banco = Double.valueOf(aux[0].replace(",", ".").replace(" €", ""));
    		caja = Double.valueOf(aux[1].replace(",", ".").replace(" €", ""));
    	} else if(!(lista.get(0).getText().equals("") && lista.get(1).getText().equals(""))) {
    		banco = Double.valueOf(lista.get(0).getText().replace(",", ".").replace(" €", "")); 
        	caja = Double.valueOf(lista.get(1).getText().replace(",", ".").replace(" €", ""));
        	ContasocDAO.reemplazarPrimero(String.valueOf(banco),String.valueOf(caja));
    	}
    	List<Ingreso> ingresos = ContasocDAO.leerTabla("ingresos").stream()
    			.map(x->Parsers.ingresoParser(x)).toList(); 
    	List<Pago> gastos = ContasocDAO.leerTabla("gastos").stream()
    			.map(x->Parsers.pagoParser(x)).toList();
    	
    	Double totalIngresosBanco = ingresos.stream()
    			.filter(x->x.getTipo().equals(TipoRetribucion.BANCO))
    			.collect(Collectors.summingDouble(Ingreso::getCantidad));
    	Double totalIngresosCaja = ingresos.stream()
    			.filter(x->x.getTipo().equals(TipoRetribucion.CAJA))
    			.collect(Collectors.summingDouble(Ingreso::getCantidad));
    	Double totalPagosBanco = gastos.stream()
    			.filter(x->x.getTipo().equals(TipoRetribucion.BANCO))
    			.collect(Collectors.summingDouble(Pago::getCantidad));
    	Double totalPagosCaja = gastos.stream()
    			.filter(x->x.getTipo().equals(TipoRetribucion.CAJA))
    			.collect(Collectors.summingDouble(Pago::getCantidad));
    	
    	DecimalFormat df = new DecimalFormat("#.##");
    	df.setRoundingMode(RoundingMode.FLOOR);
        String total = df.format((banco+caja+totalIngresosBanco+totalIngresosCaja-totalPagosBanco-totalPagosCaja));
    	
    	balanceLista.setText("Inicial banco: " + banco + "€\n" +
    			"Inicial caja: " + caja + "€\n" + 
    			"Total ingresos banco: " + totalIngresosBanco + "€\n" +
    			"Total ingresos caja: " + totalIngresosCaja + "€\n" +
    			"Total pagos banco: " + totalPagosBanco + "€\n" +
    			"Total pagos caja: " + totalPagosCaja + "€\n" +
    			"-------------------\n" +
    			"Total: " + total + "€");
    }
    
    private void actualizar() {
        ContasocDAO.fillTableFromDatabase("hortelanos", (DefaultTableModel) sociosTabla.getModel());
        ContasocDAO.fillTableFromDatabaseIf("hortelanos", listaEsperaTabla);
    }
    
    private void sociosPrintView() {
    	valor="Socios";
        String nombreTabla = "hortelanos";
        List<String> columnas = Arrays.asList("Nombre", "Apellidos", "DNI", "Dirección", "Teléfono", "Correo", "Nº Socio", "Nº Huerto", "F. Alta", "F. Baja", "Estado", "Tipo");
        
        List<String> datosTabla = ContasocDAO.leerTabla(nombreTabla);
        
        imprimirLista.setText("");
        
        for (String dato : datosTabla) {
            String[] valores = dato.split(";");
            
            StringBuilder stringBuilder = new StringBuilder();
            
            for (int i = 0; i < columnas.size(); i++) {
                String columna = columnas.get(i);
                String valor = valores[i];
                
                stringBuilder.append(columna).append(": ").append(valor).append("\n");
            }
            
            imprimirLista.append(stringBuilder.toString() + "\n");
        }
    }

    
    private void ingresosPrintView() {
    	valor="Ingresos";
        String nombreTablaHortelanos = "hortelanos";
        String nombreTablaIngresos = "ingresos";
        
        List<String> datosHortelanos = ContasocDAO.leerTabla(nombreTablaHortelanos);
        List<String> datosIngresos = ContasocDAO.leerTabla(nombreTablaIngresos);
        
        imprimirLista.setText("");
        
        Set<Integer> sociosConIngresos = new HashSet<>();
        
        // Obtener los números de socio que tienen ingresos
        for (String datoIngreso : datosIngresos) {
            String[] valoresIngreso = datoIngreso.split(";");
            int numSocioIngreso = Integer.parseInt(valoresIngreso[0]);
            sociosConIngresos.add(numSocioIngreso);
        }
        
        for (String datoHortelano : datosHortelanos) {
            String[] valoresHortelano = datoHortelano.split(";");
            String nombre = valoresHortelano[2];
            int numSocio = Integer.parseInt(valoresHortelano[1]);
            
            if (!sociosConIngresos.contains(numSocio)) {
                continue; // Saltar a la siguiente iteración si el socio no tiene ingresos
            }
                        
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nombre).append(" (").append(numSocio).append(")\n");
            stringBuilder.append("=========================\n");
            
            for (String datoIngreso : datosIngresos) {
                String[] valoresIngreso = datoIngreso.split(";");
                int numSocioIngreso = Integer.parseInt(valoresIngreso[0]);
                
                if (numSocioIngreso == numSocio) {
                    List<String> i = Arrays.asList(valoresIngreso[1], valoresIngreso[2], valoresIngreso[3], valoresIngreso[4]);
                    stringBuilder.append("Fecha: ").append(i.get(0)).append("\n");
                    stringBuilder.append("Concepto: ").append(i.get(1)).append("\n");
                    stringBuilder.append("Cantidad: ").append(i.get(2)).append("\n");
                    stringBuilder.append("Tipo: ").append(i.get(3)).append("\n\n");
                }
            }
            
            imprimirLista.append(stringBuilder.toString());
        }
    }


    
    private void gastosPrintView() {
    	valor="Gastos";
        String nombreTabla = "gastos";
        List<String> columnas = Arrays.asList("Fecha", "Proveedor", "Concepto", "Cantidad", "Nº Factura", "Tipo");

        List<String> datosTabla = ContasocDAO.leerTabla(nombreTabla);

        imprimirLista.setText("");

        Map<String, List<String>> pagosPorProveedor = new HashMap<>();

        // Organizar los pagos por proveedor
        for (String dato : datosTabla) {
            String[] valores = dato.split(";");
            String proveedor = valores[1];
            List<String> pagosProveedor = pagosPorProveedor.getOrDefault(proveedor, new ArrayList<>());
            pagosProveedor.add(dato);
            pagosPorProveedor.put(proveedor, pagosProveedor);
        }

        // Imprimir los pagos por proveedor
        for (Map.Entry<String, List<String>> entry : pagosPorProveedor.entrySet()) {
            String proveedor = entry.getKey();
            List<String> pagosProveedor = entry.getValue();

            imprimirLista.append(proveedor + "\n");
            imprimirLista.append("==========\n");

            for (String dato : pagosProveedor) {
                String[] valores = dato.split(";");

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < columnas.size(); i++) {
                    String columna = columnas.get(i);
                    String valor = valores[i];

                    stringBuilder.append(columna).append(": ").append(valor).append("\n");
                }

                imprimirLista.append(stringBuilder.toString() + "\n");
            }

            imprimirLista.append("\n");
        }
    }
    
    private void listaEsperaPrintView() {
    	valor="ListaEspera";
        String nombreTabla = "hortelanos";

        List<Hortelano> datosTabla = ContasocDAO.leerTabla(nombreTabla).stream()
        		.map(x->Parsers.hortelanoParser(x))
        		.filter(x->x.getTipo().equals(TipoHortelano.LISTA_ESPERA)).toList();

        imprimirLista.setText("");

        int i = 1;
    	for(Hortelano h:datosTabla) {
    		imprimirLista.append("Posición " + i + " en la lista de espera" + "\n" +
    				"=============================================" + "\n" +
    				"Nº de huerto: " + h.getHuerto() + "\n" +
    				"Nº de socio: " + h.getSocio() + "\n" +
    				"Nombre: " + h.getPersona().getNombre() + "\n" + 
    				"DNI: " + h.getPersona().getDni() + "\n" +
    				"Teléfono: " + h.getPersona().getTelefono() + "\n" +
    				"Correo: " + h.getPersona().getCorreo() + "\n" +
    				"Fecha de alta: " + Parsers.dateParser(h.getAlta()) + "\n" +
    				"Fecha de entrega: " + Parsers.dateParser(h.getEntrega()) + "\n" +
    				"Fecha de baja: " + Parsers.printDateParser(h.getBaja()) + "\n" +
    				"Notas: " + h.getNotas() + "\n" +
    				"Tipo: " + h.getTipo().toString().replace("_", " DE ") + "\n" +
    				"Estado: " + h.getEstado() +"\n\n"
    				);
    		i++;
    	}
    }

    private void printContent() {
        List<String> hortelanos = new ArrayList<>();
        List<String> listaEspera = new ArrayList<>();
        for(Hortelano h:ContasocDAO.leerTabla("hortelanos").stream()
        		.map(x->Parsers.hortelanoParser(x)).toList()) {
            if(h.getEstado()!=Estado.INACTIVO){
                hortelanos.add(
                		h.getHuerto()+";"+
                		h.getSocio()+";"+
                		h.getPersona().getNombre()+";"+
                		h.getPersona().getDni()+";"+
                		h.getPersona().getTelefono()+";"+
                		h.getPersona().getCorreo()+";"+
                		Parsers.printDateParser(h.getAlta())+";"+
                		Parsers.printDateParser(h.getEntrega())+";"+
                		h.getNotas()+";"+
                		h.getTipo().toString().replace("A_E", "A DE E").replace("O_INVERNADERO", "O + INV")+";"+
                		h.getEstado());
                		                
            }
            
            if(h.getTipo()==TipoHortelano.LISTA_ESPERA){
            	listaEspera.add(
                		h.getSocio()+";"+
                        h.getPersona().getNombre()+";"+
                        h.getPersona().getTelefono()+";"+
                        h.getPersona().getCorreo()+";"+
                        Parsers.printDateParser(h.getAlta()));
            }
        }
        List<String> ingresos = new ArrayList<>();
        for(Ingreso i:ContasocDAO.leerTabla("ingresos").stream()
        		.map(x->Parsers.ingresoParser(x)).toList()) {
        	String[] ingArr = i.toString().split(";");
        	ingresos.add(ingArr[0]+";"+
        			ContasocDAO.getValorPorPropiedad("hortelanos", "numSocio", ingArr[0], "nombre")+";"+
        			ingArr[1]+";"+ingArr[2]+";"+ingArr[3]+";"+ingArr[4]
        			);  
        }
        List<String> gastos = new ArrayList<>();
        for(Pago p:ContasocDAO.leerTabla("gastos").stream()
        		.map(x->Parsers.pagoParser(x)).toList()) {
        	gastos.add(p.toString());
        }
        if(valor=="Socios") {
            PDFPrinter.printStringToPDF(
            hortelanos,
            11,
            new float[] { 15f, 20f, 170f, 50f, 145f, 45f, 45f, 45f, 45f, 180f, 80f},
            "logohuerto_sinletras.png",
            "Listado de socios",
            true,
            new String[] {"H","S","Nombre","DNI","Teléfono","Correo","Alta","Entrega","Baja","Notas","Tipo"},
            true,
            8,
            Main.ESCRITORIO+"/socios.pdf"
            );
            ErrorHandler.pdfCreado();
        } else if(valor=="Ingresos") {
            PDFPrinter.printStringToPDF(
            ingresos,
            6,
            new float[] { 35f, 170f, 50f, 70f, 45f, 90f },
            "logohuerto_sinletras.png",
            "Listado de ingresos",
            true,
            new String[] {"Nº socio","Nombre y apellidos","Fecha","Concepto","Cantidad","Tipo"},
            false,
            10,
            Main.ESCRITORIO+"/ingresos.pdf"
            );
            ErrorHandler.pdfCreado();
        } else if(valor=="Gastos") {
            PDFPrinter.printStringToPDF(
            gastos,
            6,
            new float[] { 55f, 90f, 150f, 45f, 75f, 90f },
            "logohuerto_sinletras.png",
            "Listado de pagos",
            true,
            new String[] {"Fecha","Proveedor","Concepto","Cantidad","Nº Factura","Tipo"},
            false,
            10,
            Main.ESCRITORIO+"/gastos.pdf"
            );
            ErrorHandler.pdfCreado();
        } else if(valor=="ListaEspera") {
            PDFPrinter.printStringToPDF(
            listaEspera,
            5,
            new float[] { 40f, 170f, 65f, 145f, 45f},
            "logohuerto_sinletras.png",
            "Lista de espera",
            true,
            new String[] {"Nº Socio","Nombre y apellidos","Teléfono","Correo","F. Alta"},
            false,
            10,
            Main.ESCRITORIO+"/lista_de_espera.pdf"
            );
            ErrorHandler.pdfCreado();
        }
    }
    
    private void actualizarSociosTabla() {
        ((DefaultTableModel) sociosTabla.getModel()).setRowCount(0);
        ContasocDAO.fillTableFromDatabase("hortelanos", (DefaultTableModel) sociosTabla.getModel());
    }
    
    private void setTableSorter() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(sociosTabla.getModel());
        sociosTabla.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        inicioPanel = new javax.swing.JPanel();
        txtBtnPanel = new javax.swing.JPanel();
        asociacionLabel = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        correoLabel = new javax.swing.JLabel();
        entrarBtn = new javax.swing.JButton();
        bgPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        appPanel = new javax.swing.JTabbedPane();
        sociosPanel = new javax.swing.JPanel();
        sociosFields = new javax.swing.JPanel();
        sociosNHuertoLabel = new javax.swing.JLabel();
        sociosNHuertoField = new javax.swing.JTextField();
        sociosNSocioLabel = new javax.swing.JLabel();
        sociosNSocioField = new javax.swing.JTextField();
        sociosNombreLabel = new javax.swing.JLabel();
        sociosNombreField = new javax.swing.JTextField();
        sociosDniLabel = new javax.swing.JLabel();
        sociosDniField = new javax.swing.JFormattedTextField();
        sociosTelefonoLabel = new javax.swing.JLabel();
        sociosTelefonoField = new javax.swing.JFormattedTextField();
        sociosCorreoLabel = new javax.swing.JLabel();
        sociosCorreoField = new javax.swing.JTextField();
        sociosFechaAltaLabel = new javax.swing.JLabel();
        sociosFechaAltaField = new javax.swing.JTextField();
        sociosFechaEntregaLabel = new javax.swing.JLabel();
        sociosFechaEntregaField = new javax.swing.JTextField();
        sociosFechaBajaLabel = new javax.swing.JLabel();
        sociosFechaBajaField = new javax.swing.JTextField();
        sociosNotasLabel = new javax.swing.JLabel();
        sociosNotasField = new javax.swing.JTextField();
        sociosTipoLabel = new javax.swing.JLabel();
        sociosTipoComboBox = new javax.swing.JComboBox<>();
        sociosEstadoLabel = new javax.swing.JLabel();
        sociosEstadoField = new javax.swing.JTextField();
        sociosTablaPanel = new javax.swing.JScrollPane();
        sociosTabla = new javax.swing.JTable();
        ingresosPanel = new javax.swing.JPanel();
        ingresosDataPanel = new javax.swing.JPanel();
        ingresosNSocioLabel = new javax.swing.JLabel();
        ingresosNSocioField = new javax.swing.JTextField();
        ingresosFechaLabel = new javax.swing.JLabel();
        ingresosFechaField = new javax.swing.JFormattedTextField();
        ingresosConceptoLabel = new javax.swing.JLabel();
        ingresosConceptoField = new javax.swing.JTextField();
        ingresosCantidadLabel = new javax.swing.JLabel();
        ingresosCantidadField = new javax.swing.JTextField();
        ingresosCuotaLabel = new javax.swing.JLabel();
        ingresosTipoComboBox = new javax.swing.JComboBox<>();
        ingresosListaPanel = new javax.swing.JScrollPane();
        ingresosLista = new javax.swing.JTextArea();
        ingresosAgregarBtn = new javax.swing.JButton();
        ingresosBuscarBtn = new javax.swing.JButton();
        ingresosModificarBtn = new javax.swing.JButton();
        ingresosEliminarBtn = new javax.swing.JButton();
        gastosPanel = new javax.swing.JPanel();
        gastosDataPanel = new javax.swing.JPanel();
        gastosFechaLabel = new javax.swing.JLabel();
        gastosFechaField = new javax.swing.JFormattedTextField();
        gastosProveedorLabel = new javax.swing.JLabel();
        gastosProveedorField = new javax.swing.JTextField();
        gastosConceptoLabel = new javax.swing.JLabel();
        gastosConceptoField = new javax.swing.JTextField();
        gastosCantidadLabel = new javax.swing.JLabel();
        gastosCantidadField = new javax.swing.JTextField();
        gastosFacturaLabel = new javax.swing.JLabel();
        gastosFacturaField = new javax.swing.JTextField();
        gastosTipoLabel = new javax.swing.JLabel();
        gastosTipoComboBox = new javax.swing.JComboBox<>();
        gastosListaPanel = new javax.swing.JScrollPane();
        gastosLista = new javax.swing.JTextArea();
        gastosAgregarBtn = new javax.swing.JButton();
        gastosBuscarBtn = new javax.swing.JButton();
        gastosModificarBtn = new javax.swing.JButton();
        gastosEliminarBtn = new javax.swing.JButton();
        balancePanel = new javax.swing.JPanel();
        balanceDataPanel = new javax.swing.JPanel();
        balanceListaPanel = new javax.swing.JScrollPane();
        balanceLista = new javax.swing.JTextArea();
        balanceInicialBancoField = new javax.swing.JFormattedTextField();
        balanceInicialCajaField = new javax.swing.JFormattedTextField();
        balanceCalcular = new javax.swing.JButton();
        listaEsperaPanel = new javax.swing.JPanel();
        listaEsperaDataPanel = new javax.swing.JPanel();
        listaEsperaListaPanel = new javax.swing.JScrollPane();
        listaEsperaTabla = new javax.swing.JTable();
        listaEsperaActualizarBtn = new javax.swing.JButton();
        imprimirPanel = new javax.swing.JPanel();
        imprimirDataPanel = new javax.swing.JPanel();
        imprimirListaPanel = new javax.swing.JScrollPane();
        imprimirLista = new javax.swing.JTextArea();
        imprimirBtnsPanel = new javax.swing.JPanel();
        imprimirSociosBtn = new javax.swing.JButton();
        imprimirIngresosBtn = new javax.swing.JButton();
        imprimirGastosBtn = new javax.swing.JButton();
        imprimirListaEsperaBtn = new javax.swing.JButton();
        imprimirPrinterBtn = new javax.swing.JButton();
        emailPanel = new javax.swing.JPanel();
        emailDataPanel = new javax.swing.JPanel();
        emailListaPanel = new javax.swing.JScrollPane();
        emailLista = new javax.swing.JEditorPane();
        emailDestinatarioLabel = new javax.swing.JLabel();
        emailDestinatarioField = new javax.swing.JTextField();
        emailAsuntoLabel = new javax.swing.JLabel();
        emailAsuntoField = new javax.swing.JTextField();
        emailEnviarBtn = new javax.swing.JButton();
        emailBorradorBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Main.VERSION_APP);
        setBackground(new java.awt.Color(255, 255, 255));
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setLocationByPlatform(true);

        inicioPanel.setName("inicioPanel"); // NOI18N
        inicioPanel.setOpaque(false);

        txtBtnPanel.setBackground(new java.awt.Color(0, 0, 0));
        txtBtnPanel.setOpaque(false);

        asociacionLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        asociacionLabel.setForeground(new java.awt.Color(255, 255, 255));
        asociacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asociacionLabel.setText("Asociación Huertos la Salud Bellavista");
        asociacionLabel.setPreferredSize(new java.awt.Dimension(638, 48));

        direccionLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direccionLabel.setForeground(new java.awt.Color(255, 255, 255));
        direccionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direccionLabel.setText("C/ Cronos, SN Bellavista, Sevilla 4014");

        correoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        correoLabel.setForeground(new java.awt.Color(255, 255, 255));
        correoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correoLabel.setText("huertoslasaludbellavista@gmail.com");

        entrarBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        entrarBtn.setLabel("ENTRAR");
        entrarBtn.setPreferredSize(new java.awt.Dimension(202, 32));

        entrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtBtnPanelLayout = new javax.swing.GroupLayout(txtBtnPanel);
        txtBtnPanel.setLayout(txtBtnPanelLayout);
        txtBtnPanelLayout.setHorizontalGroup(
            txtBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtBtnPanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(txtBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asociacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionLabel)
                    .addComponent(correoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtBtnPanelLayout.createSequentialGroup()
                        .addComponent(entrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        txtBtnPanelLayout.setVerticalGroup(
            txtBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtBtnPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(asociacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(direccionLabel)
                .addGap(6, 6, 6)
                .addComponent(correoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addComponent(entrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setMinimumSize(new java.awt.Dimension(900, 600));
        bgPanel.setOpaque(false);

        jLabel1.setPreferredSize(new java.awt.Dimension(900, 0));

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inicioPanelLayout = new javax.swing.GroupLayout(inicioPanel);
        inicioPanel.setLayout(inicioPanelLayout);
        inicioPanelLayout.setHorizontalGroup(
            inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inicioPanelLayout.setVerticalGroup(
            inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        appPanel.setBackground(new java.awt.Color(1, 102, 255));
        appPanel.setForeground(new java.awt.Color(255, 255, 255));
        appPanel.setName("tabbedPanel"); // NOI18N
        appPanel.setOpaque(true);

        sociosPanel.setBackground(new java.awt.Color(70, 73, 75));
        sociosPanel.setName("sociosPanel"); // NOI18N

        sociosFields.setBackground(new java.awt.Color(70, 73, 75));
        sociosFields.setForeground(new java.awt.Color(255, 255, 255));

        sociosNHuertoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosNHuertoLabel.setText("Nº huerto:");

        sociosNHuertoField.setNextFocusableComponent(sociosNSocioField);
        sociosNHuertoField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosNHuertoFieldKeyPressed(evt);
        	}
        });

        sociosNSocioLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosNSocioLabel.setText("Nº socio:");

        sociosNSocioField.setNextFocusableComponent(sociosNombreField);
        sociosNSocioField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosNSocioFieldKeyPressed(evt);
        	}
        });

        sociosNombreLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosNombreLabel.setText("Nombre:");

        sociosNombreField.setNextFocusableComponent(sociosDniField);
        sociosNombreField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosNombreFieldKeyPressed(evt);
        	}
        });

        sociosDniLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosDniLabel.setText("DNI:");

        try {
            sociosDniField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        sociosDniField.setNextFocusableComponent(sociosTelefonoField);
        sociosDniField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosDniFieldKeyPressed(evt);
        	}
        });

        sociosTelefonoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosTelefonoLabel.setText("Teléfono:");

        try {
            sociosTelefonoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+34 ### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        sociosTelefonoField.setNextFocusableComponent(sociosCorreoField);
        sociosTelefonoField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosTelefonoFieldKeyPressed(evt);
        	}
        });

        sociosCorreoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosCorreoLabel.setText("Correo:");
        sociosCorreoField.setNextFocusableComponent(sociosFechaAltaField);
        sociosCorreoField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosCorreoFieldKeyPressed(evt);
        	}
        });

        sociosFechaAltaLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosFechaAltaLabel.setText("F. de Alta:");
        sociosFechaAltaField.setNextFocusableComponent(sociosFechaEntregaField);
        sociosDniField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosFechaAltaFieldKeyPressed(evt);
        	}
        });

        sociosFechaEntregaLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosFechaEntregaLabel.setText("F. de Entrega:");
        sociosFechaEntregaField.setNextFocusableComponent(sociosFechaBajaField);
        sociosFechaEntregaField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosFechaEntregaFieldKeyPressed(evt);
        	}
        });

        sociosFechaBajaLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosFechaBajaLabel.setText("F. de Baja:");
        sociosFechaBajaField.setNextFocusableComponent(sociosNotasField);
        sociosDniField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosFechaBajaFieldKeyPressed(evt);
        	}
        });

        sociosNotasLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosNotasLabel.setText("Notas:");

        sociosNotasField.setNextFocusableComponent(sociosTipoComboBox);
        sociosNotasField.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		sociosNotasFieldKeyPressed(evt);
        	}
        });

        sociosTipoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosTipoLabel.setText("Tipo:");

        sociosTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HORTELANO", "HORTELANO + INV", "LISTA DE ESPERA", "COLABORADOR" }));
        sociosTipoComboBox.setNextFocusableComponent(appPanel);

        sociosEstadoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sociosEstadoLabel.setText("Estado:");

        javax.swing.GroupLayout sociosFieldsLayout = new javax.swing.GroupLayout(sociosFields);
        sociosFields.setLayout(sociosFieldsLayout);
        sociosFieldsLayout.setHorizontalGroup(
            sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sociosFieldsLayout.createSequentialGroup()
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosNHuertoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosNHuertoField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosNSocioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosNSocioField))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sociosDniLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sociosNombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sociosDniField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(sociosNombreField))))
                .addGap(18, 18, 18)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosTelefonoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosTelefonoField, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosCorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosCorreoField))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosFechaEntregaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosFechaEntregaField))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosFechaAltaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosFechaAltaField)))
                .addGap(18, 18, 18)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosTipoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosTipoComboBox, 0, 194, Short.MAX_VALUE))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addComponent(sociosEstadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sociosEstadoField))
                    .addGroup(sociosFieldsLayout.createSequentialGroup()
                        .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sociosFechaBajaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(sociosNotasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sociosNotasField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(sociosFechaBajaField)))))
        );
        sociosFieldsLayout.setVerticalGroup(
            sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sociosFieldsLayout.createSequentialGroup()
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosNHuertoLabel)
                    .addComponent(sociosNHuertoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosNSocioLabel)
                    .addComponent(sociosNSocioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosNombreLabel)
                    .addComponent(sociosNombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosDniLabel)
                    .addComponent(sociosDniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(sociosFieldsLayout.createSequentialGroup()
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosTelefonoLabel)
                    .addComponent(sociosTelefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosCorreoLabel)
                    .addComponent(sociosCorreoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosFechaAltaLabel)
                    .addComponent(sociosFechaAltaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosFechaEntregaLabel)
                    .addComponent(sociosFechaEntregaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(sociosFieldsLayout.createSequentialGroup()
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosFechaBajaLabel)
                    .addComponent(sociosFechaBajaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosNotasLabel)
                    .addComponent(sociosNotasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosTipoLabel)
                    .addComponent(sociosTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sociosFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sociosEstadoLabel)
                    .addComponent(sociosEstadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        sociosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº huerto", "Nº socio", "Nombre", "DNI", "Teléfono", "Correo", "F. Alta", "F. Entrega", "F. Baja", "Notas", "Tipo", "Estado"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sociosTabla.setFocusable(true);
        sociosTabla.setShowGrid(false);
        sociosTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sociosTablaMouseClicked(evt);
            }
        });
        sociosTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sociosTablaKeyPressed(evt);
            }
        });
        sociosTablaPanel.setViewportView(sociosTabla);

        javax.swing.GroupLayout sociosPanelLayout = new javax.swing.GroupLayout(sociosPanel);
        sociosPanel.setLayout(sociosPanelLayout);
        sociosPanelLayout.setHorizontalGroup(
            sociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sociosPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(sociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sociosFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sociosTablaPanel))
                .addGap(18, 18, 18))
        );
        sociosPanelLayout.setVerticalGroup(
            sociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sociosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sociosFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sociosTablaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        appPanel.addTab("Socios", sociosPanel);
        sociosPanel.getAccessibleContext().setAccessibleName("socios");

        ingresosDataPanel.setBackground(new java.awt.Color(70, 73, 75));
        ingresosDataPanel.setName("Ingresos"); // NOI18N
        ingresosDataPanel.setPreferredSize(new java.awt.Dimension(648, 549));

        ingresosNSocioLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresosNSocioLabel.setText("Número de socio:");

        ingresosFechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresosFechaLabel.setText("Fecha:");

        try {
            ingresosFechaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ingresosConceptoLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresosConceptoLabel.setText("Concepto:");

        ingresosCantidadLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresosCantidadLabel.setText("Cantidad:");

        ingresosCuotaLabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresosCuotaLabel.setText("ingresosTipoLabel");

        ingresosTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BANCO", "CAJA" }));

        ingresosLista.setColumns(20);
        ingresosLista.setRows(5);
        ingresosLista.setFocusable(false);
        ingresosListaPanel.setViewportView(ingresosLista);

        ingresosAgregarBtn.setBackground(new java.awt.Color(1, 102, 255));
        ingresosAgregarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ingresosAgregarBtn.setForeground(new java.awt.Color(255, 255, 255));
        ingresosAgregarBtn.setText("AGREGAR");
        ingresosAgregarBtn.setFocusable(false);
        ingresosAgregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresosAgregarBtnActionPerformed(evt);
            }
        });

        ingresosBuscarBtn.setBackground(new java.awt.Color(1, 102, 255));
        ingresosBuscarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ingresosBuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        ingresosBuscarBtn.setText("BUSCAR");
        ingresosBuscarBtn.setFocusable(false);
        ingresosBuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresosBuscarBtnActionPerformed(evt);
            }
        });

        ingresosModificarBtn.setBackground(new java.awt.Color(1, 102, 255));
        ingresosModificarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ingresosModificarBtn.setForeground(new java.awt.Color(255, 255, 255));
        ingresosModificarBtn.setText("MODIFICAR");
        ingresosModificarBtn.setFocusable(false);
        ingresosModificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresosModificarBtnActionPerformed(evt);
            }
        });

        ingresosEliminarBtn.setBackground(new java.awt.Color(1, 102, 255));
        ingresosEliminarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ingresosEliminarBtn.setForeground(new java.awt.Color(255, 255, 255));
        ingresosEliminarBtn.setText("ELIMINAR");
        ingresosEliminarBtn.setFocusable(false);
        ingresosEliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresosEliminarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ingresosDataPanelLayout = new javax.swing.GroupLayout(ingresosDataPanel);
        ingresosDataPanel.setLayout(ingresosDataPanelLayout);
        ingresosDataPanelLayout.setHorizontalGroup(
            ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresosDataPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ingresosDataPanelLayout.createSequentialGroup()
                            .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ingresosCantidadLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ingresosNSocioLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ingresosFechaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ingresosConceptoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ingresosCuotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ingresosTipoComboBox, 0, 120, Short.MAX_VALUE)
                                .addComponent(ingresosFechaField)
                                .addComponent(ingresosConceptoField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ingresosCantidadField)
                                .addComponent(ingresosNSocioField, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(ingresosAgregarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ingresosBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresosModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresosEliminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ingresosListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        ingresosDataPanelLayout.setVerticalGroup(
            ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresosDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ingresosDataPanelLayout.createSequentialGroup()
                        .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresosNSocioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresosNSocioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresosFechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresosFechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresosConceptoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresosConceptoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresosCantidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresosCantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(ingresosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresosCuotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresosTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(ingresosAgregarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresosBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresosModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresosEliminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ingresosListaPanel))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout ingresosPanelLayout = new javax.swing.GroupLayout(ingresosPanel);
        ingresosPanel.setLayout(ingresosPanelLayout);
        ingresosPanelLayout.setHorizontalGroup(
            ingresosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ingresosDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        ingresosPanelLayout.setVerticalGroup(
            ingresosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ingresosDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        appPanel.addTab("Ingresos", ingresosPanel);

        gastosDataPanel.setBackground(new java.awt.Color(70, 73, 75));
        gastosDataPanel.setName("Ingresos"); // NOI18N
        gastosDataPanel.setPreferredSize(new java.awt.Dimension(648, 549));

        gastosFechaLabel.setForeground(new java.awt.Color(255, 255, 255));
        gastosFechaLabel.setText("Fecha:");

        try {
            gastosFechaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        gastosProveedorLabel.setForeground(new java.awt.Color(255, 255, 255));
        gastosProveedorLabel.setText("Proveedor:");

        gastosConceptoLabel.setForeground(new java.awt.Color(255, 255, 255));
        gastosConceptoLabel.setText("Concepto:");

        gastosCantidadLabel.setForeground(new java.awt.Color(255, 255, 255));
        gastosCantidadLabel.setText("Cantidad:");

        gastosFacturaLabel.setForeground(new java.awt.Color(255, 255, 255));
        gastosFacturaLabel.setText("Factura");

        gastosTipoLabel.setForeground(new java.awt.Color(255, 255, 255));
        gastosTipoLabel.setText("Tipo:");

        gastosTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BANCO", "CAJA" }));

        gastosLista.setColumns(20);
        gastosLista.setRows(5);
        gastosLista.setFocusable(false);
        gastosListaPanel.setViewportView(gastosLista);

        gastosAgregarBtn.setBackground(new java.awt.Color(1, 102, 255));
        gastosAgregarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gastosAgregarBtn.setForeground(new java.awt.Color(255, 255, 255));
        gastosAgregarBtn.setText("AGREGAR");
        gastosAgregarBtn.setFocusable(false);
        gastosAgregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastosAgregarBtnActionPerformed(evt);
            }
        });

        gastosBuscarBtn.setBackground(new java.awt.Color(1, 102, 255));
        gastosBuscarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gastosBuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        gastosBuscarBtn.setText("BUSCAR");
        gastosBuscarBtn.setFocusable(false);
        gastosBuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastosBuscarBtnActionPerformed(evt);
            }
        });

        gastosModificarBtn.setBackground(new java.awt.Color(1, 102, 255));
        gastosModificarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gastosModificarBtn.setForeground(new java.awt.Color(255, 255, 255));
        gastosModificarBtn.setText("MODIFICAR");
        gastosModificarBtn.setFocusable(false);
        gastosModificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastosModificarBtnActionPerformed(evt);
            }
        });

        gastosEliminarBtn.setBackground(new java.awt.Color(1, 102, 255));
        gastosEliminarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gastosEliminarBtn.setForeground(new java.awt.Color(255, 255, 255));
        gastosEliminarBtn.setText("ELIMINAR");
        gastosEliminarBtn.setFocusable(false);
        gastosEliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastosEliminarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gastosDataPanelLayout = new javax.swing.GroupLayout(gastosDataPanel);
        gastosDataPanel.setLayout(gastosDataPanelLayout);
        gastosDataPanelLayout.setHorizontalGroup(
            gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gastosDataPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gastosAgregarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(gastosDataPanelLayout.createSequentialGroup()
                            .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gastosTipoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(gastosCantidadLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gastosFechaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gastosProveedorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gastosConceptoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gastosFacturaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gastosTipoComboBox, 0, 120, Short.MAX_VALUE)
                                    .addComponent(gastosFechaField)
                                    .addComponent(gastosConceptoField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gastosCantidadField)
                                    .addComponent(gastosFacturaField))
                                .addComponent(gastosProveedorField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(gastosBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gastosModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gastosEliminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(gastosListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        gastosDataPanelLayout.setVerticalGroup(
            gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gastosDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gastosDataPanelLayout.createSequentialGroup()
                        .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastosFechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastosFechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastosProveedorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastosProveedorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastosConceptoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastosConceptoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastosCantidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastosCantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastosFacturaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastosFacturaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gastosDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gastosTipoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gastosTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(gastosAgregarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gastosBuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gastosModificarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gastosEliminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gastosListaPanel))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout gastosPanelLayout = new javax.swing.GroupLayout(gastosPanel);
        gastosPanel.setLayout(gastosPanelLayout);
        gastosPanelLayout.setHorizontalGroup(
            gastosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gastosDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        gastosPanelLayout.setVerticalGroup(
            gastosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gastosDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        appPanel.addTab("Gastos", gastosPanel);

        balanceDataPanel.setBackground(new java.awt.Color(70, 73, 75));
        balanceDataPanel.setName("Informe"); // NOI18N
        balanceDataPanel.setPreferredSize(new java.awt.Dimension(648, 549));

        balanceLista.setColumns(20);
        balanceLista.setRows(5);
        balanceLista.setFocusable(false);
        balanceLista.setPreferredSize(new java.awt.Dimension(232, 491));
        balanceListaPanel.setViewportView(balanceLista);

        try {
            balanceInicialBancoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####,## €")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        balanceInicialBancoField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balanceInicialBancoField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        try {
            balanceInicialCajaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####,## €")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        balanceInicialCajaField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balanceInicialCajaField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        balanceCalcular.setBackground(new java.awt.Color(1, 102, 255));
        balanceCalcular.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        balanceCalcular.setForeground(new java.awt.Color(255, 255, 255));
        balanceCalcular.setText("CALCULAR");
        balanceCalcular.setFocusable(false);
        balanceCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout balanceDataPanelLayout = new javax.swing.GroupLayout(balanceDataPanel);
        balanceDataPanel.setLayout(balanceDataPanelLayout);
        balanceDataPanelLayout.setHorizontalGroup(
            balanceDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(balanceDataPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(balanceDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceListaPanel)
                    .addGroup(balanceDataPanelLayout.createSequentialGroup()
                        .addComponent(balanceInicialBancoField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(balanceInicialCajaField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(balanceCalcular)
                        .addGap(0, 318, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        balanceDataPanelLayout.setVerticalGroup(
            balanceDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(balanceDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balanceListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(balanceDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(balanceCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balanceInicialBancoField)
                    .addComponent(balanceInicialCajaField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout balancePanelLayout = new javax.swing.GroupLayout(balancePanel);
        balancePanel.setLayout(balancePanelLayout);
        balancePanelLayout.setHorizontalGroup(
            balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(balanceDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        balancePanelLayout.setVerticalGroup(
            balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(balancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(balanceDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        appPanel.addTab("Balance", balancePanel);

        listaEsperaDataPanel.setBackground(new java.awt.Color(70, 73, 75));
        listaEsperaDataPanel.setName("ListaEspera"); // NOI18N
        listaEsperaDataPanel.setPreferredSize(new java.awt.Dimension(648, 549));

        listaEsperaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº socio", "Nombre", "Teléfono", "Email", "Fecha de Alta"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaEsperaTabla.setFocusable(false);
        listaEsperaListaPanel.setViewportView(listaEsperaTabla);

        listaEsperaActualizarBtn.setBackground(new java.awt.Color(1, 102, 255));
        listaEsperaActualizarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        listaEsperaActualizarBtn.setForeground(new java.awt.Color(255, 255, 255));
        listaEsperaActualizarBtn.setText("ACTUALIZAR");
        listaEsperaActualizarBtn.setFocusable(false);
        listaEsperaActualizarBtn.setMaximumSize(new java.awt.Dimension(164, 38));
        listaEsperaActualizarBtn.setMinimumSize(new java.awt.Dimension(164, 38));
        listaEsperaActualizarBtn.setPreferredSize(new java.awt.Dimension(164, 38));
        listaEsperaActualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEsperaActualizarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listaEsperaDataPanelLayout = new javax.swing.GroupLayout(listaEsperaDataPanel);
        listaEsperaDataPanel.setLayout(listaEsperaDataPanelLayout);
        listaEsperaDataPanelLayout.setHorizontalGroup(
            listaEsperaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaEsperaDataPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(listaEsperaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listaEsperaDataPanelLayout.createSequentialGroup()
                        .addComponent(listaEsperaActualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(listaEsperaDataPanelLayout.createSequentialGroup()
                        .addComponent(listaEsperaListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        listaEsperaDataPanelLayout.setVerticalGroup(
            listaEsperaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaEsperaDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaEsperaListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaEsperaActualizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout listaEsperaPanelLayout = new javax.swing.GroupLayout(listaEsperaPanel);
        listaEsperaPanel.setLayout(listaEsperaPanelLayout);
        listaEsperaPanelLayout.setHorizontalGroup(
            listaEsperaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(listaEsperaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listaEsperaDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        listaEsperaPanelLayout.setVerticalGroup(
            listaEsperaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(listaEsperaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listaEsperaDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        appPanel.addTab("Lista de espera", listaEsperaPanel);

        imprimirDataPanel.setBackground(new java.awt.Color(70, 73, 75));
        imprimirDataPanel.setName("ListaEspera"); // NOI18N
        imprimirDataPanel.setPreferredSize(new java.awt.Dimension(648, 549));

        imprimirLista.setColumns(20);
        imprimirLista.setRows(5);
        imprimirLista.setFocusable(false);
        imprimirListaPanel.setViewportView(imprimirLista);

        imprimirBtnsPanel.setBackground(new java.awt.Color(70, 73, 75));
        imprimirBtnsPanel.setOpaque(false);

        imprimirSociosBtn.setBackground(new java.awt.Color(1, 102, 255));
        imprimirSociosBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        imprimirSociosBtn.setForeground(new java.awt.Color(255, 255, 255));
        imprimirSociosBtn.setText("SOCIOS");
        imprimirSociosBtn.setFocusable(false);
        imprimirSociosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirSociosBtnActionPerformed(evt);
            }
        });

        imprimirIngresosBtn.setBackground(new java.awt.Color(1, 102, 255));
        imprimirIngresosBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        imprimirIngresosBtn.setForeground(new java.awt.Color(255, 255, 255));
        imprimirIngresosBtn.setText("INGRESOS");
        imprimirIngresosBtn.setFocusable(false);
        imprimirIngresosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirIngresosBtnActionPerformed(evt);
            }
        });

        imprimirGastosBtn.setBackground(new java.awt.Color(1, 102, 255));
        imprimirGastosBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        imprimirGastosBtn.setForeground(new java.awt.Color(255, 255, 255));
        imprimirGastosBtn.setText("GASTOS");
        imprimirGastosBtn.setFocusable(false);
        imprimirGastosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirGastosBtnActionPerformed(evt);
            }
        });

        imprimirListaEsperaBtn.setBackground(new java.awt.Color(1, 102, 255));
        imprimirListaEsperaBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        imprimirListaEsperaBtn.setForeground(new java.awt.Color(255, 255, 255));
        imprimirListaEsperaBtn.setText("LISTA DE ESPERA");
        imprimirListaEsperaBtn.setFocusable(false);
        imprimirListaEsperaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirListaEsperaBtnActionPerformed(evt);
            }
        });

        imprimirPrinterBtn.setBackground(new java.awt.Color(1, 102, 255));
        imprimirPrinterBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        imprimirPrinterBtn.setForeground(new java.awt.Color(255, 255, 255));
        imprimirPrinterBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/printer_small.png"))); // NOI18N
        imprimirPrinterBtn.setFocusable(false);
        imprimirPrinterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirPrinterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imprimirBtnsPanelLayout = new javax.swing.GroupLayout(imprimirBtnsPanel);
        imprimirBtnsPanel.setLayout(imprimirBtnsPanelLayout);
        imprimirBtnsPanelLayout.setHorizontalGroup(
            imprimirBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imprimirBtnsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(imprimirBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imprimirSociosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimirIngresosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(imprimirPrinterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(imprimirBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imprimirGastosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimirListaEsperaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imprimirBtnsPanelLayout.setVerticalGroup(
            imprimirBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imprimirBtnsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imprimirBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imprimirBtnsPanelLayout.createSequentialGroup()
                        .addComponent(imprimirSociosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimirIngresosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(imprimirBtnsPanelLayout.createSequentialGroup()
                        .addComponent(imprimirGastosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imprimirListaEsperaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imprimirPrinterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout imprimirDataPanelLayout = new javax.swing.GroupLayout(imprimirDataPanel);
        imprimirDataPanel.setLayout(imprimirDataPanelLayout);
        imprimirDataPanelLayout.setHorizontalGroup(
            imprimirDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imprimirDataPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(imprimirListaPanel)
                .addGap(18, 18, 18))
            .addGroup(imprimirDataPanelLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(imprimirBtnsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        imprimirDataPanelLayout.setVerticalGroup(
            imprimirDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imprimirDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imprimirListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(imprimirBtnsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout imprimirPanelLayout = new javax.swing.GroupLayout(imprimirPanel);
        imprimirPanel.setLayout(imprimirPanelLayout);
        imprimirPanelLayout.setHorizontalGroup(
            imprimirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(imprimirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imprimirDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        imprimirPanelLayout.setVerticalGroup(
            imprimirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(imprimirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imprimirDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        appPanel.addTab("Imprimir", imprimirPanel);

        emailDataPanel.setBackground(new java.awt.Color(70, 73, 75));

        emailListaPanel.setViewportView(emailLista);

        emailDestinatarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailDestinatarioLabel.setText("Destinatario/s:");

        emailDestinatarioField.setToolTipText("Si hay más de un destinatario, sepárelos por comas \",\"");

        emailAsuntoLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailAsuntoLabel.setText("Asunto:");

        emailAsuntoField.setToolTipText("Si hay más de un destinatario, sepárelos por comas \",\"");

        emailEnviarBtn.setText("Enviar");
        emailEnviarBtn.setFocusable(false);
        emailEnviarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEnviarBtnActionPerformed(evt);
            }
        });

        emailBorradorBtn.setText("Borrador");
        emailBorradorBtn.setFocusable(false);
        emailBorradorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailBorradorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout emailDataPanelLayout = new javax.swing.GroupLayout(emailDataPanel);
        emailDataPanel.setLayout(emailDataPanelLayout);
        emailDataPanelLayout.setHorizontalGroup(
            emailDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailDataPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(emailDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emailDataPanelLayout.createSequentialGroup()
                        .addComponent(emailDestinatarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailDestinatarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailAsuntoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailAsuntoField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailEnviarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailBorradorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emailListaPanel))
                .addGap(18, 18, 18))
        );
        emailDataPanelLayout.setVerticalGroup(
            emailDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailDataPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(emailDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emailDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailAsuntoLabel)
                        .addComponent(emailAsuntoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailEnviarBtn)
                        .addComponent(emailBorradorBtn))
                    .addGroup(emailDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailDestinatarioLabel)
                        .addComponent(emailDestinatarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout emailPanelLayout = new javax.swing.GroupLayout(emailPanel);
        emailPanel.setLayout(emailPanelLayout);
        emailPanelLayout.setHorizontalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        emailPanelLayout.setVerticalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        appPanel.addTab("Email", emailPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appPanel)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inicioPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appPanel)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inicioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
	private void entrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarBtnActionPerformed
        // TODO add your handling code here:
    	this.isResizable = !isResizable;
        this.setResizable(isResizable);
        showPanel(this.getContentPane(), "tabbedPanel");
    }//GEN-LAST:event_entrarBtnActionPerformed
    
    private void sociosTablaMouseClicked(java.awt.event.MouseEvent evt) {
    	int selectedRow = sociosTabla.getSelectedRow();
    	String huerto = "";
    	String socio= "";
    	String nombre = "";
    	String dni = "";
    	String telefono = "";
    	String correo = "";
    	String alta = "";
    	String entrega = "";
    	String baja = "";
    	String notas = "";
    	String tipo = "";
    	String estado = "";
        if(selectedRow>=0){
            huerto = sociosTabla.getValueAt(selectedRow, 0).toString();
            socio = sociosTabla.getValueAt(selectedRow, 1).toString();
            nombre = sociosTabla.getValueAt(selectedRow, 2).toString();
            dni = sociosTabla.getValueAt(selectedRow, 3).toString();
            telefono = sociosTabla.getValueAt(selectedRow, 4).toString();
            correo = sociosTabla.getValueAt(selectedRow, 5).toString();
            alta = sociosTabla.getValueAt(selectedRow, 6).toString();
            entrega = sociosTabla.getValueAt(selectedRow, 7).toString();
            baja = sociosTabla.getValueAt(selectedRow, 8).toString();
            notas = sociosTabla.getValueAt(selectedRow, 9).toString();
            tipo = sociosTabla.getValueAt(selectedRow, 10).toString();
            estado = sociosTabla.getValueAt(selectedRow, 11).toString();
        }
        sociosNHuertoField.setText(huerto);
        sociosNSocioField.setText(socio);
        sociosNombreField.setText(nombre);
        sociosDniField.setText(dni);
        sociosTelefonoField.setText(telefono);
        sociosCorreoField.setText(correo);
        sociosFechaAltaField.setText(alta);
        sociosFechaEntregaField.setText(entrega);
        sociosFechaBajaField.setText(baja);
        sociosNotasField.setText(notas);
        sociosTipoComboBox.setSelectedItem(tipo);
        sociosEstadoField.setText(estado);
    }
    
    private void sociosTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sociosTablaKeyPressed
        // TODO add your handling code here:
    	if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            evt.consume(); // Evitar el comportamiento predeterminado del tabulador
            eliminarSocio();
            actualizarSociosTabla();
        }
    }//GEN-LAST:event_sociosTablaKeyPressed

    private void ingresosAgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresosAgregarBtnActionPerformed
        // TODO add your handling code here:
    	añadirIngreso();
    }//GEN-LAST:event_ingresosAgregarBtnActionPerformed

    private void ingresosBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresosBuscarBtnActionPerformed
        // TODO add your handling code here:
    	buscarIngreso();
    }//GEN-LAST:event_ingresosBuscarBtnActionPerformed

    private void ingresosModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresosModificarBtnActionPerformed
        // TODO add your handling code here:
    	modificarIngreso();
    }//GEN-LAST:event_ingresosModificarBtnActionPerformed

    private void ingresosEliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresosEliminarBtnActionPerformed
        // TODO add your handling code here:
    	eliminarIngreso();
    }//GEN-LAST:event_ingresosEliminarBtnActionPerformed

    private void gastosAgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastosAgregarBtnActionPerformed
        // TODO add your handling code here:
    	añadirGasto();
    }//GEN-LAST:event_gastosAgregarBtnActionPerformed

    private void gastosBuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastosBuscarBtnActionPerformed
        // TODO add your handling code here:
    	buscarGasto();
    }//GEN-LAST:event_gastosBuscarBtnActionPerformed

    private void gastosModificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastosModificarBtnActionPerformed
        // TODO add your handling code here:
    	modificarGasto();
    }//GEN-LAST:event_gastosModificarBtnActionPerformed

    private void gastosEliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastosEliminarBtnActionPerformed
        // TODO add your handling code here:
    	eliminarGasto();
    }//GEN-LAST:event_gastosEliminarBtnActionPerformed

    private void balanceCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceCalcularActionPerformed
        // TODO add your handling code here:
    	calcularBalance();
    }//GEN-LAST:event_balanceCalcularActionPerformed

    private void listaEsperaActualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEsperaActualizarBtnActionPerformed
        // TODO add your handling code here:
    	actualizar();
    }//GEN-LAST:event_listaEsperaActualizarBtnActionPerformed

    private void imprimirSociosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirSociosBtnActionPerformed
        // TODO add your handling code here:
    	sociosPrintView();
    }//GEN-LAST:event_imprimirSociosBtnActionPerformed

    private void imprimirIngresosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirIngresosBtnActionPerformed
        // TODO add your handling code here:
    	ingresosPrintView();
    }//GEN-LAST:event_imprimirIngresosBtnActionPerformed

    private void imprimirPrinterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirPrinterBtnActionPerformed
        // TODO add your handling code here:
    	printContent();
    }//GEN-LAST:event_imprimirPrinterBtnActionPerformed

    private void imprimirGastosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirGastosBtnActionPerformed
        // TODO add your handling code here:
    	gastosPrintView();
    }//GEN-LAST:event_imprimirGastosBtnActionPerformed

    private void imprimirListaEsperaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirListaEsperaBtnActionPerformed
        // TODO add your handling code here:
    	listaEsperaPrintView();
    }//GEN-LAST:event_imprimirListaEsperaBtnActionPerformed

    private void emailEnviarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailEnviarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailEnviarBtnActionPerformed

    private void emailBorradorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailBorradorBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailBorradorBtnActionPerformed          
    
    protected void sociosFechaBajaFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
    	if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosFechaEntregaFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosFechaAltaFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosCorreoFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosTelefonoFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosDniFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosNombreFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosNSocioFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}

	protected void sociosNHuertoFieldKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}
	
	protected void sociosNotasFieldKeyPressed(KeyEvent evt) {
		//TODO Auto-generated method stub
		if(!(sociosNHuertoField.getText().isEmpty() &&
    			sociosNSocioField.getText().isEmpty() &&
    			sociosNombreField.getText().isEmpty() &&
    			sociosDniField.getText().isEmpty() &&
    			sociosTelefonoField.getText().isEmpty() &&
    			sociosCorreoField.getText().isEmpty() &&
    			sociosFechaAltaField.getText().isEmpty() &&
    			sociosFechaEntregaField.getText().isEmpty() &&
    			sociosFechaBajaField.getText().isEmpty() && 
    			sociosNotasField.getText().isEmpty())){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                evt.consume(); // Evitar el comportamiento predeterminado del tabulador
                añadirSocio();
                actualizarSociosTabla();
                sociosNHuertoField.requestFocus();
            }
        }
	}                                           
    
    // Variables declaration - do not modify                     
    private javax.swing.JTabbedPane appPanel;
    private javax.swing.JLabel asociacionLabel;
    private javax.swing.JButton balanceCalcular;
    private javax.swing.JPanel balanceDataPanel;
    private javax.swing.JFormattedTextField balanceInicialBancoField;
    private javax.swing.JFormattedTextField balanceInicialCajaField;
    private javax.swing.JTextArea balanceLista;
    private javax.swing.JScrollPane balanceListaPanel;
    private javax.swing.JPanel balancePanel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel correoLabel;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JTextField emailAsuntoField;
    private javax.swing.JLabel emailAsuntoLabel;
    private javax.swing.JButton emailBorradorBtn;
    private javax.swing.JPanel emailDataPanel;
    private javax.swing.JTextField emailDestinatarioField;
    private javax.swing.JLabel emailDestinatarioLabel;
    private javax.swing.JButton emailEnviarBtn;
    private javax.swing.JEditorPane emailLista;
    private javax.swing.JScrollPane emailListaPanel;
    private javax.swing.JPanel emailPanel;
    private javax.swing.JButton entrarBtn;
    private javax.swing.JButton gastosAgregarBtn;
    private javax.swing.JButton gastosBuscarBtn;
    private javax.swing.JTextField gastosCantidadField;
    private javax.swing.JLabel gastosCantidadLabel;
    private javax.swing.JTextField gastosConceptoField;
    private javax.swing.JLabel gastosConceptoLabel;
    private javax.swing.JPanel gastosDataPanel;
    private javax.swing.JButton gastosEliminarBtn;
    private javax.swing.JTextField gastosFacturaField;
    private javax.swing.JLabel gastosFacturaLabel;
    private javax.swing.JFormattedTextField gastosFechaField;
    private javax.swing.JLabel gastosFechaLabel;
    private javax.swing.JTextArea gastosLista;
    private javax.swing.JScrollPane gastosListaPanel;
    private javax.swing.JButton gastosModificarBtn;
    private javax.swing.JPanel gastosPanel;
    private javax.swing.JTextField gastosProveedorField;
    private javax.swing.JLabel gastosProveedorLabel;
    private javax.swing.JComboBox<String> gastosTipoComboBox;
    private javax.swing.JLabel gastosTipoLabel;
    private javax.swing.JPanel imprimirBtnsPanel;
    private javax.swing.JPanel imprimirDataPanel;
    private javax.swing.JButton imprimirGastosBtn;
    private javax.swing.JButton imprimirIngresosBtn;
    private javax.swing.JTextArea imprimirLista;
    private javax.swing.JButton imprimirListaEsperaBtn;
    private javax.swing.JScrollPane imprimirListaPanel;
    private javax.swing.JPanel imprimirPanel;
    private javax.swing.JButton imprimirPrinterBtn;
    private javax.swing.JButton imprimirSociosBtn;
    private javax.swing.JButton ingresosAgregarBtn;
    private javax.swing.JButton ingresosBuscarBtn;
    private javax.swing.JTextField ingresosCantidadField;
    private javax.swing.JLabel ingresosCantidadLabel;
    private javax.swing.JTextField ingresosConceptoField;
    private javax.swing.JLabel ingresosConceptoLabel;
    private javax.swing.JLabel ingresosCuotaLabel;
    private javax.swing.JPanel ingresosDataPanel;
    private javax.swing.JButton ingresosEliminarBtn;
    private javax.swing.JFormattedTextField ingresosFechaField;
    private javax.swing.JLabel ingresosFechaLabel;
    private javax.swing.JTextArea ingresosLista;
    private javax.swing.JScrollPane ingresosListaPanel;
    private javax.swing.JButton ingresosModificarBtn;
    private javax.swing.JTextField ingresosNSocioField;
    private javax.swing.JLabel ingresosNSocioLabel;
    private javax.swing.JPanel ingresosPanel;
    private javax.swing.JComboBox<String> ingresosTipoComboBox;
    private javax.swing.JPanel inicioPanel;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listaEsperaActualizarBtn;
    private javax.swing.JPanel listaEsperaDataPanel;
    private javax.swing.JScrollPane listaEsperaListaPanel;
    private javax.swing.JPanel listaEsperaPanel;
    private javax.swing.JTable listaEsperaTabla;
    private javax.swing.JTextField sociosCorreoField;
    private javax.swing.JLabel sociosCorreoLabel;
    private javax.swing.JFormattedTextField sociosDniField;
    private javax.swing.JLabel sociosDniLabel;
    private javax.swing.JTextField sociosEstadoField;
    private javax.swing.JLabel sociosEstadoLabel;
    private javax.swing.JTextField sociosFechaAltaField;
    private javax.swing.JLabel sociosFechaAltaLabel;
    private javax.swing.JTextField sociosFechaBajaField;
    private javax.swing.JLabel sociosFechaBajaLabel;
    private javax.swing.JTextField sociosFechaEntregaField;
    private javax.swing.JLabel sociosFechaEntregaLabel;
    private javax.swing.JPanel sociosFields;
    private javax.swing.JTextField sociosNHuertoField;
    private javax.swing.JLabel sociosNHuertoLabel;
    private javax.swing.JTextField sociosNSocioField;
    private javax.swing.JLabel sociosNSocioLabel;
    private javax.swing.JTextField sociosNombreField;
    private javax.swing.JLabel sociosNombreLabel;
    private javax.swing.JTextField sociosNotasField;
    private javax.swing.JLabel sociosNotasLabel;
    private javax.swing.JPanel sociosPanel;
    private javax.swing.JTable sociosTabla;
    private javax.swing.JScrollPane sociosTablaPanel;
    private javax.swing.JFormattedTextField sociosTelefonoField;
    private javax.swing.JLabel sociosTelefonoLabel;
    private javax.swing.JComboBox<String> sociosTipoComboBox;
    private javax.swing.JLabel sociosTipoLabel;
    private javax.swing.JPanel txtBtnPanel;
    // End of variables declaration                   
}
