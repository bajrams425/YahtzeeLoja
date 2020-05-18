package Rezultatet;

public class TWOPAIR {

    private int shuma = 0;
    private int count = 0;


    public TWOPAIR(int[] rezultatiRoll){

        for(int i = 0; i<rezultatiRoll.length; i++){
            for(int j = 1; j<rezultatiRoll.length; j++){
                if(rezultatiRoll[i]==rezultatiRoll[j]){
                    count++;
                }
                if (count == 2){
                    shuma = 15;
                    break;
                }
            }
        }
    }


    public int getShuma() {
        return shuma;
    }
}
