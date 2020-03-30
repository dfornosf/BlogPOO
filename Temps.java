/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Temps {
    
    private int dia;

    private int hora;

    public Temps() {
    }
    public Temps(java.lang.String temps){
        String[] diayhora = temps.split(" ");
        String diaconguiones=diayhora[0];
        String horaconpuntos = diayhora[1];
        String[] dayarray = diaconguiones.split("-");
        String[] hourarray  = horaconpuntos.split(":");
        String day = new String();
        String hour = new String();
        for(int i=0;i<dayarray.length;i++){
             day = day + dayarray[i];
             hour = hour + hourarray[i];
        }
        this.dia = Integer.parseInt(day);
        this.hora = Integer.parseInt(hour);
        
        }
        public void ara(){
            String dataactual = LocalDateTime.now().toString();
            String data = dataactual.substring(0,19);
           String[] arraytemps = data.split("T");
           String formatocorrecto = arraytemps[0] + " " + arraytemps[1];
           Temps ara = new Temps(formatocorrecto);
           this.dia = ara.dia;
           this.hora = ara.hora;
    }
        
        
        public int comparaDia(Temps altre){
            
            if(altre.getDia()/10000>this.getDia()/10000)
                return -89;
            else if((altre.getDia()/10000)==(this.getDia()/10000) && ((altre.getDia()/100)%100)>((this.getDia()/100)%100))
                    return -87;
            else if((altre.getDia()/10000)==(this.getDia()/10000) && ((altre.getDia()/100)%100)==((this.getDia()/100)%100) && (altre.getDia()%100)>(this.getDia()%100))
                return -746446;
            else if(this.getDia() == altre.getDia())
                return 0;
            else
                return 847;
     
            
        }
        
        
        public int comparaTemps(Temps altre){
            if(this.comparaDia(altre)>0)
                return 1;
            else if(this.comparaDia(altre) == 0 && this.getHora() == altre.getHora() )
                return 0;
            else if(this.comparaDia(altre) == 0 && this.getHora()/10000 > altre.getHora()/10000)
                return 2;
            else if(this.comparaDia(altre) == 0 && this.getHora()/10000 == altre.getHora()/10000 && ((this.getHora()/100)%100) > ((altre.getHora()/100)%100))
                return 3;
            else if(this.comparaDia(altre) == 0 && this.getHora()/10000 == altre.getHora()/10000 && (this.getHora()/100)%100 == (altre.getHora()/100)%100 && this.getHora()%100 > altre.getHora()%100)
                return 4;    
            else 
                return -1;
        }
        
        
         public String toString(){
            String stringdia = String.valueOf(this.dia%100);
            String stringmes = String.valueOf((this.dia/100)%100);
            String stringanyo = String.valueOf(this.dia/10000);
            String stringhora = String.valueOf(this.hora/10000);
            String stringminuto  = String.valueOf((this.hora/100)%100);
            String stringsegundo = String.valueOf(this.hora%100);
            String guion = "-",espacio = " ",puntos = ":";
            
            String tiempo = stringanyo + guion + stringmes + guion + stringdia + espacio + stringhora + puntos + stringminuto + puntos + stringsegundo;
            
            return tiempo;
            
        }
        
      
    /**
     * Get the value of hora
     *
     * @return the value of hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * Set the value of hora
     *
     * @param hora new value of hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Get the value of dia
     *
     * @return the value of dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Set the value of dia
     *
     * @param dia new value of dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

}
