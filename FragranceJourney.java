public class FragranceJourney{
    private FragranceState state;
    
    public FragranceJourney(FragranceState state){
        this.state = state;
    }

    public String getInfo(){
        return state.getInfo();
    }

    public String getState(){
        return state.getState();
    }
}