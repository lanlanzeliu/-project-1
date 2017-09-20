class Borders {
   String[][] borders = {{"Germany", "Austria","Belgium", "CzechRepublic","Denmark","France","Luxembourg","Netherlands","Poland","Switzerland"},
                         {"Netherlands", "Belgium", "Germany"},
                         {"Belgium", " France","Germany", "luxembourg","Netherlands"},
                         {"Luxembourg","Belgium", "France", "Germany"},
                         {"Poland","Belarus","CzechRepublic","Germany","Lithuania","Russia","Slovakia","Ukraine"},
                         {"CzechRepublic","Austria","Germany","Poland","Slovakia"},
                         {"Austria","CzechRepublic", "Germany","Hungary", "Italy", "Liechtenstein", "Slovakia", "Slovenia", "Switzerland"},
                         {"France", "Andorra", "Belgium", "Germany", "Italy", "Luxembourg", "Monaco","Spain", "Switzerland"}
                         };
  
   public boolean isBordered(Countries a, Countries b){
      for ( int i = 0; i < borders.length; i++){
         if (borders[i][0].equals(a.countryName)){
           for ( int j=0; j < borders[i].length; j++){
               if (borders[i][j].equals(b.countryName)){
                  return true;
               }
           }
         }
         else if (borders[i][0].equals(b.countryName)){
           for ( int j=0; j < borders[i].length; j++){
               if (borders[i][j].equals(a.countryName)){
                  return true;
               }
           }
         }
       }return false;  
   }
}