public class Navigator {
    private Menu currentMenu;
    public Navigator(Menu menu) {
        currentMenu = menu;
    }
    public void printMenu(){
        System.out.println("Menu: "+currentMenu.getName());
        for (int i=0; i<currentMenu.getMenuItemList().size(); i++){
            System.out.println((i+1)+". "+currentMenu.getMenuItemList().get(i).getTitle());

        }

    }
public void  navigate(int index){
        if(index>0 && index<=currentMenu.getMenuItemList().size()){
            MenuItem menuItem = currentMenu.getMenuItemList().get(index-1);
            menuItem.getAction().execute();
            if (menuItem.getNextMenu()!=null){
                currentMenu=menuItem.getNextMenu();
            }
        }else{
            System.out.println("Invalid index!!!");
        }
}
}
