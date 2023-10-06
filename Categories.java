class Categories implements FragranceState{
    public String getState(){
        return "Categories";
    }
    
    public String getInfo(){
        return "\n\tHere are our categories:\n\t1. Floral\n\t2. Citrus\n\t3. Fruity\n\t4. Woody"+
        "\n\t5. Earthy";
    }
    
    public FragranceState changeState(FragranceState d){
        return d;
    }
}