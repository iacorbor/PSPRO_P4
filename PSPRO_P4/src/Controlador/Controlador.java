/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *
 * @author israb
 */
public class Controlador {

    private IMainFrame mainFrame;
    private IResumenView resumenView;
    private IVerView verView;

    private IAuthenticator authDAO;
    private IAccountResume accountResumeDAO;
    private IClientResume clientResumeDAO;

    
    private Client clienteValidado;


    public Controlador(IMainFrame mainFrame, IResumenView resumenView, IVerView verView, IAuthenticator authDAO, IAccountResume accountResumeDAO, IClientResume clientResumeDAO) 
    {

        this.mainFrame = mainFrame;
        this.resumenView = resumenView;
        this.verView = verView;
        this.authDAO = authDAO;
        this.accountResumeDAO = accountResumeDAO;
        this.clientResumeDAO = clientResumeDAO;

        this.mainFrame.addLoginListener(e -> onLogin());
        this.mainFrame.addVerListener(e -> onShowVerPanel());
        this.mainFrame.addResumenListener(e -> onShowResumenPanel());
        this.mainFrame.addSalirListener(e -> onLogout());
    }


    private void onLogin() {

        String user = mainFrame.requestUser();
        String pass = mainFrame.requestPassword();

        this.clienteValidado = authDAO.validate(user, pass);


        if (this.clienteValidado != null) {
            mainFrame.enableMenu(true); 
            mainFrame.showMessage("Bienvenido, " + clienteValidado.getName());

            onShowResumenPanel(); 
        } else {
            mainFrame.showErrorMessage("Error: Usuario o contrase�a incorrectos.");
        }
    }

    private void onShowVerPanel() {

        mainFrame.showPanel("Ver");
    }

    private void onShowResumenPanel() {

        Client cliente = clientResumeDAO.getClient(this.clienteValidado.getId());
        List<Account> cuentas = accountResumeDAO.getAccounts(this.clienteValidado.getId());


        resumenView.setDatosCliente(cliente);
        resumenView.setTablaCuentas(cuentas);
        

        mainFrame.showPanel("Resumen");
    }
    
    private void onLogout() {
        this.clienteValidado = null;
        mainFrame.enableMenu(false);
        mainFrame.showPanel("Login"); 
        mainFrame.showMessage("Sesi�n cerrada.");
    }
}
