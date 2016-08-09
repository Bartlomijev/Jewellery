package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Shop;

public class FileManager {
	public static final String FILE_NAME = "companyHistory.txt";

	public void WriteToFile(Shop s){
		try(
			FileOutputStream fos = new FileOutputStream(FILE_NAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(s);
		} catch (FileNotFoundException e) {
			System.err.println("Nie odnaleziono pliku " + FILE_NAME);
		} catch (IOException e) {
			System.err.println("Wystąpił błąd przy zapisie danych do pliku " + FILE_NAME);
		}
	}

	public Shop ReadFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		Shop shop = null;
		try(
				FileInputStream fis = new FileInputStream(FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis);

				){
			shop = (Shop) ois.readObject();
		} catch (FileNotFoundException e) {
			System.err.println("Nie odnaleziono pliku *" + FILE_NAME);
			throw e;
		} catch (IOException e) {
			System.err.println("Wystąpił błąd przy zapisie danych do pliku " + FILE_NAME);
			throw e;
		} catch (ClassNotFoundException e) {
			System.err.println("zły format pliku");
			throw e;
		}
		return shop;
	}


}
