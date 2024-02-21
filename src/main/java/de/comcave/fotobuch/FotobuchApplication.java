package de.comcave.fotobuch;

import de.comcave.fotobuch.covers.Cover;
import de.comcave.fotobuch.covers.HardCover;
import de.comcave.fotobuch.covers.SoftCover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@SpringBootApplication
public class FotobuchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FotobuchApplication.class, args);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println();

            Cover cover = null;
            int choice = 0;
            do {
                System.out.println("Wählen Sie den Bucheinbandtyp:");
                System.out.println("1. Hardcover");
                System.out.println("2. Softcover");
                System.out.print("Ihre Wahl (1 oder 2): ");

                choice = Integer.parseInt(reader.readLine());
                cover = choice == 1 ? new HardCover() : new SoftCover();
            } while (choice != 1 && choice != 2);

            System.out.print("Anzahl der Seiten (max: " + cover.getMaxPages() + "): ");
            int totalPages = Integer.parseInt(reader.readLine());

            System.out.print("Titel des Fotobuchs: ");
            String title = reader.readLine();

            cover = cover instanceof HardCover ? new HardCover(title, totalPages) : new SoftCover(title, totalPages);
            System.out.println(cover);
        } catch (IOException | NumberFormatException e) {
            log.error("Fehler bei der Benutzereingabe oder Konvertierung.", e);
        }
    }
}