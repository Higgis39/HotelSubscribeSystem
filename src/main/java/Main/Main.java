package Main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMI.RemoteHelper;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.controller.FrameController;
import presentation.view.LoginFrame;

public class Main {

private RemoteHelper remoteHelper;
	
	public Main() {
		linkToServer();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataFactoryService"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public RemoteHelper getRemoteHelper(){
		return remoteHelper;
	}
	
	
	public static void main(String[] args){
		Main cr = new Main();
		Application.launch(LoginFrame.class, args);
	}

}
