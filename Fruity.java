class Fruity implements FragranceState{
    public String getState(){
        return "Fruity";
    }
    
    public String getInfo(){
        return "\n\tHere are our fruity scents:\n\t1. Apple\n\t4. Cherry\n\t13. Pear\n\t19. Strawberry";
    }

    public FragranceState changeState(FragranceState d){
        return d;
    }
}