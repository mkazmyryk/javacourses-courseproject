package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.GamesLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GamesFileIn {
    private final GamesLibrary gamesLibrary = new GamesLibrary();
    private final List<String> gamesInput;
    private final int numberOfColumns;

    public GamesFileIn(List<String> gamesInput, int numberOfColumns) {
        this.gamesInput = gamesInput;
        this.numberOfColumns = numberOfColumns;
        removeTitles();
        initialize();
    }

    private void removeTitles() {
        for (int i = 0; i < numberOfColumns; i++) {
            gamesInput.remove(0);
        }
    }

    private void initialize() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");//Needs for reading date format
        for (int i = 0; i < gamesInput.size() / numberOfColumns; i++) {
            gamesLibrary.addGame(new Game(gamesInput.get(i * numberOfColumns), gamesInput.get(1 + i * numberOfColumns),
                    LocalDate.parse(gamesInput.get(2 + i * numberOfColumns), dateTimeFormatter),
                    gamesInput.get(3 + i * numberOfColumns), gamesInput.get(4 + i * numberOfColumns)));
        }
    }

    public GamesLibrary getGamesLibrary() {
        return gamesLibrary;
    }
}
