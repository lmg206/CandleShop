class Woody implements FragranceState{
    public String getState(){
        return "Woody";
    }
    
    public String getInfo(){
        return "\n\tHere are our woody scents:\n\t3. Cedarwood\n\t8. Juniper\n\t14. Pine\n\t18. Sandalwood";
    }

    public FragranceState changeState(FragranceState d){
        return d;
    }
}