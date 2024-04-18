# Omni-kom

Projekt na przedmiot MAS

## Opis projektu

Omni-kom to serwis łączący graczy. Umożliwia przeglądanie katalogu gier, zakup gier dla siebie lub jako prezent dla znajomych, a także zarządzanie swoim profilem i portfelem. Projekt został zrealizowany w języku Java, z wykorzystaniem biblioteki graficznej Swing i biblioteki Lombok do obsługi metod dostępu do atrybutów.

## Struktura projektu

Projekt składa się z kilku głównych części:

- `src/main/java/mas/Models/`: zawiera modele danych, takie jak `Member`, `Product`, `Rating`, `Transaction` i `User`.
- `src/main/java/mas/View/`: zawiera klasy odpowiedzialne za interfejs użytkownika, takie jak `BuyGameWindow`, `GameWindow`, `LoginWindow`, `MainWindow`, `RegisterWindow` i `WelcomeWindow`.
- `src/main/java/mas/Main.java`: punkt wejścia do aplikacji.
- `doc/`: zawiera dokumentację projektu, w tym diagramy i mockupy GUI.
- `pom.xml`: plik konfiguracyjny Maven, który definiuje zależności projektu i ustawienia kompilacji.

## Jak uruchomić

Aby uruchomić projekt, wykonaj następujące kroki:

1. Sklonuj repozytorium.
2. Otwórz projekt w IDE obsługującym Maven (np. IntelliJ IDEA).
3. Uruchom główną klasę `Main`.

## Przyszła ewolucja systemu

Planowane jest rozszerzenie funkcjonalności systemu, w tym:

- Rozszerzenie biblioteki gier o nowe tytuły i kategorie gier
- Ulepszenie funkcjonalności osiągnięć i dodanie nowych właściwości
- Dodanie funkcjonalności związanych z grami wieloosobowymi, takich jak turnieje i rankingi
- Ulepszenie interfejsu użytkownika i dostosowanie go do różnych urządzeń
- Dodanie funkcjonalności związanych z transakcjami, takich jak płatności mobilne i krypto waluty
- Rozszerzenie funkcjonalności czatu o nowe funkcje, takie jak wideo czat i integracja z innymi platformami społecznościowymi.

## Linki

- [Notion – Wiki projektu](https://linden-studies.notion.site/Dokumentacja-projektu-d817bd6034264250879c01d338eab35d?pvs=4)