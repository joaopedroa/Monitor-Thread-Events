package com.teste.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.teste.models.Monitor;
import com.teste.teste.service.MonitoramentoService;

@RestController
public class MonitoramentoController {
	
	@Autowired
	MonitoramentoService service;

	
	@PostMapping(value = "api/monitora")
	public ResponseEntity<Void> inserirItemParaMonitoramento(@RequestBody Monitor monitor){
		this.service.adicionarItemParaMonitoramento(monitor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="api/status-thread")
	public ResponseEntity<String> getStatusThread(){
		String status = service.getStatusThread();
		return new ResponseEntity<>(status ,HttpStatus.OK);
	}
}
