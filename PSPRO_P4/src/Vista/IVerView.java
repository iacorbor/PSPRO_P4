/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

import Modelo.Account;

import java.awt.event.ActionListener;

/**
 *
 * @author israb
 */
public interface IVerView {
    void addSiguienteListener(ActionListener listener);
    void addAnteriorListener(ActionListener listener);
    // a la espera de los botones de antonio
    void setAccountData(Account cuenta);
    String getModifiedBalance();
}
