/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author israb
 */
public interface IMainFrame {
     void enableMenu(boolean enable);
     void addLoginListener(ActionListener Listener);
     void addVerListener(ActionListener listener);
    void addResumenListener(ActionListener listener);
    void addSalirListener(ActionListener listener);
    void showPanel(String nombrePanel);
    void showMessage(String mensaje);
    String requestUser();
    String requestPassword();
    void showErrorMessage(String message);
}
