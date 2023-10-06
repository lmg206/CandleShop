class Earthy implements FragranceState{
    public String getState(){
        return "Earthy";
    }
    
    public String getInfo(){
        return "\n\tHere are our earthy scents:\n\t5. Eucalyptus\n\t6. Ginger\n\t16. Rosewood\n\t17. Sage";
    }

    public FragranceState changeState(FragranceState d){
        return d;
    }
}