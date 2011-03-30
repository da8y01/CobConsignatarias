/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cobconsignatarias;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Admin
 */
public class FlowMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    private String Message;

    private boolean bEntregaExpendios = false;
    private boolean bEntregaConsignatarias = false;
    private String sFileApp = null;

    private ConnectionHandler connectionhandler;
    private Rutas RUTAS;
    private RutasConsignatarias RUTASCONSIGNATARIAS;
    private Ruta CurrRuta;
    private RutaConsignatarias CurrRutaConsignatarias;
    private RazonSocialConsignatarias CurrRazonSocialConsignatarias;

    private Enumeration enumeration;

    private int iIndexListFechas = 0;
    private int iIndexListExpendios = 0;
    private int iIndexListFechasConsignatarias = 0;
    private int iIndexListRazonesSociales = 0;
    private int iIndexListConsignatarias = 0;
    private int iIndexListProducto = 0;
    private int iIndexListFacturas = 0;
    
    private int iIndexListFechasEntrega = 0;
    private int iIndexListExpendiosEntrega = 0;
    private int iIndexListFechasConsignatariasEntrega = 0;
    private int iIndexListRazonesSocialesEntrega = 0;
    private int iIndexListConsignatariasEntrega = 0;
    private int iIndexListProductoEntrega = 0;
    private int iIndexListFacturasEntrega = 0;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private List ListProducto;
    private List ListExpendios;
    private List ListFechas;
    private Form FormFecha;
    private TextField textFieldEntDev;
    private TextField textFieldFaltantes;
    private StringItem stringItemValor;
    private TextField textFieldSobrantes;
    private ChoiceGroup choiceGroupCheck;
    private Alert Alert;
    private List ListStart;
    private Form FormCompendio;
    private Form FormStartGauge;
    private Gauge gauge;
    private FileBrowser fileBrowser;
    private List ListConsignatarias;
    private FileBrowser fileBrowserConsignatarias;
    private List ListFacturas;
    private Form FormCompendioFechasConsignatarias;
    private List ListFechasConsignatarias;
    private Form FormFechaConsignatarias;
    private ChoiceGroup choiceGroupConsignatariasPago;
    private TextField textFieldConsignatariasEntrDevol;
    private StringItem stringItemConsignatariasValorTotal;
    private TextField textFieldConsignatariasSobrantes;
    private TextField textFieldConsignatariasFaltantes;
    private List ListRazonesSociales;
    private Form FormFechaEntrega;
    private ChoiceGroup choiceGroupFormFechaEntregaEntrego;
    private TextField textFieldFormFechaEntregaRestantes;
    private StringItem stringItemFormFechaEntregaEntregados;
    private TextField textFieldFormFechaEntregaAdicionales;
    private Command exitCommand;
    private Command backCommand;
    private Command avanzarCommand;
    private Command saveCommand;
    private Command calcCommand;
    private Command okCommand;
    private Command startCommand;
    private Command giveCommand;
    private Ticker ticker1;
    private Ticker tickerConsignatarias;
    //</editor-fold>//GEN-END:|fields|0|
    private StringItem stringItemCompendio;

    private Expendio CurrExpendio;
    private Fecha CurrFecha;
    private FacturaConsignatarias CurrFacturaConsignatarias;
    private FechaConsignatarias CurrFechaConsignatarias;

    /**
     * The FlowMIDlet constructor.
     */
    public FlowMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getListStart());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == FormCompendio) {//GEN-BEGIN:|7-commandAction|1|59-preAction
            if (command == okCommand) {//GEN-END:|7-commandAction|1|59-preAction
                // write pre-action user code here
                switchDisplayable(null, getListExpendios());//GEN-LINE:|7-commandAction|2|59-postAction
                // write post-action user code here
                WriteChanges();
            }//GEN-BEGIN:|7-commandAction|3|102-preAction
        } else if (displayable == FormCompendioFechasConsignatarias) {
            if (command == okCommand) {//GEN-END:|7-commandAction|3|102-preAction
                // write pre-action user code here
                switchDisplayable(null, getListFacturas());//GEN-LINE:|7-commandAction|4|102-postAction
                // write post-action user code here
                WriteChangesConsignatarias();
            }//GEN-BEGIN:|7-commandAction|5|37-preAction
        } else if (displayable == FormFecha) {
            if (command == backCommand) {//GEN-END:|7-commandAction|5|37-preAction
                // write pre-action user code here
                String sFormFechaEntDev = textFieldEntDev.getString();
                int iDevueltos = 0;
                if (sFormFechaEntDev != null && !sFormFechaEntDev.equalsIgnoreCase("")) {
                    iDevueltos = Integer.parseInt(sFormFechaEntDev);
                }

                String sFormFechaFaltantes = textFieldFaltantes.getString();
                int iFaltantes = 0;
                if (sFormFechaFaltantes != null && !sFormFechaFaltantes.equalsIgnoreCase("")) {
                    iFaltantes = Integer.parseInt(sFormFechaFaltantes);
                }

                String sFormFechaSobrantes = textFieldSobrantes.getString();
                int iSobrantes = 0;
                if (sFormFechaSobrantes != null && !sFormFechaSobrantes.equalsIgnoreCase("")) {
                    iSobrantes = Integer.parseInt(sFormFechaSobrantes);
                }

                //if ((iDevueltos > CurrFecha.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0)) {
                if ((iDevueltos>CurrFecha.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0) || (iFaltantes > CurrFecha.GetEntregados()-iDevueltos)) {
                    getAlert().setTitle("ERROR");
                    //getAlert().setString("Valor inválido para campo 'Devueltos'.");
                    getAlert().setString("Valores inválidos.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                } else {
                    CurrFecha.SetDevueltos(iDevueltos);
                    CurrFecha.SetFaltantes(iFaltantes);
                    CurrFecha.SetSobrantes(iSobrantes);

                    CurrFecha.SetCobrado(choiceGroupCheck.getSelectedIndex());

                    if (CurrFecha.GetCobrado() == 1) {
                        CurrFecha.SetValor(CalcFechaValor());
                    }
                    else {
                        CurrFecha.SetValor(0);
                    }

                    switchDisplayable(null, getListFechas());
                }
//GEN-LINE:|7-commandAction|6|37-postAction
                // write post-action user code here
            } else if (command == calcCommand) {//GEN-LINE:|7-commandAction|7|54-preAction
                // write pre-action user code here
                String sFormFechaEntDev = textFieldEntDev.getString();
                int iDevueltos = 0;
                if (sFormFechaEntDev != null && !sFormFechaEntDev.equalsIgnoreCase("")) {
                    iDevueltos = Integer.parseInt(sFormFechaEntDev);
                }

                String sFormFechaFaltantes = textFieldFaltantes.getString();
                int iFaltantes = 0;
                if (sFormFechaFaltantes != null && !sFormFechaFaltantes.equalsIgnoreCase("")) {
                    iFaltantes = Integer.parseInt(sFormFechaFaltantes);
                }

                String sFormFechaSobrantes = textFieldSobrantes.getString();
                int iSobrantes = 0;
                if (sFormFechaSobrantes != null && !sFormFechaSobrantes.equalsIgnoreCase("")) {
                    iSobrantes = Integer.parseInt(sFormFechaSobrantes);
                }

                //if (iDevueltos > CurrFecha.GetEntregados() || (iFaltantes!=0 && iSobrantes!=0)) {
                if ((iDevueltos>CurrFecha.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0) || (iFaltantes > CurrFecha.GetEntregados()-iDevueltos)) {
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Valores inválidos.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                } else {
                    CurrFecha.SetDevueltos(iDevueltos);
                    CurrFecha.SetFaltantes(iFaltantes);
                    CurrFecha.SetSobrantes(iSobrantes);

                    CurrFecha.SetCobrado(choiceGroupCheck.getSelectedIndex());

                    int iFechaValorCalculed = CalcFechaValor();
                    if (CurrFecha.GetCobrado() == 1) {
                        CurrFecha.SetValor(iFechaValorCalculed);
                    }
                    else {
                        CurrFecha.SetValor(0);
                    }

                    int iFechaValor = iFechaValorCalculed;
                    String sFechaValor = Integer.toString(iFechaValor);
                    stringItemValor.setText(sFechaValor);
                }
//GEN-LINE:|7-commandAction|8|54-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|106-preAction
        } else if (displayable == FormFechaConsignatarias) {
            if (command == backCommand) {//GEN-END:|7-commandAction|9|106-preAction
                // write pre-action user code here
                String sFormFechaConsignatariasEntrDevol = textFieldConsignatariasEntrDevol.getString();
                int iDevueltos = 0;
                if (sFormFechaConsignatariasEntrDevol != null && !sFormFechaConsignatariasEntrDevol.equalsIgnoreCase("")) {
                    iDevueltos = Integer.parseInt(sFormFechaConsignatariasEntrDevol);
                }

                String sFormFechaFaltantes = textFieldConsignatariasFaltantes.getString();
                int iFaltantes = 0;
                if (sFormFechaFaltantes != null && !sFormFechaFaltantes.equalsIgnoreCase("")) {
                    iFaltantes = Integer.parseInt(sFormFechaFaltantes);
                }

                String sFormFechaSobrantes = textFieldConsignatariasSobrantes.getString();
                int iSobrantes = 0;
                if (sFormFechaSobrantes != null && !sFormFechaSobrantes.equalsIgnoreCase("")) {
                    iSobrantes = Integer.parseInt(sFormFechaSobrantes);
                }

                //if ((iDevueltos > CurrFechaConsignatarias.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0)) {
                if ((iDevueltos>CurrFechaConsignatarias.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0) || (iFaltantes > CurrFechaConsignatarias.GetEntregados()-iDevueltos)) {
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Valores inválidos.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                } else {
                    CurrFechaConsignatarias.SetDevueltos(iDevueltos);
                    CurrFechaConsignatarias.SetFaltantes(iFaltantes);
                    CurrFechaConsignatarias.SetSobrantes(iSobrantes);

                    CurrFechaConsignatarias.SetCobrado(choiceGroupConsignatariasPago.getSelectedIndex());

                    if (CurrFechaConsignatarias.GetCobrado() == 1) {
                        CurrFechaConsignatarias.SetValorTotal(CalcFechaConsignatariasValorTotal());
                    }
                    else {
                        CurrFechaConsignatarias.SetValorTotal(0);
                    }

                    switchDisplayable(null, getListFechasConsignatarias());
                }
//GEN-LINE:|7-commandAction|10|106-postAction
                // write post-action user code here
            } else if (command == calcCommand) {//GEN-LINE:|7-commandAction|11|107-preAction
                // write pre-action user code here
                String sFormFechaConsignatariasEntrDevol = textFieldConsignatariasEntrDevol.getString();
                int iDevueltos = 0;
                if (sFormFechaConsignatariasEntrDevol != null && !sFormFechaConsignatariasEntrDevol.equalsIgnoreCase("")) {
                    iDevueltos = Integer.parseInt(sFormFechaConsignatariasEntrDevol);
                }

                String sFormFechaFaltantes = textFieldConsignatariasFaltantes.getString();
                int iFaltantes = 0;
                if (sFormFechaFaltantes != null && !sFormFechaFaltantes.equalsIgnoreCase("")) {
                    iFaltantes = Integer.parseInt(sFormFechaFaltantes);
                }

                String sFormFechaSobrantes = textFieldConsignatariasSobrantes.getString();
                int iSobrantes = 0;
                if (sFormFechaSobrantes != null && !sFormFechaSobrantes.equalsIgnoreCase("")) {
                    iSobrantes = Integer.parseInt(sFormFechaSobrantes);
                }

                //if ((iDevueltos > CurrFechaConsignatarias.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0)) {
                if ((iDevueltos>CurrFechaConsignatarias.GetEntregados()) || (iFaltantes!=0 && iSobrantes!=0) || (iFaltantes > CurrFechaConsignatarias.GetEntregados()-iDevueltos)) {
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Valores inválidos.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                } else {
                    CurrFechaConsignatarias.SetDevueltos(iDevueltos);
                    CurrFechaConsignatarias.SetFaltantes(iFaltantes);
                    CurrFechaConsignatarias.SetSobrantes(iSobrantes);

                    CurrFechaConsignatarias.SetCobrado(choiceGroupConsignatariasPago.getSelectedIndex());

                    int iFechaConsignatariasValorTotalCalculed = CalcFechaConsignatariasValorTotal();
                    if (CurrFechaConsignatarias.GetCobrado() == 1) {
                        CurrFechaConsignatarias.SetValorTotal(iFechaConsignatariasValorTotalCalculed);
                    }
                    else {
                        CurrFechaConsignatarias.SetValorTotal(0);
                    }

                    int iFechaConsignatariasValorTotal = iFechaConsignatariasValorTotalCalculed;
                    String sFechaConsignatariasValorTotal = Integer.toString(iFechaConsignatariasValorTotal);
                    stringItemConsignatariasValorTotal.setText(sFechaConsignatariasValorTotal);
                }
//GEN-LINE:|7-commandAction|12|107-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|131-preAction
        } else if (displayable == FormFechaEntrega) {
            if (command == backCommand) {//GEN-END:|7-commandAction|13|131-preAction
                // write pre-action user code here
                //String sFormFechaEntregaEntregados = textFieldFormFechaEntregaEntregados.getString();
                //textFieldFormFechaEntregaEntregados.setString("");
                /*int iEntregados = 0;
                if (sFormFechaEntregaEntregados != null && !sFormFechaEntregaEntregados.equalsIgnoreCase("")) {
                    iEntregados = Integer.parseInt(sFormFechaEntregaEntregados);
                }*/

                String sFormFechaEntregaAdicionales = textFieldFormFechaEntregaAdicionales.getString();
                //textFieldFormFechaEntregaAdicionales.setString("");
                int iAdicionales = 0;
                if (sFormFechaEntregaAdicionales != null && !sFormFechaEntregaAdicionales.equalsIgnoreCase("")) {
                    iAdicionales = Integer.parseInt(sFormFechaEntregaAdicionales);
                }

                String sFormFechaEntregaRestantes = textFieldFormFechaEntregaRestantes.getString();
                //textFieldFormFechaEntregaRestantes.setString("");
                int iRestantes = 0;
                if (sFormFechaEntregaRestantes != null && !sFormFechaEntregaRestantes.equalsIgnoreCase("")) {
                    iRestantes = Integer.parseInt(sFormFechaEntregaRestantes);
                }

                int iEntrego = choiceGroupFormFechaEntregaEntrego.getSelectedIndex();
                //choiceGroupFormFechaEntregaEntrego.setSelectedIndex(0, true);

                if (iAdicionales!=0 && iRestantes!=0) {
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Valores inválidos.");
                    getAlert().setType(AlertType.INFO);
                    switchDisplayable(null, getAlert());
                }
                else {
                    if (GetEntregaExpendios()) {
                        //CurrFecha.SetEntregados(iEntregados);
                        CurrFecha.SetAdicionales(iAdicionales);
                        CurrFecha.SetRestantes(iRestantes);
                        CurrFecha.SetEntrego(iEntrego);

                        //textFieldFormFechaEntregaEntregados.setString("");
                        textFieldFormFechaEntregaAdicionales.setString("");
                        textFieldFormFechaEntregaRestantes.setString("");
                        choiceGroupFormFechaEntregaEntrego.setSelectedIndex(0, true);

                        switchDisplayable(null, getListFechas());
                    }
                    if (GetEntregaConsignatarias()) {
                        //CurrFechaConsignatarias.SetEntregados(iEntregados);
                        CurrFechaConsignatarias.SetAdicionales(iAdicionales);
                        CurrFechaConsignatarias.SetRestantes(iRestantes);
                        CurrFechaConsignatarias.SetEntrego(iEntrego);

                        //textFieldFormFechaEntregaEntregados.setString("");
                        textFieldFormFechaEntregaAdicionales.setString("");
                        textFieldFormFechaEntregaRestantes.setString("");
                        choiceGroupFormFechaEntregaEntrego.setSelectedIndex(0, true);

                        switchDisplayable(null, getListFechasConsignatarias());
                    }
                }
//GEN-LINE:|7-commandAction|14|131-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|65-preAction
        } else if (displayable == FormStartGauge) {
            if (command == startCommand) {//GEN-END:|7-commandAction|15|65-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|16|65-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|87-preAction
        } else if (displayable == ListConsignatarias) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|87-preAction
                // write pre-action user code here
                ListConsignatariasAction();//GEN-LINE:|7-commandAction|18|87-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|19|115-preAction
                // write pre-action user code here
                switchDisplayable(null, getListStart());//GEN-LINE:|7-commandAction|20|115-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|21|89-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|89-postAction
                // write post-action user code here
            } else if (command == giveCommand) {//GEN-LINE:|7-commandAction|23|127-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|24|127-postAction
                // write post-action user code here
                getAlert().setTitle("ENTREGAR");
                if (GetEntregaConsignatarias()) {
                    getAlert().setString("Entregados: "+CalcConsignatariasEntregados()+" - Restantes: "+CalcConsignatariasRestantesEntregar());
                }
                else {
                    getAlert().setString("Monto: "+CalcConsignatariasTotalEntregar()+" - Cantidad: "+CalcConsignatariasCantidadEntregar());
                }
                getAlert().setType(AlertType.INFO);
                switchDisplayable(null, getAlert());
            }//GEN-BEGIN:|7-commandAction|25|23-preAction
        } else if (displayable == ListExpendios) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|25|23-preAction
                // write pre-action user code here
                ListExpendiosAction();//GEN-LINE:|7-commandAction|26|23-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|27|26-preAction
                // write pre-action user code here
                switchDisplayable(null, getListProducto());//GEN-LINE:|7-commandAction|28|26-postAction
                // write post-action user code here
            } else if (command == saveCommand) {//GEN-LINE:|7-commandAction|29|45-preAction
                // write pre-action user code here
                WriteChanges();
//GEN-LINE:|7-commandAction|30|45-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|92-preAction
        } else if (displayable == ListFacturas) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|31|92-preAction
                // write pre-action user code here
                ListFacturasAction();//GEN-LINE:|7-commandAction|32|92-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|33|94-preAction
                // write pre-action user code here
                switchDisplayable(null, getListRazonesSociales());//GEN-LINE:|7-commandAction|34|94-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|35|29-preAction
        } else if (displayable == ListFechas) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|35|29-preAction
                // write pre-action user code here
                ListFechasAction();//GEN-LINE:|7-commandAction|36|29-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|37|34-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|38|34-postAction
                // write post-action user code here
                if (GetEntregaExpendios()) {
                    switchDisplayable(null, getListExpendios());
                    WriteChanges();
                }
                else {
                    switchDisplayable(null, getFormCompendio());
                }
            }//GEN-BEGIN:|7-commandAction|39|98-preAction
        } else if (displayable == ListFechasConsignatarias) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|39|98-preAction
                // write pre-action user code here
                ListFechasConsignatariasAction();//GEN-LINE:|7-commandAction|40|98-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|41|100-preAction
                // write pre-action user code here
                Date d = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                String time = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
                CurrFacturaConsignatarias.SetFechaPago(time);
//GEN-LINE:|7-commandAction|42|100-postAction
                // write post-action user code here
                if (GetEntregaConsignatarias()) {
                    switchDisplayable(null, getListFacturas());
                    WriteChangesConsignatarias();
                }
                else {
                    switchDisplayable(null, getFormCompendioFechasConsignatarias());
                }
            }//GEN-BEGIN:|7-commandAction|43|16-preAction
        } else if (displayable == ListProducto) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|43|16-preAction
                // write pre-action user code here
                ListProductoAction();//GEN-LINE:|7-commandAction|44|16-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|45|113-preAction
                // write pre-action user code here
                switchDisplayable(null, getListStart());//GEN-LINE:|7-commandAction|46|113-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|47|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|48|19-postAction
                // write post-action user code here
            } else if (command == giveCommand) {//GEN-LINE:|7-commandAction|49|126-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|50|126-postAction
                // write post-action user code here
                getAlert().setTitle("ENTREGAR");
                if (GetEntregaExpendios()) {
                    getAlert().setString("Entregados: "+CalcExpendiosEntregados()+" - Restantes: "+CalcExpendiosRestantesEntregar());
                }
                else {
                    getAlert().setString("Monto: "+CalcExpendiosTotalEntregar()+" - Cantidad: "+CalcExpendiosCantidadEntregar());
                }
                getAlert().setType(AlertType.INFO);
                switchDisplayable(null, getAlert());
            }//GEN-BEGIN:|7-commandAction|51|118-preAction
        } else if (displayable == ListRazonesSociales) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|51|118-preAction
                // write pre-action user code here
                ListRazonesSocialesAction();//GEN-LINE:|7-commandAction|52|118-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|53|120-preAction
                // write pre-action user code here
                switchDisplayable(null, getListConsignatarias());//GEN-LINE:|7-commandAction|54|120-postAction
                // write post-action user code here
            } else if (command == saveCommand) {//GEN-LINE:|7-commandAction|55|122-preAction
                // write pre-action user code here
                WriteChangesConsignatarias();
//GEN-LINE:|7-commandAction|56|122-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|57|50-preAction
        } else if (displayable == ListStart) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|57|50-preAction
                // write pre-action user code here
                ListStartAction();//GEN-LINE:|7-commandAction|58|50-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|59|72-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|60|72-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|61|68-preAction
        } else if (displayable == fileBrowser) {
            if (command == FileBrowser.SELECT_FILE_COMMAND) {//GEN-END:|7-commandAction|61|68-preAction
                // write pre-action user code here
                sFileApp = fileBrowser.getSelectedFileURL();
                System.out.println("sFileApp: "+sFileApp);
                switchDisplayable(null, getFormStartGauge());
                (new Thread() {

                    public void run() {
                        FetchLocalFile(sFileApp);
                    }
                }).start();
//GEN-LINE:|7-commandAction|62|68-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|63|71-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|64|71-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|65|82-preAction
        } else if (displayable == fileBrowserConsignatarias) {
            if (command == FileBrowser.SELECT_FILE_COMMAND) {//GEN-END:|7-commandAction|65|82-preAction
                // write pre-action user code here
                sFileApp = fileBrowserConsignatarias.getSelectedFileURL();
                System.out.println("sFileApp: "+sFileApp);
                switchDisplayable(null, getFormStartGauge());
                (new Thread() {

                    public void run() {
                        FetchLocalFileConsignatarias(sFileApp);
                    }
                }).start();
//GEN-LINE:|7-commandAction|66|82-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|67|83-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|68|83-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|69|7-postCommandAction
        }//GEN-END:|7-commandAction|69|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|70|
    //</editor-fold>//GEN-END:|7-commandAction|70|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListProducto ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of ListProducto component.
     * @return the initialized component instance
     */
    public List getListProducto() {
        if (ListProducto == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            ListProducto = new List("Escoja Producto", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            ListProducto.addCommand(getExitCommand());
            ListProducto.addCommand(getBackCommand());
            ListProducto.addCommand(getGiveCommand());
            ListProducto.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            try {
                Image image = null;
                enumeration = RUTAS.GetVectorRutas().elements();
                while (enumeration.hasMoreElements()) {
                    Ruta curr_ruta = (Ruta) enumeration.nextElement();
                    String sProducto = curr_ruta.GetProducto();
                    if (sProducto.equalsIgnoreCase("La Patria") || sProducto.equalsIgnoreCase("Patria")) {
                        image = Image.createImage("/lapatria.png");

                    }
                    if (sProducto.equalsIgnoreCase("Nuevo Estadio")) {
                        image = Image.createImage("/nuevoestadio.png");

                    }
                    if (sProducto.equalsIgnoreCase("QHubo") || sProducto.equalsIgnoreCase("Q Hubo")) {
                        image = Image.createImage("/qhubo.png");

                    }
                    ListProducto.append(sProducto, image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            iIndexListExpendios = 0;
            iIndexListExpendiosEntrega = 0;
            if (GetEntregaExpendios()) {
                ListProducto.setSelectedIndex(iIndexListProductoEntrega, true);
            }
            else {
                ListProducto.setSelectedIndex(iIndexListProducto, true);
            }
        }//GEN-BEGIN:|14-getter|2|
        return ListProducto;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListProductoAction ">//GEN-BEGIN:|14-action|0|14-preAction
    /**
     * Performs an action assigned to the selected list element in the ListProducto component.
     */
    public void ListProductoAction() {//GEN-END:|14-action|0|14-preAction
        // enter pre-action user code here
        if (GetEntregaExpendios()) {
            iIndexListProductoEntrega = ListProducto.getSelectedIndex();
        }
        else {
            iIndexListProducto = ListProducto.getSelectedIndex();
        }

        //String __selectedString = ListProducto.getString(ListProducto.getSelectedIndex());
        String __selectedString = getListProducto().getString(getListProducto().getSelectedIndex());//GEN-LINE:|14-action|1|14-postAction
        // enter post-action user code here
        enumeration = RUTAS.GetVectorRutas().elements();
        while (enumeration.hasMoreElements()) {
            Ruta ruta_current = (Ruta) enumeration.nextElement();
            if (ruta_current.GetProducto().equalsIgnoreCase(__selectedString)) {
                CurrRuta = ruta_current;
                break;
            }
        }

        switchDisplayable(null, getListExpendios());
    }//GEN-BEGIN:|14-action|2|
    //</editor-fold>//GEN-END:|14-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Salir", Command.EXIT, 1);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListExpendios ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of ListExpendios component.
     * @return the initialized component instance
     */
    public List getListExpendios() {
        if (ListExpendios == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            ListExpendios = new List("Escoja Expendio", Choice.IMPLICIT);//GEN-BEGIN:|22-getter|1|22-postInit
            ListExpendios.addCommand(getBackCommand());
            ListExpendios.addCommand(getSaveCommand());
            ListExpendios.setCommandListener(this);//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
            Image image = null;
            try {
                enumeration = CurrRuta.GetVectorExpendios().elements();
                while (enumeration.hasMoreElements()) {
                    Expendio expendio = (Expendio) enumeration.nextElement();
                    if (expendio.GetVisitado() == 1) {
                        image = Image.createImage("/visitado.png");
                    } else {
                        image = Image.createImage("/novisitado.png");
                    }
                    ListExpendios.append(expendio.GetNombre(), image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            iIndexListFechas = 0;
            iIndexListFechasEntrega = 0;
            if (GetEntregaExpendios()) {
                ListExpendios.setSelectedIndex(iIndexListExpendiosEntrega, true);
            }
            else {
                ListExpendios.setSelectedIndex(iIndexListExpendios, true);
            }
        }//GEN-BEGIN:|22-getter|2|
        return ListExpendios;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListExpendiosAction ">//GEN-BEGIN:|22-action|0|22-preAction
    /**
     * Performs an action assigned to the selected list element in the ListExpendios component.
     */
    public void ListExpendiosAction() {//GEN-END:|22-action|0|22-preAction
        // enter pre-action user code here
        if (GetEntregaExpendios()) {
            iIndexListExpendiosEntrega = ListExpendios.getSelectedIndex();
        }
        else {
            iIndexListExpendios = ListExpendios.getSelectedIndex();
        }

        //String __selectedString = ListExpendios.getString(ListExpendios.getSelectedIndex());
        String __selectedString = getListExpendios().getString(getListExpendios().getSelectedIndex());//GEN-LINE:|22-action|1|22-postAction
        // enter post-action user code here
        enumeration = CurrRuta.GetVectorExpendios().elements();
        while (enumeration.hasMoreElements()) {
            Expendio expe_current = (Expendio) enumeration.nextElement();
            if (expe_current.GetNombre().equalsIgnoreCase(__selectedString)) {
                CurrExpendio = expe_current;
                //CurrExpendio.SetFechaValores();
                break;
            }
        }
        CurrExpendio.SetVisitado(1);

        switchDisplayable(null, getListFechas());
    }//GEN-BEGIN:|22-action|2|
    //</editor-fold>//GEN-END:|22-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
            backCommand = new Command("Avanzar", "Avanzar", Command.BACK, 1);//GEN-LINE:|25-getter|1|25-postInit
            // write post-init user code here
        }//GEN-BEGIN:|25-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|25-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListFechas ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of ListFechas component.
     * @return the initialized component instance
     */
    public List getListFechas() {
        if (ListFechas == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            ListFechas = new List("Escoja Fecha", Choice.IMPLICIT);//GEN-BEGIN:|28-getter|1|28-postInit
            ListFechas.addCommand(getBackCommand());
            ListFechas.setCommandListener(this);//GEN-END:|28-getter|1|28-postInit
            // write post-init user code here
            Image image;
            try {
                enumeration = CurrExpendio.GetVectorFechas().elements();
                while (enumeration.hasMoreElements()) {
                    Fecha fecha = (Fecha) enumeration.nextElement();
                    if (fecha.GetVisitado() == 1) {
                        image = Image.createImage("/visitado.png");
                    } else {
                        image = Image.createImage("/novisitado.png");
                    }
                    ListFechas.append(fecha.GetFecha(), image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            if (GetEntregaExpendios()) {
                ListFechas.setSelectedIndex(iIndexListFechasEntrega, true);
            }
            else {
                ListFechas.setSelectedIndex(iIndexListFechas, true);
            }
        }//GEN-BEGIN:|28-getter|2|
        return ListFechas;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListFechasAction ">//GEN-BEGIN:|28-action|0|28-preAction
    /**
     * Performs an action assigned to the selected list element in the ListFechas component.
     */
    public void ListFechasAction() {//GEN-END:|28-action|0|28-preAction
        // enter pre-action user code here
        if (GetEntregaExpendios()) {
            iIndexListFechasEntrega = ListFechas.getSelectedIndex();
        }
        else {
            iIndexListFechas = ListFechas.getSelectedIndex();
        }

        //String __selectedString = ListFechas.getString(ListFechas.getSelectedIndex());
        String __selectedString = getListFechas().getString(getListFechas().getSelectedIndex());//GEN-LINE:|28-action|1|28-postAction
        // enter post-action user code here
        enumeration = CurrExpendio.GetVectorFechas().elements();
        while (enumeration.hasMoreElements()) {
            Fecha fecha_current = (Fecha) enumeration.nextElement();
            if (fecha_current.GetFecha().equalsIgnoreCase(__selectedString)) {
                CurrFecha = fecha_current;
                break;
            }
        }
        CurrFecha.SetVisitado(1);

        if (GetEntregaExpendios()) {
            switchDisplayable(null, getFormFechaEntrega());
        }
        else {
            switchDisplayable(null, getFormFecha());
        }
    }//GEN-BEGIN:|28-action|2|
    //</editor-fold>//GEN-END:|28-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormFecha ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of FormFecha component.
     * @return the initialized component instance
     */
    public Form getFormFecha() {
        if (FormFecha == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            FormFecha = new Form(CurrFecha.GetFecha(), new Item[] { getTextFieldEntDev(), getTextFieldFaltantes(), getTextFieldSobrantes(), getStringItemValor(), getChoiceGroupCheck() });//GEN-BEGIN:|36-getter|1|36-postInit
            FormFecha.addCommand(getCalcCommand());
            FormFecha.addCommand(getBackCommand());
            FormFecha.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
            int iFechaDevueltos = CurrFecha.GetDevueltos();
            if (iFechaDevueltos == 0) {
                textFieldEntDev.setString("");
            }
            else {
                String sFechaDevueltos = Integer.toString(iFechaDevueltos);
                textFieldEntDev.setString(sFechaDevueltos);
            }

            int iFechaFaltantes = CurrFecha.GetFaltantes();
            String sFechaFaltantes = Integer.toString(iFechaFaltantes);
            textFieldFaltantes.setString(sFechaFaltantes);

            int iFechaSobrantes = CurrFecha.GetSobrantes();
            String sFechaSobrantes = Integer.toString(iFechaSobrantes);
            textFieldSobrantes.setString(sFechaSobrantes);

            int iFechaValor = CurrFecha.GetValor();
            if (iFechaValor == 0) {
                stringItemValor.setText("");
            }
            else {
                String sFechaValor = Integer.toString(iFechaValor);
                stringItemValor.setText(sFechaValor);
            }

            choiceGroupCheck.setSelectedIndex(CurrFecha.GetCobrado(), true);
        }//GEN-BEGIN:|36-getter|2|
        return FormFecha;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldEntDev ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of textFieldEntDev component.
     * @return the initialized component instance
     */
    public TextField getTextFieldEntDev() {
        if (textFieldEntDev == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            textFieldEntDev = new TextField("Entr.: "+CurrFecha.GetEntregados()+" / Dev.:", "", 3, TextField.NUMERIC);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return textFieldEntDev;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: avanzarCommand ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of avanzarCommand component.
     * @return the initialized component instance
     */
    public Command getAvanzarCommand() {
        if (avanzarCommand == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            avanzarCommand = new Command("Avanzar", Command.SCREEN, 1);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return avanzarCommand;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: saveCommand ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of saveCommand component.
     * @return the initialized component instance
     */
    public Command getSaveCommand() {
        if (saveCommand == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            saveCommand = new Command("Guardar", Command.SCREEN, 2);//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return saveCommand;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Alert ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of Alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (Alert == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            Alert = new Alert("", "", null, null);//GEN-BEGIN:|46-getter|1|46-postInit
            Alert.setTimeout(Alert.FOREVER);//GEN-END:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return Alert;
    }
    //</editor-fold>//GEN-END:|46-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldFaltantes ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of textFieldFaltantes component.
     * @return the initialized component instance
     */
    public TextField getTextFieldFaltantes() {
        if (textFieldFaltantes == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            textFieldFaltantes = new TextField("Faltantes:", "", 3, TextField.NUMERIC);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return textFieldFaltantes;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListStart ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of ListStart component.
     * @return the initialized component instance
     */
    public List getListStart() {
        if (ListStart == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            ListStart = new List("CONSIGNATARIAS", Choice.IMPLICIT);//GEN-BEGIN:|49-getter|1|49-postInit
            ListStart.append("Cobrar", null);
            ListStart.append("Entregar", null);
            ListStart.addCommand(getExitCommand());
            ListStart.setCommandListener(this);
            ListStart.setSelectedFlags(new boolean[] { false, false });//GEN-END:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return ListStart;
    }
    //</editor-fold>//GEN-END:|49-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListStartAction ">//GEN-BEGIN:|49-action|0|49-preAction
    /**
     * Performs an action assigned to the selected list element in the ListStart component.
     */
    public void ListStartAction() {//GEN-END:|49-action|0|49-preAction
        // enter pre-action user code here
        String __selectedString = getListStart().getString(getListStart().getSelectedIndex());//GEN-BEGIN:|49-action|1|79-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Cobrar")) {//GEN-END:|49-action|1|79-preAction
                // write pre-action user code here
                SetEntregaExpendios(false);
                SetEntregaConsignatarias(false);
                switchDisplayable(null, getFileBrowserConsignatarias());//GEN-LINE:|49-action|2|79-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Entregar")) {//GEN-LINE:|49-action|3|129-preAction
                // write pre-action user code here
                SetEntregaExpendios(false);
                SetEntregaConsignatarias(true);
                switchDisplayable(null, getFileBrowserConsignatarias());//GEN-LINE:|49-action|4|129-postAction
                // write post-action user code here
            }//GEN-BEGIN:|49-action|5|49-postAction
        }//GEN-END:|49-action|5|49-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|49-action|6|
    //</editor-fold>//GEN-END:|49-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: calcCommand ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of calcCommand component.
     * @return the initialized component instance
     */
    public Command getCalcCommand() {
        if (calcCommand == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            calcCommand = new Command("Calcular", Command.SCREEN, 2);//GEN-LINE:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return calcCommand;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemValor ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initiliazed instance of stringItemValor component.
     * @return the initialized component instance
     */
    public StringItem getStringItemValor() {
        if (stringItemValor == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            stringItemValor = new StringItem("Valor:", "");//GEN-LINE:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return stringItemValor;
    }
    //</editor-fold>//GEN-END:|55-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormCompendio ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of FormCompendio component.
     * @return the initialized component instance
     */
    public Form getFormCompendio() {
        if (FormCompendio == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            FormCompendio = new Form("COMPENDIO: "+CurrExpendio.GetNombre(), new Item[] { });//GEN-BEGIN:|56-getter|1|56-postInit
            FormCompendio.addCommand(getOkCommand());
            FormCompendio.setCommandListener(this);//GEN-END:|56-getter|1|56-postInit
            // write post-init user code here
            int iCompendio = CalcCompendio();
            String sCompendio = Integer.toString(iCompendio);
            CurrExpendio.SetCompendio(iCompendio);

            enumeration = CurrExpendio.GetVectorFechas().elements();
            while (enumeration.hasMoreElements()) {
                Fecha fecha = (Fecha) enumeration.nextElement();

                if (fecha.GetCobrado() == 1) {
                    StringItem siTemp = new StringItem(fecha.GetFecha() + ":", fecha.GetEntregados() + " - " + fecha.GetDevueltos() + " - " + fecha.GetValor());
                    FormCompendio.append(siTemp);
                }
            }

            StringItem siCompendio = getStringItemCompendio();
            siCompendio.setLabel("TOTAL:");
            siCompendio.setText(sCompendio);
            FormCompendio.append(siCompendio);
        }//GEN-BEGIN:|56-getter|2|
        return FormCompendio;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemCompendio ">
    /**
     * Returns an initiliazed instance of stringItemCompendio component.
     * @return the initialized component instance
     */
    public StringItem getStringItemCompendio() {
        //if (stringItemCompendio == null) {
            // write pre-init user code here
            stringItemCompendio = new StringItem("TOTAL:", "");
            // write post-init user code here
        //}
        return stringItemCompendio;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormStartGauge ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of FormStartGauge component.
     * @return the initialized component instance
     */
    public Form getFormStartGauge() {
        if (FormStartGauge == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            FormStartGauge = new Form("COBRADOR", new Item[] { getGauge() });//GEN-BEGIN:|61-getter|1|61-postInit
            FormStartGauge.addCommand(getStartCommand());
            FormStartGauge.setCommandListener(this);//GEN-END:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return FormStartGauge;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: gauge ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initiliazed instance of gauge component.
     * @return the initialized component instance
     */
    public Gauge getGauge() {
        if (gauge == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            gauge = new Gauge("Leyendo...", false, Gauge.INDEFINITE, Gauge.CONTINUOUS_IDLE);//GEN-LINE:|62-getter|1|62-postInit
            // write post-init user code here
        }//GEN-BEGIN:|62-getter|2|
        return gauge;
    }
    //</editor-fold>//GEN-END:|62-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: startCommand ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of startCommand component.
     * @return the initialized component instance
     */
    public Command getStartCommand() {
        if (startCommand == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            startCommand = new Command("Iniciar", "Iniciar", Command.SCREEN, 1);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return startCommand;
    }
    //</editor-fold>//GEN-END:|64-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: fileBrowser ">//GEN-BEGIN:|66-getter|0|66-preInit
    /**
     * Returns an initiliazed instance of fileBrowser component.
     * @return the initialized component instance
     */
    public FileBrowser getFileBrowser() {
        if (fileBrowser == null) {//GEN-END:|66-getter|0|66-preInit
            // write pre-init user code here
            fileBrowser = new FileBrowser(getDisplay());//GEN-BEGIN:|66-getter|1|66-postInit
            fileBrowser.setTitle("Explorar");
            fileBrowser.setTicker(getTicker1());
            fileBrowser.setCommandListener(this);
            fileBrowser.addCommand(FileBrowser.SELECT_FILE_COMMAND);
            fileBrowser.addCommand(getExitCommand());//GEN-END:|66-getter|1|66-postInit
            // write post-init user code here
        }//GEN-BEGIN:|66-getter|2|
        return fileBrowser;
    }
    //</editor-fold>//GEN-END:|66-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker1 ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of ticker1 component.
     * @return the initialized component instance
     */
    public Ticker getTicker1() {
        if (ticker1 == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            ticker1 = new Ticker("Escoja el archivo de datos.");//GEN-LINE:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return ticker1;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroupCheck ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of choiceGroupCheck component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroupCheck() {
        if (choiceGroupCheck == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            choiceGroupCheck = new ChoiceGroup("Pag\u00F3?", Choice.EXCLUSIVE);//GEN-BEGIN:|75-getter|1|75-postInit
            choiceGroupCheck.append("No", null);
            choiceGroupCheck.append("Si", null);
            choiceGroupCheck.setSelectedFlags(new boolean[] { true, false });//GEN-END:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return choiceGroupCheck;
    }
    //</editor-fold>//GEN-END:|75-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldSobrantes ">//GEN-BEGIN:|78-getter|0|78-preInit
    /**
     * Returns an initiliazed instance of textFieldSobrantes component.
     * @return the initialized component instance
     */
    public TextField getTextFieldSobrantes() {
        if (textFieldSobrantes == null) {//GEN-END:|78-getter|0|78-preInit
            // write pre-init user code here
            textFieldSobrantes = new TextField("Sobrantes", "", 3, TextField.NUMERIC);//GEN-LINE:|78-getter|1|78-postInit
            // write post-init user code here
        }//GEN-BEGIN:|78-getter|2|
        return textFieldSobrantes;
    }
    //</editor-fold>//GEN-END:|78-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: fileBrowserConsignatarias ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initiliazed instance of fileBrowserConsignatarias component.
     * @return the initialized component instance
     */
    public FileBrowser getFileBrowserConsignatarias() {
        if (fileBrowserConsignatarias == null) {//GEN-END:|81-getter|0|81-preInit
            // write pre-init user code here
            fileBrowserConsignatarias = new FileBrowser(getDisplay());//GEN-BEGIN:|81-getter|1|81-postInit
            fileBrowserConsignatarias.setTitle("Explorar");
            fileBrowserConsignatarias.setTicker(getTickerConsignatarias());
            fileBrowserConsignatarias.setCommandListener(this);
            fileBrowserConsignatarias.addCommand(FileBrowser.SELECT_FILE_COMMAND);
            fileBrowserConsignatarias.addCommand(getExitCommand());//GEN-END:|81-getter|1|81-postInit
            // write post-init user code here
        }//GEN-BEGIN:|81-getter|2|
        return fileBrowserConsignatarias;
    }
    //</editor-fold>//GEN-END:|81-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tickerConsignatarias ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initiliazed instance of tickerConsignatarias component.
     * @return the initialized component instance
     */
    public Ticker getTickerConsignatarias() {
        if (tickerConsignatarias == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            tickerConsignatarias = new Ticker("Escoja el archivo de Consignatarias.");//GEN-LINE:|85-getter|1|85-postInit
            // write post-init user code here
        }//GEN-BEGIN:|85-getter|2|
        return tickerConsignatarias;
    }
    //</editor-fold>//GEN-END:|85-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListConsignatarias ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initiliazed instance of ListConsignatarias component.
     * @return the initialized component instance
     */
    public List getListConsignatarias() {
        if (ListConsignatarias == null) {//GEN-END:|86-getter|0|86-preInit
            // write pre-init user code here
            ListConsignatarias = new List("Escoja Consignataria", Choice.IMPLICIT);//GEN-BEGIN:|86-getter|1|86-postInit
            ListConsignatarias.addCommand(getExitCommand());
            ListConsignatarias.addCommand(getBackCommand());
            ListConsignatarias.addCommand(getGiveCommand());
            ListConsignatarias.setCommandListener(this);//GEN-END:|86-getter|1|86-postInit
            // write post-init user code here
            try {
                Image image = null;
                enumeration = RUTASCONSIGNATARIAS.GetVectorRutas().elements();
                while (enumeration.hasMoreElements()) {
                    RutaConsignatarias curr_rutaconsignatarias = (RutaConsignatarias) enumeration.nextElement();
                    //String sConsignataria = curr_rutaconsignatarias.GetConsignataria();
                    //String sConsignataria = curr_rutaconsignatarias.GetCobrador();
                    String sProducto = curr_rutaconsignatarias.GetProducto();
                    if (sProducto.equalsIgnoreCase("La Patria") || sProducto.equalsIgnoreCase("Patria")) {
                        image = Image.createImage("/lapatria.png");

                    }
                    if (sProducto.equalsIgnoreCase("Nuevo Estadio")) {
                        image = Image.createImage("/nuevoestadio.png");

                    }
                    if (sProducto.equalsIgnoreCase("QHubo") || sProducto.equalsIgnoreCase("Q Hubo")) {
                        image = Image.createImage("/qhubo.png");

                    }
                    ListConsignatarias.append(sProducto, image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            iIndexListRazonesSociales = 0;
            iIndexListRazonesSocialesEntrega = 0;
            if (GetEntregaConsignatarias()) {
                ListConsignatarias.setSelectedIndex(iIndexListConsignatariasEntrega, true);
            }
            else {
                ListConsignatarias.setSelectedIndex(iIndexListConsignatarias, true);
            }
        }//GEN-BEGIN:|86-getter|2|
        return ListConsignatarias;
    }
    //</editor-fold>//GEN-END:|86-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListConsignatariasAction ">//GEN-BEGIN:|86-action|0|86-preAction
    /**
     * Performs an action assigned to the selected list element in the ListConsignatarias component.
     */
    public void ListConsignatariasAction() {//GEN-END:|86-action|0|86-preAction
        // enter pre-action user code here
        if (GetEntregaConsignatarias()) {
            iIndexListConsignatariasEntrega = ListConsignatarias.getSelectedIndex();
        }
        else {
            iIndexListConsignatarias = ListConsignatarias.getSelectedIndex();
        }

        //String __selectedString = ListConsignatarias.getString(ListConsignatarias.getSelectedIndex());
        String __selectedString = getListConsignatarias().getString(getListConsignatarias().getSelectedIndex());//GEN-LINE:|86-action|1|86-postAction
        // enter post-action user code here
        enumeration = RUTASCONSIGNATARIAS.GetVectorRutas().elements();
        while (enumeration.hasMoreElements()) {
            RutaConsignatarias rutaconsignatarias_current = (RutaConsignatarias) enumeration.nextElement();
            if (rutaconsignatarias_current.GetCobrador().equalsIgnoreCase(__selectedString)) {
                CurrRutaConsignatarias = rutaconsignatarias_current;
                break;
            }
        }

        switchDisplayable(null, getListRazonesSociales());
    }//GEN-BEGIN:|86-action|2|
    //</editor-fold>//GEN-END:|86-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListFacturas ">//GEN-BEGIN:|91-getter|0|91-preInit
    /**
     * Returns an initiliazed instance of ListFacturas component.
     * @return the initialized component instance
     */
    public List getListFacturas() {
        if (ListFacturas == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            ListFacturas = new List("Escoja Factura", Choice.IMPLICIT);//GEN-BEGIN:|91-getter|1|91-postInit
            ListFacturas.addCommand(getBackCommand());
            ListFacturas.setCommandListener(this);//GEN-END:|91-getter|1|91-postInit
            // write post-init user code here
            Image image = null;
            try {
                enumeration = CurrRazonSocialConsignatarias.GetVectorFacturas().elements();
                while (enumeration.hasMoreElements()) {
                    FacturaConsignatarias facturaconsignatarias = (FacturaConsignatarias) enumeration.nextElement();
                    if (facturaconsignatarias.GetVisitado() == 1) {
                        image = Image.createImage("/visitado.png");
                    } else {
                        image = Image.createImage("/novisitado.png");
                    }
                    ListFacturas.append(facturaconsignatarias.GetNoFactura(), image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            iIndexListFechasConsignatarias = 0;
            iIndexListFechasConsignatariasEntrega = 0;
            if (GetEntregaConsignatarias()) {
                ListFacturas.setSelectedIndex(iIndexListFacturasEntrega, true);
            }
            else {
                ListFacturas.setSelectedIndex(iIndexListFacturas, true);
            }
        }//GEN-BEGIN:|91-getter|2|
        return ListFacturas;
    }
    //</editor-fold>//GEN-END:|91-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListFacturasAction ">//GEN-BEGIN:|91-action|0|91-preAction
    /**
     * Performs an action assigned to the selected list element in the ListFacturas component.
     */
    public void ListFacturasAction() {//GEN-END:|91-action|0|91-preAction
        // enter pre-action user code here
        if (GetEntregaConsignatarias()) {
            iIndexListFacturasEntrega = ListFacturas.getSelectedIndex();
        }
        else {
            iIndexListFacturas = ListFacturas.getSelectedIndex();
        }

        //String __selectedString = ListFacturas.getString(ListFacturas.getSelectedIndex());
        String __selectedString = getListFacturas().getString(getListFacturas().getSelectedIndex());//GEN-LINE:|91-action|1|91-postAction
        // enter post-action user code here
        enumeration = CurrRazonSocialConsignatarias.GetVectorFacturas().elements();
        while (enumeration.hasMoreElements()) {
            FacturaConsignatarias facconsig_current = (FacturaConsignatarias) enumeration.nextElement();
            if (facconsig_current.GetNoFactura().equalsIgnoreCase(__selectedString)) {
                CurrFacturaConsignatarias = facconsig_current;
                //CurrExpendio.SetFechaValores();
                break;
            }
        }

        CurrFacturaConsignatarias.SetVisitado(1);

        switchDisplayable(null, getListFechasConsignatarias());
    }//GEN-BEGIN:|91-action|2|
    //</editor-fold>//GEN-END:|91-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListFechasConsignatarias ">//GEN-BEGIN:|97-getter|0|97-preInit
    /**
     * Returns an initiliazed instance of ListFechasConsignatarias component.
     * @return the initialized component instance
     */
    public List getListFechasConsignatarias() {
        if (ListFechasConsignatarias == null) {//GEN-END:|97-getter|0|97-preInit
            // write pre-init user code here
            ListFechasConsignatarias = new List("Escoja Fecha de Factura", Choice.IMPLICIT);//GEN-BEGIN:|97-getter|1|97-postInit
            ListFechasConsignatarias.addCommand(getBackCommand());
            ListFechasConsignatarias.setCommandListener(this);//GEN-END:|97-getter|1|97-postInit
            // write post-init user code here
            Image image;
            try {
                enumeration = CurrFacturaConsignatarias.GetVectorFechas().elements();
                while (enumeration.hasMoreElements()) {
                    FechaConsignatarias fechaconsignatarias = (FechaConsignatarias) enumeration.nextElement();
                    if (fechaconsignatarias.GetVisitado() == 1) {
                        image = Image.createImage("/visitado.png");
                    } else {
                        image = Image.createImage("/novisitado.png");
                    }
                    ListFechasConsignatarias.append(fechaconsignatarias.GetFecha(), image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            if (GetEntregaConsignatarias()) {
                ListFechasConsignatarias.setSelectedIndex(iIndexListFechasConsignatariasEntrega, true);
            }
            else {
                ListFechasConsignatarias.setSelectedIndex(iIndexListFechasConsignatarias, true);
            }
        }//GEN-BEGIN:|97-getter|2|
        return ListFechasConsignatarias;
    }
    //</editor-fold>//GEN-END:|97-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListFechasConsignatariasAction ">//GEN-BEGIN:|97-action|0|97-preAction
    /**
     * Performs an action assigned to the selected list element in the ListFechasConsignatarias component.
     */
    public void ListFechasConsignatariasAction() {//GEN-END:|97-action|0|97-preAction
        // enter pre-action user code here
        if (GetEntregaConsignatarias()) {
            iIndexListFechasConsignatariasEntrega = ListFechasConsignatarias.getSelectedIndex();
        }
        else {
            iIndexListFechasConsignatarias = ListFechasConsignatarias.getSelectedIndex();
        }

        //String __selectedString = ListFechasConsignatarias.getString(ListFechasConsignatarias.getSelectedIndex());
        String __selectedString = getListFechasConsignatarias().getString(getListFechasConsignatarias().getSelectedIndex());//GEN-LINE:|97-action|1|97-postAction
        // enter post-action user code here
        enumeration = CurrFacturaConsignatarias.GetVectorFechas().elements();
        while (enumeration.hasMoreElements()) {
            FechaConsignatarias fechaconsignatarias_current = (FechaConsignatarias) enumeration.nextElement();
            if (fechaconsignatarias_current.GetFecha().equalsIgnoreCase(__selectedString)) {
                CurrFechaConsignatarias = fechaconsignatarias_current;
                break;
            }
        }
        CurrFechaConsignatarias.SetVisitado(1);

        if (GetEntregaConsignatarias()) {
            switchDisplayable(null, getFormFechaEntrega());
        }
        else {
            switchDisplayable(null, getFormFechaConsignatarias());
        }
    }//GEN-BEGIN:|97-action|2|
    //</editor-fold>//GEN-END:|97-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormCompendioFechasConsignatarias ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of FormCompendioFechasConsignatarias component.
     * @return the initialized component instance
     */
    public Form getFormCompendioFechasConsignatarias() {
        if (FormCompendioFechasConsignatarias == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            FormCompendioFechasConsignatarias = new Form("COMPENDIO FECHAS CONSIGNATARIA");//GEN-BEGIN:|101-getter|1|101-postInit
            FormCompendioFechasConsignatarias.addCommand(getOkCommand());
            FormCompendioFechasConsignatarias.setCommandListener(this);//GEN-END:|101-getter|1|101-postInit
            // write post-init user code here
            int iCompendioFactura = CalcCompendioFactura();
            String sCompendioFactura = Integer.toString(iCompendioFactura);
            CurrFacturaConsignatarias.SetCompendio(iCompendioFactura);

            enumeration = CurrFacturaConsignatarias.GetVectorFechas().elements();
            while (enumeration.hasMoreElements()) {
                FechaConsignatarias fechaconsignatarias = (FechaConsignatarias) enumeration.nextElement();

                if (fechaconsignatarias.GetCobrado() == 1) {
                    StringItem siTemp = new StringItem(fechaconsignatarias.GetFecha() + ":", fechaconsignatarias.GetEntregados() + " - " + fechaconsignatarias.GetDevueltos() + " - " + fechaconsignatarias.GetValorTotal());
                    FormCompendioFechasConsignatarias.append(siTemp);
                }
            }

            StringItem siCompendio = getStringItemCompendio();
            siCompendio.setLabel("TOTAL:");
            siCompendio.setText(sCompendioFactura);
            FormCompendioFechasConsignatarias.append(siCompendio);
        }//GEN-BEGIN:|101-getter|2|
        return FormCompendioFechasConsignatarias;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormFechaConsignatarias ">//GEN-BEGIN:|105-getter|0|105-preInit
    /**
     * Returns an initiliazed instance of FormFechaConsignatarias component.
     * @return the initialized component instance
     */
    public Form getFormFechaConsignatarias() {
        if (FormFechaConsignatarias == null) {//GEN-END:|105-getter|0|105-preInit
            // write pre-init user code here
            FormFechaConsignatarias = new Form(CurrFechaConsignatarias.GetFecha(), new Item[] { getTextFieldConsignatariasEntrDevol(), getTextFieldConsignatariasFaltantes(), getTextFieldConsignatariasSobrantes(), getStringItemConsignatariasValorTotal(), getChoiceGroupConsignatariasPago() });//GEN-BEGIN:|105-getter|1|105-postInit
            FormFechaConsignatarias.addCommand(getCalcCommand());
            FormFechaConsignatarias.addCommand(getBackCommand());
            FormFechaConsignatarias.setCommandListener(this);//GEN-END:|105-getter|1|105-postInit
            // write post-init user code here
            int iFechaConsignatariasDevueltos = CurrFechaConsignatarias.GetDevueltos();
            if (iFechaConsignatariasDevueltos == 0) {
                textFieldConsignatariasEntrDevol.setString("");
            }
            else {
                String sFechaConsignatariasDevueltos = Integer.toString(iFechaConsignatariasDevueltos);
                textFieldConsignatariasEntrDevol.setString(sFechaConsignatariasDevueltos);
            }

            int iFechaConsignatariasValorTotal = CurrFechaConsignatarias.GetValorTotal();
            if (iFechaConsignatariasValorTotal == 0) {
                stringItemConsignatariasValorTotal.setText("");
            }
            else {
                String sFechaConsignatariasValorTotal = Integer.toString(iFechaConsignatariasValorTotal);
                stringItemConsignatariasValorTotal.setText(sFechaConsignatariasValorTotal);
            }

            choiceGroupConsignatariasPago.setSelectedIndex(CurrFechaConsignatarias.GetCobrado(), true);
        }//GEN-BEGIN:|105-getter|2|
        return FormFechaConsignatarias;
    }
    //</editor-fold>//GEN-END:|105-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldConsignatariasEntrDevol ">//GEN-BEGIN:|108-getter|0|108-preInit
    /**
     * Returns an initiliazed instance of textFieldConsignatariasEntrDevol component.
     * @return the initialized component instance
     */
    public TextField getTextFieldConsignatariasEntrDevol() {
        if (textFieldConsignatariasEntrDevol == null) {//GEN-END:|108-getter|0|108-preInit
            // write pre-init user code here
            textFieldConsignatariasEntrDevol = new TextField("Entr.: "+CurrFechaConsignatarias.GetEntregados()+" / Devol.:", "", 3, TextField.NUMERIC);//GEN-LINE:|108-getter|1|108-postInit
            // write post-init user code here
        }//GEN-BEGIN:|108-getter|2|
        return textFieldConsignatariasEntrDevol;
    }
    //</editor-fold>//GEN-END:|108-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemConsignatariasValorTotal ">//GEN-BEGIN:|109-getter|0|109-preInit
    /**
     * Returns an initiliazed instance of stringItemConsignatariasValorTotal component.
     * @return the initialized component instance
     */
    public StringItem getStringItemConsignatariasValorTotal() {
        if (stringItemConsignatariasValorTotal == null) {//GEN-END:|109-getter|0|109-preInit
            // write pre-init user code here
            stringItemConsignatariasValorTotal = new StringItem("Valor Total", "");//GEN-LINE:|109-getter|1|109-postInit
            // write post-init user code here
        }//GEN-BEGIN:|109-getter|2|
        return stringItemConsignatariasValorTotal;
    }
    //</editor-fold>//GEN-END:|109-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroupConsignatariasPago ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of choiceGroupConsignatariasPago component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroupConsignatariasPago() {
        if (choiceGroupConsignatariasPago == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            choiceGroupConsignatariasPago = new ChoiceGroup("Pag\u00F3?", Choice.EXCLUSIVE);//GEN-BEGIN:|110-getter|1|110-postInit
            choiceGroupConsignatariasPago.append("No", null);
            choiceGroupConsignatariasPago.append("Si", null);
            choiceGroupConsignatariasPago.setSelectedFlags(new boolean[] { true, false });//GEN-END:|110-getter|1|110-postInit
            // write post-init user code here
        }//GEN-BEGIN:|110-getter|2|
        return choiceGroupConsignatariasPago;
    }
    //</editor-fold>//GEN-END:|110-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListRazonesSociales ">//GEN-BEGIN:|117-getter|0|117-preInit
    /**
     * Returns an initiliazed instance of ListRazonesSociales component.
     * @return the initialized component instance
     */
    public List getListRazonesSociales() {
        if (ListRazonesSociales == null) {//GEN-END:|117-getter|0|117-preInit
            // write pre-init user code here
            ListRazonesSociales = new List("Escoja Raz\u00F3n Social", Choice.IMPLICIT);//GEN-BEGIN:|117-getter|1|117-postInit
            ListRazonesSociales.addCommand(getBackCommand());
            ListRazonesSociales.addCommand(getSaveCommand());
            ListRazonesSociales.setCommandListener(this);//GEN-END:|117-getter|1|117-postInit
            // write post-init user code here
            Image image = null;
            try {
                enumeration = CurrRutaConsignatarias.GetVectorRazonSocial().elements();
                while (enumeration.hasMoreElements()) {
                    RazonSocialConsignatarias curr_razonsocialconsignatarias = (RazonSocialConsignatarias) enumeration.nextElement();
                    String sConsignataria = curr_razonsocialconsignatarias.GetConsignataria();
                    if (curr_razonsocialconsignatarias.GetVisitado() == 1) {
                        image = Image.createImage("/visitado.png");
                    } else {
                        image = Image.createImage("/novisitado.png");
                    }
                    ListRazonesSociales.append(sConsignataria, image);
                }
            } catch (IOException ioex) {
                SetMessage(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessage(ex.toString());
                ex.printStackTrace();
            }

            iIndexListFacturas = 0;
            iIndexListFacturasEntrega = 0;
            if (GetEntregaConsignatarias()) {
                ListRazonesSociales.setSelectedIndex(iIndexListRazonesSocialesEntrega, true);
            }
            else {
                ListRazonesSociales.setSelectedIndex(iIndexListRazonesSociales, true);
            }
        }//GEN-BEGIN:|117-getter|2|
        return ListRazonesSociales;
    }
    //</editor-fold>//GEN-END:|117-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListRazonesSocialesAction ">//GEN-BEGIN:|117-action|0|117-preAction
    /**
     * Performs an action assigned to the selected list element in the ListRazonesSociales component.
     */
    public void ListRazonesSocialesAction() {//GEN-END:|117-action|0|117-preAction
        // enter pre-action user code here
        if (GetEntregaConsignatarias()) {
            iIndexListRazonesSocialesEntrega = ListRazonesSociales.getSelectedIndex();
        }
        else {
            iIndexListRazonesSociales = ListRazonesSociales.getSelectedIndex();
        }

        //String __selectedString = ListRazonesSociales.getString(ListRazonesSociales.getSelectedIndex());
        String __selectedString = getListRazonesSociales().getString(getListRazonesSociales().getSelectedIndex());//GEN-LINE:|117-action|1|117-postAction
        // enter post-action user code here
        enumeration = CurrRutaConsignatarias.GetVectorRazonSocial().elements();
        while (enumeration.hasMoreElements()) {
            RazonSocialConsignatarias razonsocialconsignatarias_current = (RazonSocialConsignatarias) enumeration.nextElement();
            if (razonsocialconsignatarias_current.GetConsignataria().equalsIgnoreCase(__selectedString)) {
                CurrRazonSocialConsignatarias = razonsocialconsignatarias_current;
                break;
            }
        }

        CurrRazonSocialConsignatarias.SetVisitado(1);

        switchDisplayable(null, getListFacturas());
    }//GEN-BEGIN:|117-action|2|
    //</editor-fold>//GEN-END:|117-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldConsignatariasFaltantes ">//GEN-BEGIN:|123-getter|0|123-preInit
    /**
     * Returns an initiliazed instance of textFieldConsignatariasFaltantes component.
     * @return the initialized component instance
     */
    public TextField getTextFieldConsignatariasFaltantes() {
        if (textFieldConsignatariasFaltantes == null) {//GEN-END:|123-getter|0|123-preInit
            // write pre-init user code here
            textFieldConsignatariasFaltantes = new TextField("Faltantes", "", 3, TextField.NUMERIC);//GEN-LINE:|123-getter|1|123-postInit
            // write post-init user code here
        }//GEN-BEGIN:|123-getter|2|
        return textFieldConsignatariasFaltantes;
    }
    //</editor-fold>//GEN-END:|123-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldConsignatariasSobrantes ">//GEN-BEGIN:|124-getter|0|124-preInit
    /**
     * Returns an initiliazed instance of textFieldConsignatariasSobrantes component.
     * @return the initialized component instance
     */
    public TextField getTextFieldConsignatariasSobrantes() {
        if (textFieldConsignatariasSobrantes == null) {//GEN-END:|124-getter|0|124-preInit
            // write pre-init user code here
            textFieldConsignatariasSobrantes = new TextField("Sobrantes:", "", 3, TextField.NUMERIC);//GEN-LINE:|124-getter|1|124-postInit
            // write post-init user code here
        }//GEN-BEGIN:|124-getter|2|
        return textFieldConsignatariasSobrantes;
    }
    //</editor-fold>//GEN-END:|124-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: giveCommand ">//GEN-BEGIN:|125-getter|0|125-preInit
    /**
     * Returns an initiliazed instance of giveCommand component.
     * @return the initialized component instance
     */
    public Command getGiveCommand() {
        if (giveCommand == null) {//GEN-END:|125-getter|0|125-preInit
            // write pre-init user code here
            giveCommand = new Command("Entregar", Command.SCREEN, 0);//GEN-LINE:|125-getter|1|125-postInit
            // write post-init user code here
        }//GEN-BEGIN:|125-getter|2|
        return giveCommand;
    }
    //</editor-fold>//GEN-END:|125-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormFechaEntrega ">//GEN-BEGIN:|130-getter|0|130-preInit
    /**
     * Returns an initiliazed instance of FormFechaEntrega component.
     * @return the initialized component instance
     */
    public Form getFormFechaEntrega() {
        if (FormFechaEntrega == null) {//GEN-END:|130-getter|0|130-preInit
            // write pre-init user code here
            String sFormFechaEntregaTitle = "";
            if (GetEntregaExpendios()) {
                sFormFechaEntregaTitle = CurrFecha.GetFecha();
            }
            if (GetEntregaConsignatarias()) {
                sFormFechaEntregaTitle = CurrFechaConsignatarias.GetFecha();
            }

            FormFechaEntrega = new Form(sFormFechaEntregaTitle, new Item[] { getStringItemFormFechaEntregaEntregados(), getTextFieldFormFechaEntregaAdicionales(), getTextFieldFormFechaEntregaRestantes(), getChoiceGroupFormFechaEntregaEntrego() });//GEN-BEGIN:|130-getter|1|130-postInit
            FormFechaEntrega.addCommand(getBackCommand());
            FormFechaEntrega.setCommandListener(this);//GEN-END:|130-getter|1|130-postInit
            // write post-init user code here
            if (GetEntregaExpendios()) {
                int iFechaAdicionales = CurrFecha.GetAdicionales();
                String sFechaAdicionales = Integer.toString(iFechaAdicionales);
                textFieldFormFechaEntregaAdicionales.setString(sFechaAdicionales);

                int iFechaRestantes = CurrFecha.GetRestantes();
                String sFechaRestantes = Integer.toString(iFechaRestantes);
                textFieldFormFechaEntregaRestantes.setString(sFechaRestantes);

                choiceGroupFormFechaEntregaEntrego.setSelectedIndex(CurrFecha.GetEntrego(), true);
            }

            if (GetEntregaConsignatarias()) {
                int iFechaAdicionales = CurrFechaConsignatarias.GetAdicionales();
                String sFechaAdicionales = Integer.toString(iFechaAdicionales);
                textFieldFormFechaEntregaAdicionales.setString(sFechaAdicionales);

                int iFechaRestantes = CurrFechaConsignatarias.GetRestantes();
                String sFechaRestantes = Integer.toString(iFechaRestantes);
                textFieldFormFechaEntregaRestantes.setString(sFechaRestantes);

                choiceGroupFormFechaEntregaEntrego.setSelectedIndex(CurrFechaConsignatarias.GetEntrego(), true);
            }
        }//GEN-BEGIN:|130-getter|2|
        return FormFechaEntrega;
    }
    //</editor-fold>//GEN-END:|130-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldFormFechaEntregaAdicionales ">//GEN-BEGIN:|135-getter|0|135-preInit
    /**
     * Returns an initiliazed instance of textFieldFormFechaEntregaAdicionales component.
     * @return the initialized component instance
     */
    public TextField getTextFieldFormFechaEntregaAdicionales() {
        if (textFieldFormFechaEntregaAdicionales == null) {//GEN-END:|135-getter|0|135-preInit
            // write pre-init user code here
            textFieldFormFechaEntregaAdicionales = new TextField("Adicionales:", "", 3, TextField.NUMERIC);//GEN-LINE:|135-getter|1|135-postInit
            // write post-init user code here
        }//GEN-BEGIN:|135-getter|2|
        return textFieldFormFechaEntregaAdicionales;
    }
    //</editor-fold>//GEN-END:|135-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldFormFechaEntregaRestantes ">//GEN-BEGIN:|136-getter|0|136-preInit
    /**
     * Returns an initiliazed instance of textFieldFormFechaEntregaRestantes component.
     * @return the initialized component instance
     */
    public TextField getTextFieldFormFechaEntregaRestantes() {
        if (textFieldFormFechaEntregaRestantes == null) {//GEN-END:|136-getter|0|136-preInit
            // write pre-init user code here
            textFieldFormFechaEntregaRestantes = new TextField("Restantes:", "", 3, TextField.NUMERIC);//GEN-LINE:|136-getter|1|136-postInit
            // write post-init user code here
        }//GEN-BEGIN:|136-getter|2|
        return textFieldFormFechaEntregaRestantes;
    }
    //</editor-fold>//GEN-END:|136-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroupFormFechaEntregaEntrego ">//GEN-BEGIN:|137-getter|0|137-preInit
    /**
     * Returns an initiliazed instance of choiceGroupFormFechaEntregaEntrego component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroupFormFechaEntregaEntrego() {
        if (choiceGroupFormFechaEntregaEntrego == null) {//GEN-END:|137-getter|0|137-preInit
            // write pre-init user code here
            choiceGroupFormFechaEntregaEntrego = new ChoiceGroup("Entreg\u00F3?", Choice.EXCLUSIVE);//GEN-BEGIN:|137-getter|1|137-postInit
            choiceGroupFormFechaEntregaEntrego.append("No", null);
            choiceGroupFormFechaEntregaEntrego.append("Si", null);
            choiceGroupFormFechaEntregaEntrego.setSelectedFlags(new boolean[] { true, false });//GEN-END:|137-getter|1|137-postInit
            // write post-init user code here
        }//GEN-BEGIN:|137-getter|2|
        return choiceGroupFormFechaEntregaEntrego;
    }
    //</editor-fold>//GEN-END:|137-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemFormFechaEntregaEntregados ">//GEN-BEGIN:|140-getter|0|140-preInit
    /**
     * Returns an initiliazed instance of stringItemFormFechaEntregaEntregados component.
     * @return the initialized component instance
     */
    public StringItem getStringItemFormFechaEntregaEntregados() {
        if (stringItemFormFechaEntregaEntregados == null) {//GEN-END:|140-getter|0|140-preInit
            // write pre-init user code here
            String sEntregados = "";
            if (GetEntregaExpendios()) {
                sEntregados = CurrFecha.GetEntregados()+"";
            }
            if (GetEntregaConsignatarias()) {
                sEntregados = CurrFechaConsignatarias.GetEntregados()+"";
            }
            stringItemFormFechaEntregaEntregados = new StringItem("Entregar:", "");//GEN-LINE:|140-getter|1|140-postInit
            // write post-init user code here
            stringItemFormFechaEntregaEntregados.setText(sEntregados);
        }//GEN-BEGIN:|140-getter|2|
        return stringItemFormFechaEntregaEntregados;
    }
    //</editor-fold>//GEN-END:|140-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }


    private String GetMessage() {
        return this.Message;
    }

    private void SetMessage(String message) {
        this.Message = message;
    }


    private boolean GetEntregaExpendios() {
        return this.bEntregaExpendios;
    }

    private void SetEntregaExpendios(boolean entregaexpendios) {
        this.bEntregaExpendios = entregaexpendios;
    }


    private boolean GetEntregaConsignatarias() {
        return this.bEntregaConsignatarias;
    }

    private void SetEntregaConsignatarias(boolean entregaconsignatarias) {
        this.bEntregaConsignatarias = entregaconsignatarias;
    }


    private void WriteChanges() {
        (new Thread() {

            public void run() {
                boolean bWrote;

                Date d = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                String time = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
                CurrRuta.SetFecha(time);

                try {
                    bWrote = connectionhandler.WriteLocalFile(RUTAS.JSONObjectToString(), sFileApp);
                } catch (IOException ioex) {
                    bWrote = false;
                    SetMessage(ioex.toString());
                    ioex.printStackTrace();
                } catch (Exception ex) {
                    bWrote = false;
                    SetMessage(ex.toString());
                    ex.printStackTrace();
                }

                if (bWrote) {
                    System.out.println();
                    getAlert().setTitle("CORRECTO");
                    getAlert().setString("Información de ruta guardada.");
                    getAlert().setType(AlertType.INFO);
                    switchDisplayable(null, getAlert());
                } else {
                    System.out.println();
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Error al guardar información de ruta.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                }
            }
        }).start();
    }

    private void WriteChangesConsignatarias() {
        (new Thread() {

            public void run() {
                boolean bWrote;

                try {
                    bWrote = connectionhandler.WriteLocalFile(RUTASCONSIGNATARIAS.JSONObjectToString(), sFileApp);
                } catch (IOException ioex) {
                    bWrote = false;
                    SetMessage(ioex.toString());
                    ioex.printStackTrace();
                } catch (Exception ex) {
                    bWrote = false;
                    SetMessage(ex.toString());
                    ex.printStackTrace();
                }

                if (bWrote) {
                    System.out.println();
                    getAlert().setTitle("CORRECTO");
                    getAlert().setString("Información de Consignatarias guardada.");
                    getAlert().setType(AlertType.INFO);
                    switchDisplayable(null, getAlert());
                } else {
                    System.out.println();
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Error al guardar información de Consignatarias.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                }
            }
        }).start();
    }


    private void FetchLocalFile(String sParamFileURL) {
        try {
            connectionhandler = new ConnectionHandler();
            String sReadedFile = connectionhandler.ReadLocalFile(sParamFileURL);
            RUTAS = new Rutas(sReadedFile);
            SetMessage("[*] Ruta created.");
            switchDisplayable(null, getListProducto());
        } catch (IOException ioex) {
            SetMessage(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetMessage(ex.toString());
            ex.printStackTrace();
        }
    }

    private void FetchLocalFileConsignatarias(String sParamFileURL) {
        try {
            connectionhandler = new ConnectionHandler();
            String sReadedFile = connectionhandler.ReadLocalFile(sParamFileURL);
            RUTASCONSIGNATARIAS = new RutasConsignatarias(sReadedFile);
            SetMessage("[*] Ruta created.");
            switchDisplayable(null, getListConsignatarias());
        } catch (IOException ioex) {
            SetMessage(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetMessage(ex.toString());
            ex.printStackTrace();
        }
    }


    private int CalcFechaValor() {
        int iEntregados = CurrFecha.GetEntregados();
        int iDevueltos = CurrFecha.GetDevueltos();
        int iFaltantes = CurrFecha.GetFaltantes();
        int iSobrantes = CurrFecha.GetSobrantes();
        int iRinde = 0;

        if (iSobrantes!=0 && iDevueltos==0) {
            iRinde = iEntregados+iSobrantes;
        }
        if (iSobrantes!=0 && iDevueltos!=0) {
            iRinde = iEntregados-iDevueltos;
        }
        if (iSobrantes==0) {
            iRinde = iEntregados-iDevueltos-iFaltantes;
        }

        int iResult = iRinde*CurrFecha.GetValorUnitario();

        return iResult;
    }

    private int CalcFechaConsignatariasValorTotal() {
        int iEntregados = CurrFechaConsignatarias.GetEntregados();
        int iDevueltos = CurrFechaConsignatarias.GetDevueltos();
        int iRinde = 0;

        iRinde = iEntregados-iDevueltos;
        CurrFechaConsignatarias.SetEjemVend(iRinde);

        int iResult = iRinde*CurrFechaConsignatarias.GetValorUnitario();

        return iResult;
    }


    private int CalcCompendio() {
        int iCompendio = 0;
        enumeration = CurrExpendio.GetVectorFechas().elements();
        while (enumeration.hasMoreElements()) {
            Fecha fecha = (Fecha) enumeration.nextElement();

            if (fecha.GetCobrado() == 1) {
                iCompendio = iCompendio + fecha.GetValor();
            }
        }
        return iCompendio;
    }

    private int CalcCompendioFactura() {
        int iCompendio = 0;
        enumeration = CurrFacturaConsignatarias.GetVectorFechas().elements();
        while (enumeration.hasMoreElements()) {
            FechaConsignatarias fechaconsignatarias = (FechaConsignatarias) enumeration.nextElement();

            if (fechaconsignatarias.GetCobrado() == 1) {
                iCompendio = iCompendio + fechaconsignatarias.GetValorTotal();
            }
        }
        return iCompendio;
    }


    private int CalcExpendiosTotalEntregar() {
        int iTotalEntregar = 0;

        Enumeration eRuta = RUTAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            Ruta ruta = (Ruta) eRuta.nextElement();
            Enumeration eExpendio = ruta.GetVectorExpendios().elements();
            while (eExpendio.hasMoreElements()) {
                Expendio expendio = (Expendio) eExpendio.nextElement();
                Enumeration eFecha = expendio.GetVectorFechas().elements();
                while (eFecha.hasMoreElements()) {
                    Fecha fecha = (Fecha) eFecha.nextElement();

                    if (fecha.GetCobrado() == 1) {
                        iTotalEntregar = iTotalEntregar + fecha.GetValor();
                    }
                }
            }
        }
        return iTotalEntregar;
    }

    private int CalcConsignatariasTotalEntregar() {
        int iTotalEntregar = 0;

        Enumeration eRuta = RUTASCONSIGNATARIAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            RutaConsignatarias ruta = (RutaConsignatarias) eRuta.nextElement();
            Enumeration eRazonSocial = ruta.GetVectorRazonSocial().elements();
            while (eRazonSocial.hasMoreElements()) {
                RazonSocialConsignatarias razonsocial = (RazonSocialConsignatarias) eRazonSocial.nextElement();
                Enumeration eFactura = razonsocial.GetVectorFacturas().elements();
                while (eFactura.hasMoreElements()) {
                    FacturaConsignatarias factura = (FacturaConsignatarias) eFactura.nextElement();
                    Enumeration eFecha = factura.GetVectorFechas().elements();
                    while (eFecha.hasMoreElements()) {
                        FechaConsignatarias fecha = (FechaConsignatarias) eFecha.nextElement();

                        if (fecha.GetCobrado() == 1) {
                            iTotalEntregar = iTotalEntregar + fecha.GetValorTotal();
                        }
                    }
                }
            }
        }
        return iTotalEntregar;
    }


    private int CalcExpendiosCantidadEntregar() {
        int iCantidadEntregar = 0;

        Enumeration eRuta = RUTAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            Ruta ruta = (Ruta) eRuta.nextElement();
            Enumeration eExpendio = ruta.GetVectorExpendios().elements();
            while (eExpendio.hasMoreElements()) {
                Expendio expendio = (Expendio) eExpendio.nextElement();
                Enumeration eFecha = expendio.GetVectorFechas().elements();
                while (eFecha.hasMoreElements()) {
                    Fecha fecha = (Fecha) eFecha.nextElement();

                    if (fecha.GetCobrado() == 1) {
                        iCantidadEntregar = iCantidadEntregar + fecha.GetDevueltos();
                    }
                }
            }
        }
        return iCantidadEntregar;
    }

    private int CalcConsignatariasCantidadEntregar() {
        int iCantidadEntregar = 0;

        Enumeration eRuta = RUTASCONSIGNATARIAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            RutaConsignatarias ruta = (RutaConsignatarias) eRuta.nextElement();
            Enumeration eRazonSocial = ruta.GetVectorRazonSocial().elements();
            while (eRazonSocial.hasMoreElements()) {
                RazonSocialConsignatarias razonsocial = (RazonSocialConsignatarias) eRazonSocial.nextElement();
                Enumeration eFactura = razonsocial.GetVectorFacturas().elements();
                while (eFactura.hasMoreElements()) {
                    FacturaConsignatarias factura = (FacturaConsignatarias) eFactura.nextElement();
                    Enumeration eFecha = factura.GetVectorFechas().elements();
                    while (eFecha.hasMoreElements()) {
                        FechaConsignatarias fecha = (FechaConsignatarias) eFecha.nextElement();

                        if (fecha.GetCobrado() == 1) {
                            iCantidadEntregar = iCantidadEntregar + fecha.GetDevueltos();
                        }
                    }
                }
            }
        }
        return iCantidadEntregar;
    }


    private int CalcExpendiosEntregados() {
        int iExpendiosEntregados = 0;

        Enumeration eRuta = RUTAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            Ruta ruta = (Ruta) eRuta.nextElement();
            Enumeration eExpendio = ruta.GetVectorExpendios().elements();
            while (eExpendio.hasMoreElements()) {
                Expendio expendio = (Expendio) eExpendio.nextElement();
                Enumeration eFecha = expendio.GetVectorFechas().elements();
                while (eFecha.hasMoreElements()) {
                    Fecha fecha = (Fecha) eFecha.nextElement();

                    if (fecha.GetEntrego() == 1) {
                        iExpendiosEntregados = iExpendiosEntregados + fecha.GetEntregados();
                    }
                }
            }
        }
        return iExpendiosEntregados;
    }

    private int CalcConsignatariasEntregados() {
        int iConsignatariasEntregar = 0;

        Enumeration eRuta = RUTASCONSIGNATARIAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            RutaConsignatarias ruta = (RutaConsignatarias) eRuta.nextElement();
            Enumeration eRazonSocial = ruta.GetVectorRazonSocial().elements();
            while (eRazonSocial.hasMoreElements()) {
                RazonSocialConsignatarias razonsocial = (RazonSocialConsignatarias) eRazonSocial.nextElement();
                Enumeration eFactura = razonsocial.GetVectorFacturas().elements();
                while (eFactura.hasMoreElements()) {
                    FacturaConsignatarias factura = (FacturaConsignatarias) eFactura.nextElement();
                    Enumeration eFecha = factura.GetVectorFechas().elements();
                    while (eFecha.hasMoreElements()) {
                        FechaConsignatarias fecha = (FechaConsignatarias) eFecha.nextElement();

                        if (fecha.GetEntrego() == 1) {
                            iConsignatariasEntregar = iConsignatariasEntregar + fecha.GetEntregados();
                        }
                    }
                }
            }
        }
        return iConsignatariasEntregar;
    }


    private int CalcExpendiosRestantesEntregar() {
        int iRestantesEntregar = 0;

        Enumeration eRuta = RUTAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            Ruta ruta = (Ruta) eRuta.nextElement();
            Enumeration eExpendio = ruta.GetVectorExpendios().elements();
            while (eExpendio.hasMoreElements()) {
                Expendio expendio = (Expendio) eExpendio.nextElement();
                Enumeration eFecha = expendio.GetVectorFechas().elements();
                while (eFecha.hasMoreElements()) {
                    Fecha fecha = (Fecha) eFecha.nextElement();

                    if (fecha.GetEntrego() == 1) {
                        iRestantesEntregar = iRestantesEntregar + fecha.GetRestantes();
                    }
                }
            }
        }
        return iRestantesEntregar;
    }

    private int CalcConsignatariasRestantesEntregar() {
        int iRestantesEntregar = 0;

        Enumeration eRuta = RUTASCONSIGNATARIAS.GetVectorRutas().elements();
        while (eRuta.hasMoreElements()) {
            RutaConsignatarias ruta = (RutaConsignatarias) eRuta.nextElement();
            Enumeration eRazonSocial = ruta.GetVectorRazonSocial().elements();
            while (eRazonSocial.hasMoreElements()) {
                RazonSocialConsignatarias razonsocial = (RazonSocialConsignatarias) eRazonSocial.nextElement();
                Enumeration eFactura = razonsocial.GetVectorFacturas().elements();
                while (eFactura.hasMoreElements()) {
                    FacturaConsignatarias factura = (FacturaConsignatarias) eFactura.nextElement();
                    Enumeration eFecha = factura.GetVectorFechas().elements();
                    while (eFecha.hasMoreElements()) {
                        FechaConsignatarias fecha = (FechaConsignatarias) eFecha.nextElement();

                        if (fecha.GetEntrego() == 1) {
                            iRestantesEntregar = iRestantesEntregar + fecha.GetRestantes();
                        }
                    }
                }
            }
        }
        return iRestantesEntregar;
    }

}
