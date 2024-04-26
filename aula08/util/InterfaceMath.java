package util;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceMath extends Remote {
    public double somar(double n1, double n2) throws RemoteException;
    public double multiplicar(double n1, double n2) throws RemoteException;
}