package dadosClimatitos;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONObject;

public class Sistema {
	public static String imprimirDadosClimaticos(String dados) throws Exception {
//		System.out.println("Dados originais (JSON) obtidos no site meteorológico" + dados);
		
		JSONObject dadosJson = new JSONObject(dados);
		JSONObject informacoesMeteorologicas = dadosJson.getJSONObject("current");
		
		// Extrai os dados da localização
		String cidade = dadosJson.getJSONObject("location").getString("name");
		String pais = dadosJson.getJSONObject("location").getString("country");
		
		// Extraia os dados adicionais
		String condicaoTempo = informacoesMeteorologicas.getJSONObject("condition").getString("text");
		int umidade = informacoesMeteorologicas.getInt("humidity");
		float velocidadeVnto = informacoesMeteorologicas.getFloat("wind_kph");
		float pressaoAtmosferica = informacoesMeteorologicas.getFloat("pressure_mb");
		float sensacaoTermica = informacoesMeteorologicas.getFloat("feelslike_c");
		float temperaturaAtual = informacoesMeteorologicas.getFloat("temp_c");
		
		// Extrair a data e a hora da String retornada pela API
		String dataHoraString = informacoesMeteorologicas.getString("last_updated");
		
		// Imprimir as informações atuais
		return "Informações Meteorológicas para " + cidade + ", " + pais 
				+ "\nData e hora: " + formatarDataHora(dataHoraString) 
				+ "\nTemperatura Atual: " + temperaturaAtual + "°C" 
				+ "\nSensação Térmica: " + sensacaoTermica + "°C" 
				+ "\nCondição do tempo: " + condicaoTempo 
				+ "\nUmidade: " + umidade + "%"
				+ "\nVelocidade do vento: " + velocidadeVnto + " km/h"
				+ "\nPressão Atimosferica: " + pressaoAtmosferica + " mb";
	}
	
	// Método para imprimir os dados meteorologicos de forma organizada
	public static String getDadosClimaticos(String cidade) throws Exception {
		String caminhoApi = "E:\\Eclipse-WorkSpace\\Projetos\\src\\dadosClimatitos\\api-key.txt";
		String apiKey = Files.readString( Paths.get(caminhoApi)).trim();
		
		String formatNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
		String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formatNomeCidade;
		HttpRequest request = HttpRequest.newBuilder() // Começa a contruir de uma nova solicitação HTTP
				.uri(URI.create(apiUrl)) // Este método define o URI da solicitação HTTP.
				.build(); // Finaliza a construção da solicitação HTTP.
		
		// Criar objeto enviar solicitação HTTP e receber resposta HTTP, para acessar o site da WeatherAPI
		HttpClient cliente = HttpClient.newHttpClient();
		
		// Agora vamos enviar requisições HTTP e receber resposta Http, comunicar com site da API Metrorologica.
		HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body(); // retorna os dados meteorologicos obtidos no site da API (WeatherAPI)
	}
	
	// Método para formatar a data e a hora
    public static String formatarDataHora(String dataHoraString) throws Exception {
        // Formato da data e hora recebida pela API
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        formatoEntrada.setTimeZone(TimeZone.getTimeZone("UTC"));

        // Formato desejado para a exibição
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // Converte a string de entrada para uma data
        Date data = formatoEntrada.parse(dataHoraString);

        // Retorna a data formatada
        return formatoSaida.format(data);
    }
}
