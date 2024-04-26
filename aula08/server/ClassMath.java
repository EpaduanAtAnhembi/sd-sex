package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import util.InterfaceMath;

public class ClassMath 
    extends UnicastRemoteObject implements InterfaceMath {

    protected ClassMath() throws RemoteException {
        System.out.println("Objeto Math criado");
    }

    @Override
    public double somar(double n1, double n2) throws RemoteException {
        System.out.println("somando " + n1 + " e " + n2);
        return n1 + n2;
    }

    @Override
    public double multiplicar(double n1, double n2) throws RemoteException {
        System.out.println("multiplicando " + n1 + " e " + n2);
        return n1 * n2;
    }
}
