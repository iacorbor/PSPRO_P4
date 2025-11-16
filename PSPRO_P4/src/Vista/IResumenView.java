/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author israb
 */
public interface IResumenView {
    void addCalcularSaldoListener(ActionListener listener);
    void setDatosCliente(Cliente cliente);
    void setTablaCuentas(List<Cuenta> cuentas);
}
