package com.gmail.mizuno.tamaki.tUrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

import com.gmail.mizuno.tamaki.tUrl.args.Args;

public class TUrl {
	
	public static void main(String[] args) {
		execute(Args.parse(args));
	}

	private static void execute(Args args) {
		// TODO Auto-generated method stub
		Socket sock = null;
		try {
			sock = new Socket("mikilab.doshisha.ac.jp", 80);
			Reader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			Writer out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			out.write("GET " + "http://mikilab.doshisha.ac.jp/index.html" + " HTTP/1.1\r\n");
			out.write("Host: " + "mikilab.doshisha.ac.jp" + "\r\n");
			out.write("Connection: close\r\n");
			out.write("\r\n");
			out.flush();
			
			char[] buf = new char[4096];
			while (in.read(buf) != -1) {
				System.out.println(buf);
			}
		} catch (IOException e) {
			//TODO
			e.printStackTrace();
		} finally {
			try {
				if (sock != null) {
					sock.close();
				}
			} catch (IOException e) {}
		}
	}
}
