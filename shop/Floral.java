class Floral implements FragranceState{
    public String getState(){
        return "Floral";
    }

    public String getInfo(){
        return "\n\tHere are our floral scents:\n\t7. Jasmine\n\t9. Lavender\n\t15. Rose";
    }

    public FragranceState changeState(FragranceState d){
        return d;
    }
}