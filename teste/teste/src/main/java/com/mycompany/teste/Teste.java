/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

/**
 *
 * @author Aluno
 */
public class Teste {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0,0");

 	com.sun.management.OperatingSystemMXBean mxbean = 
		(com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	//System.out.println("Memoria Total : " + mxbean.getTotalPhysicalMemorySize() + " MegaBytes "); 
        System.out.println("Usuario: " + System.getProperty("user.name").toUpperCase());
        System.out.println("Arquitetura: " + System.getProperty("os.arch").toUpperCase());  
        System.out.println("Versão do S.O.: " + System.getProperty("os.version").toUpperCase()); 
        System.out.println("Nome do S.O.: " + System.getProperty("os.name").toUpperCase()); 

        String memoriaTotal = df.format(mxbean.getTotalPhysicalMemorySize()/ 100000000 - 5);
        System.out.println("Memoria Total : " + memoriaTotal + " GigaBytes ");
        	
	//System.out.println("Memoria disponivel : " + mxbean.getFreePhysicalMemorySize() +  " MegaBytes");
        String memoriaLivre = df.format(mxbean.getFreePhysicalMemorySize() / 100000000); 
        System.out.println("Memoria disponivel : " + memoriaLivre + " GigaBytes ");
        Double memoriaOcupada = Double.valueOf(memoriaTotal) - Double.valueOf(memoriaLivre);
       // Double porcentagem = (Double.valueOf(memoriaLivre) / Double.valueOf(memoriaTotal)) * 100;
       Double porcentagemOcupada = (memoriaOcupada / Double.valueOf(memoriaTotal)) * 100;
        System.out.println(String.format("Estamos com %.2f%s de memória em uso!",porcentagemOcupada, "%"));
        
    }
}
