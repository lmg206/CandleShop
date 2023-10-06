class AllFragrances implements FragranceState{
    public String getState(){
        return "AllFragrances";
    }
    
    public String getInfo(){
        return "\n\tHere are all of our scents:\n\t1. Apple\n\t2. Blood Orange\n\t3. Cedarwood\n\t4. Cherry" +
        "\n\t5. Eucalyptus\n\t6. Ginger\n\t7. Jasmine\n\t8. Juniper\n\t9. Lavendar\n\t10. Lemon\n\t11. Lemongrass" +
        "\n\t12. Orange\n\t13. Pear\n\t14. Pine\n\t15. Rose\n\t16. Rosewood\n\t17. Sage"+
        "\n\t18. Sandalwood\n\t19. Strawberry";
    }

    public FragranceState changeState(FragranceState d){
        return d;
    }
}