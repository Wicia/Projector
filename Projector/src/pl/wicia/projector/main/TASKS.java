/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.wicia.projector.main;

/**
 * @TODO: Add class description
 * @TODO: Add descrptions to fields
 * @TODO: Add descrptions to methods
 * @author Michał 'Wicia' Wietecha
 */
public class TASKS {
    
    private static class Critical{
        //TODO: ServiceBase + mechanizm batchy
        //TODO: Może do plików Entity zastosować wzorzec Dekorator?
        //TODO: dorobić mapowanie kolekcji do pozostałych klas entity
        //TODO: wykorzystać wrappery w serwisach
        //TODO: dorobić obiekt BatchUpdater(index, size, session)
        //TODO: superklasa używająca JFRAME + mając obiekt do wyświetlania dialogów
        //TODO: Services/sprawdzić, czy metody update'ujące operują na małej ilości danych (nie ma wyciągania z bazy i update'u na dużej liczbie danych)
    }
    
    private static class Typical{
        //TODO: Gdzie umieścić metody uzywajace named query?
        //TODO: uzupełnić pliki Entity, o dodatkowe atrybuty w properties
        //TODO: dodać nazwy do każdych z okienek + odznaczyć opcję Resizeable
        //TODO: Gdzie umieścić metody uzywajace named query?
        //TODO: stworzyć obiekt z ustawieniami + zaimplementować go w cctorach okienek i miejsc, gdzie są tworzone
        //TODO: tam gdzie sa tabele ustawić wysokość wierszy
    }
    
//        AppSettings settings = ContextSettings.getAppSettings();
//        this.initLabelWorkshopName(settings);
//        Object value = settings.getPropertyValue(PropertyName.WorkshopName);
//        if(value != null){
//            this.labelWorkshopName.setText(value.toString());
//        }
}