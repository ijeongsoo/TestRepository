/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class HttpGetClient {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			URIBuilder uribuilder= new URIBuilder("http://192.168.3.129:8080/IoTWebProgramming/http/exam01");
			uribuilder.setParameter("thermistor", String.valueOf(25));
			uribuilder.setParameter("photoresistor", String.valueOf(200));
			
			HttpGet httpGet = new HttpGet(uribuilder.build());

			CloseableHttpResponse response = httpClient.execute(httpGet);
			try {
				
				HttpEntity resEntity = response.getEntity();

				if (resEntity != null) {
					InputStream is = resEntity.getContent();
					try {
						String json = "";
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br = new BufferedReader(isr);
						
						while(true){
							String data = br.readLine();
							if(data == null) break;
							json+=data;
						}
						JSONObject jsonObject = new JSONObject(json);
						double thermistor = jsonObject.getDouble("thermistor");
						double photoresistor=jsonObject.getDouble("photoresistor");
						System.out.println(thermistor);
						System.out.println(photoresistor);
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						is.close();
					}
				}
			} finally {
				response.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			httpClient.close();
		}
	}

}
