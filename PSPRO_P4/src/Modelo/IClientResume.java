/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author israb
 */
public interface IClientResume {
    Client getClient(int idClient);
    float calculateTotalBalance(int idClient);
}
