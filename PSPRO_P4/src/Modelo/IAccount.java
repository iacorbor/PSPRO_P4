/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author israb
 */
public interface IAccount {
    Account getFirst(int idClient);
    Account getNext();
    Account getBack();
    Account getLast();
    void updateBalance(float newBalance);
    void close();
}