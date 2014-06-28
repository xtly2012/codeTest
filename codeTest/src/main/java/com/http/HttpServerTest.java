package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerTest {
	
	public static void main(String[] argus) {
		ServerSocket serverSocket = null;
		try {
			Socket socket = null;
			serverSocket = new ServerSocket(16000, 1, InetAddress.getByName("127.0.0.1"));
			while (true) {
				socket = serverSocket.accept();
				PrintHttp http = new PrintHttp(socket);
				new Thread(http).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static class PrintHttp implements Runnable {
		
		private Socket socket; 
		
		public PrintHttp(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			
			try {
				String line = null;
				StringBuffer reqBuf = new StringBuffer();
				BufferedReader bufReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				while ((line = bufReader.readLine()) != null) {
					reqBuf.append(line);
				}
				
				System.out.println(reqBuf.toString());
				
				
				OutputStream output = this.socket.getOutputStream();
				output.write("success".getBytes());
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
