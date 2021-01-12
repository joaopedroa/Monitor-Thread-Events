package com.teste.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.teste.models.Monitor;
import com.teste.teste.threads.MonitorComponent;

@Service
public class MonitoramentoService {
	
	@Autowired
	MonitorComponent monitorComponent;
	
	public void adicionarItemParaMonitoramento(Monitor monitor) {
		monitorComponent.adicionarItemParaMonitoramento(monitor);
	}

	public String getStatusThread() {
		return monitorComponent.getStatusThread();
	}

}
