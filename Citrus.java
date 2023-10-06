class Citrus implements FragranceState{
    public String getState(){
        return "Citrus";
    }
    
    public String getInfo(){
        return "\n\tHere are our citrus scents:\n\t2. Blood Orange\n\t10. Lemon\n\t11. Lemongrass\n\t12. Orange";
    }

    public FragranceState changeState(FragranceState d){
        return d;
    }
}