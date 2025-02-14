package newIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExemploNewIo {

	public static void main(String[] args) {
		
		String content = null;
		try {
			Path path = Paths.get("E:\\Eclipse-WorkSpace\\Projetos\\src\\newIO\\new.txt");
			
			Files.write(path, "Olá, mundo!".getBytes());
			
			byte[] bytes = Files.readAllBytes(path);
			
			content = new String(bytes);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(content);
	}
}
