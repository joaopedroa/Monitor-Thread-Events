package com.teste.teste.threads;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.teste.teste.models.Monitor;

@Component
public class MonitorComponent {
	
	List<Monitor> monitors = new ArrayList<Monitor>();
	
	
	@PostConstruct
	public void initializer() {
		Thread thread = new Thread(() -> monitor());
		thread.setName("Joao-Teste-01");
		thread.start();
	}
	
	private void monitor() {
		while(true) {
			System.out.println(" ######### monitorando... ########");
			try {
				Thread.sleep(3000l);
			}catch (Exception e) {
				System.out.println("error sleep thread");
			}
			System.out.println(" =====================inicio===========================");
			for(Monitor monitor: monitors) {
				
				System.out.println("Executando thread de nome: " + Thread.currentThread().getName());
				System.out.println("ID: " + monitor.getId());
				System.out.println("Ativo: " + monitor.isAtivo());
				System.out.println("Nome: " + monitor.getNome());
				
				if(monitor.getId() == 99)
					throw new RuntimeException();
			}
			System.out.println(" =====================fim===============================");
			
			
		}
	}
	
	public boolean adicionarItemParaMonitoramento(Monitor monitor) {
		return monitors.add(monitor);
	}

	public String getStatusThread() {
		return Thread.currentThread().getState().name();
	}

}
