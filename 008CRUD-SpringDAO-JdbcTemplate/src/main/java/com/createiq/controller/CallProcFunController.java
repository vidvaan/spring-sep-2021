package com.createiq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.createiq.dao.CallProcFunDAO;

@Controller
public class CallProcFunController {
	
	@Autowired
	private CallProcFunDAO callProcFunDAO;
	
	public int callAdditionFunction(int num1, int num2) {
		return callProcFunDAO.callAdditionFunction(num1, num2);
	}
	
	public Map<String, Integer> callCalProc(int num1,int num2){
		return callProcFunDAO.callCalProc(num1, num2);
	}

}
