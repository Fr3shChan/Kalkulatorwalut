
# Prosty kalkulator walutowy 

napisany został przy użyciu IntelliJ IDEA Community. 



Przy jego użyciu można dokonać prostego przeliczenia kwoty podanej w walucie EUR (Euro) na kwotę w walucie wyszczegolnionej w pliku z kursami walut.



# Zawartość:

    Folder z projektem zawiera:

        1. kod programu

        2. plik "waluty-daily.xml"

        3. niniejszy plik Readme.txt



# Uruchomienie

    By uruchomić program należy:

        1. Uruchomić "IntelliJ IDEA"

        2. Wybrać File/Open a następnie wskazać folder z projektem

        3. Po lewej stronie ekranu

            a) rozwinąć "Kalkulator - projekt" 

            b) rozwinąć "src"

            c) rozwinąć "com.Company" 

            d) wybrać (dwuklickiem) "Main"

        4. Uruchomić program

               

# Działanie

    1. Po uruchomieniu, program parsuje plik XML o nazwie "waluty-daily.xml" przy użyciu biblioteki "Parse DOM".

    2. Prosi o podanie kwoty w walucie głównej (EUR) do przeliczenia

    3. Prosi o podanie symbolu waluty docelowej (do ktorej nastąpi przeliczenie)

    4. Wyświetla podsumowanie operacji w postaci: kurs waluty docelowej oraz kwota transakcji przeliczenia.

    

# Zaimplementowana kontrola błędow

    1. kwota - czy ciąg zawiera wartości przewidziane dla zmiennej "float"

    2. kod waluty - zamiana ciągu na wielkie litery



# Ograniczenia

    1. Przy wpisywaniu wartości kwoty, dla wartości dziesiętnych należy użyć znaku "," (przecinek)

    2. Jeśli wskazana waluta docelowa nie zostanie odszukana w pliku "waluty-daily.xml", przeliczenie nie będzie miało miejsca

    



